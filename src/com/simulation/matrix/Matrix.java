package com.simulation.matrix;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.simulation.avatar.Bouncer;
import com.simulation.avatar.DJ;
import com.simulation.enums.ChangeInXY;

import com.simulation.enums.Direction;
import com.simulation.enums.Heading;
import com.simulation.enums.Shape;
import com.simulation.enviroment.MyFrame;
import com.simulation.partypeople.*;


public class Matrix {

	private MyFrame env;
	private ArrayList<LocatedAvatar> avatars;       // Array list for all avatars
	private ArrayList<LocatedAvatar> queueAvatars;  // Array list for tracking avatars in queue
	private ArrayList<LocatedAvatar> clubAvatars;  // Array list for tracking avatars in club
	private ArrayList<LocatedAvatar> unrenderedAvatars;  // Array list for tracking all avatars
	private Bouncer bouncer;
	DJ dj;
	public static JFrame frame;
	
	JButton changeMusicButton;
	JComboBox<String> musicListDropdown;
	JButton DJPlayButton;
	JButton DJStopButton;
	private JButton stopButton;

	public Matrix() {
		env = new MyFrame();
		env.setVisible(true);
		avatars = new ArrayList<>();
		queueAvatars = new ArrayList<>();
		clubAvatars = new ArrayList<>();
		unrenderedAvatars = new ArrayList<>();
		
		// Thorvin only to be touch by Thorvin
		Thorvin thorvin = new Thorvin(Shape.CIRCLE,Color.gray, 0, 20,"Thorvin", 0);
		LocatedAvatar locThorvin = new LocatedAvatar(thorvin, 0 ,0);	
		avatars.add(locThorvin);

		// catherine only to be touch by catherine
		Catherine2 catherine = new Catherine2(Shape.CIRCLE,Color.GRAY, 0, 20,"Catherine", 0);
		LocatedAvatar locCatherine = new LocatedAvatar(catherine, 0 ,0);
		avatars.add(locCatherine);
		
		// Mynul only to be touch by Mynul
		Mynul mynul = new Mynul(Shape.CIRCLE, Color.BLUE, 1, 20, "Mynul", 0);
		LocatedAvatar locMynul = new LocatedAvatar(mynul, 0, 0);
		avatars.add(locMynul);
						

		// emmanuel only to be touch by emmanuel
		Emmanuel emmanuel = new Emmanuel(Shape.CIRCLE, Color.RED, 0, 20, "Emmanuel", 0);
		LocatedAvatar locEmmanuel = new LocatedAvatar(emmanuel, 0, 0);
		avatars.add(locEmmanuel);

		// eliyas only to be touch by eliyas
		Eliyas eliyas = new Eliyas(Shape.SQUARE, new Color(160,32,240), 0, 20, "Eliyas", 0);
		LocatedAvatar locEliyas = new LocatedAvatar(eliyas, 0, 0);
		avatars.add(locEliyas);
		

		// Anatoly only to be touch by Anatoly
		Anatoly toly = new Anatoly(Shape.CIRCLE, Color.darkGray, 0, 49, "Celestine", 0);
		LocatedAvatar locAnatoly = new LocatedAvatar(toly, 0, 0);
		avatars.add(locAnatoly);

		// Alisa only to be touch by Alisa
		Alisa alisa = new Alisa(Shape.SQUARE, Color.PINK, 0, 20, "Alisa", 0);
		LocatedAvatar locAlisa = new LocatedAvatar(alisa, 0, 0);
		avatars.add(locAlisa);

		// Bjoern only to be touch by Bjoern
		Bjoern bjoern = new Bjoern(Shape.SQUARE, new Color(246,204,255), 0, 22, "Björn", 0);
		LocatedAvatar locBjoern = new LocatedAvatar(bjoern, 0, 0);
		avatars.add(locBjoern);

		// Bernhard only to be touch by Bernhard
		Bernhard bernhard = new Bernhard(Shape.CIRCLE, Color.YELLOW, 0, 24, "Bernhard",0);
		LocatedAvatar locBernhard = new LocatedAvatar(bernhard, 0, 0);
		avatars.add(locBernhard);

		// Jose only to be touch by the great Jose
		Jose Jose = new Jose(Shape.CIRCLE, Color.LIGHT_GRAY, 1, 20, "JoseLu", 0);
  		LocatedAvatar locJose = new LocatedAvatar(Jose, 0, 0);
  		avatars.add(locJose);

		// Celestine only to be touch by Celestine
		Celestine celestine  = new Celestine();
		LocatedAvatar locCelestine = new LocatedAvatar(celestine, 0, 0);
		avatars.add(locCelestine);

		// Kieran only to be touch by Kieran
		Kieran kieran = new Kieran(Shape.TRIANGLE, Color.ORANGE, 1, 21, "Kieran", 0);
		LocatedAvatar locKieran = new LocatedAvatar(kieran, 0 ,0);
		avatars.add(locKieran);

		// igor only to be touch by igor
		Igor igor = new Igor(Shape.CIRCLE, new Color(0,153,153), 0, 20, "Igor", 0);
		LocatedAvatar locIgor = new LocatedAvatar(igor, 0, 0);
		avatars.add(locIgor);

		// DJ & Bouncer
		this.bouncer = new Bouncer(Shape.CIRCLE, Color.BLACK, 0);
		dj = new DJ(Shape.CIRCLE,Color.WHITE,0,1);
		LocatedAvatar locDj = new LocatedAvatar(dj, 16, 1);
		// avatars.add(locDj);

		frame = new JFrame("Music Matrix");
        frame.setSize(200, 200);
		frame.setResizable(false);
		frame.setLocation(1000, 400);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        changeMusicButton = new JButton("Change Music");
        changeMusicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dj.handleUserMusicRequest();
            }
        });

		musicListDropdown = new JComboBox<>(dj.getMusicList().toArray(new String[0]));
		musicListDropdown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedMusic = (String) musicListDropdown.getSelectedItem();
                dj.playSpecificMusic(selectedMusic);
			}
        });

		stopButton = new JButton("STOP");
        stopButton.setBackground(Color.RED);
		stopButton.setOpaque(true);
        // stopButton.setForeground(Color.WHITE);
        stopButton.setFocusPainted(false);
        stopButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        stopButton.setPreferredSize(new Dimension(100, 40));
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dj.stopMusic();
            }
        });
        JPanel panel = new JPanel();
        panel.add(changeMusicButton);
        panel.add(new JLabel("Available Musics:"));
        panel.add(musicListDropdown);
		panel.add(stopButton);
        frame.add(panel);

        frame.setVisible(false);
	}

	private void sortAvatar(LocatedAvatar avatar) {
		if (!clubAvatars.contains(avatar) && !queueAvatars.contains(avatar) && !unrenderedAvatars.contains(avatar)) {
			unrenderedAvatars.add(avatar);
		}

		if (queueAvatars.size() < 17 && unrenderedAvatars.contains(avatar)) {
			int lastInQueueY = 22;
			if (!queueAvatars.isEmpty()) {
				lastInQueueY = queueAvatars.get(queueAvatars.size() - 1).getY();
			}
			if (lastInQueueY <= 22) {
				if (queueAvatars.isEmpty()) {
					unrenderedAvatars.remove(avatar);
					avatar.setX(34);
					avatar.setY(lastInQueueY);
					queueAvatars.add(avatar);
				} else if (lastInQueueY < 22) {
					unrenderedAvatars.remove(avatar);
					avatar.setX(34);
					avatar.setY(lastInQueueY + 1);
					queueAvatars.add(avatar);
				}
			}
		}
	}

	private void moveAvatarInQueue(LocatedAvatar avatar) {
		wait(30);
		avatar.setWhatIsee(env);
		int x = avatar.getX();
		int y = avatar.getY();
		if (x == 34 && y > 5) {
			if (env.isUsable(avatar.getX(), avatar.getY() - 1)) {
				avatar.setX(x);
				avatar.setY(y - 1);
				env.moveInQueue(x, y, avatar.getColor());
			}
		} else if (x <= 34 && y == 5) {
			if (queueAvatars.get(0).equals(avatar)) {
				if (env.isUsable(avatar.getX() - 1, avatar.getY())) {
					env.moveInQueue(x, y, avatar.getColor());
					avatar.setX(x - 1);
					avatar.setY(y);
					if (x - 1 == 32) {
						// the avatar is allowed in
						if (bouncer.checkVibe(avatar.getAvatar())){
							queueAvatars.remove(avatar);
							clubAvatars.add(avatar);
						}
						// the avatar is not allowed in
						else{
							queueAvatars.remove(avatar);
							//env.removeAvatarFromMap(avatar.getX(), avatar.getY());
						}
					}
					
				}
			}
		}
	}

	private void moveAvatarInClub(LocatedAvatar avatar) {
		wait(30);
		avatar.setWhatIsee(env);
		int oldX = avatar.getX();
		int oldY = avatar.getY();
		Direction dir = avatar.getAvatar().moveAvatar();
		switch (dir) {
			case FORWARD:
				switch (avatar.getHeading()) {
					case WEST -> changeXY(avatar, ChangeInXY.DECX);
					case EAST -> changeXY(avatar, ChangeInXY.INCX);
					case NORTH -> changeXY(avatar, ChangeInXY.DECY);
					case SOUTH -> changeXY(avatar, ChangeInXY.INCY);
				}
				break;
			case BACK:
				switch (avatar.getHeading()) {
					case WEST -> changeXY(avatar, ChangeInXY.INCX);
					case EAST -> changeXY(avatar, ChangeInXY.DECX);
					case NORTH -> changeXY(avatar, ChangeInXY.INCY);
					case SOUTH -> changeXY(avatar, ChangeInXY.DECY);
				}
				break;
			case RIGHT:
				switch (avatar.getHeading()) {
					case WEST -> changeXY(avatar, ChangeInXY.DECY);
					case EAST -> changeXY(avatar, ChangeInXY.INCY);
					case NORTH -> changeXY(avatar, ChangeInXY.INCX);
					case SOUTH -> changeXY(avatar, ChangeInXY.DECX);
				}
				break;
			case LEFT:
				switch (avatar.getHeading()) {
					case WEST -> changeXY(avatar, ChangeInXY.INCY);
					case EAST -> changeXY(avatar, ChangeInXY.DECY);
					case NORTH -> changeXY(avatar, ChangeInXY.DECX);
					case SOUTH -> changeXY(avatar, ChangeInXY.INCX);
				}
				break;
			case TURN_LEFT_ON_SPOT:
				switch (avatar.getHeading()) {
					case WEST -> avatar.setHeading(Heading.SOUTH);
					case EAST -> avatar.setHeading(Heading.NORTH);
					case NORTH -> avatar.setHeading(Heading.WEST);
					case SOUTH -> avatar.setHeading(Heading.EAST);
				}
				break;
			case TURN_RIGHT_ON_SPOT:
				switch (avatar.getHeading()) {
					case WEST -> avatar.setHeading(Heading.NORTH);
					case EAST -> avatar.setHeading(Heading.SOUTH);
					case NORTH -> avatar.setHeading(Heading.EAST);
					case SOUTH -> avatar.setHeading(Heading.WEST);
				}
				break;				
		}
		env.setPlaceFree(oldX, oldY);
		env.moveTo(oldX, oldY, avatar.getX(), avatar.getY(),avatar.getColor());
		env.setPlaceOccupied(avatar.getX(), avatar.getY());
	}

	public void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}


	public void run() {
		//playDJ();
		while (true) {
			for (LocatedAvatar avatar : avatars) {
				sortAvatar(avatar);

				if (queueAvatars.contains(avatar)) {
					moveAvatarInQueue(avatar);
				}

				if (clubAvatars.contains(avatar)) {
					moveAvatarInClub(avatar);
				}
			}
		}
	}

	private void changeXY(LocatedAvatar locAvatar, ChangeInXY c) {
		switch (c) {
			case INCX:
				if (env.isUsable(locAvatar.getX() + 1, locAvatar.getY())
						&& !env.isWall(locAvatar.getX(), locAvatar.getY(), locAvatar.getX() + 1, locAvatar.getY())) {
					locAvatar.incX();
					locAvatar.setHeading(Heading.EAST);
				}
				break;

			case DECX:
				if (env.isUsable(locAvatar.getX() - 1, locAvatar.getY())
						&& !env.isWall(locAvatar.getX(), locAvatar.getY(), locAvatar.getX() - 1, locAvatar.getY())) {
					locAvatar.decX();
					locAvatar.setHeading(Heading.WEST);
				}
				break;

			case INCY:
				if (env.isUsable(locAvatar.getX(), locAvatar.getY() + 1)
						&& !env.isWall(locAvatar.getX(), locAvatar.getY(), locAvatar.getX(), locAvatar.getY() + 1)) {
					locAvatar.incY();
					locAvatar.setHeading(Heading.SOUTH);
				}
				break;

			case DECY:
				if (env.isUsable(locAvatar.getX(), locAvatar.getY() - 1)
						&& !env.isWall(locAvatar.getX(), locAvatar.getY(), locAvatar.getX(), locAvatar.getY() - 1)) {
					locAvatar.decY();
					locAvatar.setHeading(Heading.NORTH);
				}
				break;
		}
	}

	private void playDJ(){
		dj.playMusic();
	}

	
}
