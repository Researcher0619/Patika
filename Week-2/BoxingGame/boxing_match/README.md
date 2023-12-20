# Fighter Arena Simulation

## Overview
This Java application simulates a simple arena where two fighters engage in a match. The fighters have attributes such as name, damage, health, weight, and dodge probability. The program includes three main classes: Fighter, Ring, and Main.

### Classes
#### Fighter

The Fighter class represents a participant in the arena. It has attributes like name, damage, health, weight, and dodge probability. Fighters can attack each other, and the dodge probability affects the likelihood of avoiding damage.

#### Ring

The Ring class models the arena where the match takes place. It checks the weight compatibility of fighters, randomly selects the starting player, and runs the match until there is a winner. The class also prints the remaining health of each fighter during the match.

#### Main

The Main class contains the main method, creating instances of fighters (e.g., Marc and Alex) and the arena (Ring). It initiates and runs the match between the fighters.

#### How to Use
Create instances of fighters by specifying their name, damage, health, weight, and dodge probability.
Create a Ring instance by providing the fighters and weight range.
Run the Ring instance to simulate the match and determine the winner.
Example;

public class Main {
public static void main(String[] args) {
Fighter marc = new Fighter("Marc", 15, 100, 90, 0);
Fighter alex = new Fighter("Alex", 10, 95, 100, 0);
Ring r = new Ring(marc, alex, 90, 100);
r.run();
}
}

#### Note
Adjust fighter attributes and weight range for different match scenarios. The simulation provides a basic framework for understanding how fighters with varying attributes engage in a match within specified weight limits.