package edu.neu.genetic.algorithm;

import org.apache.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Population {

    private List<City> baseRoute;
    private List<TSPGenome> genomeList;
    private double cutoff;

    /**
     * Comparator defined to compare and sort all genomes in population
     */
    Logger log = Logger.getLogger(Population.class);

    public Comparator<TSPGenome> genoTypeComparator = (TSPGenome g1, TSPGenome g2) -> g2.compareTo(g1);

    public Population(double cutoff, List<City> baseRoute) {
        this.genomeList = new ArrayList<>();
        this.cutoff = cutoff;
        this.baseRoute = baseRoute;
    }

    public List<TSPGenome> getGenomeList() {
        return genomeList;
    }

    public void setGenomeList(List<TSPGenome> genomeList) {
        this.genomeList = genomeList;
    }

    /**
     * This function randomly creates the first generation of genomes
     * based on the randomly created genString
     * Thus each each genotype is characterised with a sequence like:
     * 0 3 4 5 6 2 5 7
     *
     * @param populationSize size of the population
     * @param genolength     length of genotype
     * @param phenolength    length of phenotype
     */
    public void initializePopulation(int populationSize, int genolength, int phenolength) {
        Random r = new Random();

        //generate genome objects equivalent to size of population
        this.genomeList = IntStream.range(0, populationSize)
                // String genString is twice length of genome
                .mapToObj(g -> new TSPGenome(genolength * 2, g))
                .collect(Collectors.toList());

        this.genomeList.stream().forEach(tspGenome -> {
            IntStream.range(0, genolength * 2).forEach(i -> {
                int randInt = r.nextInt(phenolength);
                if (i % 2 != 0) {
                    while (Integer.parseInt(tspGenome.getGenString()[i - 1]) == randInt) {
                        randInt = r.nextInt(phenolength);
                    }
                }
                //creates gene string represention and links to the genome
                tspGenome.getGenString()[i] = String.valueOf(randInt);
            });
        });

        //link phenome with genome by adding new route created
        this.genomeList.stream().forEach(tspGenome -> {
            List<City> newBaseRoute = new ArrayList<>();
            baseRoute.stream().forEach(city -> newBaseRoute.add(city));
            tspGenome.generatePhenome(newBaseRoute);
        });
    }

    public void sortPopulation() {
        Collections.sort(this.genomeList, this.genoTypeComparator);
    }

    /**
     * This function takes 80% of the sorted
     * genome population form the current generation to create a new generation of genomes
     * The Children are created using a crossover between two randomly selected parents
     */
    public void regeneration() {
        Random r = new Random();
        int ubound = (int) ((1 - this.cutoff) * this.genomeList.size());
        log.info("Regeneration using the base order and Crossover");
        List<TSPGenome> newGeneration = new ArrayList<>(this.genomeList.size());

        for (int i = 0; i < this.genomeList.size(); i++) {
            int firstParent = r.nextInt((ubound));
            int secondParent = r.nextInt((ubound));

            while (firstParent == secondParent) {
                secondParent = r.nextInt((ubound));
            }
            TSPGenome child = crossover(firstParent, secondParent, i);
            log.info("Child" + i +" "+ child.getPhenome().toString());
            newGeneration.add(i, child);
        }
        this.genomeList = newGeneration;
    }

    /**
     * For Parent1 Genotype and Parent2 Genotype, first half of the
     * child gene sequence comes from Parent1 and the other half comes from Parent2
     *
     * @param firstParent  index of first Parent
     * @param secondParent index of second Parent
     * @param newMemberId  id for the the phenotype
     * @return
     */
    public TSPGenome crossover(int firstParent, int secondParent, int newMemberId) {

        log.info("\n Current Generations Parent's Genome String "+
                Arrays.toString(this.genomeList.get(firstParent).getGenString()) +
                Arrays.toString(this.genomeList.get(secondParent).getGenString())+ "\n");

        TSPGenome firstGenome = this.genomeList.get(firstParent);
        TSPGenome secondGenome = this.genomeList.get(secondParent);
        String[] childGenString = new String[firstGenome.getGenString().length];
        IntStream.range(0, childGenString.length)
                .forEach(index -> {
                    if (index < childGenString.length / 2) {
                        childGenString[index] = firstGenome.getGenString()[index];
                    } else {
                        childGenString[index] = secondGenome.getGenString()[index];
                    }
                });

        TSPGenome child = new TSPGenome(newMemberId);
        child.setGenString(childGenString);
        log.info("\n Child Generation Genome String "+ Arrays.toString(childGenString) +"\n");
        List<City> newBaseOrder = new ArrayList<>(this.baseRoute);
        child.generatePhenome(newBaseOrder);
        return child;
    }
}
