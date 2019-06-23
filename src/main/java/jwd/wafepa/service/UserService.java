package jwd.wafepa.service;

import java.util.List;

import jwd.wafepa.model.Address;
import jwd.wafepa.model.User;

public interface UserService {

	User findOne(Long id);
	
	List<User> findAll();
	
	User save(User user);
	
	List<User> save(List<User> users);
	
	//za korisnika se u ovom primeru (bez
	//specijalnog razloga) koristi
	//varijanta brisanja koja NE vraća entitet
	void delete(Long id); 
	
	
	
	
	
	
	//za korisnike se u ovom primeru (bez
		//specijalnog razloga) koristi
		//varijanta brisanja koja NE vraća entitet
	void delete(List<Long> ids);



	// ova metoda radi sa query
	List<User> findByName(String firstname);
	List<User> findByLastname(String lastname);

	List<User> findByFirstnameLike(String firstname);
	
	
	

	
	
	
}
