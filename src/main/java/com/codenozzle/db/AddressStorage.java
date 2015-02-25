package com.codenozzle.db;

import com.codenozzle.model.Address;

public final class AddressStorage extends EntityStorage<Address> {

	@Override
	public Address merge(Address current, Address updates) {
    	if (current != null) {
    		if (updates.getAddress1() != null) {
    			current.setAddress1(updates.getAddress1());
        	}
        	if (updates.getAddress2() != null) {
        		current.setAddress2(updates.getAddress2());
        	}
        	if (updates.getCity() != null) {
        		current.setCity(updates.getCity());
        	}
        	if (updates.getState() != null) {
        		current.setState(updates.getState());
        	}
        	if (updates.getZip() != null) {
        		current.setZip(updates.getZip());
        	}
    	}
		return current;
	}

}
