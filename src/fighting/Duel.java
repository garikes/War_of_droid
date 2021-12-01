package fighting;
import droids.*;
import areas.*;
public class Duel extends Battle {
    private PrimaryDroid attacker;
    private PrimaryDroid defender;
    private PrimaryDroid arena;
    public Duel(PrimaryDroid firstPrimaryDroid, PrimaryDroid secondPrimaryDroid, Arenas arenas) {
        int number = 1 + ((int) (Math.random() * 10) % 2);
        if (number == 1) {
            this.attacker = firstPrimaryDroid;
            this.defender = secondPrimaryDroid;
        } else {
            this.attacker = secondPrimaryDroid;
            this.defender = firstPrimaryDroid;
        }
    }
    public void swapping(){
        PrimaryDroid temp = attacker;
        attacker = defender;
        defender = temp;
    }
    public PrimaryDroid startofFighting(){
        try {
            int count = 1;
            while (defender.isAlive() && attacker.isAlive()) {
                System.out.println("Round " + count + ":");
                fight (attacker, defender);
                Thread.sleep(2000);
                swapping();
                count++;
            }
        }
        catch(InterruptedException e){
            System.out.println("Error.");
        }
        if(!attacker.isAlive() && defender.isAlive()) {

            return defender;
        }
        else if(!defender.isAlive() && attacker.isAlive()){
            return attacker;
        }
        else {
            return null;
        }
    }
}
