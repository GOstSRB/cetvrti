package jwd.wafepa.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import jwd.wafepa.model.Address;
import jwd.wafepa.service.AddressService;
import jwd.wafepa.support.AddressDTOToAddress;
import jwd.wafepa.support.AddressToAddressDTO;

@RestController
@RequestMapping(value="/api/address")
public class ApiAddressController {
	
	@Autowired
	private AddressService addressService;
	
//	@Autowired
//	private AddressToAddressDTO toDTO;
//	
//	@Autowired
//	private AddressDTOToAddress toAddress;

	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<Address>> getAddress(@RequestParam(value="street", required=false) String street){
		
		List<Address> addreses;
		
		if(street!=null){
			addreses= addressService.findByName(street);
		}else{
			addreses = addressService.findAll();
		}
		
		return new ResponseEntity<>(
				addreses, 
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	ResponseEntity<Address> getAddress(@PathVariable Long id){
		Address address = addressService.findOne(id);
		if(address == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				address,
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	ResponseEntity<Address> delete(@PathVariable Long id){
		Address deleted = addressService.delete(id);
		
		if(deleted == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				deleted,
				HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,
					consumes="application/json")
	public ResponseEntity<Address> add(
			@RequestBody Address newAddress){
		
		Address savedAddress = addressService.save(
				newAddress);
		
		return new ResponseEntity<>(
				savedAddress, 
				HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT,
			value="/{id}",
			consumes="application/json")
	public ResponseEntity<Address> edit(
			@RequestBody Address address,
			@PathVariable Long id){
		
		if(!id.equals(address.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Address persisted = addressService.save(address);
		
		return new ResponseEntity<>(persisted, HttpStatus.OK);
	}
	
	
}
	

