///////////////////////////////////////////////////////////////////////////////
//                   Party Simulator
// Date:         27/10/2023
//
// Class: MainTest.java
// Description: Main class for testing the avatar keep disabled outside of
//              avatar development
//
///////////////////////////////////////////////////////////////////////////////

package com.simulation.avatar;

import java.awt.Color;
import java.io.FileNotFoundException;

import com.simulation.enums.Shape;
import com.simulation.partypeople.*;

public class MainTest {
	public static void main(String[] args) throws FileNotFoundException {

		AvatarTemplate avatarJoe = new AvatarTemplate(Shape.CIRCLE, Color.RED, 1, 20, "Almudena", 0);
		Jose JoseLu = new Jose(Shape.CIRCLE, Color.RED, 1, 20, "JoseLu", 0);
		Anatoly Toli = new Anatoly(Shape.CIRCLE, Color.BLACK, 1, 22, "Anatoly Cartman", 0);
		Catherine2 partyGoerY = new Catherine2(Shape.CIRCLE, Color.RED, 1, 17, "Catherine-too-young", 0);
		Catherine2 partyGoerC1 = new Catherine2(Shape.CIRCLE, Color.RED, 1, 30, "CatherineC1", 0);
		Catherine2 partyGoerC2 = new Catherine2(Shape.CIRCLE, Color.RED, 1, 20, "CatherineC2", 0);
		Bouncer bouncerBob = new Bouncer(Shape.CIRCLE, Color.BLUE, 5);

		// The Bouncer checks if all 4 people can be let in
		bouncerBob.checkVibe(avatarJoe);
		bouncerBob.checkVibe(partyGoerC1);
		bouncerBob.checkVibe(partyGoerC2);
		bouncerBob.checkVibe(partyGoerY);
		bouncerBob.checkVibe(JoseLu);


		JoseLu.talk();
		Toli.fight(JoseLu);
	

		// The Bouncer kicks out Almudena and partyGoerC
		bouncerBob.breakUpFight(partyGoerC1, partyGoerC2, 10, 20);
		

		// After 10 min go by, Set the timeout time of the people who were kicked out
		partyGoerC1.setTimeoutTimeRemaining(0);
		partyGoerC2.setTimeoutTimeRemaining(10);

		// The Bouncer checks if all 4 people can be let in
		bouncerBob.checkVibe(avatarJoe);
		bouncerBob.checkVibe(partyGoerC1);
		bouncerBob.checkVibe(partyGoerC2);
		bouncerBob.checkVibe(partyGoerY);

	

		DJ dj = new DJ(Shape.CIRCLE, Color.BLUE, 5, 1);
		dj.playMusic(); // Start playing all tracks in sequence
		
		try {
			Thread.sleep(Long.MAX_VALUE); // Keep the main thread asleep
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

	}
}