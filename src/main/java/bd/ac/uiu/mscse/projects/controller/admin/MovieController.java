package bd.ac.uiu.mscse.projects.controller.admin;

import bd.ac.uiu.mscse.projects.model.Movie;
import bd.ac.uiu.mscse.projects.model.User;
import bd.ac.uiu.mscse.projects.service.MovieService;
import bd.ac.uiu.mscse.projects.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping(value = "/admin/movie")
public class MovieController {

  @Autowired
  private UserService userService;
  @Autowired
  private MovieService movieService;

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public ModelAndView home() {
    ModelAndView modelAndView = new ModelAndView();
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    User user = userService.findUserByEmail(auth.getName());
    modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
    modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
    modelAndView.setViewName("admin/home");
    return modelAndView;
  }

  @RequestMapping(value = {"/new", "/edit"}, method = RequestMethod.GET)
  public ModelAndView newMovie(@PathParam(value = "id") final Integer id) {
    ModelAndView modelAndView = new ModelAndView();
    Movie movie = (id == null) ? new Movie() : movieService.get(id);
    modelAndView.addObject("id", movie.getId() == null ? "" : movie.getId());
    modelAndView.addObject("movieTitle", movie.getTitle() == null ? "" : movie.getTitle());
    modelAndView.addObject("imdbUrl", movie.getImdbUrl() == null ? "" : movie.getImdbUrl());
    modelAndView.addObject("rottenTomatoesUrl", movie.getRottenTomatoesUrl() == null ? "" : movie.getRottenTomatoesUrl());
    modelAndView.addObject("posterImgUrl", movie.getPosterImgUrl() == null ? "" : movie.getPosterImgUrl());
    modelAndView.addObject("bannerImgUrl", movie.getBannerImgUrl() == null ? "" : movie.getBannerImgUrl());
    modelAndView.addObject("formAction", id == null ? "save" : "update");

    modelAndView.setViewName("/admin/movie/form");
    return modelAndView;
  }

  @RequestMapping(value = {"/", ""}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public String save(@RequestBody Movie movie) {
    System.out.println(movieService.save(movie));
    return "ok";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public String update(@RequestBody Movie movie, @PathVariable(value = "id") Integer id) {
    movie.setId(id);
    System.out.println(movieService.update(movie));
    return "ok";
  }

}
