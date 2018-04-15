package test.edu.neu.genetic.algorithm;

import edu.neu.genetic.algorithm.City;
import junit.framework.TestCase;

public class CityTest extends TestCase {

    /**
     * Tests the calculation of distance from a city to current city using Haversine
     */
    public void testDistanceTo() {
        City boston = new City("Boston", 42.3601, -71, 1);
        City austin = new City("Austin", 30.26, -97, 2);

        assertEquals(2674.2603695871003, boston.distanceTo(austin));
        assertEquals(2674.2603695871003, austin.distanceTo(boston));
    }

    /**
     * Tests the conversion of co-ordinates of the city to radians
     */
    public void testConvertCoordiatesToRadians() {

        City city = new City("Boston", 180, -98, 1);
        assertEquals("Boston", city.getName());
        assertEquals(3.141592653589793, city.getLatitude());
        assertEquals(-1.7104226669544427, city.getLongitude());
    }
}