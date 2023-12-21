package com.simulation.partypeople;

import com.simulation.avatar.Avatar;
import com.simulation.enums.Direction;
import com.simulation.enums.Places;
import com.simulation.enums.Shape;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Alisa extends Avatar {
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
    Map<Integer, Movement> movementMap = new HashMap();
    Integer movementIndex = 0;
    Direction dir = Direction.FORWARD;
    Integer dancingCounter = 0;

    // ************** Constructor **************
    public Alisa(Shape shape, Color color, int borderWidth, int avatarAge, String avatarName, int waitingTime) {
        super(shape, color, borderWidth, avatarAge, avatarName, waitingTime);
        // TODO
    }

    private static class Movement {
        private Direction direction;
        private Places place;

        public Movement(Direction direction, Places place) {
            this.direction = direction;
            this.place = place;
        }

        public Direction getDirection() {
            return direction;
        }

        public void setDirection(Direction direction) {
            this.direction = direction;
        }

        public Places getPlace() {
            return place;
        }

        public void setPlace(Places place) {
            this.place = place;
        }
    }

    // ************** Methods **************
    public Direction dancingAlgo() {
        Direction direction = dir;

        if (dancingCounter < 3) {
            direction = Direction.FORWARD;
        } else {
            if (getWhatISee()[0] != Places.DANCEFLOOR) {
                direction = pickOppositeDirection(direction);
            } else {
                direction = Direction.LEFT;
            }
        }

//        System.out.println(this.getName() + " is dancing");

        return direction;
    }

    public void fight(Avatar opponent) { // Call this function if other avatar starts a fight
        // TODO
        // develop different fighting moves
        // be very descriptive (user 2 is performing an F5 on user 3)
    }

    public void talk(Avatar person) {
        // TODO
        // create a list of answers and questions that you would like to exchange with
        // the other users of Club Penguin
        // create a primitive algorithm that would make picks from your answer list
        // based on the questions asked
    }

    public void smoke() {
        // TODO
        // if you are in the smoking area you get prompted the option to smoke
    }

    public void toilet(int timeInToilet) { // Do only toilet things in the toilet
        // TODO
        // set your time in the toilet

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

    public Direction moveAvatar() {
        if(dir == Direction.LEFT || dir == Direction.RIGHT) {
            dir = Direction.FORWARD;
        }
        if (getWhatISee()[1] == Places.OUTSIDE || getWhatISee()[1] == Places.WALL) {
            dir = pickOppositeDirection(dir);
            movementMap.put(movementIndex, new Movement(dir, getWhatISee()[0]));
        } else {
            if (movementMap.isEmpty()) {
                movementMap.put(movementIndex, new Movement(dir, getWhatISee()[0]));
            } else if (movementIndex % 5 == 0 && movementMap.get(movementIndex-1).getPlace() != Places.DANCEFLOOR) {
                dir = pickNewRandomDirection(dir);
                movementMap.put(movementIndex, new Movement(dir, getWhatISee()[0]));
            } else if (getWhatISee()[1] == Places.DANCEFLOOR && dancingCounter < 3) {
                dir = Direction.FORWARD;
                movementMap.put(movementIndex, new Movement(dir, getWhatISee()[0]));
                dancingCounter++;
//                System.out.println("Dancing " + dancingCounter);
            } else if (dancingCounter < 20 && dancingCounter >= 3) {
                dir = dancingAlgo();
                movementMap.put(movementIndex, new Movement(dir, getWhatISee()[0]));
                dancingCounter++;
//                System.out.println("Dancing " + dancingCounter);
            } else if (dancingCounter >= 20) {
                dir = Direction.FORWARD;
                if (getWhatISee()[0] != Places.DANCEFLOOR) {
                    dancingCounter = 0;
                }
                movementMap.put(movementIndex, new Movement(dir, getWhatISee()[0]));
            } else {
                movementMap.put(movementIndex, new Movement(dir, getWhatISee()[0]));
            }
        }

//        System.out.println(movementMap.get(movementIndex).getDirection() + " " + movementMap.get(movementIndex).getPlace());
        movementIndex++;
        return dir;
    }

    private Direction pickOppositeDirection(Direction direction) {
        switch (direction) {
            case BACK -> direction = Direction.FORWARD;
            case FORWARD -> direction = Direction.BACK;
            case LEFT -> direction = Direction.RIGHT;
            case RIGHT -> direction = Direction.LEFT;
        }
        return direction;
    }

    private Direction pickNewRandomDirection(Direction oldDirection) {
        Random rand = new Random();
        int number = rand.nextInt(4);
        // direction is set externally --> check with the simulation environment
        Direction dir = null;
        switch (number) {
            case 0:
                dir = Direction.FORWARD;
                break;
            case 1:
                dir = Direction.RIGHT;
                break;
            case 2:
                dir = Direction.BACK;
                break;
            case 3:
                dir = Direction.LEFT;
                break;
            default:
                break;
        }
        if (oldDirection == dir) {
            pickNewRandomDirection(oldDirection);
        }
        return dir;
    }
}
