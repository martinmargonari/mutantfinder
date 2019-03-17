package com.margonarim.mutantfinder.persistence;

import com.margonarim.mutantfinder.model.Human;

import javax.persistence.*;

@Entity
@Table(name = "human")
public class HumanDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String[] dna;

    private boolean isMutant;

    protected HumanDAO() {}

    public HumanDAO(Human human) {
        this.dna = human.getDna();
        this.isMutant = human.isMutant();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    public boolean isMutant() {
        return isMutant;
    }

    public void setMutant(boolean mutant) {
        isMutant = mutant;
    }
}
