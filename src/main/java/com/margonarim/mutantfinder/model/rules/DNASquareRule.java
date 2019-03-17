package com.margonarim.mutantfinder.model.rules;

import com.margonarim.mutantfinder.model.Human;
import com.margonarim.mutantfinder.model.exceptions.IncompatibleDNASequenceException;

public class DNASquareRule implements Rule {

    @Override
    public void validate(Object object) {
        Human human = (Human) object;
        String[] dna = human.getDna();

        int totalSubSequences = dna.length;

        for (String subSequence: dna) {
            if (subSequence.length() != totalSubSequences) {
                throw new IncompatibleDNASequenceException("DNA must be represented as a NxN table");
            }
        }
    }
}
