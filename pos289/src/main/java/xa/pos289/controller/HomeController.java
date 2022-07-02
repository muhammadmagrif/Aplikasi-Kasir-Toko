package xa.pos289.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class HomeController {
	@GetMapping(value="/index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("/index");
		return view;
	}
	
	@GetMapping(value="/cashier")
	public ModelAndView cashier() {
		ModelAndView view = new ModelAndView("/cashier");
		return view;
	}
	
	@GetMapping(value="/home")
	public ModelAndView home(HttpSession sess) {
		ModelAndView view = new ModelAndView("/home");
		view.addObject("sfullname", sess.getAttribute("fullname"));
		return view;
	}
}
