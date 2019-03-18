package com.margonarim.mutantfinder.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class StatsTest {

    private Stats stats;

    @Before
    public void init() {
        stats = new Stats(10, 2);
    }

    @Test
    public void givenCreatedStats_whenGettingCountHumanAndMutant_shouldReturnSpecifiedParameters() {

        assertTrue(stats.getCountHumanDna() == 10);
        assertTrue(stats.getCountMutantDna() == 2);
    }

    @Test
    public void givenCreatedStats_whenGettingRatio_shouldReturnTheValueOfMutantsOverHumans() {

        assertTrue(stats.getRatio() == (float) 0.2);
    }


}
