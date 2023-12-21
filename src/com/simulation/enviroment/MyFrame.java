/**
 * This class represents the main frame of the party simulation environment.
 */
package com.simulation.enviroment;

import com.simulation.enums.Places;
import com.simulation.matrix.Matrix;

import javax.swing.*;

import java.awt.event.MouseEvent;

import java.awt.*;
import java.awt.event.MouseAdapter;

public class MyFrame extends JFrame {
	GridPanel panel;
	private static final int maxY = 23;
	private static final int entranceX = 32;
	private static final int maxX = 38;
	private final int squareSize = 30; // Adjust the size of each square as needed
	private final int panelLength = squareSize * (maxX + 2); // + 2 for padding
	private final int panelHeight = squareSize * (maxY + 2); // + 2 for padding
	private Square[][] squares;

	/**
	 * This method creates the squares of the grid and assigns them to their respective places.
	 */
	private void createSquares() {
		squares = new Square[maxX][maxY];

		for (int ySquare = 0; ySquare < maxY; ySquare++) {
			for (int xSquare = 0; xSquare < maxX; xSquare++) {
				int xPixels = squareSize + xSquare * squareSize;
				int yPixels = squareSize + ySquare * squareSize;

				// Assign each square to its respective place
				if (ySquare <= 1 && xSquare >= 14 && xSquare <= 18) {
					// DJ BOOTH
					squares[xSquare][ySquare] = new Square(xPixels, yPixels, squareSize, squareSize, Color.PINK, false, Places.DJ, " ");
				} else if (xSquare >= 30 && xSquare <= 32 && ySquare <= 2) {
					// BOUNCER
					squares[xSquare][ySquare] = new Square(xPixels, yPixels, squareSize, squareSize, Color.PINK, false, Places.BOUNCER, " ");
				} else if (xSquare <= 4 && ySquare >= 8 && ySquare <= 14) {
					// BAR
					squares[xSquare][ySquare] = new Square(xPixels, yPixels, squareSize, squareSize, Color.PINK, false, Places.BAR, " ");
				} else if (xSquare >= 26 && xSquare <= 28 && ySquare >= 9 && ySquare <= 13) {
					// FUSSBALL
					squares[xSquare][ySquare] = new Square(xPixels, yPixels, squareSize, squareSize, Color.PINK, false, Places.FUSSBALL, " ");
				} else if (xSquare >= 14 && xSquare <= 18 && ySquare >= 19 && ySquare <= 21) {
					// POOL
					squares[xSquare][ySquare] = new Square(xPixels, yPixels, squareSize, squareSize, Color.PINK, false, Places.POOL, " ");
				} else if (ySquare >= 20 && xSquare >= 27 && xSquare <= 32) {
					// TOILET
					if (ySquare == 20 && (xSquare == 28 || xSquare == 31)) {
						// ENTRANCE
						squares[xSquare][ySquare] = new Square(xPixels, yPixels, squareSize, squareSize, Color.WHITE, true, Places.PATH, " ");
					} else if (ySquare == 21 && (xSquare == 28 || xSquare == 31)) {
						// USE
						squares[xSquare][ySquare] = new Square(xPixels, yPixels, squareSize, squareSize, Color.GREEN, true, Places.TOILET, " ");
					} else {
						squares[xSquare][ySquare] = new Square(xPixels, yPixels, squareSize, squareSize, Color.PINK, false, Places.TOILET, " ");
					}
				} else if (ySquare == 1) {
					// SEATS TOP
					if (xSquare == 3 || xSquare == 5 || xSquare == 7 || xSquare == 9) {
						squares[xSquare][ySquare] = new Square(xPixels, yPixels, squareSize, squareSize, Color.GREEN, true, Places.LOUNGE_BIG, " ");
					} else if (xSquare == 23 || xSquare == 25) {
						squares[xSquare][ySquare] = new Square(xPixels, yPixels, squareSize, squareSize, Color.GREEN, true, Places.LOUNGE_SMALL, " ");
					} else {
						squares[xSquare][ySquare] = new Square(xPixels, yPixels, squareSize, squareSize, Color.WHITE, true, Places.PATH, " ");
					}
				} else if (ySquare == 3 && xSquare == 16) {
					// SEAT DJ
					squares[xSquare][ySquare] = new Square(xPixels, yPixels, squareSize, squareSize, Color.GREEN, true, Places.DJ, " ");
				} else if (ySquare == 6 && (xSquare == 1 || xSquare == 3)) {
					// SEATS BAR TOP
					squares[xSquare][ySquare] = new Square(xPixels, yPixels, squareSize, squareSize, Color.GREEN, true, Places.BAR, " ");
				} else if (xSquare == 6 && (ySquare == 9 || ySquare == 11 || ySquare == 13)) {
					// SEATS BAR RIGHT
					squares[xSquare][ySquare] = new Square(xPixels, yPixels, squareSize, squareSize, Color.GREEN, true, Places.BAR, " ");
				} else if (ySquare >= 7 && ySquare <= 15 && xSquare >= 12 && xSquare <= 20) {
					// DANCEFLOOR
					squares[xSquare][ySquare] = new Square(xPixels, yPixels, squareSize, squareSize, Color.GREEN, true, Places.DANCEFLOOR, " ");
				} else if (ySquare == 11 && (xSquare == 24 || xSquare == 30)) {
					// FUSSBALL SEATS
					squares[xSquare][ySquare] = new Square(xPixels, yPixels, squareSize, squareSize, Color.GREEN, true, Places.FUSSBALL, " ");
				} else if (ySquare == 20 && (xSquare == 12 || xSquare == 20)) {
					// POOL SEATS
					squares[xSquare][ySquare] = new Square(xPixels, yPixels, squareSize, squareSize, Color.GREEN, true, Places.POOL, " ");
				} else if (xSquare == 1 && (ySquare == 19 || ySquare == 21)) {
					// SMOKING 1
					squares[xSquare][ySquare] = new Square(xPixels, yPixels, squareSize, squareSize, Color.GREEN, true, Places.LOUNGE_SMOKING, " ");
				} else if (ySquare == 21 && (xSquare == 3 || xSquare == 5)) {
					// SMOKING 2
					squares[xSquare][ySquare] = new Square(xPixels, yPixels, squareSize, squareSize, Color.GREEN, true, Places.LOUNGE_SMOKING, " ");
				} else if (xSquare == 34 && (ySquare >= 7 || ySquare <= 22)) {
					// QUEUE
					squares[xSquare][ySquare] = new Square(xPixels, yPixels, squareSize, squareSize, Color.WHITE, true, Places.QUEUE, " ");
				} else {
					squares[xSquare][ySquare] = new Square(xPixels, yPixels, squareSize, squareSize, Color.WHITE, true, Places.PATH, " ");
				}
			}
		}
	}

	public boolean isWall(int fromX, int fromY, int toX, int toY) {
		if ((fromX <= 32 && toX >= 33) || (fromX >= 33 && toX <= 32)) {
			return fromY >= 7 || fromY <= 3 || toY >= 7 || toY <= 3;
		}
		return false;
	}

	public void moveInQueue(int fromX, int fromY, Color color) {
		// the avatars enter the club
		if (fromX <= 34 && fromY == 5) {
			if (squares[fromX - 1][fromY].getIsUsable()) {
				squares[fromX][fromY].setColor(squares[fromX][fromY].getBaseColor()); // Clear the from-square
				squares[fromX][fromY].setIsUsable(true);
				repaint();
				squares[fromX - 1][fromY].setColor(color); // Set the to-square to avatar color
				squares[fromX - 1][fromY].setIsUsable(false);
			}
			repaint();
			// the avatars are in line
		} else {
			if (squares[fromX][fromY - 1].getIsUsable()) {
				squares[fromX][fromY].setColor(squares[fromX][fromY].getBaseColor()); // Clear the from-square
				squares[fromX][fromY].setIsUsable(true);
				repaint();
				squares[fromX][fromY - 1].setColor(color); // Set the to-square to avatar color
				squares[fromX][fromY - 1].setIsUsable(false);
				repaint();
			}
		}
	}

	public void removeAvatarFromMap(int x, int y) {
		squares[x][y].setColor(squares[x][y].getBaseColor()); // Clear the from-square
		squares[x][y].setIsUsable(true);
		repaint();
	}

	public void moveTo(int fromX, int fromY, int toX, int toY, Color color) {
		if (toX < maxX && toY < maxY && toX >= 0 && toY >= 0) {
			squares[fromX][fromY].setColor(squares[fromX][fromY].getBaseColor()); // Clear the from-square
			squares[fromX][fromY].setIsUsable(true);
			repaint();
			squares[toX][toY].setColor(color); // Set the to-square to avatar color
			squares[toX][toY].setIsUsable(false);
			repaint();
		}
	}

	public void setPlaceOccupied(int x, int y) {
		squares[x][y].setIsUsable(false);
	}

	public void setPlaceFree(int x, int y) {
		squares[x][y].setIsUsable(true);
		//big if true
	}

	/**
	 * This method checks if a square is usable.
	 *
	 * @param x The x-coordinate of the square.
	 * @param y The y-coordinate of the square.
	 * @return True if the square is usable, false otherwise.
	 */
	public boolean isUsable(int x, int y) {
		if (y < maxY && x < maxX && y >= 0 && x >= 0) {
			return squares[x][y].getIsUsable();
		} else
			return false;
	}

	/**
	 * This method checks the square's place.
	 *
	 * @param x The x-coordinate of the square.
	 * @param y The y-coordinate of the square.
	 */
	public Places getPlace(int x, int y) {
		return squares[x][y].getPlace();
	}

	public static int getEntranceX() {
		return entranceX;
	}

	public static int getMaxY() {
		return maxY;
	}

	/**
	 * This is the constructor of the MyFrame class.
	 * It creates the grid panel and sets up the frame.
	 */
	public MyFrame() {
		createSquares();
		panel = new GridPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout()); // Set layout manager to BorderLayout
		this.add(panel, BorderLayout.CENTER); // Add panel to the center
		this.pack();
		this.setLocationRelativeTo(null);
		createText();

		panel.addMouseListener(new MouseAdapter() {
	
        @Override
        public void mouseClicked(MouseEvent e) {
            int mouseX = e.getX();
			int mouseY = e.getY();

			// Check if the mouse click is within the bounds of the DJ avatar
			Rectangle djBounds = new Rectangle(squares[14][0].x, squares[14][0].y, 5 * 30, 30); 
			Rectangle djBounds2 = new Rectangle(squares[14][1].x, squares[14][1].y, 5 * 30, 30); 
		

			if (djBounds.contains(mouseX, mouseY) || djBounds2.contains(mouseX,mouseY)) {
				// Perform actions when DJ avatar is clicked
				handleDJClick();
			}
        }
    });
	}

	

	private void handleDJClick() {
       
		System.out.println("DJ Clicked");
      
        Matrix.frame.setVisible(true);
    }

	// Set the letters to be displayed in the individual grids here
	public void createText() {
		squares[0][15].setDisplayLetter("B");
		squares[1][15].setDisplayLetter("A");
		squares[2][15].setDisplayLetter("R");

		squares[14][22].setDisplayLetter("P");
		squares[15][22].setDisplayLetter("O");
		squares[16][22].setDisplayLetter("O");
		squares[17][22].setDisplayLetter("L");

		squares[26][19].setDisplayLetter("T");
		squares[27][19].setDisplayLetter("O");
		squares[28][19].setDisplayLetter("I");
		squares[29][19].setDisplayLetter("L");
		squares[30][19].setDisplayLetter("E");
		squares[31][19].setDisplayLetter("T");
		squares[32][19].setDisplayLetter("S");

		squares[12][16].setDisplayLetter("D");
		squares[13][16].setDisplayLetter("A");
		squares[14][16].setDisplayLetter("N");
		squares[15][16].setDisplayLetter("C");
		squares[16][16].setDisplayLetter("E");
		squares[17][16].setDisplayLetter("F");
		squares[18][16].setDisplayLetter("L");
		squares[19][16].setDisplayLetter("O");
		squares[20][16].setDisplayLetter("O");
		squares[21][16].setDisplayLetter("R");

		squares[26][14].setDisplayLetter("F");
		squares[27][14].setDisplayLetter("O");
		squares[28][14].setDisplayLetter("O");
		squares[29][14].setDisplayLetter("S");
		// following lines are a matter of taste
		// squares[26][15].setDisplayLetter("B");
		// squares[27][15].setDisplayLetter("A");
		// squares[28][15].setDisplayLetter("L");
		// squares[29][15].setDisplayLetter("L");
		// squares[16][1].setDisplayLetter("DJ");

		squares[14][2].setDisplayLetter("D");
		squares[15][2].setDisplayLetter("J");

		squares[28][3].setDisplayLetter("B");
		squares[29][3].setDisplayLetter("O");
		squares[30][3].setDisplayLetter("U");
		squares[31][3].setDisplayLetter("N");
		squares[32][3].setDisplayLetter("C");
		squares[33][3].setDisplayLetter("E");
		squares[34][3].setDisplayLetter("R");

		squares[0][22].setDisplayLetter("S");
		squares[1][22].setDisplayLetter("M");
		squares[2][22].setDisplayLetter("O");
		squares[3][22].setDisplayLetter("K");
		squares[4][22].setDisplayLetter("I");
		squares[5][22].setDisplayLetter("N");
		squares[6][22].setDisplayLetter("G");

		squares[22][0].setDisplayLetter("L");
		squares[23][0].setDisplayLetter("O");
		squares[24][0].setDisplayLetter("U");
		squares[25][0].setDisplayLetter("N");
		squares[26][0].setDisplayLetter("G");
		squares[27][0].setDisplayLetter("E");
		// squares[22][2].setDisplayLetter("S");
		// squares[23][2].setDisplayLetter("M");
		// squares[24][2].setDisplayLetter("A");
		// squares[25][2].setDisplayLetter("L");
		// squares[26][2].setDisplayLetter("L");

		squares[3][0].setDisplayLetter("L");
		squares[4][0].setDisplayLetter("O");
		squares[5][0].setDisplayLetter("U");
		squares[6][0].setDisplayLetter("N");
		squares[7][0].setDisplayLetter("G");
		squares[8][0].setDisplayLetter("E");
		// squares[3][2].setDisplayLetter("B");
		// squares[4][2].setDisplayLetter("I");
		// squares[5][2].setDisplayLetter("G");
	}

	/**
	 * This class represents the grid panel of the frame.
	 */
	class GridPanel extends JPanel {
		GridPanel() {
			this.setPreferredSize(new Dimension(panelLength, panelHeight));
		}

		/**
		 * This method paints the grid and its borders.
		 *
		 * @param g The graphics object.
		 */
		public void paint(Graphics g) {

			Graphics2D g2d = (Graphics2D) g;
			for (int i = 0; i < maxY; i++) {
				for (int j = 0; j < maxX; j++) {
					Square square = squares[j][i];
					g2d.setColor(Color.BLACK);
					g2d.drawRect(square.x, square.y, square.width, square.height);
					// these numbers ensure that the letters are displayed in the middle of the square
					if (square.getColor() != Color.WHITE) {
						g2d.setColor(square.getColor());
						g2d.fillRect(square.x + 1, square.y + 1, square.width, square.height);
					}
					g2d.drawString(square.getDisplayLetter(), square.x + 12, square.y + 19);
				}
			}

			// DRAW BORDERS
			g2d.setColor(Color.BLACK);
			g2d.setStroke(new BasicStroke(3));
			// TOP BORDER
			g2d.drawLine(squareSize, squareSize, panelLength - squareSize, squareSize);
			// RIGHT BORDER
			g2d.drawLine(panelLength - squareSize, squareSize, panelLength - squareSize, panelHeight - squareSize);
			// LEFT BORDER
			g2d.drawLine(squareSize, squareSize, squareSize, panelHeight - squareSize);
			// BOTTOM BORDER
			g2d.drawLine(squareSize, panelHeight - squareSize, panelLength - squareSize, panelHeight - squareSize);

			// ENTRANCE BORDER
			g2d.drawLine(squareSize * 34, squareSize, squareSize * 34, squareSize * 5);
			g2d.drawLine(squareSize * 34, squareSize * 8, squareSize * 34, panelHeight - squareSize);
		}
	}
}