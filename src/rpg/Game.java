package rpg;

import java.util.Random;
import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		Random r = new Random();
		boolean running = true;		
		Character player = new Character("STEFFI NINJA");
		System.out.println(player.getName() + " has entered the maze.");
		System.out.println(player.toString());

		final int roomProbability = 5;
		int roomCounter = 0;		
		
		Scanner s = new Scanner(System.in);
		
		Room currentRoom = new Room(1, roomCounter++);
		Room nextRoom = currentRoom;
		currentRoom.setStartRoom(true);
		
		while(running) {
			String input = "";
			while(!input.equalsIgnoreCase("l") && !input.equalsIgnoreCase("r") && !input.equalsIgnoreCase("e")) {				
				System.out.println("Which room dou you want to visit? l/r/e");
				input = s.nextLine();
			}
			
			
			// needs do be fixed as a while loop
			if(!currentRoom.hasRooms()) {
				System.out.println("The room doesn't have doors. Please press e for Exit to return to last room.");
				input = s.nextLine();
			}
			
			if("l".equals(input)) {
				System.out.println("<-- ENTER LEFT ROOM\n---------------");
				if(currentRoom.getLeftRoom() != null) {
					nextRoom.move(player);
					currentRoom = nextRoom;
				} else {					
					nextRoom = new Room(r.nextInt(roomProbability), roomCounter++);
					nextRoom.setParentRoom(currentRoom);
					nextRoom.move(player);
					currentRoom.setLeftRoom(nextRoom);
					currentRoom = nextRoom;
				}
			}
			else if ("r".equals(input)) {
				System.out.println("ENTER RIGHT ROOM -->\n---------------");
				if(currentRoom.getRightRoom() != null) {
					nextRoom.move(player);
					currentRoom = nextRoom;
				} else {					
					nextRoom = new Room(r.nextInt(roomProbability), roomCounter++);
					nextRoom.setParentRoom(currentRoom);
					nextRoom.move(player);
					currentRoom.setRightRoom(nextRoom);
					currentRoom = nextRoom;
				}
				System.out.println(currentRoom.toString());
			}
			else if ("e".equals(input)) {
				if(currentRoom.isStartRoom() && currentRoom.getParentRoom() == null) {
					System.out.println("YOU GAVE UP!");
					System.out.println("Health: " + player.getHealth());
					System.out.println("Gold: " + player.getGold());
					running = false;
					break;
				}
				System.out.println("vvv RETURN TO LAST ROOM vvv");
				currentRoom = currentRoom.getParentRoom();
				currentRoom.move(player);
			}
			
			if (player.getHealth() <= 0) {
				System.out.println("You dead!");
				System.out.println("Amount of GOLD to decorate your grave: " + player.getGold());
				running = false;
				break;
			}
		}
		s.close();
	}
}
