package edu.neu.genetic.algorithm;

import java.util.List;

public class GeneticAlgorithm {
    public static final int POPULATION_SIZE = 8;
    private List<City> initialRoute = null;

    public GeneticAlgorithm(List<City> initialRoute) {
        this.initialRoute = initialRoute;
    }

    public List<City> getInitialRoute() {
        return this.initialRoute;
    }
}
