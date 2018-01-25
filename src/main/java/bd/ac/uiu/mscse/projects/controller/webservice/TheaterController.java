package bd.ac.uiu.mscse.projects.controller.webservice;

import bd.ac.uiu.mscse.projects.model.Theater;
import bd.ac.uiu.mscse.projects.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/webservice/theater")
public class TheaterController {
  @Autowired
  private TheaterService theaterService;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Theater> get(@PathVariable(value = "id") Integer id) {
    return ResponseEntity.ok(theaterService.get(id));
  }

  @RequestMapping(value = {"", "/"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<List<Theater>> list() {
    return ResponseEntity.ok(theaterService.getAll());
  }

  @RequestMapping(value = {"", "/"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> post(@RequestBody Theater Theater) {
    System.out.println(theaterService.save(Theater));
    return ResponseEntity.ok().build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> put(@RequestBody Theater Theater, @PathVariable(value = "id") Integer id) {
    System.out.println(theaterService.save(Theater));
    return ResponseEntity.ok().build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> put(@PathVariable(value = "id") Integer id) {
    theaterService.delete(id);
    return ResponseEntity.ok().build();
  }
}
