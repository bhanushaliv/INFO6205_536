package edu.neu.genetic.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class GeneticAlgorithm {

    public static void main(String[] args) {

        final int POPULATION_SIZE = 1000;
        int genoTypeLength = 4;
        int phenoTypeLength = 8;
        double cutoff = 0.2;
        final int NUMBER_OF_GENERATION = 20;

        List<City> initialRoute = new ArrayList<>(Arrays.asList(new City("Boston", 42.3601, -71, 1),
                new City("Austin", 30.26, -97, 2),
                new City("Houston", 29.7604, -95.3698, 3),
                new City("San Francisco", 37, -122, 4),
                new City("Denver", 39, -104, 5),
                new City("Los Angeles", 34, -118, 6),
                new City("Chicago", 41.3601, -87, 7),
                new City("New York", 40.3601, -74, 8)));

        List<City> baseRoute = initialRoute;
        Population population = new Population(cutoff, baseRoute);

        population.initializePopulation(POPULATION_SIZE, genoTypeLength, phenoTypeLength);

        population.sortPopulation();
        System.out.println("Generation 0\n" + population.getGenomeList().get(0).getPhenome().toString());
        IntStream.range(1, NUMBER_OF_GENERATION + 1)
                .forEach(generationNo -> {
                    population.regeneration();
                    population.sortPopulation();
                    System.out.println("\nGeneration " + generationNo);
                    System.out.println(population.getGenomeList().get(0).getPhenome().toString());
                });
    }
}
