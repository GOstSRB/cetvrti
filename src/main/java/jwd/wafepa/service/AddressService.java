package jwd.wafepa.service;

import java.util.List;

import jwd.wafepa.model.Address;

public interface AddressService {
	/**
	 * Returns an Address with specified ID.
	 * @param id ID of the Address
	 * @return Address, if Address with such ID
	 * exists, {@code null} if Address is not found.
	 */
	Address findOne(Long id);
	
	/**
	 *  
	 * @return List of all existing activities.
	 */
	List<Address> findAll();
	
	/**
	 * Persists an Address. If Address's id is null,
	 * a new id will be assigned automatically.
	 * @param Address
	 * @return Address state after persisting. 
	 */
	Address save(Address address);
	
	/**
	 * Persist a list of activities
	 * @param activities
	 * @return
	 */
	List<Address> save(List<Address> addreses);
	
	/**
	 * Deletes an Address having specified ID.
	 * @param id ID of the Address to be removed. 
	 * @return Removed Address if removal is successful. 
	 * If the Address was not found, an {@link IllegalArgumentException}
	 * is thrown.
	 */
	Address delete(Long id);
	
	/**
	 * Remove a list of activities.
	 * @param ids A {@link List} of Address IDs (each ID is of type {@link Long})
	 */
	void delete(List<Long> ids);
	
	/**
	 * 
	 * @param name
	 * @return List of Activities who's name equals the string
	 * given in the {@code name} parameter.
	 */
	List<Address> findByName(String street);


}
