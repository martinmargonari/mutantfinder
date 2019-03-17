package com.margonarim.mutantfinder.model;

import com.margonarim.mutantfinder.model.rules.LetterGridConsistentRule;
import com.margonarim.mutantfinder.model.rules.Validable;

import java.util.ArrayList;

/**
 * The {@code LetterGrid} class represents grids of character strings
 * which may contain words in it, in specific directions that can be
 * specified
 */
public class LetterGrid extends Validable {

    /** Grid of letters */
    private char[][] grid;

    /** Width of grid */
    private int width;

    /** Height of grid */
    private int height;

    /**
     * Direction type constants in which words can be present in the grid
     */
    public enum Direction {
        RIGHT      (0,  1),
        LEFT       (0, -1),
        DOWN       (1,  0),
        UP         (-1, 0),
        RIGHT_DOWN (1,  1),
        LEFT_DOWN  (1, -1),
        RIGHT_UP   (-1, 1),
        LEFT_UP    (-1,-1);

        /** X axis of direction */
        private final int x;

        /** Y axis of direction */
        private final int y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * Initializes a newly created {@code LetterGrid} object so that it represents
     * a grid of letters with the content sepecified in the argument
     *
     * @param grid
     *        A {@code char[][]}
     */
    public LetterGrid(char[][] grid) {
        this.grid = grid;
        this.height = grid.length;
        this.width = grid[0].length;

        rules = new ArrayList<>();
        rules.add(new LetterGridConsistentRule());
        validate();
    }

    /**
     * @return the content of the created grid
     */
    public char[][] getGrid() {
        return grid;
    }

    /**
     * Returns true if and only if this grid contains the specified word
     * in the specified direction to look for
     *
     * @param word the word to find
     * @param directions the list of directions in which to find the word
     * @return true if the grid contains {@code word} in the specified
     *         {@code directions}
     */
    public boolean isPresent(String word, Direction[] directions) {

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == word.charAt(0)) {
                    for (Direction direction: directions) {
                        if (isPresentInDirection(word, i, j, direction) )
                            return true;
                    }
                }
            }
        }

        return false;

    }

    /**
     * Returns true if and only if this grid contains the specified word
     * in any direction
     *
     * @param word the word to find
     * @return true if the grid contains {@code word} in any direction
     */
    public boolean isPresent(String word) {
        Direction[] directions = {Direction.RIGHT, Direction.LEFT, Direction.UP, Direction.DOWN,
                Direction.RIGHT_DOWN, Direction.LEFT_DOWN, Direction.RIGHT_UP, Direction.LEFT_UP};

        return isPresent(word, directions);
    }

    /**
     * Returns true if and only if this grid contains the specified word,
     * starting in the specified (x,y) point of th grid, in the specified direction
     * @param word the word to find
     * @param initialX the x axis of the grid in which the word should start
     * @param initialY the y axis of the grid in which the word should start
     * @param direction the direction in which to look for
     * @return if the word is found
     */
    private boolean isPresentInDirection(String word, int initialX, int initialY, Direction direction) {
        int x = initialX;
        int y = initialY;
        int position = 0;

        while ( 0 <= y && y < width &&
                0 <= x && x < height &&
                position < word.length() &&
                word.charAt(position) == grid[x][y]) {

            x += direction.x;
            y += direction.y;
            position++;

        }

        return (position == word.length());
    }


}
