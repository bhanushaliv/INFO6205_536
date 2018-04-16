# INFO6205_536
## Travelling Salesman Problem (Genetic Algorithm)

Team Members:
Shrikant Mudholkar 001284732
Varsha Bhanushali  001234580

### Problem Statement 
Solve Travelling Salesman Problem using Genetic Algorithm.
Given a list of cities and the distances between each pair of cities, what is the shortest possible route that visits each city and returns to the origin city?

### Components

        GenoType            -     Gene Expression and Phenotype
        Gene Expression     -     Gene String is a string array of 8 numbers where every number represents the index of the city stored in the phenotype.
        Phenotype  	        -     Every phenotype is mapped to Genotype. A phenotype consists of list of cities representing the route.
        Fitness Function    -     Fitness of every phenotype is based on the total distance of that route.                   	           
        Sort Function       -     Sorting of the phenome is based on the fitness of every Phenotype.
        

### Crossover
For Crossover, select gene from top selected parent 1 and parent 2. 
Create new gene for next generation using first half gene of parent 1 and second half of other parent. 

### Evolution Mechanism 
Keep looking for the optimal solution until the minimum distance becomes constant for 10 generations. 
Creation of new generations would go until maximum of 100 generations.

### Result

Total Cities = 8<br />
Genotype Length = 8<br />
Total Solution by brute force = 8! (40320)<br />
Population = 1000<br />
Optimal solutions is found by keeping 40320/1000 ~ 40% of the Solution space<br />
Optimal Solution found in 3rd generation
