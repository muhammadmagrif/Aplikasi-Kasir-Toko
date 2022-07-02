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

import xa.pos289.models.OrderDetails;
import xa.pos289.repositories.OrderDetailsRepo;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/api/")
public class ApiOrderDetailController {
	@Autowired OrderDetailsRepo orderepo;
	
	@GetMapping("/orderdetail")
	public ResponseEntity<List<OrderDetails>> getAllPro(){
		try {
			List<OrderDetails> orderdetail = this.orderepo.findAll();
			return new ResponseEntity<>(orderdetail, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/orderdetail/{id}")
	public ResponseEntity<?> getOrHeById(@PathVariable Long id){
		try {
			OrderDetails orderdetail = this.orderepo.findById(id).orElse(null);
			if(orderdetail != null) {
				return new ResponseEntity<OrderDetails>(orderdetail, HttpStatus.OK);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order Detail dengan id " + id + " tidak ditemukan");
			}
			
		}catch(Exception e){
			return new ResponseEntity<OrderDetails>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/orderdetail/get/{hid}")
	public ResponseEntity<?> getOrHeByHid(@PathVariable("hid") Long hid){
		try {
			List<OrderDetails> orderdetail = this.orderepo.getDetailByHeaderId(hid);
			return new ResponseEntity<List<OrderDetails>>(orderdetail, HttpStatus.OK);			
		}catch(Exception e){
			return new ResponseEntity<List<OrderDetails>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("orderdetail")
	public ResponseEntity<OrderDetails> insertorderdetail(@RequestBody OrderDetails orderdetail) {
		try {
			this.orderepo.save(orderdetail);
			return new ResponseEntity<OrderDetails>(orderdetail, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<OrderDetails>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PutMapping("/orderdetail/{id}")
	public ResponseEntity<OrderDetails> editOrderDetail(@RequestBody OrderDetails orderdetail, @PathVariable Long id){
		try {
			orderdetail.setId(id);
			this.orderepo.save(orderdetail);
			return new ResponseEntity<OrderDetails>(orderdetail, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<OrderDetails>(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/orderdetail/{id}")
	public ResponseEntity<OrderDetails> deleteOrderDetail(@PathVariable Long id){
		try {
			this.orderepo.deleteById(id);
			return new ResponseEntity<OrderDetails>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<OrderDetails>(HttpStatus.NO_CONTENT);
		}
	}
}
