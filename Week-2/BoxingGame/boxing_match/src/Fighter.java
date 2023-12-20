import java.lang.*;

// Fighter class representing a combatant in the ring
class Fighter {
    String name;        // Fighter's name
    int damage;         // Damage inflicted by the fighter
    int health;         // Fighter's current health
    int weight;         // Fighter's weight class
    double dodge;       // Dodge probability of the fighter

    // Constructor for creating a Fighter instance
    public Fighter(String name, int damage, int health, int weight, double dodge) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.weight = weight;
        this.dodge = dodge;
    }

    // Method representing a fighter hitting an opponent
    public int hit(Fighter foe) {
        System.out.println("------------");
        System.out.println(this.name + " => " + foe.name + " dealt " +  this.damage + " damage.");

        // Check if the opponent dodges the attack
        if (foe.dodge()) {
            System.out.println(foe.name + " dodged the incoming damage.");
            return foe.health;
        }

        // Check if the opponent's health goes below zero
        if (foe.health - this.damage < 0)
            return 0;

        // Reduce opponent's health based on the damage
        return foe.health - this.damage;
    }

    // Method to determine if the fighter successfully dodges an attack
    public boolean dodge() {
        double randomValue = Math.random() * 100;  // Generates a random value between 0.0 to 99.9
        return randomValue <= this.dodge;
    }
}
