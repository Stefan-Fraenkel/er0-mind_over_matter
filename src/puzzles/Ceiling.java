package puzzles;

import framework.Abilities;
import framework.Item;
import framework.Outputter;
import framework.Pocket;

public class Ceiling extends Puzzle_Common {

	private int finalecounter = 0;
	private Item Eye = new Item("Eye", "A horrid Eye.", "Hammer_usable");
	private Item[] interactionpoints = { Eye };
	
	private int hintcounter = -2;

	private String actionbarline1 = " ___________North___________   _________________________   _________________________   _________________________ ";
	private String actionbarline2 = "|             ^             | |                         | |                         | |                         |";
	private String actionbarline3 = "|West <  Shine light  > East| |         Pick up         | |      Use X with Y       | |          Pocket         |";
	private String actionbarline4 = "|_____________v_____________| |_________________________| |_________________________| |_________________________|";
	private String actionbarline5 = "            South                                                                                                ";
	private String actionbar = "\n" + actionbarline1 + "\r\n" + actionbarline2 + "\r\n" + actionbarline3 + "\r\n"
			+ actionbarline4 + "\r\n" + actionbarline5;
	
	public Ceiling() {
		this.setInteractionPoints(interactionpoints);
	}

	public String getDescription() {
		hintcounter++;
		this.setResult(null);
		if (hintcounter == 5) {
			this.setResult("\"HAHAHA! I'm starting to feel insulted. Don't you trust me? I already told you: You have no skills of your own.\nNow that I have taken away your feeble minded ideas on how to interact with the world there is nothing you can do!\"");	
		}
		if (hintcounter == 10) {
			this.setResult("\"Stop resisting! Give in to me! I already took away your Pocket. What else do you want to loose? Maybe I should just take away your mind.\"");
		}
		if (hintcounter >= 15) {
			this.setResult("\"How many times do I need to Hammer this home? Stop scurrying in the dark. Just lie down! \nYou don't need to wreck your brain any more. No need to do anything. Doesn't that sound nice? No more: Use this With that. Only blissful obedience.\"");
		}
		if (this.getCompletion() == false) {
			return "A horrid Eye is hovering above you.\nIt glows infront of an ever expanding void of black nothingness.\nWatching you with menace.\nJudging you with disgust.";
		} else
			return 	"\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n"
					+ "\nYou muster all your might and throw your trusty Hammer towards the menacing Eye.\nYou are surprised how fast it cuts through the air.\nIn fact it seems to be picking up even more speed!"
					+ "\n\nSuddenly a terrible noise fills the room and pierces your body.\nYou realize it is the Eye screaming as your Hammer is about to connect.\n\nThen there is silence. Absolute terrible silence."
					+ "\n\n\n________________________________________________________________________________________________________________\n\n\nYou wake up with your head hurting.\n\n"
					+ "You hold a Hammer in your hand.\nBlood is pouring down your face.\n\n"
					+ "You decide to get a refund on your new brain implant.";
	}

	public String getQuestion() {
		if (this.getCompletion() == false) {
			return "What now?";
		} else
			return null;
	}

	public String getImage() {
		return 	  "           _ . - = - . _\r\n"
				+ "       . \"  \\  \\   /  /  \" .\r\n"
				+ "     ,  \\                 /  .\r\n"
				+ "   . \\   _,.--~=~\"~=~--.._   / .\r\n"
				+ "  ;  _.-\"  / \\ !   ! / \\  \"-._  .\r\n"
				+ " / ,\"     / ,` .---. `, \\     \". \\\r\n"
				+ "/.'   `~  |   /:::::\\   |  ~`   '.\\\r\n"
				+ "\\`.  `~   |   \\:::::/   | ~`  ~ .'/\r\n"
				+ " \\ `.  `~ \\ `, `~~~' ,` /   ~`.' /\r\n"
				+ "  .  \"-._  \\ / !   ! \\ /  _.-\"  .\r\n"
				+ "   ./    \"=~~.._  _..~~=`\"    \\.\r\n"
				+ "     ,/         \"\"          \\,\r\n"
				+ "       . _/             \\_ .\r\n"
				+ "          \" - ./. .\\. - \"\r\n";
	}

	public void performInteraction(Item item1, Item item2) {
		if ((item1.getItemName().equals("Hammer") && item2.getItemName().equals("Eye")) || (item2.getItemName().equals("Hammer") && item1.getItemName().equals("Eye"))) {
			this.setCompletion(true);
//			Outputter.setActions(null);
			if (item1.getItemName().equals("Hammer")){
				Pocket.removeItem(item1);
			}
			else Pocket.removeItem(item2);
		}
	}

	public String animation(String string, Integer zahl) {
		if (string != null && string.length() > zahl) {
			string = string.substring(0, string.length() - 1);
		}
		return string;
	}

	public boolean enterCondition() {

		if (Abilities.getLayout().getEast().getCompletion() == true
				&& Abilities.getLayout().getWest().getCompletion() == true
				&& Abilities.getLayout().getNorth().getCompletion() == true
				&& Abilities.getLayout().getSouth().getCompletion() == true) {
			return true;
		} else {
			boolean check = false;
			for (Item pocket : Pocket.getPocket()) {
				if (pocket.getItemDescription().contains("With the AA Battery inside")) {
					check = true;
					break;
				}
			}
			if (check == false) {
				Outputter.setEnter("It is too dark to look around. Maybe I can find a way to light up this room.");
				return false;
			} else {
				Outputter.setEnter("For some reason you can't get yourself to look up.");
				return false;
			}
		}
		
	}

	@Override
	public void enterSetup() {
		this.setResult(null);
		if (this.finalecounter == 0) {
			Outputter.resetActions();
			String carryover = "\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n" + this.getImage() + "\n" + this.getDescription();
			
			System.out.println(carryover);
			System.out.println(Outputter.getActions());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(carryover);
			System.out.println("\n\"So you found me out little human! Left yourself a note somewhere, did you?!\"");
			System.out.println(Outputter.getActions());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(carryover);
			System.out.println("\n\"Looks like your mind can't be pacified that easily. I must say, I am annoyed!\"");
			System.out.println(Outputter.getActions());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(carryover);
			System.out.println("\n\"What a pathetic lifeform. Devoid of any real abilities. Only making things up as it goes along.\"");
			System.out.println(Outputter.getActions());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(carryover);
			System.out.println("\n\"You are incapable of survival. You need tools for even the most basic tasks. Let me take those away from you!\"");
			System.out.println(Outputter.getActions());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(carryover);
			System.out.println("\n\"Let's see, you carry your little helpers in something you call your Pocket, right? Well, say goodbye to it!\"");
			System.out.println(Outputter.getActions());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while (actionbarline5.length() > 85) {
				actionbarline1 = this.animation(actionbarline1, 85);
				actionbarline2 = this.animation(actionbarline2, 85);
				actionbarline3 = this.animation(actionbarline3, 85);
				actionbarline4 = this.animation(actionbarline4, 85);
				actionbarline5 = this.animation(actionbarline5, 85);
				actionbar = "\n" + actionbarline1 + "\r\n" + actionbarline2 + "\r\n" + actionbarline3 + "\r\n"
						+ actionbarline4 + "\r\n" + actionbarline5;
				System.out.println(carryover + "\n\n\"Let's see, you carry your little helpers in something you call your Pocket, right? Well, say goodbye to it!\"" + "\n" + actionbar);
				try {
					Thread.sleep(42);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(carryover);
			System.out.println("\n\"This is my domain now! You are merely a pest I need to get rid of.\"");
			System.out.println(actionbar);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(carryover);
			System.out.println("\n\"Let me erase those silly ideas you should not have remembered in the first place!\"");
			System.out.println(actionbar);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			while (actionbarline5.length() > 0) {
				actionbarline1 = this.animation(actionbarline1, 0);
				actionbarline2 = this.animation(actionbarline2, 0);
				actionbarline3 = this.animation(actionbarline3, 0);
				actionbarline4 = this.animation(actionbarline4, 0);
				actionbarline5 = this.animation(actionbarline5, 0);
				actionbar = "\n" + actionbarline1 + "\r\n" + actionbarline2 + "\r\n" + actionbarline3 + "\r\n"
						+ actionbarline4 + "\r\n" + actionbarline5;
				System.out.println(carryover + "\n\n\"Let me erase those silly ideas you should not have remembered in the first place!\"" + "\n" + actionbar);
				try {
					Thread.sleep(42);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			this.setResult("\"Oh, did I make you forget all the things you can do? Too bad humans have no skills of their own!\"");
			Outputter.setReaction("It illuminates the one place you tried so much to ignore.");
			Outputter.setActions(null);
			this.finalecounter++;
		}
	}

	public void moveTest(String movement) {
		this.setResult("You want to run away. But you can't seem to escape the Eye's gaze.");
	}

}
