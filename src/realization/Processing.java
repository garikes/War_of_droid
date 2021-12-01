package realization;
import droids.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Processing {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<PrimaryDroid> list = new ArrayList<>();
        System.out.println("Welcome do DroidBattle");
        while(true) {
            System.out.println("******************** Menu ********************");
            Choosing.menu();
            System.out.print("Enter the code(what do you want to do):");
            int code = Integer.parseInt(reader.readLine());
            switch (code) {
                case 1:
                    Choosing.droidInformation();
                    Choosing.createDroids(list);
                    break;
                case 2:
                    Choosing.listOfDroids(list);
                    break;
                case 3:
                    Choosing.actions(list);
                    break;
                case 4:
                    Choosing.actionsTeamFight(list);
                    break;
                case 5:
                    while(true) {
                        System.out.print("Select the type of battle(1 - duel, 2 - team battle):");
                        int type = Integer.parseInt(reader.readLine());
                        if (type == 1) {
                            Choosing.writeDuelToFile(list);
                            break;
                        }
                        else if(type == 2) {
                            Choosing.writeTeamBattleToFile(list);
                            break;
                        }
                        else System.out.println("wrong code, try again.");
                    }
                    break;
                case 6: Choosing.playLastBattleFromFile();
                    break;
                case 7: return;

            }
        }
    }
}
