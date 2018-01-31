package bd.ac.uiu.mscse.projects.controller;

import bd.ac.uiu.mscse.projects.model.Booking;
import bd.ac.uiu.mscse.projects.model.Movie;
import bd.ac.uiu.mscse.projects.model.Show;
import bd.ac.uiu.mscse.projects.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
  @Autowired
  private BookingService bookingService;
  @Autowired
  private UserService userService;

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
    modelAndView.addObject("booking", makeBooking(showId));
    modelAndView.setViewName("book-show");
    return modelAndView;
  }

  public HashMap<String, Object> makeBooking(int showId) {
    HashMap<String, Object> booking = new HashMap<>();
    Show show = showService.get(showId);
    booking.put("show", show);
    booking.put("movie", movieService.get(show.getMovieId()));
    booking.put("theater", theaterService.get(show.getTheaterId()));
    booking.put("seatNo", Integer.parseInt(String.format("%s%s", show.getId(), getRandom())));
    return booking;
  }

  private String getRandom() {
    Random rand = new Random();
    return String.format("%04d", rand.nextInt(10000));
  }

  @RequestMapping(value = "/book/{showId}/{seatNo}/purchase", method = RequestMethod.POST)
  public ModelAndView purchase(
      @PathVariable(value = "showId") Integer showId, @PathVariable("seatNo") int seatNo) {
    Booking booking = new Booking();
    booking.setShowId(showId);
    booking.setSeatNo(seatNo);
    booking.setUserId(getUser().getId());
    Integer savedId = bookingService.save(booking);
    return new ModelAndView("redirect:/profile/history");
  }

  @RequestMapping(value = "/profile/history", method = RequestMethod.GET)
  public ModelAndView history() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("bookings", populateBookings(
        bookingService.getUserBookings(getUser().getId())));
    modelAndView.setViewName("profile/history");
    return modelAndView;
  }

  @RequestMapping(value = "/profile/book/{bookId}", method = RequestMethod.GET)
  public ModelAndView printView(@PathVariable(value = "bookId") int bookId) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("booking", populateBooking(bookingService.get(bookId)));
    modelAndView.setViewName("profile/ticket");
    return modelAndView;
  }

  private List<Map<String, Object>> populateBookings(List<Booking> userBookings) {
    List<Map<String, Object>> bookings = new ArrayList<>();
    for (Booking userBooking : userBookings) {
      bookings.add(populateBooking(userBooking));
    }
    return bookings;
  }

  private Map<String, Object> populateBooking(Booking userBooking) {
    HashMap<String, Object> booking = new HashMap<>();
    Show show = showService.get(userBooking.getId());
    booking.put("id", userBooking.getId());
    booking.put("show", show);
    booking.put("movie", movieService.get(show.getMovieId()));
    booking.put("theater", theaterService.get(show.getTheaterId()));
    booking.put("seatNo", userBooking.getSeatNo());
    return booking;
  }

  private List<Movie> getUniqueMovies(List<Show> upcomingShows) {
    List<Movie> movies = new ArrayList<>();
    for (Show upcomingShow : upcomingShows) {
      try {
        Movie movie = movieService.get(upcomingShow.getMovieId());
        if (!movies.contains(movie)) {
          movies.add(movie);
        }
      } catch (Exception ignored) {
      }
    }
    return movies;
  }

  private bd.ac.uiu.mscse.projects.model.User getUser() {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return userService.findUserByEmail(user.getUsername());
  }
}
