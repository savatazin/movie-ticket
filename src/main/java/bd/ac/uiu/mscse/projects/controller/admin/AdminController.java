package bd.ac.uiu.mscse.projects.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

  @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
  public ModelAndView home() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("admin/home");
    return modelAndView;
  }

  @RequestMapping(value = "/booking", method = RequestMethod.GET)
  public ModelAndView booking() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("admin/booking/index");
    return modelAndView;
  }

//  @RequestMapping(value = "/movie", method = RequestMethod.GET)
//  public ModelAndView movie() {
//    ModelAndView modelAndView = new ModelAndView();
//    modelAndView.setViewName("admin/movie/index");
//    return modelAndView;
//  }

  @RequestMapping(value = "/show", method = RequestMethod.GET)
  public ModelAndView show() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("admin/show/index");
    return modelAndView;
  }
}
