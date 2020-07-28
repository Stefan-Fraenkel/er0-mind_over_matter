package framework;

public class Outputter {

	private static String actionbarline1og = " ___________North___________   _________________________   _________________________   _________________________ ";
	private static String actionbarline2og = "|             ^             | |                         | |                         | |                         |";
	private static String actionbarline3og = "|West <  Shine light  > East| |         Pick up         | |      Use X with Y       | |          Pocket         |";
	private static String actionbarline4og = "|_____________v_____________| |_________________________| |_________________________| |_________________________|";
	private static String actionbarline5og = "            South                                                                                                ";
	private static String actionbarog = "\n" + actionbarline1og + "\r\n" + actionbarline2og + "\r\n" + actionbarline3og + "\r\n" + actionbarline4og + "\r\n" + actionbarline5og;
	
	private static String actionbarline1og_north = " __________[North]__________   _________________________   _________________________   _________________________ ";
	private static String actionbarline3og_west = "[West]<  Shine light  > East| |         Pick up         | |      Use X with Y       | |          Pocket         |";
	private static String actionbarline3og_east = "|West <  Shine light  >[East] |         Pick up         | |      Use X with Y       | |          Pocket         |";
	private static String actionbarline5og_south = "           [South]                                                                                               ";
	
	private static String actionbarline1 = actionbarline1og;
	private static String actionbarline2 = actionbarline2og;
	private static String actionbarline3 = actionbarline3og;
	private static String actionbarline4 = actionbarline4og;
	private static String actionbarline5 = actionbarline5og;
	private static String actionbar = "\n" + actionbarline1 + "\r\n" + actionbarline2 + "\r\n" + actionbarline3 + "\r\n" + actionbarline4 + "\r\n" + actionbarline5;
	
	private static String actionbarquestionline1 = " _________________________   _________________________ ";
	private static String actionbarquestionline2 =	"|                         | |                         |";
	private static String actionbarquestionline3 =	"|           Yes           | |           No            |";
	private static String actionbarquestionline4 =	"|_________________________| |_________________________|";
	private static String actionbarquestionline5 =	"                                                       ";
	private static String actionbarquestion = "\n" + actionbarquestionline1 + "\r\n" + actionbarquestionline2 + "\r\n" + actionbarquestionline3 + "\r\n" + actionbarquestionline4 + "\r\n" + actionbarquestionline5;

	
	private static String output;

	private static String image;
	private static String result;
	private static String description;
	private static String question;
	private static String actions;
	private static String pocket;
	private static String enter;
	private static String error;
	private static String reaction;
	
	public static String getOutput() {
		image = Abilities.getView().getImage();
		description = Abilities.getView().getDescription();
		question = Abilities.getView().getQuestion();
		result = Abilities.getView().getResult();
		
		if (Abilities.getView() == Abilities.getLayout().getNorth()) {
		actionbar = "\n" + actionbarline1og_north + "\r\n" + actionbarline2og + "\r\n" + actionbarline3og + "\r\n" + actionbarline4og + "\r\n" + actionbarline5og;

		}
		else if (Abilities.getView() == Abilities.getLayout().getSouth()) {
			actionbar = "\n" + actionbarline1og + "\r\n" + actionbarline2og + "\r\n" + actionbarline3og + "\r\n" + actionbarline4og + "\r\n" + actionbarline5og_south;

		}
		else if (Abilities.getView() == Abilities.getLayout().getEast()) {
			actionbar = "\n" + actionbarline1og + "\r\n" + actionbarline2og + "\r\n" + actionbarline3og_east + "\r\n" + actionbarline4og + "\r\n" + actionbarline5og;

		}
		else if (Abilities.getView() == Abilities.getLayout().getWest()) {
			actionbar = "\n" + actionbarline1og + "\r\n" + actionbarline2og + "\r\n" + actionbarline3og_west + "\r\n" + actionbarline4og + "\r\n" + actionbarline5og;

		}
		else actions = actionbar;
		
		if (Abilities.getView().getYesnoquestion() == true) {
			actions = actionbarquestion;
		}
		else actions = actionbar;
		output = "\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n";
		

//		image
//		enter
//		result
//		pocket
//		description
//		actions
//		question
//		error
		
		if (image != null) {
			output += "\n\n" + image;
		}
		if (enter != null) {
			output += "\n\n" + enter;
			}
		if (reaction != null) {
			output += "\n\n" + reaction;
			}
		if (result != null) {
			output += "\n\n" + result;
		}
		if (pocket != null) {
			output += "\n\n" + pocket;
		}
		if (description != null) {
			output += "\n\n" + description;
		}
		if (actions != null) {
			output += "\n" + actions;
		}
		if (question != null) {
			output += "\n\n" + question;
		}
		if (error != null) {
			output += "\n\n" + error;
		}
		output += "\n";
		
		enter = null;
		image = null;
		description = null;
		question = null;
		result = null;
		pocket = null;
		error = null;
		reaction = null;
		Abilities.getView().setResult(null);
		
		return output;
		
	}
	
	public static void setError(String input) {
		error = input;
	}
	
	public static void setPocket(String input) {
		pocket = input;
	}
	
	public static void setEnter(String input) {
		enter = input;
	}
	
	public static void setReaction(String input) {
		if (reaction != null) {
		reaction += "\n\n" + input;
		}
		else reaction = input;
	}
	
	public static void resetActions() {
		actionbar = actionbarog;
	}

	public static void setActions(String input) {
		actionbar = input;
	}
	
	public static String getActions() {
		return actionbar;
	}
	
////funktioniert nicht in Kombination mit Scanner, da der immer eine neue Zeile beginnt und Java keinen universalen Weg hat, eine Zeile zurückzugehen :(
//	public static void setScreenClearer(String input) {
//		int refresher = input.length();
//		for (int i = 0; i < refresher; i++) {
//			deleter += "\b";
//		}
//	}
	
}
