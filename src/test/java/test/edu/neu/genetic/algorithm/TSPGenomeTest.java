package test.edu.neu.genetic.algorithm;

import edu.neu.genetic.algorithm.City;
import edu.neu.genetic.algorithm.TSPGenome;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TSPGenomeTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void testGeneratePhenome() {
        List<City> baseRoute = new ArrayList<>(Arrays.asList(new City("Boston", 42.3601, -71, 1),
                new City("Austin", 30.26, -97, 2),
                new City("Houston", 29.7604, -95.3698, 3),
                new City("San Francisco", 37, -122, 4),
                new City("Denver", 39, -104, 5),
                new City("Los Angeles", 34, -118, 6),
                new City("Chicago", 41.3601, -87, 7),
                new City("New York", 40.3601, -74, 8)));

        TSPGenome genome = new TSPGenome(8, 1);
        genome.setGenString(new String[]{"1", "3", "4", "7", "4", "2", "6", "5"});
        genome.generatePhenome(new ArrayList<>(baseRoute));
        // fitness score has been updated
        assertNotNull(genome.getPhenome().getFitness());
        //total distance has been updated
        assertNotSame(0, genome.getPhenome().getTotalDistance());
        //test the cities are getting randomized
        assertNotSame(baseRoute, genome.getPhenome().getCities());
    }
}