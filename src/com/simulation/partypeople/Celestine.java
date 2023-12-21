package com.simulation.partypeople;

import com.simulation.avatar.Avatar;
import com.simulation.enums.Direction;
import com.simulation.enums.Shape;

import java.awt.*;
import java.util.Random;

public class Celestine extends Avatar{


    public Celestine() {
        super(Shape.CIRCLE, new Color(153, 255, 255), 1, 20, "Celestine", 0);
    }

    @Override
    public Direction moveAvatar() {
        Random rand = new Random();
        int number = rand.nextInt(4);
        Direction dir = Direction.FORWARD;
        if (number == 0) {
            dir = Direction.FORWARD;
        } else if (number == 1) {
            dir = Direction.RIGHT;
        } else if (number == 2) {
            dir = Direction.BACK;
        } else if (number == 3) {
            dir = Direction.LEFT;
        }
        return dir;
    }
}
