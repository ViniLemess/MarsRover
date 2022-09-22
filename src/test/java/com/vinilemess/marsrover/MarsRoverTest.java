package com.vinilemess.marsrover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverTest {

    private MarsRover marsRover;

    @BeforeEach
    void instantiateRover() {
        marsRover = new MarsRover();
    }

    @Test
    void whenNoCommandsGiven_currentPositionMustBe00N() {
        assertEquals("0:0:N", marsRover.printCurrentPosition());
    }

    @Test
    void forEachGivenMCommand_whenDirectionEqualsToN_mustIncrementCoordinateY() {
        marsRover.executeCommand("MMMM");
        assertEquals("0:4:N", marsRover.printCurrentPosition());
    }

    @Test
    void givenCommandL_whenDirectionEqualsToN_thenDirectionMustBeW() {
        marsRover.executeCommand("L");
        assertEquals("0:0:W", marsRover.printCurrentPosition());
    }

    @Test
    void givenCommandR_whenDirectionEqualsToN_thenDirectionMustBeE() {
        marsRover.executeCommand("R");
        assertEquals("0:0:E", marsRover.printCurrentPosition());
    }

    @Test
    void whenCoordinatesYEqualsTo9AndDirectionEqualsToN_givenCommandM_directionMustBeS() {
        marsRover.executeCommand("MMMMMMMMM");
        marsRover.executeCommand("M");
        assertEquals("0:9:S", marsRover.printCurrentPosition());
    }

    @Test
    void forEachGivenMCommand_whenDirectionEqualsToE_mustIncrementX() {
        marsRover.executeCommand("R");
        marsRover.executeCommand("MMMM");
        assertEquals("4:0:E", marsRover.printCurrentPosition());
    }

    @Test
    void givenCommandL_whenDirectionEqualsToE_thenDirectionMustBeN() {
        marsRover.executeCommand("R");
        marsRover.executeCommand("L");
        assertEquals("0:0:N", marsRover.printCurrentPosition());
    }

    @Test
    void givenCommandR_whenDirectionEqualsToE_thenDirectionMustBeS() {
        marsRover.executeCommand("R");
        marsRover.executeCommand("R");
        assertEquals("0:0:S", marsRover.printCurrentPosition());
    }

    @Test
    void whenCoordinatesXEqualsTo9AndDirectionEqualsToE_givenCommandM_directionMustBeW() {
        marsRover.executeCommand("RMMMMMMMMM");
        marsRover.executeCommand("M");
        assertEquals("9:0:W", marsRover.printCurrentPosition());
    }

    @Test
    void whenCoordinatesXEqualsTo0AndDirectionEqualsToW_givenCommandM_directionMustBeE() {
        marsRover.executeCommand("L");
        marsRover.executeCommand("M");
        assertEquals("0:0:E", marsRover.printCurrentPosition());
    }

    @Test
    void forEachGivenMCommand_whenDirectionEqualsToW_mustDecrementX() {
        marsRover.executeCommand("RMMMMLL");
        marsRover.executeCommand("MM");
        assertEquals("2:0:W", marsRover.printCurrentPosition());
    }

    @Test
    void givenCommandL_whenDirectionEqualsToW_thenDirectionMustBeS() {
        marsRover.executeCommand("L");
        marsRover.executeCommand("L");
        assertEquals("0:0:S", marsRover.printCurrentPosition());
    }

    @Test
    void givenCommandR_whenDirectionEqualsToW_thenDirectionMustBeN() {
        marsRover.executeCommand("L");
        marsRover.executeCommand("R");
        assertEquals("0:0:N", marsRover.printCurrentPosition());
    }

    @Test
    void whenCoordinatesYEqualsTo0AndDirectionEqualsToS_givenCommandM_directionMustBeN() {
        marsRover.executeCommand("LL");
        marsRover.executeCommand("M");
        assertEquals("0:0:N", marsRover.printCurrentPosition());
    }

    @Test
    void forEachGivenMCommand_whenDirectionEqualsToS_mustDecrementY() {
        marsRover.executeCommand("MMMMLL");
        marsRover.executeCommand("MM");
        assertEquals("0:2:S", marsRover.printCurrentPosition());
    }

    @Test
    void givenCommandL_whenDirectionEqualsToS_thenDirectionMustBeE() {
        marsRover.executeCommand("LL");
        marsRover.executeCommand("L");
        assertEquals("0:0:E", marsRover.printCurrentPosition());
    }

    @Test
    void givenCommandR_whenDirectionEqualsToS_thenDirectionMustBeW() {
        marsRover.executeCommand("LL");
        marsRover.executeCommand("R");
        assertEquals("0:0:W", marsRover.printCurrentPosition());
    }

    @Test
    void givenAnyUnknownCommand_currentPositionMustBe00N() {
        marsRover.executeCommand("UNKNOWN");
        assertEquals("0:0:N", marsRover.printCurrentPosition());
    }
}