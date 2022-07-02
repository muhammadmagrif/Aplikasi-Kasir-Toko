package xa.pos289.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xa.pos289.models.Product;
import xa.pos289.repositories.ProductsRepo;

@Service
@Transactional
public class ProductService {
	
	@Autowired ProductsRepo productrepo;
	
	public List<Product> listAll(){
		return this.productrepo.findAll();
	}
}
