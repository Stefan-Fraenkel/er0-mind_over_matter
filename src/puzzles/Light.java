package puzzles;

import java.util.Scanner;

import framework.Item;
import framework.Outputter;
import framework.Pocket;

public class Light extends Puzzle_Common {

	private boolean [] lights = {false, false, false, false};
	private boolean exit;
	private boolean completed;

	private String on1 = "      .        ";
	private String off1 = "               ";

	private String on2 = " .    |    ,   ";
	private String off2 = "               ";

	private String on3 = "  \\   '   /    ";
	private String off3 = "               ";
	
	private String on4 = "   ` ,-. '     ";
	private String off4 = "     ,-.       ";
	
	private String line5 =
			"	    (   )          (   )          (   )          (   )    \r\n" + 
			"	     \\ /            \\ /            \\ /            \\ /\r\n" + 
			"	    _|=|_          _|=|_          _|=|_          _|=|_";
//			+ "\r\n" + 
//			"   |_____|        |_____|        |_____|        |_____|";



	public Light() {
		this.setCompletion(false);
	}
	
//Implementierte Interface Methoden
	
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
	
	public String getDescription() {
		if (this.getCompletion() == false) {
			return "There is a dimmly lit machine mounted on the wall.\nIts numbered buttons are too stiff to be pressed by hand. A lot of force seems to be required to make them move.\nLuckily there is a Claw Hammer attached to the machine with a chain.";
			}
		else return "All four lights are turned on.\nLooks like you are done here.";
	}
	
	public String getQuestion() {
		if (this.getCompletion() == false && this.getYesnoquestion() == true) {
			return "Do you want to interact with this machine?";
			}
		else return "What do you do?";
		}
	

	public void setYesnoquestion(boolean input) {
		if (this.getCompletion() == false) {
		this.yesno = input;}
		else this.yesno = false;
	}
	
	
	public void testCompletion(int button) {
		if (lights[0] == true && lights[1] == true && lights[2] == true && lights[3] == true) {
			Outputter.setReaction("You hammer button " + button + "." + "\n\nSeems like that did the trick!\nThe chain that was holding the Claw Hammer gets released.");
			this.setResult(null);
			this.setYesnoquestion(false);
			Pocket.addItemAuto(new Item ("Hammer", "A Claw Hammer with one side for hammering and one side for removing Nails.", "Nails_usable", "Plank_usable", "Eye_usable"));
		}
		else this.setResult("You hammer button " + button + "." + "\n\nSeems like this riddle is not yet solved.");
	}
	
	public String getImage() {
		return this.outputLights();
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

	
	public void performInteraction() {
		this.setExit(false);
		  while (this.getCompletion() == false && this.getExit() == false) {
		  Scanner sc = new Scanner(System.in);
		  System.out.println("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
		    System.out.println(this.outputLights());
			if (this.getResult() != null) {
				 System.out.println(this.getResult());
			}
		    System.out.println("To reset or leave this puzzle simply put in: 'exit'.\n\nWhich button do you want to hammer:");
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
			this.pressButton(zahl);
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
	
	public boolean getCompletion() {
		if (lights[0] == true && lights[1] == true && lights[2] == true && lights[3] == true) {
			return true;
			}
		else return false;

	}
	
	private void setLights(boolean a, boolean b, boolean c, boolean d) {
		if (a == true ) {
			if (lights[0] == true && a == true) {
				this.lights[0] = false;
			}
			else this.lights[0] = a;
		}

		if (b == true ) {
		if (lights[1] == true && b == true) {
			this.lights[1] = false;
		}
		else this.lights[1] = b;
		}
		
		if (c == true ) {
		if (lights[2] == true && c == true) {
			this.lights[2] = false;
		}
		else this.lights[2] = c;
		}
		
		if (d == true ) {
		if (lights[3] == true && d == true) {
			this.lights[3] = false;
		}
		else this.lights[3] = d;
		}
	}

	
	public String outputLights() {
		String bulb11 = on1;
		String bulb12 = on2;
		String bulb13 = on3;
		String bulb14 = on4;
		String bulb21 = on1;
		String bulb22 = on2;
		String bulb23 = on3;
		String bulb24 = on4;
		String bulb31 = on1;
		String bulb32 = on2;
		String bulb33 = on3;
		String bulb34 = on4;
		String bulb41 = on1;
		String bulb42 = on2;
		String bulb43 = on3;
		String bulb44 = on4;
		if (lights[0] == true) {
			bulb11 = on1;
			bulb12 = on2;
			bulb13 = on3;
			bulb14 = on4;
		}
		else {
			bulb11 = off1;
			bulb12 = off2;
			bulb13 = off3;
			bulb14 = off4;
		}
		
		if (lights[1] == true) {
			bulb21 = on1;
			bulb22 = on2;
			bulb23 = on3;
			bulb24 = on4;
		}
		else {
			bulb21 = off1;
			bulb22 = off2;
			bulb23 = off3;
			bulb24 = off4;
		}
		
		if (lights[2] == true) {
			bulb31 = on1;
			bulb32 = on2;
			bulb33 = on3;
			bulb34 = on4;
		}
		else {
			bulb31 = off1;
			bulb32 = off2;
			bulb33 = off3;
			bulb34 = off4;
		}
		
		if (lights[3] == true) {
			bulb41 = on1;
			bulb42 = on2;
			bulb43 = on3;
			bulb44 = on4;
		}
		else {
			bulb41 = off1;
			bulb42 = off2;
			bulb43 = off3;
			bulb44 = off4;
		}
		
		String line1 = "	" +	bulb11 + bulb21 + bulb31 + bulb41 + "\r\n";
		String line2 = "	" +	bulb12 + bulb22 + bulb32 + bulb42 + "\r\n";
		String line3 = "	" +	bulb13 + bulb23 + bulb33 + bulb43 + "\r\n";
		String line4 = "	" +	bulb14 + bulb24 + bulb34 + bulb44 + "\r\n";
	 
		return 
//				"\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n" + 
		"				 _________________________\n" + 
		"				|                         |\n" +
		"				|      Enlighten me       |\n" +
		"				|_________________________|\n" +
		"	____________________________________________________________________\n" +
				line1 + line2 + line3 + line4 + line5 +
		"\n	____________________________________________________________________\n" + 

		"	" +	on1 + on1 + off1 + on1 +  "\r\n" + 
		"	" + on2 + on2 + off2 + on2 + ",---," +"\r\n" +
		"	" + on3 + on3 + off3 + on3 + "| 1 |" + "\r\n" +
		"	" + on4 + on4 + off4 + on4 + "'---'" + "\r\n" +
		line5 + "\n" +
		
				"	" + on1 + off1 + on1 + off1 + "\r\n" +
				"	" + on2 + off2 + on2 + off2 + ",---," +"\r\n" +
				"	" + on3 + off3 + on3 + off3 + "| 2 |" + "\r\n" +
				"	" + on4 + off4 + on4 + off4 + "'---'" + "\r\n" +
				line5  + "\n" +

		"	" + on1 + on1 + on1 + off1 + "\r\n" +
		"	" + on2 + on2 + on2 + off2 + ",---," +"\r\n" +
		"	" + on3 + on3 + on3 + off3 + "| 3 |" + "\r\n" +
		"	" + on4 + on4 + on4 + off4 + "'---'" + "\r\n" +
		line5  + "\n" +

				"	" + on1 + off1 + on1 + on1 + "\r\n" +
				"	" + on2 + off2 + on2 + on2 + ",---," +"\r\n" +
				"	" + on3 + off3 + on3 + on3 + "| 4 |" + "\r\n" +
				"	" + on4 + off4 + on4 + on4 + "'---'" + "\r\n" +
				line5  + "\n" +
						
						"	____________________________________________________________________\n\n";		
}
	
	public void pressButton(int button) {
		if (button == 1 || button == 2 || button == 3 || button == 4) {

		if (button == 1) {
			this.setLights(true, true, false, true);
		}
		if (button == 2) {
			this.setLights(true, false, true, false);
		}
		if (button == 3) {
			this.setLights(true, true, true, false);
		}
		if (button == 4) {
			this.setLights(true, false, true, true);
		}
		this.testCompletion(button);
		}
		else this.setResult("\nThat button does not exist.\nSeems like this riddle is not yet solved.");
	}

}
