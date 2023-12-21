///////////////////////////////////////////////////////////////////////////////
//                   Party Simulator
// Date:         27/10/2023
//
// Class: Joe.java
// Description: Template for the people
//
///////////////////////////////////////////////////////////////////////////////
package com.simulation.partypeople;

import java.awt.Color;
import java.util.Random;

import com.simulation.avatar.Avatar;
import com.simulation.enums.Direction;
import com.simulation.enums.Shape;

public class Anatoly extends Avatar{

	// ************** Constructor **************
	public Anatoly(Shape shape, Color color, int borderWidth, int avatarAge, String avatarName, int waitingTime) {
		super(shape, color, borderWidth, avatarAge, avatarName, waitingTime);
	}


	public Direction danceAlgorithm() {
	Random rand = new Random();
		int number = rand.nextInt(4);

		Direction dir = Direction.FORWARD;
		if (number == 0) {
			dir = Direction.FORWARD;
		} else if (number == 1) {
			dir = Direction.RIGHT;
		} else if (number == 2) {
			dir = Direction.BACK;
		} else if (number == 3) {
			dir = Direction.LEFT;
		}
		return dir;
	}

	public void fight(Avatar opponent) { 
        if(opponent.getName() == "JoseLu"){
            System.out.println("You're time is up, Rolda!");
        }

        // Call this function if other avatar starts a fight
		// if an interaction with another partyGoer has occured
        // start dirty-talking 
        // implement Wrestling moves: rko, f5, aa.
	}

	public void talk(Avatar person) {
		 if(person.getName() == "JoseLu"){
            System.out.println("That is gotta be the worst mustache I have seen in my life!");
        }
	}

	public void toilet(int timeInToilet) {
		// TODO
	}

	public void playPool() {
		// TODO
	}

	public void playFussball() {
		// TODO
	}

	public Direction moveAvatar() {
		Random rand = new Random();
		int number = rand.nextInt(4);

		Direction dir = Direction.FORWARD;
		if (number == 0) {
			dir = Direction.FORWARD;
		} else if (number == 1) {
			dir = Direction.RIGHT;
		} else if (number == 2) {
			dir = Direction.BACK;
		} else if (number == 3) {
			dir = Direction.LEFT;
		}
		return dir;

        // define a variable that would hold a list of priorities: sort places on a scale of 1-5
        // check the map of places discovered, if it's empty randomly head to places until everything is discovered and stored
        // if the whole map was discovered start applying the priority queue
        // head first towards the higher-rated places on the list, stay there longer
    }
}
