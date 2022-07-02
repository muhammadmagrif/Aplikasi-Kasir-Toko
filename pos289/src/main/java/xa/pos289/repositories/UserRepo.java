package xa.pos289.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import xa.pos289.models.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Long>{
	@Query(value="SELECT * FROM users u WHERE u.Username = ?1 AND u.Password = ?2", nativeQuery=true)
	List<Users> getLogin(String Username, String Password);
}
