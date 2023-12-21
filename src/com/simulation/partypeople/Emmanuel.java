package com.simulation.partypeople;

import java.awt.Color;
import java.util.Random;

import com.simulation.avatar.Avatar;
import com.simulation.enums.Direction;
import com.simulation.enums.Shape;

public class Emmanuel extends Avatar {

	public Emmanuel(Shape shape, Color color, int borderWidth, int avatarAge, String avatarName, int waitTime) {
		super(shape, color, borderWidth, avatarAge, avatarName, waitTime);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Direction moveAvatar() {
		Random rand = new Random();
		int number = rand.nextInt(5);
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
		}
		else if (number == 4) {
			dir = Direction.TURN_LEFT_ON_SPOT;
		}
		else if (number == 5) {
			dir = Direction.TURN_RIGHT_ON_SPOT;
		}
		return dir;
	
	}

}
