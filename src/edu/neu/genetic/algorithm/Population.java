package edu.neu.genetic.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Population {

    private List<City> baseGene;
    private int populationSize = GeneticAlgorithm.POPULATION_SIZE);
    private List<TSPPhenome> routes = new ArrayList<>(populationSize);
    private List<TSPGenome> genomeList = new ArrayList<>(populationSize);

    public Population(int populationSize, List<City> cities) {
        IntStream.range(0, populationSize).forEach(x -> routes.add(new TSPPhenome(cities)));
    }

    public List<TSPGenome> getGenomeList() {
        return genomeList;
    }

    public void setGenomeList(List<TSPGenome> genomeList) {
        this.genomeList = genomeList;
    }

    public List<TSPPhenome> getRoutes() {
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

    public void initPopulation(int genolength, int phenolength){
        Random r = new Random();

        //generate genome objects equivalent to size of population
        this.genomeList = IntStream.range(0,populationSize)
                // String rep is twice length of genome. if 23 45 31 swap numbers located at adjacent indices.
                                    .mapToObj(g -> new TSPGenome(genolength*2,g))
                                    .collect(Collectors.toList());


        this.genomeList.stream().forEach( tspGenome -> {
            IntStream.range(0, genolength*2).forEach( i -> {
                int randInt = r.nextInt(phenolength);
                tspGenome.getGenString()[i] = String.valueOf(randInt);
            });
        });

        this.genomeList.stream().forEach( tspGenome -> {
            List<City> newBaseGene = new ArrayList<>();
            baseGene.stream().forEach(baseGen -> newBaseGene.add(baseGen));
            tspGenome.generatePhenome(newBaseGene);

        });

}
}
