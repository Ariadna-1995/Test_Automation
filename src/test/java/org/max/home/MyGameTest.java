package org.max.home;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;


public class MyGameTest {
    Player gamer;
    Game game;
    List<Door> doors;

    @BeforeEach
    void SetUp () {
        doors = new ArrayList<>();
    }

    @Test
    void testGameRoundChangeChoiceAndLose () {
        gamer = new Player("Игрок", true);
        doors.add(new Door(true));
        doors.add(new Door(false));
        doors.add(new Door(false));
        game = new Game(gamer, doors);

        boolean check = game.round(0).isPrize();

        Assertions.assertFalse(check);

    }

    @Test
    void testGameRoundChangeChoiceAndWin () {
        gamer = new Player("Игрок", true);
        doors.add(new Door(false));
        doors.add(new Door(true));
        doors.add(new Door(false));
        game = new Game(gamer, doors);
        boolean check = game.round(0).isPrize();

        Assertions.assertTrue(check);

    }

    @Test
    void testGameRoundNotChangeChoiceAndLose () {
        gamer = new Player("Игрок", false);
        doors.add(new Door(true));
        doors.add(new Door(false));
        doors.add(new Door(false));
        game = new Game(gamer, doors);

        boolean check = game.round(0).isPrize();

        Assertions.assertTrue(check);

    }

    @Test
    void testGameRoundNotChangeChoiceAndWin () {
        gamer = new Player("Игрок", false);
        doors.add(new Door(false));
        doors.add(new Door(true));
        doors.add(new Door(false));
        game = new Game(gamer, doors);
        boolean check = game.round(0).isPrize();

        Assertions.assertFalse(check);

    }





}