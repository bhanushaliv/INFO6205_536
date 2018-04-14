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

    public void generatePhenome(List<City> baseRoute) {
        transform(0, this.genString.length, baseRoute);
        this.phenome.setCities(baseRoute);
        this.phenome.getFitness();
    }

    public void transform(int startIndex, int endIndex, List<City> route) {

        /* Apply swap logic using string represention
        if 13 32 42 swap number located at the adjacent indices 1 and 3*/

        if (startIndex == endIndex) {
            return;
        }
        int index1 = Integer.valueOf(this.genString[startIndex]);
        int index2 = Integer.valueOf(this.genString[startIndex + 1]);

        route = swap(route, index1, index2);

        transform(startIndex + 2, endIndex, route);
    }

    private List<City> swap(List<City> route, int index1, int index2) {

        City tempCity = route.get(index1);

        route.add(index1, route.get(index2));
        route.add(index2, tempCity);

        return route;
    }

    public int compareTo(TSPGenome other) {

        return other.phenome.getFitness() < this.phenome.getFitness() ? 1
                : (other.phenome.getFitness() == this.phenome.getFitness() ? 0 : -1);
    }
}
