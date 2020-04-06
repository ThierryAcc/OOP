package rpg;

import java.util.Random;

public class Room {
	boolean startRoom = false;
	boolean visited = false;
	boolean hasRooms;
	String name;
	Room leftRoom;
	Room rightRoom;
	Room parentRoom;
	Random r = new Random();
	
	public Room(int random, int counter) {
		if(random == 0) {
			this.hasRooms = false;
		}
		else if(random >= 1) {
			this.hasRooms = true;
		}
		name = "R" + counter;
	}
	
	// erster Raum kein Exit --> Spiel zu Ende
	public void move(Character c) {
		System.out.println("ROOM=" + name);
		if(this.visited == false) {
			int roomItem = r.nextInt(3);
			int random = r.nextInt(70);

			if(roomItem == 0) {
				c.calcHealth(random);
				System.out.println("It's a HEALTH potion! +" + random);
				printStats(c);	
			}
			else if (roomItem == 1) {
				c.calcHealth(-random);
				System.out.println("It's a MONSTER! You lost " + random);
				printStats(c);
			}
			else if (roomItem == 2) {
				c.addGold(random);
				System.out.println("YOU FOUND A TREASURE! +" + random +" Gold");
				printStats(c);
			}
		} else {
			System.out.println("NOTHING HERE --- ROOM ALREADY VISITED");
			printStats(c);
		}
	
		this.visited = true;
	}
	
	public Room getLeftRoom() {
		return leftRoom;
	}

	public void setLeftRoom(Room leftRoom) {
		this.leftRoom = leftRoom;
	}

	public Room getRightRoom() {
		return rightRoom;
	}

	public void setRightRoom(Room rightRoom) {
		this.rightRoom = rightRoom;
	}

	public Room getParentRoom() {
		return parentRoom;
	}

	public void setParentRoom(Room parentRoom) {
		this.parentRoom = parentRoom;
	}

	public boolean isStartRoom() {
		return startRoom;
	}

	public void setStartRoom(boolean startRoom) {
		this.startRoom = startRoom;
		this.visited = true;
	}

	public boolean hasRooms() {
		return hasRooms;
	}

	@Override
	public String toString() {
		return "Room [startRoom=" + startRoom + ", visited=" + visited + ", hasRooms=" + hasRooms + ", r=" + r + "]";
	}

	public void printStats(Character c) {
		System.out.println("Health: " + c.getHealth());
		System.out.println("Gold: " + c.getGold());
	}
	
	
	

}
