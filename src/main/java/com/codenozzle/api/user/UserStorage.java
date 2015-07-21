package com.codenozzle.api.user;

import com.codenozzle.core.EntityStorage;

public final class UserStorage extends EntityStorage<User> {

    @Override
	public User merge(User current, User updates) {
    	if (current != null) {
    		if (updates.getFirstName() != null) {
    			current.setFirstName(updates.getFirstName());
        	}
        	if (updates.getLastName() != null) {
        		current.setLastName(updates.getLastName());
        	}
        	if (updates.getEmailAddress() != null) {
        		current.setEmailAddress(updates.getEmailAddress());
        	}
        	if (updates.isActive() != null) {
        		current.setActive(updates.isActive());
        	}
    	}
		return current;
	}

}
