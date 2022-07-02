package xa.pos289.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import xa.pos289.models.Product;

@Repository
public interface ProductsRepo extends JpaRepository<Product, Long>  {
	@Query(value="SELECT * FROM product p WHERE LOWER(p.Name) LIKE %:textsearch% OR LOWER(p.Description) LIKE %:textsearch%", nativeQuery=true)
	List<Product> SearchProduct(@Param("textsearch") String textsearch);
}
