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

import java.util.ArrayList;
import java.util.List;

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
    List<Movie> allMovie = movieService.getAll();
    if (allMovie.size() > 6) {
      modelAndView.addObject("bannerMovies", allMovie.subList(0, 5));
    } else {
      modelAndView.addObject("bannerMovies", allMovie);
    }
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

  @RequestMapping(value = "/book/{showId}", method = RequestMethod.GET)
  public ModelAndView book(@PathVariable(value = "showId") Integer showId) {
    ModelAndView modelAndView = new ModelAndView();
    Show show = showService.get(showId);
    modelAndView.addObject("show", show);
    modelAndView.addObject("movie", movieService.get(show.getMovieId()));
    modelAndView.addObject("theater", theaterService.get(show.getTheaterId()));
    modelAndView.addObject("bookKey", System.currentTimeMillis());
    modelAndView.setViewName("book-show");
    return modelAndView;
  }

  @RequestMapping(value = "/book/{showId}/purchase", method = RequestMethod.POST)
  public ModelAndView purchase(@PathVariable(value = "showId") Integer showId) {
    return new ModelAndView("redirect:/profile/history");
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
