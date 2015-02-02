package com.codenozzle.app;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import com.codenozzle.db.AppStorage;
import com.codenozzle.model.Address;
import com.codenozzle.model.Order;
import com.codenozzle.model.OrderStatus;
import com.codenozzle.model.Product;
import com.codenozzle.model.User;

public class Randomizer {

	private Random rand;
	
	public void loadSampleData() {
		rand = new Random();
		loadSampleUsers();
		loadSampleProducts();
		loadSampleAddresses();
		loadSampleOrders();
	}
	
	public void reloadSampleData() {
		removeSampleData();
		loadSampleData();
	}

	private void removeSampleData() {
		AppStorage.ORDER.removeAll();
		AppStorage.PRODUCT.removeAll();
		AppStorage.ADDRESS.removeAll();
		AppStorage.USER.removeAll();
	}

	private void loadSampleAddresses() {
		List<Address> addressList = new ArrayList<Address>();
		addressList.add(new Address("Address 1", "Address 1", "Wilmington", "NC", "24578"));
		addressList.add(new Address("Address 2", "Address 2", "Raleigh", "NC", "12457"));
		addressList.add(new Address("Address 3", "Address 3", "Wilmington", "NC", "24578"));
		addressList.add(new Address("Address 4", "Address 4", "Raleigh", "NC", "24578"));
		addressList.add(new Address("Address 5", "Address 5", "Durham", "NC", "46565"));
		addressList.add(new Address("Address 6", "Address 6", "Cary", "NC", "85796"));
		addressList.add(new Address("Address 7", "Address 7", "Shallotte", "NC", "24578"));
		addressList.add(new Address("Address 8", "Address 8", "Asheville", "NC", "11245"));
		
		AppStorage.ADDRESS.storeAll(addressList);
	}

	private void loadSampleUsers() {
		List<User> userList = new ArrayList<User>();
		userList.add(new User("First Name 1", "Last Name 1", "Email Address 1", true));
		userList.add(new User("First Name 2", "Last Name 2", "Email Address 2", true));
		userList.add(new User("First Name 3", "Last Name 3", "Email Address 3", true));
		userList.add(new User("First Name 4", "Last Name 4", "Email Address 4", true));
		userList.add(new User("First Name 5", "Last Name 5", "Email Address 5", true));
		userList.add(new User("First Name 6", "Last Name 6", "Email Address 6", true));

		AppStorage.USER.storeAll(userList);
	}

	private void loadSampleProducts() {
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product("MB-284", "Motherboard", "Motherboard description", new BigDecimal("125"), true));
		productList.add(new Product("PR-3674", "Processor", "Processor description", new BigDecimal("178"), true));
		productList.add(new Product("RM-1211", "Ram", "Ram description", new BigDecimal("48"), true));
		productList.add(new Product("HD-7906", "Hard drive", "Hard drive description", new BigDecimal("371"), true));
		productList.add(new Product("CC-1123", "Computer case", "Computer case description", new BigDecimal("99"), true));
		productList.add(new Product("BD-9786", "Blu-ray drive", "Blu-ray drive description", new BigDecimal("37"), true));

		AppStorage.PRODUCT.storeAll(productList);
	}

	private void loadSampleOrders() {
		List<Order> orderList = new ArrayList<Order>();
		for (int i = 0; i < 20; i++) {
			orderList.add(new Order(getRandomUser(), getRandomAddress(), getRandomAddress(), getRandomOrderStatus(), getNow(), true));
		}
		
		AppStorage.ORDER.storeAll(orderList);
	}

	private OrderStatus getRandomOrderStatus() {
		return OrderStatus.values()[randInt(1, OrderStatus.values().length)];
	}

	private Timestamp getNow() {
		return new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
	}

	private Address getRandomAddress() {
		return AppStorage.ADDRESS.getRandom();
	}

	private User getRandomUser() {
		return AppStorage.USER.getRandom();
	}

	private int randInt(int min, int max) {
		return rand.nextInt((max - min)) + min;
	}
	
}
