package com.margonarim.mutantfinder.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface HumanRepository extends CrudRepository<Human, Long> {

    @Query("SELECT COUNT(dna) FROM Human WHERE isMutant = true")
    long countMutant();
}
