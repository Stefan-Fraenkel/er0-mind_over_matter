package puzzles;

import java.util.Scanner;

import framework.Item;
import framework.Outputter;
import framework.Pocket;

public class TicTacToe extends Puzzle_Common {
	
	private boolean exit;
	private boolean completed;

	public TicTacToe() {
		this.setCompletion(false);
	}
	
//Implementierte Interface Methoden
	
	public String getDescription() {
		if (this.getCompletion() == false) {
			return "There is some kind of safe installed inside the wall.\nIt does not seem to limit the number of tries for entering the right code.";
			}
		else return "The safe in the wall stands open.\nThere is nothing left inside.\nLooks like you are done here.";
	}
	
	public String getQuestion() {
		if (this.getCompletion() == false && this.getYesnoquestion() == true) {
		return "Do you want to try entering the code?";
		}
		else return "What do you do?";
	}
	
	
	public void setYesnoquestion(boolean input) {
		if (this.getCompletion() == false) {
		this.yesno = input;}
		else this.yesno = false;
	}

	
	public void testCompletion(int code) {
		if (code == 8416) {
			this.setCompletion(true);
			Outputter.setReaction("This must have been the correct code! The keypad beeps happily and the safe opens.\nTo your surprise there is nothing in it but a thin wooden Plank.");
			this.setYesnoquestion(false);
			Pocket.addItemAuto(new Item ("Plank", "A wooden Plank.", "Nails_usable", "Hammer_usable", "Slot_usable", "Wall_usable", "Slot_usable", "Panel_usable"));
		}
		else this.setResult("Seems like this code is incorrect.");
	}

	
	public String getResult() {
		if (this.getCompletion() == true && this.completed == false) {
			this.completed = true;
			return this.result;
		}
		else if (this.getCompletion() == true && this.completed == true) {
			return null;
		}
		else return this.result;
	}
	

	public String getImage() {
		return 
//				"\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n" + 
		"					 _________________________\n" + 
		"					|                         |\n" +
		"					|  Next X marks the Spot  |\n" +
		"					|_________________________|\n" +
		"\n" +
		"	 _____ _____ _____ 	 _____ _____ _____ 	 _____ _____ _____ 	 _____ _____ _____ \r\n" +
		"	|     |     |     |	|     |     |     |	|     |     |     |	|     |     |     |\r\n" +
		"	|  O  |  X  |  O  |	|  X  |     |  O  |	|     |  X  |  X  |	|  O  |     |  X  |\r\n" +
		"	|_____|_____|_____|	|_____|_____|_____|	|_____|_____|_____|	|_____|_____|_____|\r\n" +
		"	|     |     |     |	|     |     |     |	|     |     |     |	|     |     |     |\r\n" +
		"	|     |  X  |     |	|     |  O  |     |	|  X  |  O  |  O  |	|     |  O  |     |\r\n" +
		"	|_____|_____|_____|	|_____|_____|_____|	|_____|_____|_____|	|_____|_____|_____|\r\n" +
		"	|     |     |     |	|     |     |     |	|     |     |     |	|     |     |     |\r\n" +
		"	|  O  |     |  X  |	|  X  |     |  O  |	|     |  O  |  O  |	|  O  |     |  X  |\r\n" +
		"	|_____|_____|_____|	|_____|_____|_____|	|_____|_____|_____|	|_____|_____|_____|\n\n" +

				"					   _____________________ 	\r\n" +
				"					  |\\ _____ _____ _____ /|	\r\n" +
				"					  | |     |     |     |	|\r\n" +
				"					  | |  1  |  2  |  3  |	|\r\n" +
				"					  | |_____|_____|_____|	|\r\n" +
				"					  | |     |     |     |	|\r\n" +
				"					  | |  4  |  5  |  6  |	|\r\n" +
				"					  | |_____|_____|_____|	|\r\n" +
				"					  | |     |     |     |	|\r\n" +
				"					  | |  7  |  8  |  9  | |\r\n" +
				"					  | |_____|_____|_____|	|\r\n" +
				"					  | |                 | |\r\n" +
				"					  | |      Enter      | |\r\n" +
				"					  | |_________________| |\r\n" +
				"					  |/___________________\\|\n\n";
	}


	public void performInteraction() {
		this.setExit(false);
		  while (this.getCompletion() == false && this.getExit() == false) {
		  Scanner sc = new Scanner(System.in);
		  System.out.println("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
		    System.out.println(this.getImage());
		    if (this.getResult() != null) {
				 System.out.println(this.getResult());
			}
		    System.out.println("To leave this puzzle simply put in: 'exit'.\n\nPlease insert a 4-digit code:");
		    String input = sc.nextLine();
		    if (input.contains("exit")) {
		    	this.setYesnoquestion(true);
				this.setResult(null);
				this.setExit(true);
				}
		    else {
		    int zahl;
		    try {
		       zahl = Integer.parseInt(input);
		    }
		    catch (NumberFormatException e)
		    {
		       zahl = 0;
		    }
			this.testCompletion(zahl);
	  }
	  }
	}

	//Für dieses Puzzle spezifische Methoden
	
		public boolean getExit() {
			return exit;
		}

		public void setExit(boolean exit) {
			this.exit = exit;
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


}
