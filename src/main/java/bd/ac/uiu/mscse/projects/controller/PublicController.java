package bd.ac.uiu.mscse.projects.controller;

import bd.ac.uiu.mscse.projects.model.Movie;
import bd.ac.uiu.mscse.projects.model.Show;
import bd.ac.uiu.mscse.projects.service.MovieService;
import bd.ac.uiu.mscse.projects.service.ShowService;
import bd.ac.uiu.mscse.projects.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class PublicController {

  @Autowired
  private ShowService showService;
  @Autowired
  private MovieService movieService;
  @Autowired
  private TheaterService theaterService;

  @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
  public ModelAndView home() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("movies", getUniqueMovies(showService.getUpcomingShows()));
    modelAndView.setViewName("home");
    return modelAndView;
  }

  @RequestMapping(value = "/movie/{movieId}/{movieTitle:.*}", method = RequestMethod.GET)
  public ModelAndView movie(@PathVariable(value = "movieId") Integer movieId) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("movie", movieService.get(movieId));
    modelAndView.addObject("shows", showService.getAllCurrentShowsOf(movieId));
    modelAndView.setViewName("movie");
    return modelAndView;
  }

  private List<Movie> getUniqueMovies(List<Show> upcomingShows) {
    List<Movie> movies = new ArrayList<>();
    for (Show upcomingShow : upcomingShows) {
      Movie movie = movieService.get(upcomingShow.getMovieId());
      if (!movies.contains(movie)) {
        movies.add(movie);
      }
    }
    return movies;
  }
}
