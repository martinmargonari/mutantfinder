package com.margonarim.mutantfinder.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface HumanRepository extends CrudRepository<HumanDAO, Long> {

    @Query("SELECT COUNT(dna) FROM HumanDAO WHERE isMutant = true")
    long countMutant();
}
