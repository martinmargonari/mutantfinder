package com.margonarim.mutantfinder.model.rules;

import com.margonarim.mutantfinder.model.Human;
import com.margonarim.mutantfinder.model.exceptions.MalformedDNASequenceException;

public class DNABaseRule implements Rule {

    @Override
    public void validate(Object object) {
        Human human = (Human) object;

        String[] dna = human.getDna();
        String humanNitrogenBase = new String(Human.NITROGEN_BASES);
        for (String subsequence: dna) {
            if ( ! subsequence.matches("[" + humanNitrogenBase + "]*")) {
                throw new MalformedDNASequenceException("DNA malformed. It can only contain the characters " +
                        "representing the nitrogen bases.");
            }
        }
    }
}
