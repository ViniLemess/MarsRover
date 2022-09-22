package com.vinilemess.marsrover;

public enum CardinalPoint {
    NORTH("N"),
    WEST("W"),
    EAST("E"),
    SOUTH("S");

    private final String cardinalDirection;

    CardinalPoint(String cardinalDirection) {
        this.cardinalDirection = cardinalDirection;
    }

    public String getCardinalDirection() {
        return cardinalDirection;
    }
}
