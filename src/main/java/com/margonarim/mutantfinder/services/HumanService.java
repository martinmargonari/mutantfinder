package com.margonarim.mutantfinder.services;

import com.margonarim.mutantfinder.model.Human;
import com.margonarim.mutantfinder.model.Stats;

public interface HumanService {

    void save(Human human);

    long count();

    long mutantCount();

    Stats getStats();
}
