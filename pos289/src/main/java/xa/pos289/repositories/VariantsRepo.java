package xa.pos289.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import xa.pos289.models.Variant;

@Repository
public interface VariantsRepo extends JpaRepository<Variant, Long> {
	
	@Query("FROM Variant WHERE Category_id = ?1")
	List<Variant> findByCategory_id(Long Category_id);
}
