package puzzles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import framework.Abilities;
import framework.Item;
import framework.Outputter;

/*
Sammlung aller Funktionen, die Puzzle zur Verfügung stellen müssen.
Außerdem werden Standardimplementierungen bereitgestellt, die bei Bedarf in den Kind-Klassen überschrieben werden können.
 */

public abstract class Puzzle_Common {

	protected Item[] items = {};
	protected Item[] interactionpoints;
	protected String result;
	protected String description;
	protected String image;
	protected String question;
	protected boolean completion;
	protected boolean yesno;


	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] input) {
		this.items = input;
	}

	public void removeItems(Item item) {
		List<Item> list = new ArrayList<Item>(Arrays.asList(this.items));
		list.removeAll(Arrays.asList(item));
		items = list.toArray(new Item[0]);
	}

	public String getImage() {
		return this.image;
	}

	public String getDescription() {
		return this.description;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getQuestion() {
		return this.question;
	}

	public boolean getYesnoquestion() {
		return this.yesno;
	}

	public void setYesnoquestion(boolean input) {
		this.yesno = input;
	}

	public void performInteraction() {
		
	}
	
	public void performInteraction(Item item1, Item item2) {
		
	}

	public boolean getCompletion() {
		return this.completion;
	}

	public void setCompletion(boolean bol) {
		this.completion = bol;
	}
	
	public void moveTest(String movement) {
		String direction = null;
		if (Abilities.getLayout().getNorth().equals(this)) {
			direction = "North";
		}
		if (Abilities.getLayout().getSouth().equals(this)) {
			direction = "South";
		}
		if (Abilities.getLayout().getEast().equals(this)) {
			direction = "East";
		}
		if (Abilities.getLayout().getWest().equals(this)) {
			direction = "West";
		}
		if (Abilities.getLayout().getUp().equals(this)) {
			direction = "Up";
		}
		if (Abilities.getLayout().getDown().equals(this)) {
			direction = "Down";
		}

		if (movement.equalsIgnoreCase(direction)) {
			Outputter.setReaction("You are already looking in that direction.");
		} else
			Abilities.moveResult(movement);

	}

	public boolean enterCondition() {
		return true;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void enterSetup() {
		if (this.getCompletion() == false) {
			this.setYesnoquestion(true);
		}
	}

	public Item[] getInteractionPoints() {
		return this.interactionpoints;
	}

	public void setInteractionPoints(Item[] interactionpoints) {
		this.interactionpoints = interactionpoints;
	}

}
