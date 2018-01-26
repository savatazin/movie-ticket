package bd.ac.uiu.mscse.projects.controller.admin;

import bd.ac.uiu.mscse.projects.model.Movie;
import bd.ac.uiu.mscse.projects.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping(value = "/admin/movie")
public class MovieMvcController {

  @Autowired
  private MovieService movieService;

  @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
  public ModelAndView home() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("title", "Movie");
    modelAndView.addObject("movies", movieService.getAll());
    modelAndView.setViewName("admin/movie/index");
    return modelAndView;
  }

  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView create() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("title", "Movie");
    modelAndView.addObject("movieFormAction", "/admin/movie/new");
    modelAndView.addObject("movie", new Movie());
    modelAndView.setViewName("admin/movie/form");
    return modelAndView;
  }

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public ModelAndView postToCreate(@ModelAttribute("movieForm") Movie movie) {
    try {
      Integer savedId = movieService.save(movie);
      if (savedId != null) {
        log.info("Saved with id :: " + savedId + " :: " + movie);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/movie");
        return modelAndView;
      }
    } catch (Exception e) {
      log.error("Failed to save movie", e);
    }
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("title", "Movie");
    modelAndView.addObject("movie", movie);
    modelAndView.addObject("errorMessage", "Failed to save movie. Please fill the values correctly.");
    modelAndView.addObject("movieFormAction", "/admin/movie/new");
    modelAndView.setViewName("admin/movie/form");
    return modelAndView;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ModelAndView details(@PathVariable(value = "id") Integer id) {
    try {
      Movie movie = movieService.get(id);
      if (movie != null) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Movie :: " + movie.getTitle());
        modelAndView.addObject("movie", movie);
        modelAndView.setViewName("admin/movie/details");
        return modelAndView;
      }
    } catch (Exception e) {
      log.error("Failed to create movie edit form for id :: " + id, e);
    }
    return new ModelAndView("redirect:/admin/movie");
  }

  @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
  public ModelAndView edit(@PathVariable(value = "id") Integer id) {
    try {
      Movie movie = movieService.get(id);
      if (movie != null) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Movie :: " + movie.getTitle());
        modelAndView.addObject("movie", movie);
        modelAndView.addObject("movieFormAction", "/admin/movie/" + movie.getId() + "/edit");
        modelAndView.setViewName("admin/movie/form");
        return modelAndView;
      }
    } catch (Exception e) {
      log.error("Failed to create movie edit form for id :: " + id, e);
    }
    return new ModelAndView("redirect:/admin/movie");
  }

  @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
  public ModelAndView postToEdit(@ModelAttribute("movieForm") Movie movie,
                                 @PathVariable(value = "id") Integer id) {
    try {
      movie.setId(id);
      Integer updatedId = movieService.update(movie);
      if (updatedId != null) {
        log.info("Updated with id :: " + updatedId + " :: " + movie);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/movie");
        return modelAndView;
      }
    } catch (Exception e) {
      log.error("Failed to update movie edit form for id :: " + id, e);
    }
    ModelAndView modelAndView = new ModelAndView("redirect:/admin/movie");
    modelAndView.addObject("title", "Movie");
    modelAndView.addObject("movie", movie);
    modelAndView.addObject("errorMessage", "Failed to save movie. Please fill the values correctly.");
    modelAndView.addObject("movieFormAction", "/admin/movie/" + id + "/edit");
    modelAndView.setViewName("admin/movie/form");
    return modelAndView;
  }

  @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
  public ModelAndView delete(@PathVariable(value = "id") Integer id) {
    movieService.delete(id);
    return new ModelAndView("redirect:/admin/movie");
  }
}
