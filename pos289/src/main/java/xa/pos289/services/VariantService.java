package xa.pos289.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xa.pos289.models.Variant;
import xa.pos289.repositories.VariantsRepo;

@Service
@Transactional
public class VariantService {
@Autowired VariantsRepo varepo;
	
	public List<Variant> listAll(){
		return this.varepo.findAll();
	}
}
