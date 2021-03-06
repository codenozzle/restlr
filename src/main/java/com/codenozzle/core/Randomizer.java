package com.codenozzle.core;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import com.codenozzle.api.address.Address;
import com.codenozzle.api.order.Order;
import com.codenozzle.api.order.OrderLineItem;
import com.codenozzle.api.order.OrderStatus;
import com.codenozzle.api.product.Product;
import com.codenozzle.api.user.User;

public class Randomizer {

	private static Random rand;
	
	public static void loadSampleData() {
		rand = new Random();
		loadSampleUsers();
		loadSampleProducts();
		loadSampleAddresses();
		loadSampleOrders();
	}
	
	public static void reloadSampleData() {
		removeSampleData();
		loadSampleData();
	}

	private static void removeSampleData() {
		AppStorage.ORDER.removeAll();
		AppStorage.PRODUCT.removeAll();
		AppStorage.ADDRESS.removeAll();
		AppStorage.USER.removeAll();
		AppStorage.IMAGES.removeAll();
	}

	private static void loadSampleAddresses() {
		List<Address> addressList = new ArrayList<Address>();
		
		addressList.add(new Address("Mason Smith", "9199 Hillside Avenue", "", "Fayetteville", "NC", "28303"));
		addressList.add(new Address("Jacob Johnson", "9246 Windsor Drive", "", "Glenview", "IL", "60025"));
		addressList.add(new Address("Michael Williams", "9783 Linden Street", "Apt 203", "North Ridgeville", "OH", "44039"));
		addressList.add(new Address("Daniel Jones", "3009 King Street", "", "Pittsfield", "MA", "01201"));
		addressList.add(new Address("Jackson Brown", "8072 Chestnut Avenue", "", "Saint Paul", "MN", "55104"));
		addressList.add(new Address("Luke Thompson", "8169 Hilltop Road", "Apt 6", "Soddy Daisy", "TN", "37379"));
		addressList.add(new Address("Hunter Moore", "864 12th Street", "", "Ypsilanti", "MI", "48197"));
		addressList.add(new Address("Archer Green", "385 Harrison Street", "", "Altoona", "PA", "16601"));
		addressList.add(new Address("Evan Carter", "837 Laurel Lane", "", "Mount Laurel", "NJ", "08054"));
		addressList.add(new Address("Charles Henderson", "842 Court Street", "", "Madisonville", "KY", "42431"));
		addressList.add(new Address("Jacob Johnson", "348 Cambridge Road", "", "Frederick", "MD", "21701"));
		addressList.add(new Address("Michael Williams", "221 Elizabeth Street", "", "Janesville", "WI", "53546"));
		
		AppStorage.ADDRESS.storeAll(addressList);
	}

	private static void loadSampleUsers() {
		List<User> userList = new ArrayList<User>();
		
		userList.add(new User("Mason", "Smith", "Mason.Smith@gmail.com", true));
		userList.add(new User("Jacob", "Johnson", "Jacob.Johnson@gmail.com", true));
		userList.add(new User("Michael", "Williams", "Michael.Williams@gmail.com", true));
		userList.add(new User("Daniel", "Jones", "Daniel.Jones@gmail.com", true));
		userList.add(new User("Jackson", "Brown", "Jackson.Brown@gmail.com", true));
		userList.add(new User("Luke", "Thompson", "Luke.Thompson@gmail.com", true));
		userList.add(new User("Hunter", "Moore", "Hunter.Moore@gmail.com", true));
		userList.add(new User("Archer", "Green", "Archer.Green@gmail.com", true));
		userList.add(new User("Evan", "Carter", "Evan.Carter@gmail.com", true));
		userList.add(new User("Charles", "Henderson", "Charles.Henderson@gmail.com", true));

		AppStorage.USER.storeAll(userList);
	}

	private static void loadSampleProducts() {
		List<Product> productList = new ArrayList<Product>();
		
		productList.add(new Product("MB-284", "Motherboard", "Motherboard description", new BigDecimal("125"), true));
		productList.add(new Product("PR-3674", "Processor", "Processor description", new BigDecimal("178"), true));
		productList.add(new Product("RM-1211", "Ram", "Ram description", new BigDecimal("48"), true));
		productList.add(new Product("HD-7906", "Hard drive", "Hard drive description", new BigDecimal("371"), true));
		productList.add(new Product("CC-1123", "Computer case", "Computer case description", new BigDecimal("99"), true));
		productList.add(new Product("BD-9786", "Blu-ray drive", "Blu-ray drive description", new BigDecimal("37"), true));

		AppStorage.PRODUCT.storeAll(productList);
	}

	private static void loadSampleOrders() {
		List<Order> orderList = new ArrayList<Order>();
		for (int i = 0; i < 20; i++) {
			Order order = new Order(getRandomUser(), getRandomAddress(), getRandomAddress(), getRandomOrderStatus(), LocalDateTime.now());
			order.setLineItems(getRandomLineItems());
			order.calculateTotals();
			orderList.add(order);
		}
		
		AppStorage.ORDER.storeAll(orderList);
	}

	private static Collection<OrderLineItem> getRandomLineItems() {
		Collection<OrderLineItem> lineItems = new ArrayList<OrderLineItem>();
		for (int i = 0; i < 5; i++) {
			lineItems.add(new OrderLineItem(getRandomProduct(), getRandomQuantity()));
		}
		return lineItems;
	}

	private static Integer getRandomQuantity() {
		return randInt(1, 20);
	}

	private static Product getRandomProduct() {
		return AppStorage.PRODUCT.getRandom();
	}

	private static OrderStatus getRandomOrderStatus() {
		return OrderStatus.getAll().get(randInt(1, OrderStatus.getAll().size()));
	}

	private static Address getRandomAddress() {
		return AppStorage.ADDRESS.getRandom();
	}

	private static User getRandomUser() {
		return AppStorage.USER.getRandom();
	}

	private static int randInt(int min, int max) {
		return rand.nextInt((max - min)) + min;
	}
	
}
