package framework;

import puzzles.*;
import framework.Room;

public final class Abilities {


	private static Room layout;
	private static Puzzle_Common view;

	private Abilities() {
		
	}

	public static Room getLayout() {
		return layout;
	}


	public static void setLayout(Room room_layout) {
		Abilities.layout = room_layout;
	}
	
	public static Puzzle_Common getView() {
		return view;
	}

	public static void setView(Puzzle_Common input) {
		view = input;
	}

// Verarbeitung der Nutzereingaben
	
	static void yesNo(String input) {
		if (getView().getYesnoquestion() == true) {
		if (input.contains("yes")) {
				  getView().performInteraction();
			  }
		else {
			getView().setYesnoquestion(false);
			Outputter.setReaction("You don't want to do this right now.");
		}
	}
	}
	
	public static void moveResult(String movement) {
		
		if(getView().getYesnoquestion() == false) {
			
			if (movement.contentEquals("north") && getLayout().getNorth().enterCondition() == true) {
				Outputter.setReaction("You shine your Flashlight north.");
				getLayout().getNorth().enterSetup();
				setView(getLayout().getNorth());
			}
			if (movement.contentEquals("south") && getLayout().getSouth().enterCondition() == true) {
				Outputter.setReaction("You shine your Flashlight south.");
				getLayout().getSouth().enterSetup();
				setView(getLayout().getSouth());
			}
			if (movement.contentEquals("east") && getLayout().getEast().enterCondition() == true) {
				Outputter.setReaction("You shine your Flashlight east.");
				getLayout().getEast().enterSetup();
				setView(getLayout().getEast());
			}
			if (movement.contentEquals("west") && getLayout().getWest().enterCondition() == true) {
				Outputter.setReaction("You shine your Flashlight west.");
				getLayout().getWest().enterSetup();
				setView(getLayout().getWest());
			}
			if (movement.contentEquals("up") && getLayout().getUp().enterCondition() == true) {
				Outputter.setReaction("You shine your Flashlight up.");
				getLayout().getUp().enterSetup();
				setView(getLayout().getUp());
			}
			if (movement.contentEquals("down") && getLayout().getDown().enterCondition() == true) {
				Outputter.setReaction("You shine your Flashlight down.");
				getLayout().getDown().enterSetup();
				setView(getLayout().getDown());
			}
		}
		else Outputter.setError("You need to make a decision.");

	}
	
	static void move(String movement) {
		
		if(getView().getYesnoquestion() == false) {
		
			getView().moveTest(movement);

	}
	else Outputter.setError("You need to make a decision.");

	}
	
	static void lookupPocket() {
		if(getView().getYesnoquestion() == false) {
			
		Pocket.lookupPocket();
	}
	else Outputter.setError("You need to make a decision.");
	}
	
	static void pickup(String [] pickup) {
		
		if(getView().getYesnoquestion() == false) {
			
		String pickupObject = "";
		Item pickedObject = null;
		
		for (String pickupTest : pickup) {
			if (getView().getItems() != null) {
			for (Item items : getView().getItems()) {
				
					if (items.getItemName().equalsIgnoreCase(pickupTest)) {
						pickupObject = items.getItemName();
						pickedObject = items;
						getView().removeItems(pickedObject);
						Pocket.addItem(pickedObject);
						break;
					}
					}
		}
			}
			
			if (pickupObject.contentEquals("")) {
				Outputter.setReaction("You can't pick that up.");
			} else
				Outputter.setReaction("You pick up the " + pickedObject.getItemName() + ".\n\nYou take a closer look: " + pickedObject.getItemDescription() + "\n\nYou put it in your Pocket.");

		
		}
			else Outputter.setError("You need to make a decision.");
	}

	
	static void usewith(String[] object1, String[] object2) {
		
		if(getView().getYesnoquestion() == false) {

		Item firstObject = null;
		Item secondObject = null;
		
		if (Pocket.getPocket() != null) {
		for (String object : object1) {
		for (Item pocket : Pocket.getPocket()) {
				if (pocket.getItemName().equalsIgnoreCase(object)) {
					firstObject = pocket;
					break;
				}
			}
		}
		}
		if (Pocket.getPocket() != null) {
			for (String object : object2) {
				for (Item pocket : Pocket.getPocket()) {
				if (pocket.getItemName().equalsIgnoreCase(object)) {
					secondObject = pocket;
					break;
				}
			}
		}
		}

			if (firstObject == null) {
				if (getView().getItems() != null) {
				for (String object : object1) {
				for (Item items : getView().getItems()) {
						if (items.getItemName().equalsIgnoreCase(object)) {
							firstObject = items;
							break;
						}
					}
				}
			}}
			if (secondObject == null) {
				if (getView().getItems() != null) {
				for (String object : object2) {
				for (Item items : getView().getItems()) {
						if (items.getItemName().equalsIgnoreCase(object)) {
							secondObject = items;
							break;
						}
					}
				}
			}
			}
			
			if (firstObject == null) {
				if (getView().getInteractionPoints() != null) {
				for (String object : object1) {
				for (Item interactionpoints : getView().getInteractionPoints()) {
						if (interactionpoints.getItemName().equalsIgnoreCase(object)) {
							firstObject = interactionpoints;
							break;
						}
					}
				}
			}
			}
			if (secondObject == null) {
				if (getView().getInteractionPoints() != null) {
				for (String object : object2) {
				for (Item interactionpoints : getView().getInteractionPoints()) {
						if (interactionpoints.getItemName().equalsIgnoreCase(object)) {
							secondObject = interactionpoints;
							break;
						}
					}
				}
			}
			}
		
		if (firstObject == null || secondObject == null
				|| firstObject.getItemName().contentEquals(secondObject.getItemName())) {
			Outputter.setReaction("You need two Objects to use in conjunction.");
		} else {
			Outputter.setReaction("You try to use the " + firstObject.getItemName() + " with the " + secondObject.getItemName());
			firstObject.itemCombination(secondObject);
		}
	
	}
	else Outputter.setError("You need to make a decision.");
		
	}
}