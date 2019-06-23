package jwd.wafepa.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jwd.wafepa.model.Address;

import jwd.wafepa.repository.AddressRepository;
import jwd.wafepa.service.AddressService;

@Service
public class JpaAddressService implements AddressService{

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address findOne(Long id) {

		return addressRepository.findOne(id);
	}

	@Override
	public List<Address> findAll() {

		return addressRepository.findAll();
	}

	@Override
	public Address save(Address address) {
	
		return addressRepository.save(address);
	}

	@Override
	public List<Address> save(List<Address> addreses) {

		return addressRepository.save(addreses);
	}

	@Override
	public Address delete(Long id) {
	
		Address toDelete = addressRepository.findOne(id);
		if(toDelete != null) {
			addressRepository.delete(toDelete);
		}
		return toDelete;
	}
	
	@Override
	public void delete(List<Long> ids) {
	
		for (Long id : ids) {
			addressRepository.delete(id);
		}
	}

	@Override
	public List<Address> findByName(String street) {
	
		return addressRepository.findByName(street);
	}
	
	@PostConstruct
	public void БилоШта(){
		save(new Address(null, "kuca", "2a"));
		save(new Address(null, "stan", "33c"));
	}

}
