package jwd.wafepa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
	
//	List<User> findByFirstnameLike (String firstname);
	List<User> findByFirstnameLike(String firstname);
//	List<Address> findByName (String street);
	List<User> findByLastname (String lastname);
	
	
	
//	Posto ime ne sadrzisamo "name" kao naziv stringa hibernate ne prepoznaje automatski polje i izbacuje exception
//	Error creating bean with name 'jpaAddressService'...
//	moramo da napravimo upit iz baze sa @Query
	
	@Query("SELECT u FROM User u WHERE u.firstname = :name1")
	List<User> findByName(@Param("name1") String firstname);

}
