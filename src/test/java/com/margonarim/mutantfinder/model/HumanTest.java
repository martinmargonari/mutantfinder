package com.margonarim.mutantfinder.model;

import com.margonarim.mutantfinder.model.exceptions.IncompatibleDNASequenceException;
import com.margonarim.mutantfinder.model.exceptions.MalformedDNASequenceException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HumanTest {

    private Human human;

    @Before
    public void init() {
        human = new Human(new String[]{"ATGC","GTCA","CCCC","ATGC"});
    }

    @Test
    public void givenCreatedHuman_whenGettingDNA_shouldReturnTheSpecifiedDNA() {
        String[] dna = human.getDna();

        assertTrue(dna[0].contentEquals("ATGC"));
        assertTrue(dna[1].contentEquals("GTCA"));
        assertTrue(dna[2].contentEquals("CCCC"));
        assertTrue(dna[3].contentEquals("ATGC"));
    }

    @Test
    public void givenNonMutantHuman_whenAskingIsMutant_shouldReturnFalse() {
        assertFalse(human.isMutant());
    }

    @Test
    public void givenMutantHuman_whenAskingIsMutant_shouldReturnTrue() {
        Human mutant = new Human(new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"});

        assertTrue(mutant.isMutant());
    }

    @Test(expected = IncompatibleDNASequenceException.class)
    public void givenWrongSequenceDNA_whenCreatingNewHuman_shouldThrowIncompatibleDNASequenceException() {
        new Human(new String[]{"CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"});
    }

    @Test(expected = MalformedDNASequenceException.class)
    public void givenMalformedDNA_whenCreatingNewHuman_shouldThrowMalformedDNASequenceException() {
        new Human(new String[]{"BTGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"});
    }

}
