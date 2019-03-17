package com.margonarim.mutantfinder.model.rules;

import com.margonarim.mutantfinder.model.LetterGrid;

public class LetterGridConsistentRule implements Rule {

    @Override
    public void validate(Object letterGrid) {
        char[][] grid = ((LetterGrid) letterGrid).getGrid();

        int definedLength = grid[0].length;

        for (int i = 1; i < grid.length; i++) {
            if (grid[i].length != definedLength) {
                throw new IllegalArgumentException("Grid rows must be all of the same size.");
            }
        }

    }
}
