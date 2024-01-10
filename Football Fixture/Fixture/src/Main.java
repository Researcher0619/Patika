
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Team> teams = new ArrayList<>();


        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen turnuvada oynayacak takım sayısını giriniz : ");
        int n = input.nextInt();
        input.nextLine();

        for (int i = 1; i <= n; i++){
            System.out.print(i + ". takımı giriniz : ");
            teams.add(new Team(input.nextLine()));
        }

        FixtureMatch fixtureMatch = new FixtureMatch(teams);
        fixtureMatch.generate();
    }
}