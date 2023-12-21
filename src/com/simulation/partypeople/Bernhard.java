///////////////////////////////////////////////////////////////////////////////
//                   Party Simulator
// Date:         27/10/2023
//
// Class: AvatarTemplate.java
// Description: Template for the people
//
///////////////////////////////////////////////////////////////////////////////
package com.simulation.partypeople;

import com.simulation.avatar.Avatar;
import com.simulation.enums.BeverageType;
import java.awt.Color;
import java.util.Random;

import com.simulation.enums.Direction;
import com.simulation.enums.Places;
import com.simulation.enums.Shape;

public class Bernhard extends Avatar{
	// this int is just a flag to do the first moves and scout the bar.
	// When it is set to 1 it will never be reset to 0 and means that the avatar
	// starts moving according to its desires after scouting the area
	// int firstmovesfinished = 0;
	int j = 0;
	int i = 0;
	int l = 0;
	int k = 0;
	int m = 0;
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
	public Bernhard(Shape shape, Color color, int borderWidth, int avatarAge, String avatarName, int waitingTime) {
		super(shape, color, borderWidth, avatarAge, avatarName, waitingTime);
		// TODO
	}

	// ************** Methods **************
	public Direction dancingAlgo() {
		// TODO
		// develop the type of movement that would represent your dance pattern
		Direction dir;
		if (this.getWhatISee()[0] == Places.DANCEFLOOR) {
			for (l++; l < 5;) {
				dir = Direction.FORWARD;
				return dir;
			}
			for (k++; k < 2;) {
				dir = Direction.BACK;
				l = 0;
				return dir;
			}
			// for (m++; m < 5;) {
			// 	dir = Direction.FORWARD;
			// 	return dir;
			// }
			dir = Direction.TURN_LEFT_ON_SPOT;
			l = 0;
			m = 0;
			k = 0;
		} else {
			dir = Direction.TURN_LEFT_ON_SPOT;
		}
		return dir;
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

	public Direction moveAvatar() {
		// only do this once at the beginning to scout the area
		// squaresinvision = this.getWhatISee();
		// Direction dir = Direction.FORWARD;
		// if (this.firstmovesfinished == 0) {
			
		// }
		// setting desire to 0 means there is currently no desire
		// setting desire to 6 for now to achieve dance floor challenge
		int desire = 0;
		this.setAlcoholPercentage(0);


		// TODO
		// create an algorithm that determines the next step of your movement pattern
		// based on a set of priorities.
		// Direction dir = Direction.IDLE;
		// return dir;

		//The following lines make the avatar move randomly
		/* Random rand = new Random();
		int number = rand.nextInt(4);
		// direction is set externally --> check with the simulation environment
		Direction dir = Direction.FORWARD;
		if (number == 0) {
			dir = Direction.FORWARD;
		}
		else if (number == 1) {
			dir = Direction.RIGHT;
		}
		else if (number == 2) {
			dir = Direction.BACK;
		}
		else if (number == 3) {
			dir = Direction.LEFT;
		} */
		// return dir;

		if (this.getWhatISee()[0] == Places.DANCEFLOOR) {
			Direction direction = dancingAlgo();
			return direction;
		}
		Direction dir = Direction.FORWARD;
		for (j++; j < 15;) {
			dir = Direction.FORWARD;
			return dir;
		}
		for (i++; i < 2;) {
			dir = Direction.LEFT;
			return dir;
		}
		dir = Direction.TURN_LEFT_ON_SPOT;


		// End of code for random movement
		// First check if any immediate desires need to be fulfilled
		// Check if avatar needs toilet

		// decide what to do based on generated number
		// 1 - foosball
		// 2 - pool
		// 3 - bar
		// 4 - lounge
		// 5 - dj
		// 6 - dancefloor
		// 7 - toilet
		// 8 - talk
		// 9 - fight
		// 10 - go to bar and get water
		if (this.getAlcoholPercentage() > 60) {
			desire = 10;
		}
		// if alcoholpercentage is too high then start a fight
		else if (this.getAlcoholPercentage() > 80) {
			desire = 9;
			// add code here to fight the next avatar that appears around you
		}
		// check what is in front of the avatar and interact with the place if the current desire can be met there

		// The following lines make the avatar move randomly
		//Random rand = new Random();
		//int number = rand.nextInt(4);
		// direction is set externally --> check with the simulation environment

		return dir;
	}

	private int decideDesire() {
		int desire = 0;
		Random rand = new Random();
		// pick random number between 0 and 100
		int number = rand.nextInt(100);
		// decide what to do based on generated number
		// 1 - foosball
		// 2 - pool
		// 3 - bar
		// 4 - lounge
		// 5 - dj
		// 6 - dancefloor
		if (number >= 0 && number < 30) {
			desire = 1;
		}
		else if (number >= 30 && number < 60) {
			desire = 2;
		}
		else if (number >= 60 && number < 80) {
			desire = 3;
		}
		else if (number >= 80 && number < 90) {
			desire = 4;
		}
		else if (number >= 90 && number < 95) {
			desire = 5;
		}
		else if (number >= 95 && number < 100) {
			desire = 6;
		}
		return desire;
	}

	public void drink(BeverageType type) { // Ask bartender to drink. The update alcohol levels happens automatically!
		// TODO
		// increase the drunkness level and subsequently make it lose coordination
	}
}