///////////////////////////////////////////////////////////////////////////////
//                   Party Simulator
// Date:         01/12/2023
//
// Class: Bjoern.java
// Description: Template for the people
//
///////////////////////////////////////////////////////////////////////////////
package com.simulation.partypeople;

import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;
import com.simulation.avatar.Avatar;
import com.simulation.enums.Direction;
import com.simulation.enums.Shape;
import com.simulation.enums.Places;

public class Bjoern extends Avatar {

	// store locally where u are
	// check with that exactly what can u do?
	private boolean onDanceFloor = false;

	// ************** Constructor **************
	public Bjoern(Shape shape, Color color, int borderWidth, int avatarAge, String avatarName, int waitingTime) {
		super(shape, color, borderWidth, avatarAge, avatarName, waitingTime);
	}

	@Override
	public int getAge() {
		return 22;
	}
	
	public void dancingAlgo() {
		// TODO

	}

	public void fight(Avatar opponent) { // Call this function if other avatar starts a fight
		// TODO

	}

	public void talk(Avatar person) {
		// TODO
	}

	public void smoke() {
		// TODO
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
		Places inFrontOfMe = getWhatISee()[0];
		System.out.println(inFrontOfMe);
		if (!onDanceFloor) {
			switch (inFrontOfMe) {
			case PATH:
				return Direction.FORWARD;
			case PERSON:
				return Direction.LEFT;
			case DANCEFLOOR:
				onDanceFloor = true;
				return Direction.IDLE;
			case OUTSIDE:
				return Direction.BACK;
			default:
				return determineMovementRandomly();
			}
		} else {
			switch (inFrontOfMe) {
			case PATH:
				return Direction.BACK;
			case PERSON:
				return Direction.IDLE;
			case DANCEFLOOR:
				onDanceFloor = true;
				return Direction.FORWARD;
			default:
				return determineMovementRandomly();
			}
		}
	}

	private Direction determineMovementRandomly() {
		int rand = ThreadLocalRandom.current().nextInt(0, 100);
		switch ((00 <= rand && rand < 33) ? 0 : (33 <= rand && rand < 66) ? 1 : 2) {
		case 0:
			return Direction.FORWARD;
		case 1:
			return Direction.RIGHT;
		default:
			return Direction.LEFT;
		}
	}
}
