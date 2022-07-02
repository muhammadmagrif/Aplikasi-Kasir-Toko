package xa.pos289.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.DocumentException;

import xa.pos289.exporters.ProductExporter;
import xa.pos289.models.Product;
import xa.pos289.services.ProductService;

@Controller
@RequestMapping(value="/product/")
public class ProductController {
	@GetMapping(value="index")
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("/product/index");
		return view;
	}
	
	@GetMapping(value="form")
	public ModelAndView form() {
		ModelAndView view = new ModelAndView("/product/form");
		return view;
	}
	
	@Autowired ProductService service;
	
	@GetMapping(value="exportproduct")
	public void exportproduct(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateformat = new SimpleDateFormat("yyyymmmddHHmmss");
		String currentdate = dateformat.format(new Date());
		
		String headerkey = "Content-Disposition";
		String headerValue = "attachment; filename=product_" + currentdate + ".pdf";
		response.setHeader(headerkey, headerValue);
		
		List<Product> listproduct = service.listAll();
		
		ProductExporter exporter = new ProductExporter(listproduct);
		exporter.export(response);
	}
}
