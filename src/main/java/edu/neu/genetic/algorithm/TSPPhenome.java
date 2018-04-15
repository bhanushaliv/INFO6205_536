package edu.neu.genetic.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TSPPhenome {

    private List<City> cities;
    private double fitness = 0;
    private int id;
    private double totalDistance;

    public TSPPhenome(int id) {
        this.id = id;
        this.cities = new ArrayList<>();
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<City> getCities() {
        return cities;
    }

    /**
     * Calculate the total distance for a route in a Phenotype
     *
     * @return total distance for a route
     */
    public double calculateTotalDistance() {
        int citiesSize = this.cities.size();
        this.totalDistance = (int) (this.cities.stream().mapToDouble(x -> {
            int cityIndex = this.cities.indexOf(x);
            double returnValue = 0;
            if (cityIndex < citiesSize - 1) returnValue = x.distanceTo(this.cities.get(cityIndex + 1));
            return returnValue;
        }).sum() + this.cities.get(0).distanceTo(this.cities.get(citiesSize - 1)));

        return this.totalDistance;
    }

    /**
     * @return info in format
     * Generation X
     * ID X :
     * Boston->Chicago->Denver->San Francisco->Los Angeles->Austin->Houston->New York
     * Total Distance : X
     * Fitness score : X
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ID " + this.id + " :\n");

        IntStream.range(0, this.cities.size())
                .forEach(i -> {
                    stringBuilder.append(this.cities.get(i).toString());
                    if (i != this.cities.size() - 1)
                        stringBuilder.append("->");
                });

        stringBuilder.append("\nTotal Distance : " + this.totalDistance);
        stringBuilder.append("\nFitness score : " + this.fitness);

        return stringBuilder.toString();
    }

    /**
     * Calculate fitness for a phenotype
     *
     * @return fitess score
     */
    public double getFitness() {
        this.fitness = (1 / calculateTotalDistance()) * 10000;
        return this.fitness;
    }
}
