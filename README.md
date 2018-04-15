# INFO6205_536
Travelling Salesman Problem (Genetic Algorithm)

### Project 
Solve Travelling Salesman Problem using Genetic Algorithm.
Given a list of cities and the distances between each pair of cities, what is the shortest possible route that visits each city and returns to the origin city?


        GenoType            -     Gene Expression and Phenotype
        Gene Expression     -     Gene String is a string array of 8 numbers where every number represents the index of the city stored in                                   the phenotype.
        Phenotype  	        -     Every phenotype is mapped to Genotype. A phenotype consists of list of cities representing the route.
        Fitness Function    -     Fitness of every phenotype is based on the total distance of that route.                   	           
        Sort Function       -     Sorting of the phenome is based on the fitness of every Phenotype.
        Evolution Mechanism -     Find the optimal solution until the minimum distance is constant in a range for 20 generations. Creation                                   of new generations would go uptil maximum of 100 generations.



### Crossover
For Crossover, select gene from top selected parent 1 and parent 2. Create new gene for next generation using first half gene of parent 1 and second half of other parent. 

### Result
