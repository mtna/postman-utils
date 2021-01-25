package us.mtna.postman.collection.model;

import java.util.ArrayList;
import java.util.List;

import us.mtna.postman.model.Item;
import us.mtna.postman.model.ItemGroup;
import us.mtna.postman.model.ItemImpl;

public class ModelUtils {

	/**
	 * Iterates through the provided list of {@link Item} and pulls out all the
	 * {@link ItemImpl} and returns them.
	 * 
	 * @param items the {@link Item}s to iterate through
	 * @return a list of all the {@link ItemImpl} found.
	 */
	public static List<ItemImpl> getRequestItems(List<Item> items) {
		List<ItemImpl> requests = new ArrayList<>();
		for (Item item : items) {
			if (item instanceof ItemGroup) {
				requests.addAll(getRequestItems(((ItemGroup) item).getItem()));
			} else {
				requests.add((ItemImpl) item);
			}
		}
		return requests;
	}

	/**
	 * Iterates through the provided list of {@link Item}s and flattens them into an
	 * un-nested list to be able to more easily manipulate.
	 * 
	 * @param items the {@link Item}s to flatten.
	 * @return the flat list of the {@link Item}s
	 */
	public static List<Item> flattenItems(List<Item> items) {
		List<Item> flatList = new ArrayList<>();
		for (Item item : items) {
			if (item instanceof ItemGroup) {
				flatList.addAll(flattenItems(((ItemGroup) item).getItem()));
			} else {
				flatList.add((ItemImpl) item);
			}
		}
		return flatList;
	}

}
