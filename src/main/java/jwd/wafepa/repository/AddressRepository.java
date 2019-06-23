package jwd.wafepa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
	
//	List<Address> findByName (String name);
//	List<Address> findByName (String street);
//	Posto adresa ne sadrzi "name" kao naziv stringa hibernate ne prepoznaje automatski polje i izbacuje exception
//	Error creating bean with name 'jpaAddressService'...
//	moramo da napravimo upit iz baze sa @Query
	
	@Query("SELECT a FROM Address a WHERE a.street = :name1")
	List<Address> findByName(@Param("name1") String street);

}
