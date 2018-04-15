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
        final int MAX_NUMBER_OF_GENERATION = 100;

        List<City> initialRoute = new ArrayList<>(Arrays.asList(new City("Boston", 42.3601, -71, 1),
                new City("Austin", 30.26, -97, 2),
                new City("Houston", 29.7604, -95.3698, 3),
                new City("San Francisco", 37, -122, 4),
                new City("Denver", 39, -104, 5),
                new City("Los Angeles", 34, -118, 6),
                new City("Chicago", 41.3601, -87, 7),
                new City("New York", 40.3601, -74, 8)));

        Population population = new Population(cutoff, initialRoute);

        population.initializePopulation(POPULATION_SIZE, genoTypeLength, phenoTypeLength);

        int bestDistanceConstantForGenerationsCtr = 1;
        double bestDistanceSoFar;
        TSPPhenome bestPhenome = population.getGenomeList().get(0).getPhenome();

        population.sortPopulation();
        bestDistanceSoFar = population.getGenomeList().get(0).getPhenome().getTotalDistance();
        System.out.println("Generation 0\n" + population.getGenomeList().get(0).getPhenome().toString());

        /**
         * run the loop for max 100 generations
         * Assumption: if the bestMinDistance is same for 20 generations
         * we have found our solution
         */
        for (int i = 1; i <= MAX_NUMBER_OF_GENERATION; i++) {

            if (bestDistanceConstantForGenerationsCtr > 20) {
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
