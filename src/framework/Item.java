package framework;

public class Item {

	private String itemName;
	private String itemDescription;
	private String itemUsableWith = "";
	private String itemCombinableWith = "";
	private Item itemCombined;
		

	public Item(String name, String description) {
		this.setItemName(name);
		this.setItemDescription(description);
	}
	
	public Item(String name, String description, String...input) {
		this.setItemName(name);
		this.setItemDescription(description);
		for (String test : input) {
			if (test.endsWith("_usable")) {
				test = test.replace("_usable", "");
				this.setItemUsableWith(test);
			}
			else if (test.endsWith("_combinable")) {
				test = test.replace("_combinable", "");
				this.setItemCombinableWith(test);
				}
		}
	}
	
	public Item(String name, String description, Item comboitem, String...input) {
		this.setItemName(name);
		this.setItemDescription(description);
		this.setCombinedItem(comboitem);
		for (String test : input) {
			if (test.endsWith("_usable")) {
				test = test.replace("_usable", "");
				this.setItemUsableWith(test);
			}
			else if (test.endsWith("_combinable")) {
				test = test.replace("_combinable", "");
				this.setItemCombinableWith(test);
				}
		}
	}
	

	public String getItemName() {
		return itemName;
	}

	private void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	private void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getItemUsableWith() {
		return itemUsableWith;
	}

	private void setItemUsableWith(String itemUsableWith) {
		this.itemUsableWith += itemUsableWith + " ";
	}

	public String getItemCombinableWith() {
		return itemCombinableWith;
	}

	private void setItemCombinableWith(String itemCombinableWith) {
		this.itemCombinableWith += itemCombinableWith + " ";
	}
	
	private void setCombinedItem(Item input) {
		this.itemCombined = input;
	}
	
	private Item getCombinedItem() {
		return itemCombined;
	}
	
public void itemCombination (Item input) {
	if (input.getItemCombinableWith().contains(this.getItemName()) || this.getItemCombinableWith().contains(input.getItemName())) {
		if (this.getCombinedItem() != null) {
		Pocket.addItem(this.getCombinedItem());
		Abilities.getView().setResult("This works!\nYou inspect your " + this.getCombinedItem().getItemName() + "\n" + this.getCombinedItem().getItemDescription() + "\nYou put it in your Pocket.");
		}
		else if (input.getCombinedItem() != null) {
		Pocket.addItem(this.getCombinedItem());
		Abilities.getView().setResult("This works!\n\nYou inspect your " + this.getCombinedItem().getItemName() + "\n" + this.getCombinedItem().getItemDescription() + "\nYou put it in your Pocket.");
		}
		Pocket.removeItem(input);
		Pocket.removeItem(this);
	}
	else if (input.getItemUsableWith().contains(this.getItemName()) || this.getItemUsableWith().contains(input.getItemName())) {
		Abilities.getView().performInteraction(this, input);
	}
	else Abilities.getView().setResult("This combination won't work.");

}
	
}
