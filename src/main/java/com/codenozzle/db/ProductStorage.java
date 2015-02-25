package com.codenozzle.db;

import com.codenozzle.model.Product;

public final class ProductStorage extends EntityStorage<Product> {
    
    @Override
    public Product merge(Product current, Product updates) {
    	if (current != null) {
    		if (updates.getProductSku() != null) {
    			current.setProductSku(updates.getProductSku());
        	}
        	if (updates.getProductName() != null) {
        		current.setProductName(updates.getProductName());
        	}
        	if (updates.getDescription() != null) {
        		current.setDescription(updates.getDescription());
        	}
        	if (updates.getPrice() != null) {
        		current.setPrice(updates.getPrice());
        	}
        	if (updates.isActive() != null) {
        		current.setActive(updates.isActive());
        	}
    	}
		return current;
    }

}
