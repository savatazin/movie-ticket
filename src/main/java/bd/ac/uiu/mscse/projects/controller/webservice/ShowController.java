package bd.ac.uiu.mscse.projects.controller.webservice;

import bd.ac.uiu.mscse.projects.model.Show;
import bd.ac.uiu.mscse.projects.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/webservice/show")
public class ShowController {
  @Autowired
  private ShowService showService;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Show> get(@PathVariable(value = "id") Integer id) {
    return ResponseEntity.ok(showService.get(id));
  }

  @RequestMapping(value = {"", "/"}, method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<List<Show>> getAll() {
    return ResponseEntity.ok(showService.getAll());
  }

  @RequestMapping(value = {"", "/"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> post(@RequestBody Show show) {
    System.out.println(showService.save(show));
    return ResponseEntity.ok().build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> put(@RequestBody Show show, @PathVariable(value = "id") Integer id) {
    show.setId(id);
    System.out.println(showService.save(show));
    return ResponseEntity.ok().build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> put(@PathVariable(value = "id") Integer id) {
    showService.delete(id);
    return ResponseEntity.ok().build();
  }
}
