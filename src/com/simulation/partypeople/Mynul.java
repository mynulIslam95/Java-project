///////////////////////////////////////////////////////////////////////////////
//                   Party Simulator
// Date:         16/12/2023
//
// Class: Mynul.java
// Description: Avatar class for Mynul
//
///////////////////////////////////////////////////////////////////////////////

package com.simulation.partypeople;
import com.simulation.avatar.Avatar;
import java.awt.Color;
import java.io.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import com.simulation.enums.*;

import com.simulation.enums.Direction;
public class Mynul extends Avatar {
    
    private int dancingCounter = 0;
    private Direction moonwalkingDirection = Direction.LEFT;
    private int moonwalkingCounter = 0;

// ************** Constructor **************
	public Mynul(Shape shape, Color color, int borderWidth, int avatarAge, String avatarName, int waitingTime) {
		super(shape, color, borderWidth, avatarAge, avatarName, waitingTime);
		
	
		

	}


public Direction dancingAlgo() {
    Direction dancingDir;

    // Check if it's time to change the moonwalking direction
    if (moonwalkingCounter <= 7) {
        // Continue moonwalking in the same direction
        dancingDir = moonwalkingDirection;
        moonwalkingCounter++;
    } else {
        // Change moonwalking direction after covering about 6 blocks
        moonwalkingCounter = 0;
        moonwalkingDirection = (moonwalkingDirection == Direction.LEFT) ? Direction.RIGHT : Direction.LEFT;
        dancingDir = moonwalkingDirection;
    }

    // Introduce more random and forward moves
    int randomMove = ThreadLocalRandom.current().nextInt(0, 11);
    switch (randomMove) {
        case 0:
        case 1:
        case 2:
        case 3:
            dancingDir = Direction.FORWARD;
            break;
        case 4:
            dancingDir = Direction.BACK;
            break;
        case 5:
            dancingDir = Direction.TURN_LEFT_ON_SPOT;
            break;
        case 6:
            dancingDir = Direction.FORWARD;
            break;
        case 7:
            dancingDir = Direction.TURN_LEFT_ON_SPOT;
            break;
		case 8:
            dancingDir = Direction.FORWARD;
            break;
		case 9:
            dancingDir = moonwalkingDirection;
            break;
		case 10:
            dancingDir = Direction.BACK;
            break;
        default:
            break;
    }

    dancingCounter++;

    System.out.println(this.getName() + " is dancing");

    return dancingDir;
}


	
		public int getAge() {
		return 28;
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
		// Check if Mynul is on the dance floor
		if (getWhatISee()[0] == Places.DANCEFLOOR) {
			// If on the dance floor, call the dancing algorithm
			return dancingAlgo(); // Stay idle during dancing
		} else {
			// If not on the dance floor, move towards the dance floor
			if (getWhatISee()[1] == Places.DANCEFLOOR) {
				// If dance floor is ahead, move forward
				return Direction.FORWARD;
			} else {
				// Otherwise, perform regular movement with adjusted speed
				int r = ThreadLocalRandom.current().nextInt(0, 100);
				switch ((00 <= r && r < 20) ? 0 :
						(20 <= r && r < 40) ? 1 :
						(40 <= r && r < 60) ? 2 :
						(60 <= r && r < 80) ? 4 :
						(80 <= r && r < 95) ? 5 : 3) {
					case 0:
						return Direction.FORWARD;
					case 1:
						return Direction.RIGHT;
					case 2:
						return Direction.LEFT;
					case 3:
						return Direction.BACK;
					case 4:
						return Direction.TURN_LEFT_ON_SPOT;
					case 5:
						return Direction.TURN_RIGHT_ON_SPOT;
					default:
						return Direction.IDLE;
				}
			}
		}
	}
	
	

	
}
