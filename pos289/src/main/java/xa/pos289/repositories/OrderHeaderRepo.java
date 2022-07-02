package xa.pos289.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xa.pos289.models.OrderHeader;

@Repository
public interface OrderHeaderRepo extends JpaRepository<OrderHeader, Long> {

}
