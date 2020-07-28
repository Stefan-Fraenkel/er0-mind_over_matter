package framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Pocket {

	
	private static Item[] pocketArray = new Item[0];
	
	public static Item[] getPocket() {
		return pocketArray;
	}
	
	public static void lookupPocket() {

		String inventory = "";
		for (Item items : Pocket.getPocket()) {
			inventory += "\n\n" + items.getItemName() + "\n- " + items.getItemDescription();
		}
		if (inventory.contentEquals("")) {
			inventory = "You feel around in your Pocket. It seems to be empty.";
		}
		else if (inventory.contains("With the Battery inside it Shines a light.")) {
			inventory = "You look in your pocket. You find the following items:" + inventory;
		}
		else inventory = "You feel around in your pocket. You find the following items:" + inventory;
		
		Outputter.setPocket(inventory);

	}

	public static void addItemAuto(Item item) {
		Outputter.setReaction("You pick up the " + item.getItemName() + ".\nYou take a closer look.\n" + item.getItemDescription() + "\nYou put it in your Pocket.");
		addItem(item);
	}
	
	public static void addItem(Item item) {
		List<Item> list = new ArrayList<Item>(Arrays.asList(pocketArray));
		list.addAll(Arrays.asList(item));
		pocketArray = list.toArray(new Item[0]);
	}

	public static void removeItem(Item item) {
		List<Item> list = new ArrayList<Item>(Arrays.asList(pocketArray));
		list.removeAll(Arrays.asList(item));
		pocketArray = list.toArray(new Item[0]);
	}
}
