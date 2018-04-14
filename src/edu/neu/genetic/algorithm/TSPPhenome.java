package edu.neu.genetic.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TSPPhenome {

    private List<City> cities = new ArrayList<>();
    private double fitness = 0;
    private boolean isFitnessChanged = true;
    private int id;

    public TSPPhenome(int id) {
        this.id = id;
    }

    public TSPPhenome(List<City> cities) {
        this.cities = cities;
        Collections.shuffle(this.cities);
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<City> getCities() {
        isFitnessChanged = true;
        return cities;
    }

    public double calculateTotalDistance() {
        int citiesSize = this.cities.size();
        int totalDistance = (int) (this.cities.stream().mapToDouble(x -> {
            int cityIndex = this.cities.indexOf(x);
            double returnValue = 0;
            if (cityIndex < citiesSize - 1) returnValue = x.distanceTo(this.cities.get(cityIndex + 1));
            return returnValue;
        }).sum() + this.cities.get(0).distanceTo(this.cities.get(citiesSize - 1)));

        return 0;
    }

    public String toString() {
        return Arrays.toString(cities.toArray());
    }

    public double getFitness() {

        if (isFitnessChanged == true) {
            fitness = (1 / calculateTotalDistance()) * 10000;
            isFitnessChanged = false;
        }
        return fitness;
    }
}
