package com.codenozzle.db;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import com.codenozzle.model.Entity;
import jersey.repackaged.com.google.common.collect.Maps;

public abstract class EntityStorage<T extends Entity> {

	private final Map<Integer, T> storage = Maps.newLinkedHashMap();
    private final AtomicInteger counter = new AtomicInteger(0);
	
	public T store(final T entity) {
    	if (entity.getId() == null) {
    		entity.setId(counter.addAndGet(1));
    	}
        return storage.put(entity.getId(), entity);
    }

    public T get(final int id) {
        return storage.get(id);
    }

    public Collection<T> getAllAsList() {
        return storage.values();
    }
    
    public Map<Integer, T> getAll() {
        return storage;
    }

    public T remove(final int id) {
        return storage.remove(id);
    }
    
    public int removeAll() {
    	int count = storage.size();
        storage.clear();
        return count;
    }
    
    public void storeAll(List<T> entities) {
    	for (T entity : entities) {
    		store(entity);
    	}
	}
    
    public int getRandomKey() {
		Object[] keys = storage.keySet().toArray();
		Object key = keys[new Random().nextInt(keys.length)];
		return ((Integer) key).intValue();
	}
    
    public T getRandom() {
    	return storage.get(getRandomKey());
	}
    
}
