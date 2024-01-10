# Fixture Generator

This Java program generates a random fixture schedule for teams. The generated fixtures follow the rules of a Double Round-Robin system, where each team plays against every other team twice, once at home and once away.

## Rules:

- If the number of teams is odd, a "Bay" team is added to make it even. Teams paired with the "Bay" team will not play matches in that round.

## Usage:

1. Create `Team` objects for each team.
2. Add the teams to the list.
3. Create a `FixtureMatch` object with the list of teams.
4. Call the `generate` method to generate and display the fixture schedule.

## Example:

```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Teams
        Team team1 = new Team("Galatasaray");
        Team team2 = new Team("Fenerbahçe");
        Team team3 = new Team("Beşiktaş");

        // List of teams
        List<Team> teams = Arrays.asList(team1, team2, team3);

        // Fixture match generator
        FixtureMatch fixtureMatch = new FixtureMatch(teams);

        // Generate and display the fixture
        fixtureMatch.generate();
    }
}

