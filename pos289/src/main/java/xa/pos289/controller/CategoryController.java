package xa.pos289.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.DocumentException;

import xa.pos289.exporters.CategoryExporter;
import xa.pos289.models.Category;
import xa.pos289.repositories.CategoryRepo;
import xa.pos289.services.CategoryService;

@Controller
@RequestMapping(value="/category/")
public class CategoryController {
	@Autowired
	private CategoryRepo catrepo;
	
	@GetMapping(value="index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("/category/index");
		List<Category> listcat = this.catrepo.findAll();
		view.addObject("listcat", listcat);
		return view;
	}
	
	@GetMapping(value="form")
	public ModelAndView form() {
		ModelAndView view = new ModelAndView("/category/form");
		Category category = new Category();
		view.addObject("category", category);
		return view;
	}
	
	@PostMapping(value="save")
	public ModelAndView save(@ModelAttribute Category category, BindingResult result) {
		if(!result.hasErrors()) {
			category.setCreate_by("Magrif");
			this.catrepo.save(category);
		}
		return new ModelAndView("redirect:/category/index");
	}
	
	@GetMapping(value="/edit/{id}")
	public ModelAndView editform(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("/category/form");
		Category category = this.catrepo.findById(id).orElse(null);
		view.addObject("category", category);
		return view;
	}
	
	@GetMapping(value="/deleteform/{id}")
	public ModelAndView deleteform(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("/category/deleteform");
		Category category = this.catrepo.findById(id).orElse(null);
		view.addObject("category", category);
		return view;
	}
	
	@GetMapping(value="/del/{id}")
	public ModelAndView del(@PathVariable("id") Long id) {
		if(id != null) {
			this.catrepo.deleteById(id);
		}
		return new ModelAndView("redirect:/category/index");
	}
	
	@Autowired CategoryService service;
	
	@GetMapping(value="exportcategory")
	public void exportcategory(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateformat = new SimpleDateFormat("yyyymmmddHHmmss");
		String currentdate = dateformat.format(new Date());
		
		String headerkey = "Content-Disposition";
		String headerValue = "attachment; filename=category_" + currentdate + ".pdf";
		response.setHeader(headerkey, headerValue);
		
		List<Category> listcat = service.listAll();
		
		CategoryExporter exporter = new CategoryExporter(listcat);
		exporter.export(response);
	}
}
