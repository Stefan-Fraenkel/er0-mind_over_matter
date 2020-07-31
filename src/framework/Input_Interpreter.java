package framework;

public final class Input_Interpreter {

/*
Zweck der Klasse: Nutzereingaben, welche dieses Programm grundsaetzlich verarbeiten kann erkennen, annehmen und in Einzelteile zerlegen.
Diese werden dann an die Klasse "Abilities" weitergereicht. Erst dort wird dann versucht, diese Eingaben umzusetzen.
*/
	
	private Input_Interpreter() {

	}

	public static void determineInput(String input) {
		
// Formatierung allgemein

		input = input.toLowerCase();
		input = input.trim();

		while (input.contains("  ")) {
			input = input.replaceAll("  ", " ");
		}

		input = input.replaceAll("shine light ", "");
		input = input.replaceAll("shine ", "");
		input = input.replaceAll("look ", "");

// Entfernung Sonderzeichen
		
		String[] inputArray = input.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

/*
Bestimmung der Art der gewünschten Interaktion des Inputs.
Danach: Weiterreichung an die jeweils zusatändige Methode.
*/
		
// Erkennung: Ja/Nein Frage

		if (input.contains("yes") && (inputArray.length == 1)
				|| (input.contains("no") && !input.contains("north")) && (inputArray.length == 1)) {
			yesNo(input);
		}

// Erkennung: Bewegung

		if (input.contains("north") || input.contains("south") || input.contains("east") || input.contains("west")
				|| (input.contains("up") && !input.contains("pick")) || input.contains("down")) {
			view(input);
		}

// Erkennung: Aufnehmen von Items und Verstauen im Inventar

		if (input.contains("pick up") && (!input.contains("use") && !input.contains("with"))) {
			pickUp(input, inputArray);
		}

// Erkennung: Kombinieren von Items

		if ((input.contains("use")) && input.contains("with") && (input.indexOf("use") < input.indexOf("with"))
				&& !input.contains("pick up")) {
			useWith(input, inputArray);
		}

// Erkennung: Aufnehmen oder Verstauen möglich

		if (input.contains("pick up") && input.contains("use") && input.contains("with")) {
			pickUporUsewith(input, inputArray);
		}

// Erkennung: Aufruf des Inventars

		if (input.contains("pocket") && (inputArray.length <= 2)) {
			pocket();
		}

	}


/*
Bestimmung der variablen Elemente der gewünschten Interaktion des Inputs.
Danach: Weiterreichung an die Klasse Abilities zur Umsetzung des Kommandos.
*/

// Bei einigen Eingaben, wie Ja/Nein, sind keine weiteren Operationen notwendig.
	
	private static void yesNo(String input) {
		Abilities.yesNo(input);
	}

	private static void view(String input) {
		Abilities.move(input);
	}
	
	private static void pocket() {
		Abilities.lookupPocket();
	}

	private static void pickUporUsewith(String input, String[] inputArray) {

		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i].contains("pick")) {
				pickUp(input, inputArray);
				break;
			}
			if (inputArray[i].contains("use")) {
				useWith(input, inputArray);
				break;
			}
		}
	}

	private static void pickUp(String input, String[] inputArray) {

		int up = 0;
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i].contains("up")) {
				up = i;
				break;
			}
		}

		String[] object1 = new String[inputArray.length - up - 1];

		int count = inputArray.length - up - 1;
		for (int i = 0; i < count; i++) {
			object1[i] = inputArray[up + i + 1];
		}

		Abilities.pickup(object1);

	}

	private static void useWith(String input, String[] inputArray) {

		int use = 0;
		int with = 0;

		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i].contains("use")) {
				use = i;
				break;
			}
		}
		for (int j = 0; j < inputArray.length; j++) {
			if (inputArray[j].contains("with")) {
				with = j;
				break;
			}

		}

		String[] object1 = new String[with - use - 1];
		String[] object2 = new String[inputArray.length - with - 1];

		int count = with - use - 1;
		for (int i = 0; i < count; i++) {
			object1[i] = inputArray[use + i + 1];
		}
		count = inputArray.length - with - 1;
		for (int i = 0; i < count; i++) {
			object2[i] = inputArray[with + i + 1];
		}

		Abilities.usewith(object1, object2);

	}

}