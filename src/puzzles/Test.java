package puzzles;
import java.util.Scanner;

import framework.*;

public class Test {
	
// Escape Room 0: Mind over Matter 
	
	public static void main(String[] args) {
		Room room_01 = new Room(new Light(), new TicTacToe(), new Items1_Blank(), new Items2_Nails(), new Ceiling(), new Floor() );
		Abilities.setLayout(room_01);
		Abilities.setView(room_01.getDown());
	
		System.out.println("This is a Text-Adventure.\nThe game will present its output in this terminal.\nTo solve its puzzles you will simply need to type out commands.\nPlease maximize this window as some scenes will require a large space to display properly.\n\nOnce you are done press 'Enter' to start the game.");
		Scanner enter = new Scanner(System.in);
		String intro = enter.nextLine();

		
	while (room_01.getEast().getCompletion() == false || room_01.getWest().getCompletion() == false || room_01.getNorth().getCompletion() == false || room_01.getSouth().getCompletion() == false || room_01.getUp().getCompletion() == false) {
			System.out.print(Outputter.getOutput());
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			Input_Interpreter.determineInput(input);
		}
		System.out.println(Abilities.getView().getDescription());
	}

}
