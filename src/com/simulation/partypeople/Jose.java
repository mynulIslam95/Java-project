///////////////////////////////////////////////////////////////////////////////
//                   Party Simulator
// Date:         27/10/2023
//
// Class: Jose.java
// Description: Avatar class for Jose Luis Roldan Rodriguez
//
///////////////////////////////////////////////////////////////////////////////
package com.simulation.partypeople;

import com.simulation.avatar.Avatar;

import java.awt.Color;
import java.io.*;
import java.util.Random;

import com.simulation.enums.*;

public class Jose extends Avatar {

	File file = new File("misc/Shrek-Script_Jose.txt");
	BufferedReader br = null;

	private int WAIT_TOILET = 10; // 10 loops * 30 ms

	private String shrek_movie;
	private BeverageType myBeverageType; 
	private int waitTime_toilet; 
	private int waitTime_dance; 
	private boolean is_dancing; 
	private boolean is_near_bar; 


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
	public Jose(Shape shape, Color color, int borderWidth, int avatarAge, String avatarName, int waitingTime) {
		super(shape, color, borderWidth, avatarAge, avatarName, waitingTime);
		this.myBeverageType = BeverageType.MOJITO;
		this.waitTime_toilet = 0;
		this.waitTime_dance = 0;
		try {
			br = new BufferedReader(
				new InputStreamReader(new FileInputStream(file),"UTF-8"));
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			e.printStackTrace();
		}
		// Read first line
		try {
			shrek_movie = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ************** Methods **************
	public Direction dancingAlgo(Places place) {	// Implement how much time to be inside the dancing floor, for now stay inside
		// TODO
		// develop the type of movement that would represent your dance pattern

		Direction dancingDir = Direction.IDLE;

		if (is_dancing == false){  // Step inside dancing floor
			dancingDir = Direction.FORWARD;
			is_dancing = true;
			System.out.printf("Jose: Yeah dancing is fun! \n");
		} else if (place != Places.DANCEFLOOR){
			dancingDir = Direction.TURN_LEFT_ON_SPOT;
		} else {
			dancingDir = moveRand();  // Move random for now inside the dancing floor
		}
		return dancingDir;
	}

	public void fight(Avatar opponent) { // Call this function if other avatar starts a fight
		if (opponent.getName() == "Anatoly Cartman") {
			// DJ.playSpecificMusic("Fighting_Love");
			System.out.printf("Jose kicks %s %n", opponent.getName());
		}
		// TODO
		// develop different fighting moves
		// be very descriptive (user 2 is performing an F5 on user 3)
	}

	public void talk() { // My avatar only speaks about shrek movie
		try {
			for (int i = 0; i < 2; i++) {
				// DJ.playSpecificMusic("AllStar");
				if ((shrek_movie = br.readLine()) != null) {
					System.out.printf("Jose: %n   %s %n", shrek_movie);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void smoke() {
		// TODO
		// if you are in the smoking area you get prompted the option to smoke
	}

	public Direction toilet() { // Do only toilet things in the toilet
		Direction dir = Direction.IDLE;
		if(waitTime_toilet == 0){
			dir = Direction.IDLE;
			System.out.printf("Jose: Im sitting on the toilet playing my recorder turururu tururururu \n");
		} else if (waitTime_toilet < WAIT_TOILET) {
			dir = Direction.IDLE;
			System.out.printf("Jose: Sitting on the toilet playing my recorder turururu tururururu \n");
		} else{
			if(waitTime_toilet == (WAIT_TOILET + 2)){
				dir = Direction.FORWARD;
				waitTime_toilet = 0;
			} else{
				dir = Direction.TURN_LEFT_ON_SPOT;
			}
		}
		waitTime_toilet ++;
		return dir;
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

	public Direction moveAvatar() { // First implementation random movement
		// TODO
		// IF A WAIT TIME > 0, do that action skipping switch case
		Direction dir = Direction.FORWARD; //Default
		Places place_ahead = getWhatISee()[1];
		Places place_standing = getWhatISee()[0];
		// System.out.printf("Jose sees: %s \n", place); // FRO DEBBUGING
		if (is_dancing == true) {
			dir = this.dancingAlgo(place_ahead);
		// } else if (){

		} else {
		switch (place_ahead) {
			case BAR:
				if (place_standing == Places.BAR) {
					dir = Direction.TURN_LEFT_ON_SPOT;
					this.drink(myBeverageType);		// Drink
					is_near_bar = false;
				} else {
					dir = Direction.TURN_LEFT_ON_SPOT;
					is_near_bar = true;
				}
				
				break;
			case POOL:
				dir = Direction.TURN_LEFT_ON_SPOT;   // Play for x time
				this.playPool();
				break;
			case TOILET:
				dir = toilet();  // Stay x time and then leave
				break;
			case DANCEFLOOR:
				dir = this.dancingAlgo(place_ahead);
				break;
			case FUSSBALL:
				dir = Direction.TURN_LEFT_ON_SPOT;
				this.playFussball();  // Play for x time
				break;
			case LOUNGE_BIG: // stay for x time
				System.out.println("Jose is in the lounge.");
				break;
			case LOUNGE_SMALL: // stay for x time
				System.out.println("Jose is in the lounge.");
				break;
			case LOUNGE_SMOKING:
				System.out.println("Sorry I don't smoke");
				break;
			case DJ:
				// Ask for song?
				dir = Direction.TURN_LEFT_ON_SPOT;  // Stay x time and then leave
				break;
			case BOUNCER:
				System.out.println("Jose: Hi bouncer!");
				dir = Direction.TURN_LEFT_ON_SPOT;  // Stay x time and then leave
				break;
			case PATH:
				if (random() >=2){
					dir = moveRand();  // KEEP WALKING WALKING WALKING WALK
				}
				break;
			case WALL:
				dir = Direction.TURN_LEFT_ON_SPOT;  // Turn around
				break;
			case OUTSIDE:
				// Turn around I dont want to leave hehe
				dir = Direction.TURN_LEFT_ON_SPOT;
				break;
			case PERSON:
				dir = Direction.IDLE;
				talk();
				break;
			case QUEUE:
				System.out.println("Queque.");
				break;
			default:
				dir = moveRand();
				break;
			}
		} 
		return dir;
	}

	public void drink(BeverageType type) { // Ask bartender to drink. The update alcohol levels happens automatically!
		// TODO
		// increase the drunkness level and subsequently make it lose coordination
		System.out.printf("Jose: bartender give me your strongest potion \n");
	}

	public Direction moveRand(){
		Direction dir = Direction.IDLE;
		switch(random()){
			case 0:
				dir = Direction.FORWARD;
				break;
			case 1:
				dir = Direction.TURN_RIGHT_ON_SPOT;
				break;
			case 2:
				dir = Direction.FORWARD;
				break;
			case 3:
				dir = Direction.TURN_LEFT_ON_SPOT;
				break;
		}
		return dir;
	}

	public int random(){
		Random rand = new Random();
		return rand.nextInt(4);
	}
}
