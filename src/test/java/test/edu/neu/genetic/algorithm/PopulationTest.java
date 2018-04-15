package test.edu.neu.genetic.algorithm;

import edu.neu.genetic.algorithm.City;
import edu.neu.genetic.algorithm.Population;
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
     *
     */
    public void testCrossover() {
    }
}