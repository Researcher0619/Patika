import java.util.Random;

// Ring class representing the arena where two fighters compete
public class Ring {
    Fighter f1;         // Fighter 1
    Fighter f2;         // Fighter 2
    int minWeight;      // Minimum weight allowed in the ring
    int maxWeight;      // Maximum weight allowed in the ring

    // Constructor for creating a Ring instance
    public Ring(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    // Method to determine which fighter starts the match
    public Fighter whoStart(Fighter f1, Fighter f2) {
        int rand = (int) (Math.random() * 100);

        // Randomly select the starting fighter based on a 50% chance
        if (rand < 50) {
            System.out.println("The first player " + f1.name + " will start.");
            return f1;
        }
        System.out.println("The first player " + f2.name + " will start.");
        return f2;
    }

    // Method to run the match between two fighters in the ring
    public void run() {
        if (checkWeight()) {
            while (f1.health > 0 && f2.health > 0) {
                System.out.println("======== NEW ROUND ===========");

                Fighter starter = whoStart(f1, f2);

                // Execute the match based on the starting fighter
                if (starter == f1) {
                    f2.health = f1.hit(f2);
                    if (isWin()) {
                        break;
                    }
                    f1.health = f2.hit(f1);
                    if (isWin()) {
                        break;
                    }
                } else {
                    f1.health = f2.hit(f1);
                    if (isWin()) {
                        break;
                    }
                    f2.health = f1.hit(f2);
                    if (isWin()) {
                        break;
                    }
                }

                printScore();
            }
        } else {
            System.out.println("The fighters' weights do not match.");
        }
    }

    // Method to check if the weights of both fighters are within the allowed range
    public boolean checkWeight() {
        return (f1.weight >= minWeight && f1.weight <= maxWeight) && (f2.weight >= minWeight && f2.weight <= maxWeight);
    }

    // Method to determine if there is a winner in the match
    public boolean isWin() {
        if (f1.health == 0) {
            System.out.println("The winner of the match is: " + f2.name);
            return true;
        } else if (f2.health == 0) {
            System.out.println("The winner of the match is: " + f1.name);
            return true;
        }

        return false;
    }

    // Method to print the current scores of both fighters
    public void printScore() {
        System.out.println("------------");
        System.out.println(f1.name + " Remaining Health \t:" + f1.health);
        System.out.println(f2.name + " Remaining Health \t:" + f2.health);
    }
}
