///////////////////////////////////////////////////////////////////////////////
//                   Party Simulator
// Date:         27/10/2023
//
// Class: Bouncer.java
// Description: Class extending avatar.java for the bouncer checking people
//              ages and also stopping fights
//
///////////////////////////////////////////////////////////////////////////////
package com.simulation.avatar;

import java.awt.Color;
import com.simulation.enums.Direction;
import com.simulation.enums.Shape;

public class Bouncer extends Avatar {
	private static final int AGELIMIT = 18;
	// I think the Simulation should be in charge of these lists of people in the
	// party and people who are not outside:
	// Everyone starts out outside. If they get granted entry, they get added to the
	// peopleInParty list.
	// If they get kicked out or the bouncer has to break up a fight with one of
	// them, they get added to the peopleWhoAreOutside list.
	// List<Avatar> peopleInParty = new ArrayList<>();
	// List<Avatar> peopleWhoAreOutside = new ArrayList<>();

	// ************** Constructor **************
	public Bouncer(Shape shape, Color color, int borderWidth) {
		super(shape, color, borderWidth);
	}

	public boolean checkAge(int avatarAge) {
		boolean isOverAge = false;
		if (avatarAge >= AGELIMIT) {
			isOverAge = true;
		}
		return isOverAge;
	}

	public boolean checkVibe(Avatar person) {
		// Check the person's age and if they are in timeout, then let them in or not
		boolean personIsInParty;
		int personAlc = person.getAlcoholPercentage();
		int personAge = person.getAge();
		int personTimeoutTimeRemaining = person.getTimeoutTimeRemaining();
		boolean personIsOldEnough = checkAge(personAge);
		if (personAlc == 0 && personIsOldEnough == true && personTimeoutTimeRemaining == 0) {
			person.setIsInThePartyState(true);
			//The Environment should own the arrays for people in the party and people outside
			/* if (!peopleInParty.contains(person)) {
				peopleInParty.add(person);
			}
			if (peopleWhoAreOutside.contains(person)) {
				peopleWhoAreOutside.remove(person);
			} */
			personIsInParty = true;
		} else {
			person.setIsInThePartyState(false);
			personIsInParty = false;
		}
		return personIsInParty;
	}

	public void hitPerson(Avatar person) {
		// The bouncer hits the person
		person.setIsHit(true);
	}

	public void breakUpFight(Avatar person1, Avatar person2, int person1DurationKickedOut,
			int person2DurationKickedOut) {
		// The bouncer breaks up a fight between two Avatars
		hitPerson(person1);
		hitPerson(person2);
		kickOut(person1, person1DurationKickedOut);
		kickOut(person2, person2DurationKickedOut);
	}

	// Here, maybe the Environment keeps track of if the timeout time has elapsed or
	// not
	public void setTimeout(Avatar person, int timeoutOverride) {
		// If timeoutOverride is 0, then use the default timeout value of 10.
		// If timeoutOverride is > 0, then use that value.
		int timeInTimeout = (timeoutOverride > 0) ? timeoutOverride : 10;
		person.setTimeoutTimeRemaining(timeInTimeout);

	}

	public Avatar kickOut(Avatar person, int duration) {
		// kick the person out from the party
		person.setIsInThePartyState(false);
		//The Environment should own the arrays for people in the party and people outside
		/* if (!peopleWhoAreOutside.contains(person)) {
			peopleWhoAreOutside.add(person);
		}
		if (peopleInParty.contains(person)) {
			peopleInParty.remove(person);
		}*/ 
		setTimeout(person, duration);
		// Here, maybe the Environment keep track of how much time is remaining
		person.setTimeoutTimeRemaining(duration);

		// Return the Avatar so that the Environment can work with it to keep track of
		// how much time is remaining for
		// this particular Avatar to be outside
		return person;
	}

	//The Environment should own the arrays for people in the party and people outside
	/* public List<Avatar> getListOfPeopleInParty() {
		return peopleInParty;
	}

	public String getListOfPeopleWhoAreOutside() {
		return peopleWhoAreOutside.toString();
	}*/

	public Direction moveAvatar() {
		return Direction.IDLE;
	}
}
