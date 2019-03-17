package com.margonarim.mutantfinder.persistence;

import com.margonarim.mutantfinder.model.Human;
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
        Human human = new Human(new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"});
        HumanDAO humanDAO = new HumanDAO(human);
        humanRepository.save(humanDAO);

        assertTrue(humanRepository.count() == 1);
    }

    @Test
    public void givenAnEmptyHumanTable_whenSavingThreeHumans_thenThereIsThreeRecordsInTheTable() {
        Human human = new Human(new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"});
        Human human2 = new Human(new String[]{"CTGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"});
        Human human3 = new Human(new String[]{"GTGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"});
        
        HumanDAO humanDAO = new HumanDAO(human);
        HumanDAO humanDAO2 = new HumanDAO(human2);
        HumanDAO humanDAO3 = new HumanDAO(human3);
        
        humanRepository.save(humanDAO);
        humanRepository.save(humanDAO2);
        humanRepository.save(humanDAO3);

        assertTrue(humanRepository.count() == 3);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void givenAHumanInATable_whenTryingToInsertAHumanWithSameDNA_thenThrowsDataIntegrityViolationException() {
        Human human = new Human(new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"});
        Human human2 = new Human(new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"});

        HumanDAO humanDAO = new HumanDAO(human);
        HumanDAO humanDAO2 = new HumanDAO(human2);
        
        humanRepository.save(humanDAO);
        humanRepository.save(humanDAO2);
    }

    @Test
    public void givenAnEmptyHumanTable_whenSavingAMutantHuman_thenThereIsOneMutantInTheTable() {
        Human human = new Human(new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"});
        HumanDAO humanDAO = new HumanDAO(human);
        humanRepository.save(humanDAO);

        assertTrue(humanRepository.countMutant() == 1);
    }

    @Test
    public void givenAnEmptyHumanTable_whenSavingAMutantAndANonMutant_thenThereIsTwoRecordsAndOneMutantInTheTable() {
        Human human = new Human(new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"});
        Human mutant = new Human(new String[]{"ATGC", "CAGT", "TTAT", "AGAA"});

        HumanDAO humanDAO = new HumanDAO(human);
        HumanDAO mutantDAO = new HumanDAO(mutant);

        humanRepository.save(humanDAO);
        humanRepository.save(mutantDAO);

        assertTrue(humanRepository.count() == 2);
        assertTrue(humanRepository.countMutant() == 1);
    }
}
