package bd.ac.uiu.mscse.projects.controller.admin;

import bd.ac.uiu.mscse.projects.model.Theater;
import bd.ac.uiu.mscse.projects.service.TheaterService;
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
@RequestMapping(value = "/admin/theater")
public class TheaterMvcController {

  @Autowired
  private TheaterService theaterService;

  @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
  public ModelAndView theater() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("title", "Theater");
    modelAndView.addObject("theaters", theaterService.getAll());
    modelAndView.setViewName("admin/theater/index");
    return modelAndView;
  }

  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView create(@ModelAttribute("theaterForm") Theater theater) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("title", "Theater");
    modelAndView.addObject("formAction", "/admin/theater/new");
    modelAndView.addObject("theater", new Theater());
    modelAndView.setViewName("admin/theater/form");
    return modelAndView;
  }

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public ModelAndView postToCreateTheater(@ModelAttribute("theaterForm") Theater theater) {
    try {
      Integer savedId = theaterService.save(theater);
      if (savedId != null) {
        log.info("Saved with id :: " + savedId + " :: " + theater);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/theater");
        return modelAndView;
      }
    } catch (Exception e) {
      log.error("Failed to save theater", e);
    }
    ModelAndView modelAndView = new ModelAndView("redirect:/admin/theater");
    modelAndView.addObject("title", "Theater");
    modelAndView.addObject("theater", theater);
    modelAndView.addObject("errorMessage", "Failed to save theater. Please fill the values correctly.");
    modelAndView.addObject("formAction", "/admin/theater/new");
    modelAndView.setViewName("admin/theater/form");
    return modelAndView;
  }

  @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
  public ModelAndView edit(@PathVariable(value = "id") Integer id) {
    try {
      Theater theater = theaterService.get(id);
      if (theater != null) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Theater :: " + theater.getTitle());
        modelAndView.addObject("theater", theater);
        modelAndView.addObject("formAction", "/admin/theater/" + theater.getId() + "/edit");
        modelAndView.setViewName("admin/theater/form");
        return modelAndView;
      }
    } catch (Exception e) {
      log.error("Failed to create theater edit form for id :: " + id, e);
    }
    return new ModelAndView("redirect:/admin/theater");
  }

  @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
  public ModelAndView postToEdit(@ModelAttribute("theaterForm") Theater theater,
                                 @PathVariable(value = "id") Integer id) {
    try {
      theater.setId(id);
      Integer updatedId = theaterService.update(theater);
      if (updatedId != null) {
        log.info("Updated with id :: " + updatedId + " :: " + theater);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/theater");
        return modelAndView;
      }
    } catch (Exception e) {
      log.error("Failed to update theater edit form for id :: " + id, e);
    }
    ModelAndView modelAndView = new ModelAndView("redirect:/admin/theater");
    modelAndView.addObject("title", "Theater");
    modelAndView.addObject("theater", theater);
    modelAndView.addObject("errorMessage", "Failed to save theater. Please fill the values correctly.");
    modelAndView.addObject("formAction", "/admin/theater/" + id + "/edit");
    modelAndView.setViewName("admin/theater/form");
    return modelAndView;
  }

  @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
  public ModelAndView delete(@PathVariable(value = "id") Integer id) {
    theaterService.delete(id);
    return new ModelAndView("redirect:/admin/theater");
  }
}
