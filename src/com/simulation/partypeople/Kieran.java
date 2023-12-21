/**
Party Simulation: Kieran Avatar
Date: 16.12.2023
Class: Kieran.java extending the Avatar.java class
Description: Creating a unique avatar for Kieran
Status: WIP
**/

//Packages
package com.simulation.partypeople;

// Imports
import com.simulation.avatar.Avatar;
import com.simulation.enums.BeverageType;
import java.awt.Color;
import java.util.Random;
import com.simulation.enums.Direction;
import com.simulation.enums.Shape;

// Additional imports for avatar creating a "mind map"
import java.util.HashMap;
import java.util.Map;
import com.simulation.enums.Places;
import com.simulation.matrix.LocatedAvatar;
import com.simulation.matrix.Matrix;


/* To do list:
    Store surroudings locally
    Develop an algorithm to determine your next destination
    Develop movement pattern
    Develop dancing movement pattern
    Develop fighting algorithm with certain fighting skills
    Develop prefered drinks list
    Develop default phrases to interact with other users of Club Penguin
    Develop spiels
    Develop smoke area behaviour
    Develop skibidi toilet

    ! Develop algorithm to find the bar and have a drink, so not random movement completely but build an "internal" map
    of the environement and find the bar
*/

public class Kieran extends Avatar{

	// Variables

	private HashMap <String, Places[]> perceivedMap;  // Creating a variable to store discovered map coordinates
	private BeverageType cool_beverage;
	private Boolean danceFloorShenanigans;

	// Constructor

	public Kieran(Shape shape, Color color, int borderWidth, int avatarAge, String avatarName, int waitingTime) {
		super(shape, color, borderWidth, avatarAge, avatarName, waitingTime);
		// WIP
		perceivedMap = new HashMap <>(); // Instantiating an instance of a Hashmap to store coordinates
		danceFloorShenanigans = false;
	}

	// Methods

	public Direction dancingAlgo() {
		// TODO
		// develop the type of movement that would represent your dance pattern
		// Task: develop moon walk dancing algorithm
		// Idea: move through club until encountering dancefloor, call dancingAlgo
		//...needs to move avatar back and forth and stay within dance floor area
		danceFloorShenanigans = true;
		Places futureSpot = getWhatISee()[1];
		Direction dancingMovement = Direction.FORWARD;
		// System.out.println("Let's DANCE!");  // Print statement for testing, comment out to merge with main

		// Switch case for dance floor scenarios
		// Need to keep avatar on dancefloor for specified time
		switch(futureSpot) {
			case DANCEFLOOR:
				dancingMovement = Direction.FORWARD;
				break;
			case PATH:
				dancingMovement = Direction.BACK;
				break;
			case PERSON:
				dancingMovement = Direction.RIGHT; // Only turning right like Zoolander
				dancingMovement = Direction.BACK;
				break;
			default:
				dancingMovement = Direction.FORWARD;
				break;
		}
		return dancingMovement;
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

	public Direction moveAboutAimlessly() {
		Random rand = new Random();
        int number = rand.nextInt(4);
		Direction randomMovementDir = Direction.IDLE;
		if (number == 0) {
			randomMovementDir = Direction.FORWARD;
			// System.out.println("Forward movement");
		}
		else if (number == 1) {
			randomMovementDir = Direction.RIGHT;
			// System.out.println("Right movement");
		}
		else if (number == 2) {
			randomMovementDir = Direction.BACK;
			// System.out.println("Back movement");
		}
		else if (number == 3) {
			randomMovementDir = Direction.LEFT;
			// System.out.println("Left movement");
		}
		return randomMovementDir;
	}

	public Direction moveAvatar() {
        // TODO
        // create an algorithm that determines the next step of your movement pattern
        // based on a set of priorities.

		// Variables for movement
		Direction movementDirection = Direction.FORWARD;
		Places currentSpot = getWhatISee()[0];
        Places futureSpot = getWhatISee()[1];

		if(danceFloorShenanigans == false) {

			// Switch case for movement dependent on environment location
			switch(futureSpot) {
				case OUTSIDE:
					movementDirection = Direction.BACK;
					break;
				case PATH:
					movementDirection = moveAboutAimlessly();
					break;
				case PERSON:
					movementDirection = Direction.RIGHT;
					movementDirection = Direction.BACK;					
				case LOUNGE_BIG:
					movementDirection = Direction.FORWARD;
					movementDirection = Direction.RIGHT;
					movementDirection = Direction.BACK;
					//    talk();
					break;
				case LOUNGE_SMALL:
					movementDirection = Direction.FORWARD;
					movementDirection = Direction.RIGHT;
					movementDirection = Direction.BACK;
					//    talk();
					break;
				case LOUNGE_SMOKING:
					movementDirection = Direction.FORWARD;
					movementDirection = Direction.RIGHT;
					movementDirection = Direction.BACK;
					smoke();
					break;
				case DANCEFLOOR:
					movementDirection = Direction.FORWARD;
					movementDirection = dancingAlgo();
				case BAR:
					movementDirection = Direction.FORWARD;
					drink(cool_beverage);
					setAlcoholPercentage(10);
					// System.out.println("I am drinking a cool beverage!");
					movementDirection = Direction.RIGHT;
					movementDirection = Direction.BACK;
					break;
				case DJ:
					// request music?
					movementDirection = Direction.RIGHT;
					movementDirection = Direction.BACK;
					break;
				case BOUNCER:
					// talk();
					movementDirection = Direction.RIGHT;
					movementDirection = Direction.BACK;
					break;
				case FUSSBALL:
					movementDirection = Direction.FORWARD;
					playFussball();
					movementDirection = Direction.RIGHT;
					movementDirection = Direction.BACK;
					break;
				case POOL:
			   		movementDirection = Direction.FORWARD;
					playPool();
					movementDirection = Direction.RIGHT;
					movementDirection = Direction.BACK;
					break;
				case TOILET:
					//    toilet(int timeInToilet)
					movementDirection = Direction.RIGHT;
					movementDirection = Direction.BACK;
					break;
				case WALL:
				movementDirection = Direction.RIGHT;
			    	movementDirection = Direction.BACK;
					break;
				default:
					moveAboutAimlessly();
					break;
			}
		} else if (danceFloorShenanigans = true) {
			movementDirection = dancingAlgo();
		}
		return movementDirection;
	}

	// WIP *****************************************************************************

	// Implementing a mental map for the avatar to use relative positions to locate places in the environment
	// Cannot access x and y coordinates, need to use relative positions!

	// Algorithm to move randomly and create a mind map, eventually trying to find the bar
	// Places currentPlace = getWhatISee()[0];

	public Places[] getPlaceAtCoordinate(int x, int y) {
		String coordinates = x + "," + y;
		return perceivedMap.getOrDefault(coordinates, new Places[0]);
	}

	private void storeCoordinate(int x, int y, Places place) {
        String coordinates = x + "," + y;
        
        // Checking if coordinates exist in the map
        if (perceivedMap.containsKey(coordinates)) {
            // If coordinates exist, append the new place to the existing array
            Places[] placesArray = perceivedMap.get(coordinates);
            Places[] updatedPlacesArray = new Places[placesArray.length + 1];
            System.arraycopy(placesArray, 0, updatedPlacesArray, 0, placesArray.length);
            updatedPlacesArray[placesArray.length] = place;
            perceivedMap.put(coordinates, updatedPlacesArray);
        } else {
            // If coordinates don't exist, create a new array and store the place
            Places[] newPlacesArray = { place };
            perceivedMap.put(coordinates, newPlacesArray);
        }
    }

	public void updatePerceivedEnvironment(Places[] whatISee) {
        // Clear the existing perceived environment before updating
        perceivedMap.clear();

        // Update the perceived environment
        for (int i = 0; i < whatISee.length; i++) {
            // Construct a unique key based on the relative position from the avatar
            String relativePositionKey = generateRelativePositionKey(i);
            // Update the perceived environment with the observed place at the relative position
            // perceivedMap.put(relativePositionKey, whatISee[i]);
        }
    }

	private String generateRelativePositionKey(int index) {
        // This method should generate a key representing the position relative to the avatar
        // Example: return "relativeKey_" + index;
        return Integer.toString(index); // Placeholder
    }
}
