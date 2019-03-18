package com.margonarim.mutantfinder.services;

import com.margonarim.mutantfinder.model.Human;
import com.margonarim.mutantfinder.model.Stats;
import com.margonarim.mutantfinder.persistence.HumanDAO;
import com.margonarim.mutantfinder.persistence.HumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class HumanServiceImpl implements HumanService {

    @Autowired
    private HumanRepository humanRepository;

    public HumanServiceImpl() {}

    @Override
    public void save(Human human) {
        humanRepository.save(new HumanDAO(human));
    }

    @Override
    public long count() {
        return humanRepository.count();
    }

    @Override
    public long mutantCount() {
        return humanRepository.countMutant();
    }

    @Override
    public Stats getStats() {
        long humanDna = count();
        long mutantDNA = mutantCount();

        return new Stats(humanDna, mutantDNA);
    }

}
