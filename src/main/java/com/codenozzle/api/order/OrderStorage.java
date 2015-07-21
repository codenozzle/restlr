package com.codenozzle.api.order;

import com.codenozzle.core.EntityStorage;

public final class OrderStorage extends EntityStorage<Order> {

	@Override
	public Order merge(Order current, Order updates) {
    	/*if (current != null) {
    		if (updates.getUserId() != null) {
    			current.setUserId(updates.getUserId());
        	}
        	if (updates.getShippingAddressId() != null) {
        		current.setShippingAddressId(updates.getShippingAddressId());
        	}
        	if (updates.getBillingAddressId() != null) {
        		current.setBillingAddressId(updates.getBillingAddressId());
        	}
    	}*/
		return current;
	}
	
}
