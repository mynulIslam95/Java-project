package com.simulation.partypeople;

import java.awt.Color;

import com.simulation.avatar.Avatar;
import com.simulation.enums.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Igor extends Avatar{
	boolean printTest = false;
	// ToDo individually:
		// - Store surroudings locally
		// - Develop an algorithm to determine your next destination
		// - Develop movement pattern
		// - Develop dancing movement pattern
		// - Develop fighting algorithm with certain fighting skills
		// - Develop prefered drinks list
		// - Develop default phrases to interact with other users of Club Penguin
		// - Develop spiels
		// - Develop smoke area behaviour
		// - Develop skibidi toilet

		// ************** Constructor **************
		public Igor(Shape shape, Color color, int borderWidth, int avatarAge, String avatarName, int waitingTime) {
			super(shape, color, borderWidth, avatarAge, avatarName, waitingTime);
			// TODO
		}

		// ************** Methods **************
		public Direction dancingAlgo(Places whatISee) {
			if (whatISee == Places.DANCEFLOOR && whatISee != Places.PERSON) {
				return Direction.FORWARD; 
			}
			else
				return Direction.TURN_RIGHT_ON_SPOT;
		}

		public void fight(Avatar opponent) { // Call this function if other avatar starts a fight
			// TODO
			// develop different fighting moves
			// be very descriptive (user 2 is performing an F5 on user 3)
		}

		public void talk(Avatar person) {
			// TODO
			// create a list of answers and questions that you would like to exchange with
			// the other users of Club Penguin
			// create a primitive algorithm that would make picks from your answer list
			// based on the questions asked
		}

		public void smoke() {
			// TODO
			// if you are in the smoking area you get prompted the option to smoke
		}

		public void toilet(int timeInToilet) { // Do only toilet things in the toilet
			// TODO
			// set your time in the toilet

		}

		public void playPool() { // Play pool only on the designate spot
			// TODO

		}

		public void playFussball() { // Play Fussball only on the designate spot
			// TODO
			// if two players interact in the fussball area, prompt the option to start a
			// game
			// game algorithm shall be determined externally

		}
		
		// A function for knowing if a place in the map is usable or not
		private boolean isUsable(Places place) {
			//if (place == Places.PATH || place == Places.PERSON)
			if (place == Places.PATH || place == Places.DANCEFLOOR)
				return true;
			else
				return false;
		}
		
		private boolean firstTimeInClub = false; // To track whether the avatar has turned right
//		private boolean foundLeftWall = false;
//		private boolean foundUpperWall = false;
//		private boolean foundRightWall = false;
//		private boolean foundLowerWall = false;
		private boolean lookRight = false;
		private boolean lookFront = false;
		private boolean lookLeft = false;
		private boolean lookBack = false;
		private Places prevGetWhatISee = Places.PATH;
		
		private boolean seeWallFront = false;
		private boolean seeWallRight = false;
		private boolean mapIsComplete = false;
		private boolean usableOnTheRight = true;
		
		private Direction walkToCreateAMap() {
	        Places whatISee;
	        if (!firstTimeInClub) {
	            // If the avatar hasn't turned right yet, do so
	            firstTimeInClub = true; // Set flag to indicate that the avatar has turned right
	            System.out.println("jUST eNTERED tHE cLUB -> tURNING rIGHT");
	            return Direction.TURN_RIGHT_ON_SPOT;
	        } else {
	        	if (!isUsable(prevGetWhatISee)) {
	        		prevGetWhatISee = getWhatISee()[0];
	        		if (isUsable(getWhatISee()[0])) {
		        		System.out.println("Before that I saw an unusble -> move forward");
		        		return Direction.FORWARD;
	        		}
	        		else {
	        			System.out.println("Before that I saw an unusble but front is unsuble as well -> turn left");
		        		return Direction.TURN_LEFT_ON_SPOT;
	        		}
	        	}
	        	else {
	        		if (!lookRight) {
	        			lookRight = true;
	        			whatISee = getWhatISee()[0];
	        			System.out.println(getWhatISee()[0]);
	        			if (whatISee == Places.WALL) {
	        				System.out.println("I see the wall in front of me...");
	        				seeWallFront = true;
	        			}
	        			else
	        				seeWallFront = false;
	        			return Direction.TURN_RIGHT_ON_SPOT;
	        		}
	        		else if (!lookBack) {
	        			lookBack = true;
	        			whatISee = getWhatISee()[0];
	        			usableOnTheRight = isUsable(whatISee);
	        			System.out.println(getWhatISee()[0]);
	        			if (whatISee == Places.WALL) {
	        				System.out.println("I see the wall on the right...");
	        				seeWallRight = true;
	        			}
	        			else
	        				seeWallRight = false;
	        			return Direction.TURN_RIGHT_ON_SPOT;
	        		}
	        		else if (!lookLeft) {
	        			lookLeft = true;
	        			whatISee = getWhatISee()[0];
	        			System.out.println(getWhatISee()[0]);
	        			return Direction.TURN_RIGHT_ON_SPOT;
	        		}
	        		else if (!lookFront) {
	        			lookFront = true;
	        			whatISee = getWhatISee()[0];
	        			System.out.println(getWhatISee()[0]);
	        			return Direction.TURN_RIGHT_ON_SPOT;
	        		}
	        		else {
	        			lookRight = false;
	        			lookLeft = false;
	        			lookBack = false;
	        			lookFront = false;
	        			whatISee = getWhatISee()[0];
	        			prevGetWhatISee = whatISee;
	        			System.out.println(getWhatISee()[0]);
	        			if (seeWallFront) {
	        				seeWallFront = false;
	        				seeWallRight = true;
	        				//prevGetWhatISee = getWhatISee()[0];
	        				System.out.println("See wall in front of me -> turn left");
	        				return Direction.TURN_LEFT_ON_SPOT;
	        			}
	        			if (!seeWallRight) {
	        				if (usableOnTheRight) {
	        					System.out.println("I don't see wall on the right and right is usable-> turn right");
	        					prevGetWhatISee = Places.BOUNCER; // Just a flag to know that I turned right and next i want to move forward
	        					return Direction.TURN_RIGHT_ON_SPOT;
	        				}
	        				else if (isUsable(whatISee)) {
	        					System.out.println("I dont see the wall on the right, right is unsuable and fowrard is free -> move forward");
	        					return Direction.FORWARD;
	        				}
	        				else {
	        					System.out.println("I dont see the wall on the right, right is unsuable and fowrard is not free -> turn left");
	        					return Direction.TURN_LEFT_ON_SPOT;
	        				}
//	        				System.out.println("I don't see wall on the right -> turn right");

	        			}
	        			if (isUsable(prevGetWhatISee)) {
	        				System.out.println("Nothing in front of me -> go forward");
	        				return Direction.FORWARD;
	        			}
	        			else {
	        				System.out.println("Something in front of me -> turn left");
	        				prevGetWhatISee = getWhatISee()[0];
	        				return Direction.TURN_LEFT_ON_SPOT;
	        			}
	        		}
	        		
	        	}
	        }
		}
		
		int rowsCount = 0;
		int xPos = 0;
		int yPos = 0;
		boolean lookNorth = false;
		boolean lookEast = false;
		boolean lookSouth = false;
		boolean lookWest = false;
		Heading lookingDirection = Heading.WEST; // 0 - north, 1 - east, 2 - south, 3 - west
		boolean doneSettingRandomDir = false;
		Places placeToFind = Places.DANCEFLOOR;
		Places[][] map = { { Places.PATH } };
		
		boolean foundDanceFloor = false; // For testing to find the dance bar
		
	    public Direction moveAvatar() {
//	    	System.out.println("xPos: "+xPos+", yPos: "+yPos+", lookingDirection = "+lookingDirection);
//	    	Scanner scanner = new Scanner(System.in);
//	        scanner.nextLine();
	        Places whatISee;
	        Direction dir;
	        if (!lookWest && lookingDirection == Heading.WEST) {
	        	lookWest = true;
    			whatISee = getWhatISee()[0];
    			if (printTest)
    			System.out.println(getWhatISee()[0]);
    			if (lookingDirection == Heading.WEST && xPos == 0) {
    				if (printTest)
    				System.out.println("Adding new column to the left");
    				map = updateMapNewColumnLeft(map,whatISee,xPos,yPos);
    				xPos = xPos+1; // Added a new column left so xPos is updated +1
    			}
		        // Update the element that the avatar sees
		        map[yPos][xPos-1] = whatISee;
		        setHeadingTurnRight();
		        if (whatISee == placeToFind) { // Found The Dance Floor
		        	foundDanceFloor = true;
		        	return Direction.FORWARD;
		        }
		        if (printTest)
		        System.out.println("New Heading after west: "+lookingDirection);
    			return Direction.TURN_RIGHT_ON_SPOT;
    		}
    		else if (!lookNorth && lookingDirection == Heading.NORTH) {
    			lookNorth = true;
    			whatISee = getWhatISee()[0];
    			usableOnTheRight = isUsable(whatISee);
    			if (printTest)
    			System.out.println(getWhatISee()[0]);
    			if (lookingDirection == Heading.NORTH && yPos == 0) {
    				if (printTest)
    				System.out.println("Adding new row up");
    				map = updateMapNewRowUp(map,whatISee,xPos,yPos);
    				yPos = yPos +1; // Added a new row up so yPox is updated +1
    			}
		        // Update the element that the avatar sees
		        map[yPos-1][xPos] = whatISee;
		        if (whatISee == placeToFind) { // Found The Dance Floor
		        	foundDanceFloor = true;
		        	return Direction.FORWARD;
		        }
		        setHeadingTurnRight();
    			return Direction.TURN_RIGHT_ON_SPOT;
    		}
    		else if (!lookEast && lookingDirection == Heading.EAST) {
    			
    			lookEast = true;
    			whatISee = getWhatISee()[0];
    			if (printTest)
    			System.out.println(getWhatISee()[0]);
    			
    			if (lookingDirection == Heading.EAST && xPos+1 == map[0].length) {
    				if (printTest)
    				System.out.println("Adding new column to the right");
    				map = updateMapNewColumnRight(map,whatISee,xPos,yPos);
    			}
		        // Update the element that the avatar sees
		        map[yPos][xPos+1] = whatISee;
		        if (whatISee == placeToFind) { // Found The Dance Floor
		        	foundDanceFloor = true;
		        	return Direction.FORWARD;
		        }
		        setHeadingTurnRight();
    			return Direction.TURN_RIGHT_ON_SPOT;
    		}
    		else if (!lookSouth && lookingDirection == Heading.SOUTH) {
    			lookSouth = true;
    			whatISee = getWhatISee()[0];
    			if (printTest)
    			System.out.println(getWhatISee()[0]);
    			if (lookingDirection == Heading.SOUTH && yPos+1 == map.length) {
    				if (printTest)
    				System.out.println("Adding new row down");
    				map = updateMapNewRowDown(map,whatISee,xPos,yPos);
    			}
    	        // Update the element that the avatar sees
    	        map[yPos+1][xPos] = whatISee;
		        if (whatISee == placeToFind) { // Found The Dance Floor
		        	foundDanceFloor = true;
		        	return Direction.FORWARD;
		        }
    	        setHeadingTurnRight();
    			return Direction.TURN_RIGHT_ON_SPOT;
    		}
    		else {
    			whatISee = getWhatISee()[0];
    			if (printTest)
    			System.out.println(getWhatISee()[0]);
    			if (foundDanceFloor) { // Dance
    				dir = dancingAlgo(whatISee);
    			}
    			else if (doneSettingRandomDir) {
    				if (isUsable(whatISee)) {
    					doneSettingRandomDir = false;
    					lookWest = false;
    					lookSouth = false;
	        			lookEast = false;
	        			lookNorth = false;
	        			if (printTest)
	    				System.out.println("Nothing in front of me -> go forward to: "+lookingDirection);;
	    				dir = Direction.FORWARD;
	    				if (lookingDirection == Heading.WEST) // looks west
	    					xPos--;
	    				if (lookingDirection == Heading.SOUTH) // looks south
	    					yPos++;
	    				if (lookingDirection == Heading.EAST) // looks east
	    					xPos++;
	    				if (lookingDirection == Heading.NORTH) // looks north
	    					yPos--;
	    				
	    				if (xPos < 0)
	    					xPos = 0;
	    				if (yPos < 0)
	    					yPos = 0;
    				}
    				else 
    					dir = turnToRandomDir(whatISee); // turn again
    			}
    			else {
    				dir = turnToRandomDir(whatISee);
    				doneSettingRandomDir = true;
    			}
    		}
	        if (printTest)
	        displayMap(map);
	        //return walkToCreateAMap();
	        if (printTest)
	        System.out.println("GOING TO: " + dir);
	        return dir;
	    }
	    private void setHeadingTurnLeft() {
	    	if (printTest)
	    	System.out.println("Turning left");
	    	if (lookingDirection == Heading.WEST) // looks west turn south
				lookingDirection = Heading.SOUTH;
	    	else if (lookingDirection == Heading.SOUTH) // looks south turn east
				lookingDirection = Heading.EAST;
	    	else if (lookingDirection == Heading.EAST) // looks east turn north 
				lookingDirection = Heading.NORTH;
	    	else if (lookingDirection == Heading.NORTH) // looks north turn west
				lookingDirection = Heading.WEST;
	    }
	    private void setHeadingTurnRight() {
	    	if (printTest)
	    	System.out.println("Turning right");
			if (lookingDirection == Heading.WEST) // looks west turn north
				lookingDirection = Heading.NORTH;
			else if (lookingDirection == Heading.SOUTH) // looks south turn west
				lookingDirection = Heading.WEST;
			else if (lookingDirection == Heading.EAST) // looks east turn south 
				lookingDirection = Heading.SOUTH;
			else if (lookingDirection == Heading.NORTH) // looks north turn east
				lookingDirection = Heading.EAST;
	    }
	    private Direction turnToRandomDir(Places whatISee) {
	    	Direction dir;
	    	Random rand = new Random();
			int number = rand.nextInt(5);
			// direction is set externally --> check with the simulation environment
			if (number == 0) {
				dir = Direction.TURN_LEFT_ON_SPOT;
				setHeadingTurnLeft();
			}
			//else if (number == 1) {
			else if (number == 1) {
				dir = Direction.TURN_RIGHT_ON_SPOT;
				setHeadingTurnRight();
			}
			else { // higher chance to go forward
				if (isUsable(whatISee))
					dir = Direction.FORWARD;
				else {
					dir = Direction.TURN_LEFT_ON_SPOT;
					setHeadingTurnLeft();
				}
			}
			if (printTest)
			System.out.println("Turning random to: "+dir+" looking: "+lookingDirection);
			return dir;
	    }
	    
	 // Function to update the map based on what the avatar sees
	    public static Places[][] updateMapNewColumnRight(Places[][] oldMap, Places seen, int positionX, int positionY) {
	        int rows = oldMap.length;
//	        System.out.println(rows);
	        int columns = oldMap[0].length;
	        
	        // Create a new map with increased size
	        Places[][] newMap = new Places[rows][columns + 1];

	        // Copy the old map elements to the new map
	        for (int i = 0; i < rows; i++) {
	            System.arraycopy(oldMap[i], 0, newMap[i], 0, columns);
	        }	        
	        return newMap;
	    }
	    public static Places[][] updateMapNewColumnLeft(Places[][] oldMap, Places seen, int positionX, int positionY) {
	        int rows = oldMap.length;
	        
//	        System.out.println(rows);
	        int columns = oldMap[0].length;
	        
	        // Create a new map with increased size
	        Places[][] newMap = new Places[rows][columns + 1];

	        // Copy the old map elements to the new map
	        for (int i = 0; i < rows; i++) {
	            System.arraycopy(oldMap[i], 0, newMap[i], 1, columns);
	        }
	        return newMap;
	    }
	    public static Places[][] updateMapNewRowDown(Places[][] oldMap, Places seen, int positionX, int positionY) {
	        int rows = oldMap.length;
//	        System.out.println(rows);
	        int columns = oldMap[0].length;
	        
	        // Create a new map with increased size
	        Places[][] newMap = new Places[rows + 1][columns];

	        // Copy the old map elements to the new map
	        for (int i = 0; i < rows; i++) {
	            System.arraycopy(oldMap[i], 0, newMap[i], 0, columns);
	        }
	        
	        return newMap;
	    }
	    public static Places[][] updateMapNewRowUp(Places[][] oldMap, Places seen, int positionX, int positionY) {
	        int rows = oldMap.length;
//	        System.out.println(rows);
	        int columns = oldMap[0].length;
	        
	        // Create a new map with increased size
	        Places[][] newMap = new Places[rows + 1][columns];

	        // Copy the old map elements to the new map
	        for (int i = 1; i < rows + 1; i++) {
	            System.arraycopy(oldMap[i-1], 0, newMap[i], 0, columns);
	        }
	        return newMap;
	    }

	    // Function to display the map
	    public static void displayMap(Places[][] map) {
	        for (Places[] row : map) {
	            System.out.println(Arrays.toString(row));
	        }
	    }
}
