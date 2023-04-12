package com.m2pfintech;

public class ProbabilityChecker {
    private final double probability;
    public ProbabilityChecker(double probability){
        this.probability = probability;

    }

    @Override
    public boolean equals(Object probabilityObj) {
        if(this == probabilityObj){
            return true;
        }
        if(probabilityObj.getClass() != getClass() || probabilityObj == null){
            return false;
        }
        ProbabilityChecker that = (ProbabilityChecker) probabilityObj;
        return  that.probability == probability;
    }

    public ProbabilityChecker and(ProbabilityChecker event) {
        return new ProbabilityChecker(this.probability*event.probability);
    }

    public ProbabilityChecker ProbabilityOfEventNotOccurring() {
        return new ProbabilityChecker(1 - probability);
    }
}
