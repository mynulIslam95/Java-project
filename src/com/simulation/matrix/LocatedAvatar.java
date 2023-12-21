package com.simulation.matrix;

import java.awt.Color;

import com.simulation.avatar.Avatar;

import com.simulation.enums.Heading;
import com.simulation.enums.Places;
import com.simulation.enviroment.MyFrame;

public class LocatedAvatar {
	private Avatar avatar;
	private int x;
	private int y;
	private Heading heading;

	public LocatedAvatar(Avatar avatar, int x, int y) {
		this.avatar = avatar;
		this.x = x;
		this.y = y;
		this.heading = Heading.WEST;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public Heading getHeading() {
		return heading;
	}

	public void incX() {
		x++;
	}

	public void decX() {
		x--;
	}

	public void incY() {
		y++;
	}

	public void decY() {
		y--;
	}

	public void setHeading(Heading heading) {
		this.heading = heading;
	}

	public Color getColor() {
		return avatar.getColor();
	}
		
	public void setWhatIsee(MyFrame env) {
		Places[] p = new Places[2];
		p[0] = getPlace(env, x, y);
		p[1] = getFrontPlace(env);
		avatar.setWhatISee( p );
		
		//System.out.println("\n"+avatar.getName()+"'s heading: "+heading+" "+p[0]);
		//Scanner inp = new Scanner(System.in);
		//inp.nextLine();
	}

	
	
	
	private Places getFrontPlace(MyFrame env) {
		if ( x > MyFrame.getEntranceX() ) {
			return Places.OUTSIDE;
		}
		switch (getHeading()) {
		case WEST:
			if( x == 0 ) {
				return Places.WALL;
			}else {
				return getPlace(env, x-1, y);
			}
		case EAST:
			if( x == MyFrame.getEntranceX() ) {
				return Places.WALL;
			} else {
				return getPlace(env, x+1, y);
			}
		case NORTH:
			if ( y == 0 ) {
				return Places.WALL;
			} else {
				return getPlace(env, x, y-1);
			}
		default: // SOUTH:
			if ( y == MyFrame.getMaxY() - 1 ) {
				return Places.WALL;
			} else {
				return getPlace(env, x, y+1);
			}
			}
}
		
	private Places getPlace(MyFrame env, int x, int y) {
		if ( env.getPlace(x, y) == Places.PATH && !env.isUsable(x, y) ) {
			return Places.PERSON;
		} else {
			return env.getPlace(x, y);
		}
	}
	
}
