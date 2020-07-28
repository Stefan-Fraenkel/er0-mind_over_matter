package framework;
import puzzles.*;

public class Room {
	
	private Puzzle_Common north;
	private Puzzle_Common south;
	private Puzzle_Common east;
	private Puzzle_Common west;
	private Puzzle_Common up;
	private Puzzle_Common down;


	public Puzzle_Common getNorth() {
		return north;
	}

	public void setNorth(Puzzle_Common north) {
		this.north = north;
	}

	public Puzzle_Common getSouth() {
		return south;
	}

	public void setSouth(Puzzle_Common south) {
		this.south = south;
	}

	public Puzzle_Common getEast() {
		return east;
	}

	public void setEast(Puzzle_Common east) {
		this.east = east;
	}

	public Puzzle_Common getWest() {
		return west;
	}

	public void setWest(Puzzle_Common west) {
		this.west = west;
	}

	public Puzzle_Common getUp() {
		return up;
	}

	public void setUp(Puzzle_Common up) {
		this.up = up;
	}

	public Puzzle_Common getDown() {
		return down;
	}

	public void setDown(Puzzle_Common down) {
		this.down = down;

	}

	public void setDown2(Puzzle_Common down) {
		this.down = down;
	}
	

	public Room(Puzzle_Common North, Puzzle_Common South, Puzzle_Common East, Puzzle_Common West, Puzzle_Common Up, Puzzle_Common Down) {
		this.setNorth(North);
		this.setSouth(South);
		this.setEast(East);
		this.setWest(West);
		this.setUp(Up);
		this.setDown(Down);
	}

}
