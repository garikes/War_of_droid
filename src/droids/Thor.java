package droids;
import fighting.*;

public class Thor extends PrimaryDroid {
    private final int thunderStrike;
    private final int hammerBlow;
    public Thor(String name){
        this.droidName =  name;
        this.droidClass = "thor";
        droidHealth = droidFullHealth = 820;
        droidDamage = 175;
        thunderStrike =(int)(Math.random()*10)+215;
        hammerBlow=(int)(Math.random()*15)+195;
    }
    public void thorAttack(PrimaryDroid primaryDroid, Battle battle){
        if(primaryDroid.droidClass == "cap") {
            primaryDroid.droidHealth -= this.thunderStrike;
            System.out.println("\u001B[32m" + this + " decreases life of"+ primaryDroid + "on " + thunderStrike + " points \u001B[0m");
        } else if(primaryDroid.droidClass == "hawk") {
            primaryDroid.droidHealth -= this.hammerBlow;
            System.out.println("\u001B[34m" + this + " decreases life of"+ primaryDroid + "on " + hammerBlow + " points \u001B[0m");
        } else {
            super.attack(primaryDroid);
        }
    }
}
