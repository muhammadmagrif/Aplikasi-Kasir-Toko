package xa.pos289.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xa.pos289.models.Product;
import xa.pos289.repositories.ProductsRepo;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/api")
public class ApiProductController {
	@Autowired ProductsRepo prorepo;
	
	@GetMapping("/product")
	public ResponseEntity<List<Product>> getAllPro(){
		try {
			List<Product> product = this.prorepo.findAll();
			return new ResponseEntity<>(product, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<?> getProById(@PathVariable Long id){
		try {
			Product product = this.prorepo.findById(id).orElse(null);
			if(product != null) {
				return new ResponseEntity<Product>(product, HttpStatus.OK);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product dengan id " + id + " tidak ditemukan");
			}
			
		}catch(Exception e){
			return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/insertProduct")
	public ResponseEntity<Product> insertProduct(@RequestBody Product product) {
		try {
			this.prorepo.save(product);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PutMapping("/editProduct/{id}")
	public ResponseEntity<Product> editProduct(@RequestBody Product product, @PathVariable Long id){
		try {
			product.setId(id);
			this.prorepo.save(product);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable Long id){
		try {
			this.prorepo.deleteById(id);
			return new ResponseEntity<Product>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/product/search/{textsearch}")
	public ResponseEntity<List<Product>> getAllPro(@PathVariable("textsearch") String textsearch){
		try {
			List<Product> product = this.prorepo.SearchProduct(textsearch);
			return new ResponseEntity<>(product, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}