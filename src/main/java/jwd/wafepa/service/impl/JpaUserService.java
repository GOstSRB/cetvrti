package jwd.wafepa.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.User;
import jwd.wafepa.repository.UserRepository;
import jwd.wafepa.service.UserService;


// kada radimo sa bazom onda nam je @Service JpaNAZIVService odgovoran za metode...
@Service
public class JpaUserService implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findOne(Long id) {
		
		return userRepository.findOne(id);
	}

	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
	}

	@Override
	public User save(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public List<User> save(List<User> users) {
		
		return userRepository.save(users);
	}

	@Override
	public void delete(Long id) {
		
		User toDelete = userRepository.findOne(id);
		
		if (toDelete != null) {
			userRepository.delete(id);
		}
	}

	@Override
	public void delete(List<Long> ids) {
		
		for (Long id : ids) {
			userRepository.delete(id);
		}
	}

// ova metoda radi sa query	
	@Override
	public List<User> findByName(String firstname) {
	
		return userRepository.findByName(firstname);
	}
	
	@Override
	public List<User> findByLastname(String lastname) {

		return userRepository.findByLastname(lastname);
	}	

	
	@Override
	public List<User> findByFirstnameLike(String firstname) {
	
		return userRepository.findByFirstnameLike(firstname);
	}
	
	
	@PostConstruct
	public void bol() {
		save(new User(null, "milan1rns@gmail.com", "pas", "Milan", "Radic"));
		save(new User(null, "boskobole@gmail.com", "pas", "Bosko", "Radic"));
		save(new User(null, "alekalek@gmail.com", "pas", "Aleksandra", "Radic"));
		save(new User(null, "lukluk@gmail.com", "pas", "Luka", "Radic"));
	}



	

}
