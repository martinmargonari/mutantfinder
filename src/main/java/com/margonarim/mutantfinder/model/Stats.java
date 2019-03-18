package com.margonarim.mutantfinder.model;

public class Stats {

    private long countMutantDna;
    private long countHumanDna;
    private float ratio;

    public Stats() {}

    public Stats(long countHumanDna, long countMutantDna) {
        this.countHumanDna = countHumanDna;
        this.countMutantDna = countMutantDna;
        this.ratio = countMutantDna / (float) countHumanDna;
    }

    public long getCountMutantDna() {
        return countMutantDna;
    }

    public void setCountMutantDna(long countMutantDna) {
        this.countMutantDna = countMutantDna;
        this.ratio = countMutantDna / (float) countHumanDna;
    }

    public long getCountHumanDna() {
        return countHumanDna;
    }

    public void setCountHumanDna(long countHumanDna) {
        this.countHumanDna = countHumanDna;
        this.ratio = countMutantDna / (float) countHumanDna;
    }

    public float getRatio() {
        return ratio;
    }

}
