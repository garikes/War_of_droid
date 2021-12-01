package droids;

import fighting.Battle;

public class HawkEye extends PrimaryDroid {
    private final int bowShot;
    private final int arrowStrike;
    public HawkEye(String name){
        this.droidName = name;
        this.droidClass = "hawk";
        droidHealth = droidFullHealth = 1000;
        droidDamage = 100;
        bowShot = (int)(Math.random()*10)+160;
        arrowStrike=(int)(Math.random()*15)+130;
    }
    public void hawkAttack(PrimaryDroid primaryDroid, Battle battle){
        if(primaryDroid.droidClass == "hulk") {
            primaryDroid.droidHealth -= this.bowShot;
            System.out.println("\u001B[32m" + this + " decreases life of"+ primaryDroid + "on " + bowShot + " points \u001B[0m");
        }else if( primaryDroid.droidClass == "iron" ) {
            primaryDroid.droidHealth -= this.arrowStrike;
            System.out.println("\u001B[34m" + this + " decreases life of"+ primaryDroid + "on " + arrowStrike + " points \u001B[0m");
        } else {
            super.attack(primaryDroid);
        }
    }
}
