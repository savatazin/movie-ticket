package bd.ac.uiu.mscse.projects.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping(value = "/image")
public class ImageController {

  private final String directory = "G:\\uploads";

  @RequestMapping(value = "/upload", method = RequestMethod.POST)
  public ResponseEntity<Void> upload(@RequestParam("uploadfile") MultipartFile uploadfile) {
    try {
      String filename = System.currentTimeMillis() + "_" + uploadfile.getOriginalFilename();
      String filepath = Paths.get(directory, filename).toString();

      // Save the file locally
      BufferedOutputStream stream =
          new BufferedOutputStream(new FileOutputStream(new File(filepath)));
      stream.write(uploadfile.getBytes());
      stream.close();
      return ResponseEntity.created(URI.create("/image/" + filename)).build();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

  @RequestMapping(value = "/{filename:.+}", method = RequestMethod.GET)
  public ResponseEntity<byte[]> getImage(@PathVariable("filename") String filename) throws IOException {
    String filePath = Paths.get(directory, filename).toString();
    byte[] fileContent = Files.readAllBytes(new File(filePath).toPath());
    return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(fileContent);
  }
}
