package test.edu.neu.genetic.algorithm;

import edu.neu.genetic.algorithm.City;
import edu.neu.genetic.algorithm.Population;
import edu.neu.genetic.algorithm.TSPGenome;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PopulationTest extends TestCase {

    /**
     * This test checks the initialization of the population based on the base route and cutoff
     */
    public void testInitializePopulation() {

        List<City> baseRoute = new ArrayList<>(Arrays.asList(new City("Boston", 42.3601, -71, 1),
                new City("Austin", 30.26, -97, 2),
                new City("Houston", 29.7604, -95.3698, 3),
                new City("San Francisco", 37, -122, 4),
                new City("Denver", 39, -104, 5),
                new City("Los Angeles", 34, -118, 6),
                new City("Chicago", 41.3601, -87, 7),
                new City("New York", 40.3601, -74, 8)));

        Population population = new Population(1, baseRoute);

        population.initializePopulation(1000, 4, 8);
        assertEquals(1000, population.getGenomeList().size());
        assertNotNull(population.getGenomeList().get(0).getGenString());
        assertEquals(8, population.getGenomeList().get(0).getPhenome().getCities().size());
    }

    /**
     * Tests whether for Parent1 Genotype and Parent2 Genotype, first half of the
     * child gene sequence comes from Parent1 and the other half comes from Parent2
     */
    public void testCrossover() {

        List<City> baseRoute = new ArrayList<>(Arrays.asList(new City("Boston", 42.3601, -71, 1),
                new City("Austin", 30.26, -97, 2),
                new City("Houston", 29.7604, -95.3698, 3),
                new City("San Francisco", 37, -122, 4),
                new City("Denver", 39, -104, 5),
                new City("Los Angeles", 34, -118, 6),
                new City("Chicago", 41.3601, -87, 7),
                new City("New York", 40.3601, -74, 8)));

        Population population = new Population(1, baseRoute);

        population.initializePopulation(1000, 4, 8);
        TSPGenome firstParent = population.getGenomeList().get(0);
        TSPGenome secondParent = population.getGenomeList().get(1);

        TSPGenome child = population.crossover(0, 1, 1);

        assertEquals(firstParent.getGenString()[0], child.getGenString()[0]);
        assertEquals(firstParent.getGenString()[1], child.getGenString()[1]);
        assertEquals(firstParent.getGenString()[2], child.getGenString()[2]);
        assertEquals(firstParent.getGenString()[3], child.getGenString()[3]);

        assertEquals(secondParent.getGenString()[4], child.getGenString()[4]);
        assertEquals(secondParent.getGenString()[5], child.getGenString()[5]);
        assertEquals(secondParent.getGenString()[6], child.getGenString()[6]);
        assertEquals(secondParent.getGenString()[7], child.getGenString()[7]);
    }
}