package com.margonarim.mutantfinder.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class HumanPersistenceTest {

    @Autowired
    private HumanRepository humanRepository;

    @Test
    public void givenAnEmptyHumanTable_whenSavingAHuman_thenThereIsOneRecordInTheTable() {
        Human human = new Human(new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"}, true);
        humanRepository.save(human);

        assertTrue(humanRepository.count() == 1);
    }

    @Test
    public void givenAnEmptyHumanTable_whenSavingThreeHumans_thenThereIsThreeRecordsInTheTable() {
        Human human = new Human(new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"}, true);
        Human human2 = new Human(new String[]{"CTGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"}, true);
        Human human3 = new Human(new String[]{"GTGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"}, true);
        humanRepository.save(human);
        humanRepository.save(human2);
        humanRepository.save(human3);

        assertTrue(humanRepository.count() == 3);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void givenAHumanInATable_whenTryingToInsertAHumanWithSameDNA_thenThrowsDataIntegrityViolationException() {
        Human human = new Human(new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"}, true);
        Human human2 = new Human(new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"}, true);

        humanRepository.save(human);
        humanRepository.save(human2);
    }

    @Test
    public void givenAnEmptyHumanTable_whenSavingAMutantHuman_thenThereIsOneMutantInTheTable() {
        Human human = new Human(new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"}, true);
        humanRepository.save(human);

        assertTrue(humanRepository.countMutant() == 1);
    }

    @Test
    public void givenAnEmptyHumanTable_whenSavingAMutantAndANonMutant_thenThereIsTwoRecordsAndOneMutantInTheTable() {
        Human human = new Human(new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"}, true);
        Human mutant = new Human(new String[]{"ATGC", "CAGT", "TTAT", "AGAA"}, false);
        humanRepository.save(human);
        humanRepository.save(mutant);

        assertTrue(humanRepository.count() == 2);
        assertTrue(humanRepository.countMutant() == 1);
    }
}
