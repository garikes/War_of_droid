package fighting;
import droids.*;
import areas.*;
import java.util.List;
public class TeamFight extends Battle {
    private List<PrimaryDroid> teamAttacker;
    private List<PrimaryDroid> teamDefender;
    private String teamAttackerName;
    private String teamDefenderName;
    public TeamFight(List<PrimaryDroid> firstTeam, String firstTeamName, List<PrimaryDroid> secondTeam, String secondTeamName, Arenas arenas, String strategy) {

        int number = 1 + ((int) (Math.random() * 10) % 2);
        if (number == 1) {
            this.teamAttacker = firstTeam;
            this.teamDefender = secondTeam;
            teamAttackerName = firstTeamName;
            teamDefenderName = secondTeamName;
        } else {
            this.teamAttacker = secondTeam;
            this.teamDefender = firstTeam;
            teamAttackerName = secondTeamName;
            teamDefenderName = firstTeamName;
        }
    }
    public boolean isTeamAlive(List<PrimaryDroid> list){
        int count = 0;
        for(PrimaryDroid primaryDroid : list){
            if(primaryDroid.isAlive()) {
                count++;
                break;
            }
        }
        if(count > 0) {
            return true;
        }
        return false;
    }
    public PrimaryDroid[] strategy(){ //вибирати дроїдів випадковим чином
        PrimaryDroid[] pair = new PrimaryDroid[2];
        PrimaryDroid temp;
        int size = teamAttacker.size();
        int number = (int) (Math.random() * 10) % size;
        temp = teamAttacker.get(number);
        if (temp.isAlive()) {
            pair[0] = temp;
        }
        else{
            for(PrimaryDroid primaryDroid : teamAttacker){
                if(primaryDroid.isAlive()){
                    pair[0] = primaryDroid;
                    break;
                }
            }
        }
        number = (int) (Math.random() * 10) % size;
        temp = teamDefender.get(number);
        if (temp.isAlive()) {
            pair[1] = temp;
        }
        else{
            for(PrimaryDroid primaryDroid : teamDefender){
                if(primaryDroid.isAlive()){
                    pair[1] = primaryDroid;
                    break;
                }
            }
        }
        return pair;
    }
    public void swappingTeam(){
        List<PrimaryDroid> temp = teamAttacker;
        String tempName = teamAttackerName;
        teamAttacker = teamDefender;
        teamDefender = temp;
        teamAttackerName = teamDefenderName;
        teamDefenderName = tempName;
    }
    public String startTeamBattle(){
        try {
            int count = 1;
            int droidNumber = 0;
            while (isTeamAlive(teamDefender) && isTeamAlive(teamAttacker)) {
                System.out.println("Round " + count +  "(" + teamAttackerName + " is attacking  "  + teamDefenderName +  "):");
                PrimaryDroid[] pair = null;
                pair = strategy();
                fight(pair[0], pair[1]);    //бій
                Thread.sleep(2000);
                if((count - 1) % 2 != 0) {  // для роботи порядкової стратегії
                    droidNumber++;
                    if(droidNumber == teamAttacker.size()) droidNumber = 0;
                }
                swappingTeam();
                count++;
            }
        }
        catch(Exception e){ System.out.println("Error.");}
        if(isTeamAlive(teamAttacker) && !isTeamAlive(teamDefender)){
            return teamAttackerName;
        }
        else if(isTeamAlive(teamDefender) && !isTeamAlive(teamAttacker)){
            return teamDefenderName;
        }
        else{
            return null;    //нічия
        }
    }
}
