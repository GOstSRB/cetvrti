package jwd.wafepa.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jwd.wafepa.model.User;
import jwd.wafepa.service.UserService;

import org.springframework.stereotype.Service;


// InMemoryNAZIVService  koristimo kada api radi samo u memoriji bez baze podataka...
//@Service
public class InMemoryUserService implements UserService {

	private Map<Long, User> data = new HashMap<>();
	private Long idCounter = 1L;
	
	@Override
	public User findOne(Long id) {
		return data.get(id);
	}

	@Override
	public List<User> findAll() {
		return new ArrayList<>(data.values());
	}

	@Override
	public User save(User user) {
		if (user.getId() == null) {
			user.setId(idCounter);
			idCounter++;
		}
		data.put(user.getId(), user);
		return user;
	}

	@Override
	public void delete(Long id) throws IllegalArgumentException {
		User user = data.remove(id);
		if (user == null) {
			throw new IllegalArgumentException("Removing unexisting user with id=" + id);
		}
	}

	@Override
	public List<User> save(List<User> users) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(List<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findByFirstnameLike(String firstname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByName(String firstname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByLastname(String lastname) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<User> findByfrstname(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
