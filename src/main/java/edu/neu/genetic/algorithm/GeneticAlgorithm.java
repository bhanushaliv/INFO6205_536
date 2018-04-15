package edu.neu.genetic.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        int totalGenerations = 1;
        int bestDistanceConstantForGenerationsCtr = 1;
        double bestDistanceSoFar;
        TSPPhenome bestPhenome = null;

        population.sortPopulation();
        bestDistanceSoFar = population.getGenomeList().get(0).getPhenome().getTotalDistance();
        System.out.println("Generation 0\n" + population.getGenomeList().get(0).getPhenome().toString());

        /**
         * run the loop for max 100 generations
         * Assumption: if the bestMinDistance is same for 10 generations
         * we have found our solution
         */
        for (int i = 0; i < 100; i++) {

            if (bestDistanceConstantForGenerationsCtr > 10) {
                break;
            }

            population.regeneration();
            population.sortPopulation();

            bestDistanceConstantForGenerationsCtr++;
            double currentBestDistance = population.getGenomeList().get(0).getPhenome().getTotalDistance();

            if (currentBestDistance < bestDistanceSoFar) {
                bestDistanceSoFar = currentBestDistance;
                bestDistanceConstantForGenerationsCtr = 0;
                bestPhenome = population.getGenomeList().get(0).getPhenome();
            }
            System.out.println("\nGeneration " + i);
            System.out.println(population.getGenomeList().get(0).getPhenome().toString());
        }

        System.out.println("\n*******Best way to visit all the cities*******\n" + bestPhenome);

    }
}
