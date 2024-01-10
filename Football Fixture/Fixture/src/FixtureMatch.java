
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class FixtureMatch {
    List<Team> teams;
    List<String> firstRounds, lastRounds;
    private  static int sc = 1;

    public FixtureMatch(List<Team> teams){
        this.teams = teams;
        firstRounds = new ArrayList<>();
        lastRounds = new ArrayList<>();
    }

    public void generate(){
        Random random = new Random();
        int half = (teams.size() * (teams.size() - 1)) / 2;
        int counter = 0;
        if (teams.size()%2 == 0){
            while (counter < half){
                Team home = teams.get(random.nextInt(teams.size()));
                Team away = teams.get(random.nextInt(teams.size()));
                if (home != away && !firstRounds.contains(home.getName() + " - " + away.getName())){
                    firstRounds.add(home.getName() + " - " + away.getName());
                    lastRounds.add(away.getName() + " - " + home.getName());
                    counter++;
                }
            }
        }else {
            teams.add(new Team("BAY"));
            while (counter < half){
                Team home = teams.get(random.nextInt(teams.size()));
                Team away = teams.get(random.nextInt(teams.size()));
                if (home != away && !firstRounds.contains(home.getName() + " - " + away.getName())){
                    firstRounds.add(home.getName() + " - " + away.getName());
                    lastRounds.add(away.getName() + " - " + home.getName());
                    counter++;
                }
            }
        }
        display(firstRounds);
        display(lastRounds);
    }
    public void display(List<String> rounds){
        for (int i = 0; i < rounds.size(); i++){
            if (i %3 == 0){
                System.out.println("\n " + sc + ". round: ");
                sc++;
            }
            System.out.println(rounds.get(i));
        }
    }
}