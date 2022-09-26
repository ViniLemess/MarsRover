package com.vinilemess.marsrover;

public class MarsRover {

    private CardinalPoint direction;
    private int coordinateX;
    private int coordinateY;

    public MarsRover() {
        direction = CardinalPoint.NORTH;
        coordinateX = 0;
        coordinateY = 0;
    }

    public String executeCommand(String command) {
        for (char character : command.toCharArray()) {
            switch (String.valueOf(character)) {
                case "M" -> moveRover();
                case "R" -> turnRight();
                case "L" -> turnLeft();
                default -> throw new IllegalArgumentException(String.format("Invalid command: %s", character));
            }
        }
        return getCurrentPosition();
    }

    private void moveRover() {
         switch (this.direction) {
            case SOUTH -> moveSouth();
            case NORTH -> moveNorth();
            case EAST -> moveEast();
            case WEST -> moveWest();
        }
    }

    private void moveNorth() {
        if (coordinateY + 1 > 9) {
            invertDirection();
            return;
        }
        coordinateY++;
    }

    private void moveSouth() {
        if (coordinateY - 1 < 0) {
            invertDirection();
            return;
        }
        coordinateY--;
    }

    private void moveEast() {
        if (coordinateX + 1 > 9) {
            invertDirection();
            return;
        }
        coordinateX++;
    }

    private void moveWest() {
        if (coordinateX - 1 < 0) {
            invertDirection();
            return;
        }
        coordinateX--;
    }

    private void turnLeft() {
        switch (this.direction) {
            case NORTH -> this.direction = CardinalPoint.WEST;
            case WEST -> this.direction = CardinalPoint.SOUTH;
            case SOUTH -> this.direction = CardinalPoint.EAST;
            case EAST -> this.direction = CardinalPoint.NORTH;
        }
    }

    private void turnRight() {
        switch (this.direction) {
            case NORTH -> this.direction = CardinalPoint.EAST;
            case EAST -> this.direction = CardinalPoint.SOUTH;
            case SOUTH -> this.direction = CardinalPoint.WEST;
            case WEST -> this.direction = CardinalPoint.NORTH;
        }
    }

    private void invertDirection() {
        switch (this.direction) {
            case NORTH -> this.direction = CardinalPoint.SOUTH;
            case EAST -> this.direction = CardinalPoint.WEST;
            case SOUTH -> this.direction = CardinalPoint.NORTH;
            case WEST -> this.direction = CardinalPoint.EAST;
        }
    }

    public String getCurrentPosition() {
        return "%d:%d:%s".formatted(coordinateX, coordinateY, direction.getCardinalDirection());
    }
}


