package puzzles;

import framework.Abilities;
import framework.Item;
import framework.Outputter;
import framework.Pocket;

public class Items1_Blank extends Puzzle_Common {

	private boolean completed;

	private Puzzle_Common other;
	private String otherlocation;

	private boolean naileddown = false;
	private boolean planked = false;
	
	private String leverup =
			"\n             ___ (@)" +
			"\n            |.-.|/ " +
			"\n            || |/" +
			"\n            || /|" +
			"\n            ||/||" +
			"\n            || ||" +
			"\n            ||_||" +
			"\n            '---'";
	private String leverdown = 
			"\n             ___" +
			"\n            |.-.| " +
			"\n            || ||" +
			"\n            || ||" +
			"\n            ||\\||" +
			"\n            || \\|" +
			"\n            ||_|\\" +
			"\n            '---'\\" +
			"\n                 (@)";
	private String leverplanked = 
			"\n             ___ (@)" +
			"\n            |.-.|/ " +
			"\n            || |/" +
			"\n            || /|" +
			"\n            ||/||" +
			"\n    ,-------'---'-------," +
			"\n    |___________________|" +
			"\n            '---'";
	private String displayoff =
			"\n  __________________________\n" + 
			" |                          |\n" +
			" |                          |\n" +
			" |__________________________|\n";
	private String display;

	private Item Wall = new Item("Wall", "A Wall made of wood.", "Plank_usable");
	private Item Panel = new Item("Panel", "A wooden Panel", "Plank_usable");
	private Item Slot = new Item("Slot", "A slot in the middle of the wooden Wall.", "Plank_usable");
	private Item Lever = new Item("Lever", "A Lever in the middle of the wooden Wall.", "Plank_usable");


	private Item[] pois = { Wall, Panel, Slot, Lever };

	public Items1_Blank() {
		this.setCompletion(false);
		this.setInteractionPoints(pois);
	}

	public String getImage() {
		return this.image;

		
	}
	
	public boolean getNaileddown() {
		return naileddown;
	}

	public void setNaileddown(boolean naileddown) {
		this.naileddown = naileddown;
	}

	public String getDescription() {
		if (this.getCompletion() == false) {
			return "You see a wooden Wall in front of you.\nThere is a vertical Slot in the middle of it with a Lever sticking out and a display above it.\nThe display is currently off.\nThe Lever is pointing downwards.";
		} 		else if (this.getCompletion() == true && this.other.getCompletion() == false && this.getNaileddown() == true) {
			return "You see a wooden Wall in front of you.\nThere is a vertical Slot in the middle of it with a Lever sticking out and a display above it.\nThe Lever is pointing upwards.\nYou have nailed the Plank below holding it in place.\nThe display reads: You're half there!\n\nLooks like you are done here.";
		}
		else if (this.getCompletion() == true && this.other.getCompletion() == false) {
			return "You see a wooden Wall in front of you.\nThere is a vertical Slot in the middle of it with a Lever sticking out and a display above it.\nThe Lever is pointing upwards.\nThe display reads: You're half there!";
		}
		else
			return "The display on this Wall together with the display on the " + otherlocation + " seem to be talking to you.\nThey say: \"Look Up\".\n\nLooks like you are done here.";
	}

	public String getResult() {
		if (this.getCompletion() == true && this.completed == true) {
			return null;
		} else
			return this.result;
	}

	public String getQuestion() {
		if (this.getCompletion() == false && this.getYesnoquestion() == true) {
			return "Do you want to push it up?";
		} else
			return "What do you do?";
	}

	public boolean getCompletion() {
		if (this.getNaileddown() == true) {
			return true;
		} else
			return this.completion;
	}

	public void performInteraction(Item item1, Item item2) {
		this.setOther();
		if (this.getCompletion() == true && this.planked == true && ((item1.getItemName().equals("Plank") && item2.getItemName().equals("Nails")) | (item1.getItemName().equals("Nails") && item2.getItemName().equals("Plank"))) || ((item1.getItemName().equals("Plank") && item2.getItemName().equals("Hammer")) | (item1.getItemName().equals("Hammer") && item2.getItemName().equals("Plank"))) || ((item1.getItemName().equals("Hammer") && item2.getItemName().equals("Nails")) | (item1.getItemName().equals("Nails") && item2.getItemName().equals("Hammer")))) {
			this.setCompletion(true);
			this.setNaileddown(true);
			this.setYesnoquestion(false);
			Pocket.removeItem(item1);
			Pocket.removeItem(item2);
			this.setResult("You use your Hammer to nail the wooden Plank below the Lever.\nThis should hold. Now the Lever will stay in place.");
			}
		else if (this.getCompletion() == true && (item1.getItemName().equals("Plank") && !item2.getItemName().equals("Hammer") && !item2.getItemName().equals("Nails")) | (item2.getItemName().equals("Plank") && !item1.getItemName().equals("Hammer") && !item1.getItemName().equals("Nails"))) {
			this.setCompletion(true);
			this.setYesnoquestion(false);
			this.planked = true;
			this.setResult("You hold the wooden Plank below the Lever. Now the Lever won't drop down. But you still need something to hold the Plank in place.");
		}
		else this.setResult("This doesn't work.");
	}
	
	public void performInteraction() {
		this.setOther();
		if (this.getCompletion() == false && this.other.getCompletion() == false) {
			this.setResult("You push the Lever.\nThe display comes to life.");
			this.setCompletion(true);
			this.setYesnoquestion(false);
		} else if (this.getCompletion() == false && this.other.getCompletion() == true) {
			this.other.setCompletion(false);
			this.setCompletion(true);
			if (this.other.getCompletion() == true) {
				this.setResult(
						"You push the Lever.\nThe display comes to life. It reads: 'You have'.\nAt the same time the display at "
								+ otherlocation + " changes. It reads: 'made it!'.\n\nThen both displays begin flickering and change again.\nThe display on this Wall now reads: 'Look'.\nThe display on the " + otherlocation + " reads: 'Up'");
				this.setYesnoquestion(false);
			} else {
				this.setResult("You push the Lever.\nThe display comes to life.\nAt the same time you hear a noise at "
						+ otherlocation + ".");
				this.other.setYesnoquestion(true);
				this.setYesnoquestion(false);
			}
		} 

	}

	public Puzzle_Common getOther() {
		return other;
	}

// Find Wall of other location

	public void setOther() {
		if (Abilities.getLayout().getNorth().getClass().getSimpleName().contains("Items2")) {
			this.other = Abilities.getLayout().getNorth();
			this.otherlocation = "the northern Wall";
		}

		if (Abilities.getLayout().getSouth().getClass().getSimpleName().contains("Items2")) {
			this.other = Abilities.getLayout().getSouth();
			this.otherlocation = "the southern Wall";
		}

		if (Abilities.getLayout().getEast().getClass().getSimpleName().contains("Items2")) {
			this.other = Abilities.getLayout().getEast();
			this.otherlocation = "the eastern Wall";
		}

		if (Abilities.getLayout().getWest().getClass().getSimpleName().contains("Items2")) {
			this.other = Abilities.getLayout().getWest();
			this.otherlocation = "the western Wall";
		}

		if (Abilities.getLayout().getUp().getClass().getSimpleName().contains("Items2")) {
			this.other = Abilities.getLayout().getUp();
			this.otherlocation = "above you";
		}

		if (Abilities.getLayout().getDown().getClass().getSimpleName().contains("Items2")) {
			this.other = Abilities.getLayout().getDown();
			this.otherlocation = "below you";
		}
	}

	public boolean enterCondition() {
		boolean check = false;
		for (Item pocket : Pocket.getPocket()) {
			if (pocket.getItemDescription().contains("With the AA Battery inside")) {
				check = true;
				break;
			}
		}
		if (check == false) {
			Outputter.setEnter("It is too dark to look around. Maybe I can find a way to light up this room.");
		}
		return check;
	}

	public void enterSetup() {
		this.setOther();
		if (this.getCompletion() == false) {
			this.setYesnoquestion(true);
		}
		if (this.getCompletion() == true && this.getOther().getCompletion() == true && this.naileddown == false && !this.getOther().getDescription().contains("Looks like you are done here.")) {
			this.setCompletion(false);
		}
		if (this.getResult() != null && this.getNaileddown() == false && this.getResult().contains("You hold the wooden Plank below the Lever. Now the Lever won't drop down. But you still need something to hold the Plank in place.")) {
			this.planked = false;
		}
	}
	
	public void setYesnoquestion(boolean input) {
		if (this.getCompletion() == false) {
			this.yesno = input;
		} else
			this.yesno = false;

	}

}
