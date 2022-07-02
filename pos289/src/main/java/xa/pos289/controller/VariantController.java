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

import xa.pos289.exporters.VariantExporter;
import xa.pos289.models.Category;
import xa.pos289.models.Variant;
import xa.pos289.repositories.CategoryRepo;
import xa.pos289.repositories.VariantsRepo;
import xa.pos289.services.VariantService;

@Controller
@RequestMapping(value="/variant/")

public class VariantController {
	@Autowired VariantsRepo varepo;
	@Autowired CategoryRepo catrepo;
	
	@GetMapping(value="index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("/variant/index");
		List<Variant> listvar = this.varepo.findAll();
		view.addObject("listvar", listvar);
		return view;
	}
	
	@GetMapping(value="form")
	public ModelAndView form() {
		ModelAndView view = new ModelAndView("/variant/form");
		Variant variant = new Variant();
		view.addObject("variant", variant);
		List<Category> category = this.catrepo.findAll();
		view.addObject("category", category);
		return view;
	}
	
	@PostMapping(value="save")
	public ModelAndView save(@ModelAttribute Variant variant, BindingResult result) {
		if(!result.hasErrors()) {
			variant.setCreate_by("Magrif");
			this.varepo.save(variant);
		}
		return new ModelAndView("redirect:/variant/index");
	}
	
	@GetMapping(value="/edit/{id}")
	public ModelAndView editform(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("/variant/form");
		Variant variant = this.varepo.findById(id).orElse(null);
		view.addObject("variant", variant);
		List<Category> category = this.catrepo.findAll();
		view.addObject("category", category);
		return view;
	}
	
	@GetMapping(value="/deleteform/{id}")
	public ModelAndView deleteform(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("/variant/deleteform");
		Variant variant = this.varepo.findById(id).orElse(null);
		view.addObject("variant", variant);
		return view;
	}
	
	@GetMapping(value="/del/{id}")
	public ModelAndView del(@PathVariable("id") Long id) {
		if(id != null) {
			this.varepo.deleteById(id);
		}
		return new ModelAndView("redirect:/variant/index");
	}
	
	@Autowired VariantService service;
	
	@GetMapping(value="exportvariant")
	public void exportvariant(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateformat = new SimpleDateFormat("yyyymmmddHHmmss");
		String currentdate = dateformat.format(new Date());
		
		String headerkey = "Content-Disposition";
		String headerValue = "attachment; filename=variant_" + 	currentdate + ".pdf";
		response.setHeader(headerkey, headerValue);
		
		List<Variant> listvar = service.listAll();
		
		VariantExporter exporter = new VariantExporter(listvar);
		exporter.export(response);
	}
}
