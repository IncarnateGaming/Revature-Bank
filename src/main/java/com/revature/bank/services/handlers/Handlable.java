package com.revature.bank.services.handlers;

import java.util.List;

public interface Handlable {
	List<Object> list();
	List<Object> list(int accountId);
	List<Integer> listIds(int accountId);
	Object get(int id);
	Object update(Object object);
	Object save(Object object);
	Object delete(Object object);
	Object delete(int id);
	/**
	 * Gets the highest id from this classes Objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
}
