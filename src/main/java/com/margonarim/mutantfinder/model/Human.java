package com.margonarim.mutantfinder.model;

import com.margonarim.mutantfinder.model.rules.DNABaseRule;
import com.margonarim.mutantfinder.model.rules.DNASquareRule;
import com.margonarim.mutantfinder.model.rules.Validable;
import com.margonarim.mutantfinder.utils.LetterGridUtils;

import java.util.ArrayList;

/**
 * The {@code LetterGrid} class represents a human being
 */
public class Human extends Validable {

    /** Array containing the four types of nitrogen bases, which define the DNA
     *  A: Adenine
     *  T: Thymine
     *  C: Cytosine
     *  G: Guanine
     */
    public static final char[] NITROGEN_BASES = {'A', 'T', 'C', 'G'};

    /**
     *  An array containing each one of the mutant sequences that can be present in the DNA
     */
    private static final String[] MUTANT_SEQUENCES = {"AAAA", "TTTT", "CCCC", "GGGG"};

    /** dna which defines each human
     *  ach element of the array corresponds to a subsequence of the DNA,
     *  so it must be a combination of the defined types of nitrogen bases
     *  For example: {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"}
     */
    private String[] dna;

    /**
     *  Initializes a newly created {@code Human} object so that it represents
     *  a unique human being, with a specified dna
     *
     *  @param dna a valid dna, formed as it is defined
     */
    public Human(String[] dna) {
        this.dna = dna;

        rules = new ArrayList<>();
        rules.add(new DNASquareRule());
        rules.add(new DNABaseRule());
        validate();
    }

    public String[] getDna() {
        return dna;
    }

    /**
     * Returns true if and only if the specified dna represents a
     * mutant human being as it is defined
     *
     * @param dna a valid dna, formed as it is defined
     * @return true if the {@code dna} represents a mutant
     */
    public static boolean isMutant(String[] dna) {

        LetterGrid dnaAsGrid = new LetterGrid(LetterGridUtils.toGrid(dna));
        LetterGrid.Direction[] directionsToLook =
                {LetterGrid.Direction.RIGHT, LetterGrid.Direction.RIGHT_DOWN,
                        LetterGrid.Direction.DOWN, LetterGrid.Direction.LEFT_DOWN};

        int sequencesFound = 0;
        for (String mutantSequence: MUTANT_SEQUENCES) {
            if (dnaAsGrid.isPresent(mutantSequence, directionsToLook)) {
                sequencesFound++;
            }

            if (sequencesFound == 2) {
                break;
            }
        }

        return (sequencesFound == 2);
    }

    /**
     *  Returns true if and only if this human represents a
     *  mutant as it is defined
     *
     *  @return true if this human represents a mutant
     */
    public boolean isMutant() {
        return Human.isMutant(dna);
    }
}
