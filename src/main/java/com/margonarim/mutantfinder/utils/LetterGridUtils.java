package com.margonarim.mutantfinder.utils;

/**
 * The {@code LetterGridUtils} class represents utility methods
 * for operating with grids of letters, which will be represented
 * as char[][]
 */
public final class LetterGridUtils {

    // Private constructor to prevent instatiation
    private LetterGridUtils() { }

    /**
     * Constructs a new {@code char[][]} by splitting the specified
     * array of rows by letter.
     * For instance, {@code toGrid({"abc","def","ghi"})}
     * returns {@code {{"a","b","c}, {"d","e","f"}, {"g","h","i"}}}
     * @param rows an array of strings
     * @return an array of arrays, in which each subarray is the result
     * of splitting each word of {@code rows} by letter
     */
    public static char[][] toGrid(String[] rows) {
        int len = rows.length;
        char[][] grid = new char[len][];

        for (int i = 0; i < len; i++) {
            grid[i] = rows[i].toCharArray();
        }

        return grid;
    }
}
