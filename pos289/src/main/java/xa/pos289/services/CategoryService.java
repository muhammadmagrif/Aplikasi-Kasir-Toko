package xa.pos289.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xa.pos289.models.Category;
import xa.pos289.repositories.CategoryRepo;

@Service
@Transactional
public class CategoryService {
	@Autowired CategoryRepo catrepo;
	
	public List<Category> listAll(){
		return this.catrepo.findAll();
	}
}
