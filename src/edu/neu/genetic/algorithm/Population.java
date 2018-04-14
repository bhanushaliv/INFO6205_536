package edu.neu.genetic.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Population {


    private List<Route> routes = new ArrayList<>(GeneticAlgorithm.POPULATION_SIZE);

    public Population(int populationSize, List<City> cities) {
        IntStream.range(0, populationSize).forEach(x -> routes.add(new Route(cities)));
    }


    public List<Route> getRoutes() {
        return this.routes;
    }

    public void sortRoutesByFitness() {
        routes.sort((route1, route2) -> {
            int flag = 0;
            if (route1.getFitness() > route2.getFitness()) flag = -1;
            else if (route1.getFitness() < route2.getFitness()) flag = 1;
            return flag;
        });
    }
}
