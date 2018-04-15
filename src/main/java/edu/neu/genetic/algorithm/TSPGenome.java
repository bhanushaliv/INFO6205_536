package edu.neu.genetic.algorithm;

import java.util.List;

public class TSPGenome implements Comparable<TSPGenome> {

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

    /**
     * Generate phenome by transforming the base route for current generation
     *
     * @param baseRoute base route
     */
    public void generatePhenome(List<City> baseRoute) {
        transform(0, this.genString.length, baseRoute);
        this.phenome.setCities(baseRoute);
        this.phenome.getFitness();
    }

    /**
     * Apply swap logic using string genString
     * if 13 32 42 swap number located at the adjacent indices 1 and 3
     *
     * @param startIndex start index for recursion
     * @param endIndex end index
     * @param route route to be transformed
     */
    public void transform(int startIndex, int endIndex, List<City> route) {

        if (startIndex == endIndex) {
            return;
        }
        int index1 = Integer.valueOf(this.genString[startIndex]);
        int index2 = Integer.valueOf(this.genString[startIndex + 1]);

        swap(route, index1, index2);

        transform(startIndex + 2, endIndex, route);
    }

    /**
     *
     * @param route list of cities
     * @param index1
     * @param index2
     * @return list with items swapped according to the indices
     */
    private List<City> swap(List<City> route, int index1, int index2) {

        City tempCity = route.get(index1);
        route.set(index1, route.get(index2));
        route.set(index2, tempCity);
        return route;
    }

    public int compareTo(TSPGenome other) {

        return other.phenome.getFitness() < this.phenome.getFitness() ? 1
                : (other.phenome.getFitness() == this.phenome.getFitness() ? 0 : -1);
    }
}
