package com.margonarim.mutantfinder.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class LetterGridUtilsTest {

    @Test
    public void givenArrayOfWords_whenToGrid_shouldReturnGridWhichEachWordInARow() {
        String[] words = {"abc", "def", "ghi", "ss"};
        char[][] grid = LetterGridUtils.toGrid(words);

        assertTrue(new String(grid[0]).contentEquals("abc"));
        //assertTrue(String.join("",grid[1]).contentEquals("def"));
        //assertTrue(String.join("",grid[2]).contentEquals("ghi"));
    }
}
