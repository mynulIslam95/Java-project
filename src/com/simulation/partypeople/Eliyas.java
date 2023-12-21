package com.simulation.partypeople;

import java.awt.Color;
import java.util.Random;
import com.simulation.avatar.Avatar;
import com.simulation.enums.BeverageType;
import com.simulation.enums.Direction;
import com.simulation.enums.Places;
import com.simulation.enums.Shape;

public class Eliyas extends Avatar {

	public Eliyas(Shape shape, Color color, int borderWidth, int avatarAge, String avatarName, int waitingTime) {
		super(shape, color, borderWidth, avatarAge, avatarName, waitingTime);

	}

	public void dancingAlgo() {

	}

	public void drink(BeverageType type) {
		// TODO

	}

	public void fight(Avatar opponent) {
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
		Places iStandOn = getWhatISee()[0];
		Places inFrontOfMe = getWhatISee()[1];
		if (iStandOn != Places.DANCEFLOOR)
			switch (inFrontOfMe) {
			case WALL:
				return Direction.TURN_LEFT_ON_SPOT;
			case BAR:
				return Direction.TURN_LEFT_ON_SPOT;
			case POOL:
				return Direction.TURN_LEFT_ON_SPOT;
			case FUSSBALL:
				return Direction.TURN_LEFT_ON_SPOT;
			case TOILET:
				return Direction.TURN_LEFT_ON_SPOT;
			case DANCEFLOOR:
				return Direction.FORWARD;
			case BOUNCER:
				return Direction.TURN_LEFT_ON_SPOT;
			case DJ:
				return Direction.TURN_LEFT_ON_SPOT;
			case OUTSIDE:
				return Direction.BACK;
			default:
				return randomMovement();
			}
		else {
			switch (inFrontOfMe) {
			case PERSON:
				return Direction.TURN_RIGHT_ON_SPOT;
			case PATH:
				return Direction.BACK;
			default:
				return randomMovement();
			}
		}
	}

	private Direction randomMovement() {
		Random rand = new Random();
		int number = rand.nextInt(100);
		Direction dir = Direction.IDLE;
		if (number <= 45) {
			dir = Direction.FORWARD;
		} else if (number > 45 && number < 65) {
			dir = Direction.RIGHT;
		} else if (number > 65 && number < 75) {
			dir = Direction.BACK;
		} else if (number >= 75) {
			dir = Direction.LEFT;
		}
		return dir;
	}

}
