package xa.pos289.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xa.pos289.models.OrderHeader;
import xa.pos289.repositories.OrderHeaderRepo;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/api")
public class ApiOrderHeaderController {
	@Autowired OrderHeaderRepo orherepo;
	
	@GetMapping("/orderheader")
	public ResponseEntity<List<OrderHeader>> getAllPro(){
		try {
			List<OrderHeader> orderheader = this.orherepo.findAll();
			return new ResponseEntity<>(orderheader, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/orderheader/{id}")
	public ResponseEntity<?> getOrHeById(@PathVariable Long id){
		try {
			OrderHeader orderheader = this.orherepo.findById(id).orElse(null);
			if(orderheader != null) {
				return new ResponseEntity<OrderHeader>(orderheader, HttpStatus.OK);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order Header dengan id " + id + " tidak ditemukan");
			}
			
		}catch(Exception e){
			return new ResponseEntity<OrderHeader>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/orderheader")
	public ResponseEntity<OrderHeader> insertOrderHeader(@RequestBody OrderHeader orderheader) {
		OrderHeader orderheaderdata = this.orherepo.save(orderheader);
		if(orderheaderdata.equals(orderheader)) {
			return new ResponseEntity<OrderHeader>(orderheader, HttpStatus.OK);
		} else {
			return new ResponseEntity<OrderHeader>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PutMapping("/orderheader/{id}")
	public ResponseEntity<OrderHeader> editOrderHeader(@RequestBody OrderHeader orderheader, @PathVariable Long id){
		try {
			orderheader.setId(id);
			this.orherepo.save(orderheader);
			return new ResponseEntity<OrderHeader>(orderheader, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<OrderHeader>(HttpStatus.NO_CONTENT);
		}
	}
}
