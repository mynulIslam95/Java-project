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

public class Catherine2 extends Avatar{

	// store locally where u are
	// check with that exactly what can u do?

	// ************** Constructor **************
	public Catherine2(Shape shape, Color color, int borderWidth, int avatarAge, String avatarName, int waitingTime) {
		super(shape, color, borderWidth, avatarAge, avatarName, waitingTime);
		// TODO Auto-generated constructor stub
	}

	public void dancingAlgo() {
		System.out.println("dance");

	}

	public void fight(Avatar opponent) { // Call this function if other avatar starts a fight
		System.out.println("Fight " + opponent.getName());
		opponent.setIsHit(true);
	}

	public void talk(Avatar person) {
		System.out.println("Hi " + person.getName());
	}

	public void toilet(int timeInToilet) {
		System.out.println("wc for " + timeInToilet);
	}

	public void playPool() {
		System.out.println("playing pool");
	}

	public void playFussball() {
		System.out.println("playing foosball");
	}

	public Direction moveAvatar() {
		Random rand = new Random();		
		int number = rand.nextInt(50);
		Direction dir;	
		if ((number % 2) == 0) {
			dir = Direction.FORWARD;
		} else if ((number % 3) == 0) {
			dir = Direction.BACK;
		} else if ((number % 4) == 0) {
			dir = Direction.RIGHT;
		} else {
			dir = Direction.LEFT;
		} 
		return dir;
	}
}
