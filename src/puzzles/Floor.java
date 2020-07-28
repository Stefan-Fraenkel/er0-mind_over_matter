package puzzles;

import framework.*;

public class Floor extends Puzzle_Common {

	private int tutorial_pocket = 0;
	
	private Item Flashlight_On = new Item ("Flashlight", "With the AA Battery inside it Shines a light.");
	private Item Flashlight_Off = new Item ("Flashlight", "A functionless Flashlight. It requires an AA Battery to work.", Flashlight_On , "Battery_combinable");
	private Item Battery = new Item("Battery", "An AA Battery. Commonly used in Flashlights", Flashlight_On, "Flashlight_combinable");
	
	private Item [] loot = {Flashlight_Off, Battery};
	
	private static int counter = 0;

	public Floor() {
		this.setItems(loot);
		this.setResult("You wake up with your head hurting.\nYou don't seem to remember much.\n\nYou try to look around. It's useless. You are engulfed in darkness.\nYou fumble around in the impenetrable void.");
	}
	
	public String getImage() {
		return null;
	}


	public String getDescription() {
		boolean check = false;
		for (Item pocket : Pocket.getPocket()) {

			if (pocket.getItemDescription().equalsIgnoreCase("With the AA Battery inside")) {
			check = true;
			break;
			}}
		if (check == false) {
		if (items.length == 1 && items[0] == Flashlight_Off || items.length == 2) {
			return "You are alone on the floor of some pitch black room.\n\nOn your right you touch something that feels like a Flashlight.\nMaybe you can pick it up.";
		}
		if (items.length == 1 && items[0] == Battery) {
			return "You are alone on the floor of some pitch black room.\n\nOn your left you touch something that feels like a Battery.\nMaybe you can pick it up.";
		}
		else return "You can't find anything else.\nSurrounded by nothingness you wonder if there is a way to light this place up.";
		}
		else return "There is nothing interesting left on the floor.";
	}

	
	public String getResult() {
		if (counter < 1) {
			counter++;
			Outputter.setActions(
				"\n _________________________\r\n" + 
				"|                         |\r\n" + 
				"|         Pick up         |\r\n" + 
				"|_________________________|");
			return this.result;
		}
		else if (items.length <= 1 && Pocket.getPocket().length == 1 && Pocket.getPocket()[0].getItemDescription().contains("With the AA Battery inside")) {
			Outputter.resetActions();
			this.result = null;
			return "With the Battery inside you can Shine the Flashlight in different directions and explore this place.";
			
		}
		else if (items.length == 2 && Pocket.getPocket().length == 1 && Pocket.getPocket()[0].getItemDescription().contains("With the AA Battery inside")) {
			Outputter.resetActions();
			this.result = null;
			return "This works!\nYou use your precognitive abilities to find the Flashlight and a Battery in the dark and put them together.\nNow you can Shine the Flashlight in different directions and explore this place.";
		}
		else if (items.length == 0 && Pocket.getPocket().length == 2) {
			Outputter.setActions(
			  		"\n _________________________   _________________________   _________________________\r\n" + 
					  "|                         | |                         | |                         |\r\n" + 
					  "|         Pick up         | |      Use X with Y       | |          Pocket         |\r\n" + 
					  "|_________________________| |_________________________| |_________________________|");
			return "You remember that things you have collected can be used with the environment or with each other!";
		}
		else if (items.length == 1 && Pocket.getPocket().length == 1 && Pocket.getPocket()[0] == Flashlight_On) {
			Outputter.setActions(
			  		"\n _________________________   _________________________   _________________________\r\n" + 
					  "|                         | |                         | |                         |\r\n" + 
					  "|         Pick up         | |      Use X with Y       | |          Pocket         |\r\n" + 
					  "|_________________________| |_________________________| |_________________________|");
			return "Now you can Shine the Flashlight in different directions and explore this place.";
		}
		else if (items.length == 1 && items[0] == Flashlight_Off && tutorial_pocket == 0) {
			tutorial_pocket++;
			Outputter.setActions(
			  "\n _________________________   _________________________\r\n" + 
				"|                         | |                         |\r\n" + 
				"|         Pick up         | |          Pocket         |\r\n" + 
				"|_________________________| |_________________________|");
			return "In doing so you notice your Pocket.\nOf course! You can put all kinds of stuff in it and see what you have collected by looking in your Pocket.\n\nYou wonder why you ignored the obvious Flashlight and reached for something else in the dark.\nBut this is a strange situation anyway.";
		}
		else if (items.length == 1 && items[0] == Battery && tutorial_pocket == 0) {
			tutorial_pocket++;
			Outputter.setActions(
					  "\n _________________________   _________________________\r\n" + 
						"|                         | |                         |\r\n" + 
						"|         Pick up         | |          Pocket         |\r\n" + 
						"|_________________________| |_________________________|");
			return "In doing so you notice your Pocket.\nOf course! You can put all kinds of stuff in it and see what you have collected by looking in your Pocket.\n\nYou search the darkness once more.";
		}
		else {
			return this.result;
		}
	}

	public boolean getYesnoquestion() {
		return false;
	}
	
	public String getQuestion() {
		return "What do you do?";
	}

}
