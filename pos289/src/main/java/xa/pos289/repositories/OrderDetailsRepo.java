package xa.pos289.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import xa.pos289.models.OrderDetails;

@Repository
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Long> {
	@Query(value="FROM OrderDetails WHERE OrderHeaderid = ?1")
	List<OrderDetails> getDetailByHeaderId(Long hid);
}
