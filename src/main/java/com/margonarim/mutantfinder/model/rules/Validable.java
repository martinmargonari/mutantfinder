package com.margonarim.mutantfinder.model.rules;

import java.util.List;

public abstract class Validable {

    protected List<Rule> rules;

    protected void validate() {
        for (Rule rule: rules) {
            rule.validate(this);
        }
    }
}
