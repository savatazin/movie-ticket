package bd.ac.uiu.mscse.projects.controller.admin;

import bd.ac.uiu.mscse.projects.model.Show;
import bd.ac.uiu.mscse.projects.service.MovieService;
import bd.ac.uiu.mscse.projects.service.ShowService;
import bd.ac.uiu.mscse.projects.service.TheaterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping(value = "/admin/show")
public class ShowMvcController {

  @Autowired
  private ShowService showService;

  @Autowired
  private MovieService movieService;

  @Autowired
  private TheaterService theaterService;

  @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
  public ModelAndView show() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("title", "Show");
    List<Map<String, Object>> shows = populateShowsData(showService.getAll());
    log.info("All shows :: " + shows);
    modelAndView.addObject("shows", shows);
    modelAndView.setViewName("admin/show/index");
    return modelAndView;
  }

  private List<Map<String, Object>> populateShowsData(List<Show> allShows) {
    List<Map<String, Object>> shows = new ArrayList<>();
    for (Show show : allShows) {
      shows.add(populateShowData(show));
    }
    return shows;
  }

  private Map<String, Object> populateShowData(Show show) {
    Map<String, Object> showMap = new HashMap<>();
    showMap.put("id", show.getId());
    showMap.put("movie", movieService.get(show.getMovieId()));
    showMap.put("theater", theaterService.get(show.getTheaterId()));
    showMap.put("show_date", show.getShowDate());
    showMap.put("show_time_start", show.getShowTimeStart());
    showMap.put("show_time_end", show.getShowTimeEnd());
    return showMap;
  }

  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView create(@ModelAttribute("showForm") Show show) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("title", "Show");
    modelAndView.addObject("formAction", "/admin/show/new");
    modelAndView.addObject("show", new Show());
    modelAndView.setViewName("admin/show/form");
    return modelAndView;
  }

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public ModelAndView postToCreateShow(@ModelAttribute("showForm") Show show) {
    try {
      Integer savedId = showService.save(show);
      if (savedId != null) {
        log.info("Saved with id :: " + savedId + " :: " + show);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/show");
        return modelAndView;
      }
    } catch (Exception e) {
      log.error("Failed to save show", e);
    }
    ModelAndView modelAndView = new ModelAndView("redirect:/admin/show");
    modelAndView.addObject("title", "Show");
    modelAndView.addObject("show", show);
    modelAndView.addObject("errorMessage", "Failed to save show. Please fill the values correctly.");
    modelAndView.addObject("formAction", "/admin/show/new");
    modelAndView.setViewName("admin/show/form");
    return modelAndView;
  }

  @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
  public ModelAndView edit(@PathVariable(value = "id") Integer id) {
    try {
      Show show = showService.get(id);
      if (show != null) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Show");
        modelAndView.addObject("show", show);
        modelAndView.addObject("formAction", "/admin/show/" + show.getId() + "/edit");
        modelAndView.setViewName("admin/show/form");
        return modelAndView;
      }
    } catch (Exception e) {
      log.error("Failed to create show edit form for id :: " + id, e);
    }
    return new ModelAndView("redirect:/admin/show");
  }

  @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
  public ModelAndView postToEdit(@ModelAttribute("showForm") Show show,
                                 @PathVariable(value = "id") Integer id) {
    try {
      show.setId(id);
      Integer updatedId = showService.update(show);
      if (updatedId != null) {
        log.info("Updated with id :: " + updatedId + " :: " + show);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/show");
        return modelAndView;
      }
    } catch (Exception e) {
      log.error("Failed to update show edit form for id :: " + id, e);
    }
    ModelAndView modelAndView = new ModelAndView("redirect:/admin/show");
    modelAndView.addObject("title", "Show");
    modelAndView.addObject("show", show);
    modelAndView.addObject("errorMessage", "Failed to save show. Please fill the values correctly.");
    modelAndView.addObject("formAction", "/admin/show/" + id + "/edit");
    modelAndView.setViewName("admin/show/form");
    return modelAndView;
  }

  @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
  public ModelAndView delete(@PathVariable(value = "id") Integer id) {
    showService.delete(id);
    return new ModelAndView("redirect:/admin/show");
  }
}
