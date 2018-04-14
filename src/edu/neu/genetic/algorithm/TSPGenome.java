package edu.neu.genetic.algorithm;

import java.util.List;

public class TSPGenome {

    private String[] genString;
    private TSPPhenome phenome;

    public TSPGenome(int id) {
        this.phenome = new TSPPhenome(id);
    }

    public TSPGenome(int genLength, int id) {
        this.phenome = new TSPPhenome(id);
        this.genString = new String[genLength];
    }

    public String[] getGenString() {
        return genString;
    }

    public void setGenString(String[] genString) {
        this.genString = genString;
    }

    public TSPPhenome getPhenome() {
        return phenome;
    }

    public void setPhenome(TSPPhenome phenome) {
        this.phenome = phenome;
    }

    public void generatePhenome(List<City> baseGene) {

    }

    public void transform() {

    }
}
