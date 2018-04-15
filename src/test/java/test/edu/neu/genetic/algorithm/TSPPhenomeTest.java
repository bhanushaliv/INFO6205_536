package test.edu.neu.genetic.algorithm;

import edu.neu.genetic.algorithm.City;
import edu.neu.genetic.algorithm.TSPPhenome;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;

public class TSPPhenomeTest extends TestCase {

    /**
     * Tests the total distance between the cities in the route
     */
    public void testCalculateTotalDistance() {
        TSPPhenome tspPhenome = new TSPPhenome(1);
        tspPhenome.setCities(new ArrayList<>(Arrays.asList(new City("Boston", 42.3601, -71, 1),
                new City("Austin", 30.26, -97, 2),
                new City("Houston", 29.7604, -95.3698, 3),
                new City("San Francisco", 37, -122, 4),
                new City("Denver", 39, -104, 5),
                new City("Los Angeles", 34, -118, 6),
                new City("Chicago", 41.3601, -87, 7),
                new City("New York", 40.3601, -74, 8))));

        assertEquals(12652.0, tspPhenome.calculateTotalDistance());
    }

    /**
     * Tests the fitness score function for the given route
     */
    public void testGetFitness() {

        TSPPhenome tspPhenome = new TSPPhenome(1);
        tspPhenome.setCities(new ArrayList<>(Arrays.asList(new City("Boston", 42.3601, -71, 1),
                new City("Austin", 30.26, -97, 2),
                new City("Houston", 29.7604, -95.3698, 3),
                new City("San Francisco", 37, -122, 4),
                new City("Denver", 39, -104, 5),
                new City("Los Angeles", 34, -118, 6),
                new City("Chicago", 41.3601, -87, 7),
                new City("New York", 40.3601, -74, 8))));

        assertEquals(0.7903888713246918, tspPhenome.getFitness());
    }
}