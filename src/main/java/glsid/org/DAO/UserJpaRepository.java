package glsid.org.DAO;

import glsid.org.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserJpaRepository  extends JpaRepository<User, Long> {

	
	@Query("select u from User u where u.name = :name ")
	public User findByName(@Param("name") String name);
	
}
