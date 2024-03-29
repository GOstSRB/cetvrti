package jwd.wafepa.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.wafepa.model.Address;
import jwd.wafepa.model.User;
import jwd.wafepa.model.User;
import jwd.wafepa.service.UserService;



@RestController
@RequestMapping(value="/api/users")
public class ApiUserController {
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private UserToUserDTO toDTO;
//	
//	@Autowired
//	private UserRegistrationDtoToUser toUser;
	
	@RequestMapping(method=RequestMethod.GET, params= {"firstname"})
	ResponseEntity<List<User>> getUser(@RequestParam(value="firstname", required=false) String name){
		
		List<User> users;
		
		if(name!=null){
			users= userService.findByName(name);
		}else{
			users = userService.findAll();
		}
		
		return new ResponseEntity<>(
				users, 
				HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, params= {"lastname"})
	ResponseEntity<List<User>> getUserByLastname(@RequestParam(value="lastname", required=false) String name){
		
		List<User> users;
		
		if(name!=null){
			users= userService.findByLastname(name);
		}else{
			users = userService.findAll();
		}
		
		return new ResponseEntity<>(
				users, 
				HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, params= {"%firstname%"})
	ResponseEntity<List<User>> getUserByFirstnameLike(@RequestParam(value="firstname", required=false) String firstname){
		
		List<User> users;
		
		if(firstname!=null){
			users= userService.findByFirstnameLike(firstname);
		}else{
			users = userService.findAll();
		}
		
		return new ResponseEntity<>(
				users, 
				HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<User>> getUser(){List<User> users = userService.findAll();
	
		
		if(users == null || users.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	ResponseEntity<User> getUser(@PathVariable Long id){
		User user = userService.findOne(id);
		if(user==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	ResponseEntity<User> delete(@PathVariable Long id){
		userService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(method=RequestMethod.POST,
					consumes="application/json")
	public ResponseEntity<User> add(@RequestBody User newUser){
		User savedUser = userService.save(newUser);
		
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT,
			value="/{id}",
			consumes="application/json")
	public ResponseEntity<User> edit(
			@RequestBody User user,
			@PathVariable Long id){
		
		if(id!=user.getId()){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		User persisted = userService.save(user);
		
		return new ResponseEntity<>(persisted,HttpStatus.OK);
	}
	
	
	
}
