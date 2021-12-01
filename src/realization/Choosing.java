package realization;
import fighting.Duel;
import fighting.TeamFight;
import droids.*;
import areas.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Choosing {
    private static final String fileWithBattle = "C:\\Users\\petru\\OneDrive\\Рабочий стол\\score_battle.txt";
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void droidInformation(){
        System.out.println("|____________|________________|____________________|");
        System.out.println("| Droid code | Droid type     |   Signature move   |");
        System.out.println("|____________|________________|____________________|");
        System.out.println("|     1      | CaptainAmerica |   cap attack       |");
        System.out.println("|     2      |     HawkEye    |   hawk attack      |");
        System.out.println("|     3      |      Hulk      |    hulk attack     |");
        System.out.println("|     4      |    IronMan     |   iron attack      |");
        System.out.println("|     5      |      Thor      |   thor attack      |");
        System.out.println("|____________|________________|____________________|");
    }
    public static void areaInformation(){
        System.out.println("|____________|______________________|");
        System.out.println("| Area code  |     Area name        |");
        System.out.println("|____________|______________________|");
        System.out.println("|     1      |  EliminationChamber  |");
        System.out.println("|     2      |     ExtremeRules     |");
        System.out.println("|     3      |      HellInACell     |");
        System.out.println("|     4      |      RoyalRumble     |");
        System.out.println("|     5      |     SurvivorSeries   |");
        System.out.println("|____________|______________________|");
    }
    public static void menu(){
        System.out.println("|_____________|_____________________________|");
        System.out.println("|    Code     |          Your action        |");
        System.out.println("|_____________|_____________________________|");
        System.out.println("|     1       |       Droids creation       |");
        System.out.println("|     2       | Show list of created droids |");
        System.out.println("|     3       |        Fighting 1 on 1      |");
        System.out.println("|     4       |    Fighting  team-to-team   |");
        System.out.println("|     5       |       Writing  to a file    |");
        System.out.println("|     6       |   Playing battle from file  |");
        System.out.println("|     7       |            Exit             |");
        System.out.println("|_____________|_____________________________|");
    }
    public static void createDroids(ArrayList<PrimaryDroid> list) throws IOException{
        System.out.println("Droid Creation:");
        while (true) {
            System.out.print("Enter the droid type: ");
            int code = Integer.parseInt(reader.readLine());
            System.out.print("Enter the name of the droid: ");
            String name = reader.readLine();
            switch(code){
                case 1: list.add(new CaptainAmerica(name)); break;
                case 2: list.add(new HawkEye(name)); break;
                case 3: list.add(new Hulk(name)); break;
                case 4: list.add(new IronMan(name)); break;
                case 5: list.add(new Thor(name)); break;
                default: System.out.println("You entered the wrong code. Do it again."); break;
            }
            System.out.print("Continue?(yes/no):");
            String answer = reader.readLine();
            if(answer.equals("no")) break;
        }
        System.out.println("Droids are successfully created.");
    }
    public static void listOfDroids(List<PrimaryDroid> list){
        System.out.println("List of created droids:");
        System.out.println("|_____|______________|______________|");
        System.out.println("|  #  | Droid type   | Droid name   |");
        System.out.println("|_____|______________|______________|");
        for(int i = 0; i < list.size(); i++) {
            PrimaryDroid primaryDroid = list.get(i);
            System.out.printf("| %-3d | %-12s | %-12s |\n", i + 1, primaryDroid.getDroidClass(), primaryDroid.getDroidName());
        }
        System.out.println("|_____|______________|______________|");
    }
    public static Arenas chooseArena(int code){
        switch(code){
            case 1:  return new EliminationChamber();
            case 2:  return new ExtremeRules();
            case 3:  return new HellInACell();
            case 4:  return new RoyalRumble();
            case 5:  return new SurvivorSeries();
            default: return new SurvivorSeries();
        }
    }
    public static Duel inputInformationAboutDuel(List<PrimaryDroid> list) throws IOException{
        System.out.println("******************** Duel ********************");
        if(list.size() < 2) {
            System.out.println("Create at least two droids.");
            return null;
        }
        PrimaryDroid firstPrimaryDroid;
        PrimaryDroid secondPrimaryDroid;
        int code;
        System.out.println("Selection two droids and arena :");
        Choosing.listOfDroids(list);
        System.out.print("Selection of the first droid: ");
        code = Integer.parseInt(reader.readLine());
        firstPrimaryDroid = list.get(code - 1);
        System.out.print("Selection of the second droid: ");
        code = Integer.parseInt(reader.readLine());
        secondPrimaryDroid = list.get(code - 1);
        areaInformation();
        System.out.print("Selection  an arena: ");
        code = Integer.parseInt(reader.readLine());
        return new Duel(firstPrimaryDroid, secondPrimaryDroid,chooseArena(code));
    }
    public static TeamFight inputInformationAboutTeamBattle(List<PrimaryDroid> list) throws IOException{
        System.out.println("******************* Team fighting *******************");
        if(list.size() < 4) {
            System.out.println("Create at least four droids.");
            return null;
        }
        System.out.println("Before,enter the battle information:");
        int teamsSize;
        while(true) {
            System.out.print("Enter the number of team members: ");
            teamsSize = Integer.parseInt(reader.readLine());
            if (list.size() / 2 < teamsSize || teamsSize <= 1) {
                System.out.println("wrong amount, do it  again.");
                continue;
            }
            break;
        }
        ArrayList<PrimaryDroid> firstTeam = new ArrayList<>();
        ArrayList<PrimaryDroid> secondTeam = new ArrayList<>();
        int code;
        String firstTeamName, secondTeamName;
        System.out.print("Enter the name of the first team:");
        firstTeamName = reader.readLine();
        Choosing.listOfDroids(list);
        for(int i = 0; i < teamsSize; i++){
            System.out.print("Select the " + (i + 1) + " droid for the first team:");
            code = Integer.parseInt(reader.readLine());
            PrimaryDroid primaryDroid = list.get(code - 1);
            if(!firstTeam.contains(primaryDroid)) {
                firstTeam.add(primaryDroid);
            }
            else {
                System.out.println("wrong code, try again.");
                i--;
            }
        }
        System.out.print("Enter the name of the second team:");
        secondTeamName = reader.readLine();
        Choosing.listOfDroids(list);
        for(int i = 0; i < teamsSize; i++){
            System.out.print("Select the " + (i + 1) + " droid for the second team:");
            code = Integer.parseInt(reader.readLine());
            PrimaryDroid primaryDroid = list.get(code - 1);
            if(!secondTeam.contains(primaryDroid) && !firstTeam.contains(primaryDroid)) {
                secondTeam.add(primaryDroid);
            }
            else{
                System.out.println("wrong code, try again.");
                i--;
            }
        }
        areaInformation();
        System.out.print("Select an arena: ");
        code = Integer.parseInt(reader.readLine());
        Arenas arenas = chooseArena(code);
        String strategy = "random";
        return new TeamFight(firstTeam, firstTeamName, secondTeam, secondTeamName, arenas, strategy);
    }
    public static void actions(List<PrimaryDroid> list) throws IOException {
        Duel duel = inputInformationAboutDuel(list);
        if(duel == null) return;
        System.out.println("The duel began!!!\n");
        System.out.println("**********************************************");
        PrimaryDroid winner = duel.startofFighting();
        System.out.println("**********************************************\n");
        if(winner != null){
            System.out.println(winner + " won!");
        }
        else System.out.println("Draw.");
        System.out.println("**********************************************");
    }
    public static void actionsTeamFight(List<PrimaryDroid> list) throws IOException {
        TeamFight teamFight = inputInformationAboutTeamBattle(list);
        if(teamFight == null) return;
        System.out.println("The team fight began!!!\n");
        System.out.println("**********************************************");
        String winner = teamFight.startTeamBattle();
        System.out.println("**********************************************\n");
        if(winner != null){
            System.out.println(winner + " won!");
        }
        else System.out.println("Draw.");
        System.out.println("**********************************************");
    }
    public static void writeDuelToFile(List<PrimaryDroid> list) throws IOException {
        Duel duel = inputInformationAboutDuel(list);
        if(duel == null) return;
        System.out.println("Wait...");
        //запам'ятовуємо справжній PrintStream у спеціальну змінну
        PrintStream consoleStream = System.out;
        FileOutputStream fileOutputStream = new FileOutputStream(fileWithBattle);
        //створюємо адаптер классу PrintStream
        PrintStream stream = new PrintStream(fileOutputStream);
        //Встановлюємо його як поточний System.out
        System.setOut(stream);
        System.out.println("The duel began!!!\n");
        System.out.println("**********************************************");
        PrimaryDroid winner = duel.startofFighting();
        System.out.println("**********************************************\n");
        if(winner != null){
            System.out.println(winner + " won!");
        }
        else System.out.println("Draw.");
        System.out.println("**********************************************");
        //повертаємо все як було
        System.setOut(consoleStream);
        System.out.println("The duel was successfully saved to a file.");
    }
    public static void writeTeamBattleToFile(List<PrimaryDroid> list) throws IOException {
        TeamFight teamFight = inputInformationAboutTeamBattle(list);
        if(teamFight == null) return;
        System.out.println("Wait...");
        //запам'ятовуємо справжній PrintStream у спеціальну змінну
        PrintStream consoleStream = System.out;
        FileOutputStream fileOutputStream = new FileOutputStream(fileWithBattle);
        //створюємо адаптер классу PrintStream
        PrintStream stream = new PrintStream(fileOutputStream);
        //Встановлюємо його як поточний System.out
        System.setOut(stream);
        System.out.println("The team battle began!!!\n");
        System.out.println("**********************************************");
        String winner = teamFight.startTeamBattle();
        System.out.println("**********************************************\n");
        if(winner != null){
            System.out.println(winner + " won!");
        }
        else System.out.println("Draw.");
        System.out.println("**********************************************");
        //повертаємо все як було
        System.setOut(consoleStream);
        System.out.println("The team battle was successfully saved to a file.");
    }
    public static void playLastBattleFromFile() throws IOException{
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileWithBattle)));
        while (fileReader.ready()) {
            System.out.println(fileReader.readLine());
        }
    }
}
