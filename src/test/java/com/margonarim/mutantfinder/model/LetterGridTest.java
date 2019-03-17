package com.margonarim.mutantfinder.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LetterGridTest {

    private LetterGrid letterGrid;

    @Before
    public void init() {
            letterGrid = new LetterGrid(new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}});

        /*                | a | b | c |
         *   FORMED GRID: | d | e | f |
         *                | g | h | i |
         */
    }

    @Test
    public void givenGridOfWords_whenCallingGetGrid_shouldReturnTheCreatedGrid() {
        char[][] createdGrid = letterGrid.getGrid();

        assertTrue(new String(createdGrid[0]).contentEquals("abc"));
        assertTrue(new String(createdGrid[1]).contentEquals("def"));
        assertTrue(new String(createdGrid[2]).contentEquals("ghi"));
    }

    @Test
    public void givenGridOfWords_whenCallingIsPresentForExistingWordInRightDirection_shouldReturnTrue() {
        LetterGrid.Direction[] posibleDirections = {LetterGrid.Direction.RIGHT};

        assertTrue(letterGrid.isPresent("abc", posibleDirections));
        assertTrue(letterGrid.isPresent("de", posibleDirections));
        assertTrue(letterGrid.isPresent("hi", posibleDirections));
    }

    @Test
    public void givenGridOfWords_whenCallingIsPresentForExistingWordInLeftDirection_shouldReturnTrue() {
        LetterGrid.Direction[] posibleDirections = {LetterGrid.Direction.LEFT};

        assertTrue(letterGrid.isPresent("cba", posibleDirections));
        assertTrue(letterGrid.isPresent("ed", posibleDirections));
        assertTrue(letterGrid.isPresent("ih", posibleDirections));
    }

    @Test
    public void givenGridOfWords_whenCallingIsPresentForExistingWordInDownDirection_shouldReturnTrue() {
        LetterGrid.Direction[] posibleDirections = {LetterGrid.Direction.DOWN};

        assertTrue(letterGrid.isPresent("adg", posibleDirections));
        assertTrue(letterGrid.isPresent("eh", posibleDirections));
        assertTrue(letterGrid.isPresent("cf", posibleDirections));
    }

    @Test
    public void givenGridOfWords_whenCallingIsPresentForExistingWordInUpDirection_shouldReturnTrue() {
        LetterGrid.Direction[] posibleDirections = {LetterGrid.Direction.UP};

        assertTrue(letterGrid.isPresent("da", posibleDirections));
        assertTrue(letterGrid.isPresent("heb", posibleDirections));
        assertTrue(letterGrid.isPresent("if", posibleDirections));
    }

    @Test
    public void givenGridOfWords_whenCallingIsPresentForExistingWordInRightDownDirection_shouldReturnTrue() {
        LetterGrid.Direction[] posibleDirections = {LetterGrid.Direction.RIGHT_DOWN};

        assertTrue(letterGrid.isPresent("aei", posibleDirections));
        assertTrue(letterGrid.isPresent("dh", posibleDirections));
        assertTrue(letterGrid.isPresent("bf", posibleDirections));
    }

    @Test
    public void givenGridOfWords_whenCallingIsPresentForExistingWordInLeftDownDirection_shouldReturnTrue() {
        LetterGrid.Direction[] posibleDirections = {LetterGrid.Direction.LEFT_DOWN};

        assertTrue(letterGrid.isPresent("bd", posibleDirections));
        assertTrue(letterGrid.isPresent("ceg", posibleDirections));
        assertTrue(letterGrid.isPresent("fh", posibleDirections));
    }

    @Test
    public void givenGridOfWords_whenCallingIsPresentForExistingWordInRightUpDirection_shouldReturnTrue() {
        LetterGrid.Direction[] posibleDirections = {LetterGrid.Direction.RIGHT_UP};

        assertTrue(letterGrid.isPresent("db", posibleDirections));
        assertTrue(letterGrid.isPresent("gec", posibleDirections));
        assertTrue(letterGrid.isPresent("hf", posibleDirections));
    }

    @Test
    public void givenGridOfWords_whenCallingIsPresentForExistingWordInLeftUpDirection_shouldReturnTrue() {
        LetterGrid.Direction[] posibleDirections = {LetterGrid.Direction.LEFT_UP};

        assertTrue(letterGrid.isPresent("iea", posibleDirections));
        assertTrue(letterGrid.isPresent("hd", posibleDirections));
        assertTrue(letterGrid.isPresent("fb", posibleDirections));
    }

    @Test
    public void givenGridOfWords_whenCallingIsPresentForExistingWordInAnyDirection_shouldReturnTrue() {

        assertTrue(letterGrid.isPresent("de"));
        assertTrue(letterGrid.isPresent("fc"));
        assertTrue(letterGrid.isPresent("iea"));
    }

    @Test
    public void givenGridOfWords_whenCallingIsPresentForNonExistingWordInAnyDirection_shouldReturnFalse() {

        assertFalse(letterGrid.isPresent("xyz"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenGridOfWords_whenCreatingGridWithWrongSize_shouldThrowIllegalArgumentException() {

        new LetterGrid(new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h'}});
    }

}
