package bd.ac.uiu.mscse.projects.controller.webservice;

import bd.ac.uiu.mscse.projects.model.Movie;
import bd.ac.uiu.mscse.projects.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/webservice/movie")
public class MovieController {

  @Autowired
  private MovieService movieService;

  @RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<List<Movie>> list(@PathParam(value = "q") String query) {
    return ResponseEntity.ok(movieService.search(query));
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Movie> get(@PathVariable(value = "id") Integer id) {
    return ResponseEntity.ok(movieService.get(id));
  }

  @RequestMapping(value = {"", "/"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> post(@RequestBody Movie movie) {
    System.out.println(movieService.save(movie));
    return ResponseEntity.ok().build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> put(@RequestBody Movie movie, @PathVariable(value = "id") Integer id) {
    movie.setId(id);
    System.out.println(movieService.save(movie));
    return ResponseEntity.ok().build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> put(@PathVariable(value = "id") Integer id) {
    movieService.delete(id);
    return ResponseEntity.ok().build();
  }
}
