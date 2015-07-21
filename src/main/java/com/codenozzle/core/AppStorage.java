package com.codenozzle.core;

import com.codenozzle.api.address.AddressStorage;
import com.codenozzle.api.order.OrderStorage;
import com.codenozzle.api.product.ProductStorage;
import com.codenozzle.api.user.UserStorage;

public class AppStorage {

	public static final UserStorage USER = new UserStorage();
	public static final ProductStorage PRODUCT = new ProductStorage();
	public static final OrderStorage ORDER = new OrderStorage();
	public static final AddressStorage ADDRESS = new AddressStorage();
	public static final FileDataStorage IMAGES = new FileDataStorage();
	
}
