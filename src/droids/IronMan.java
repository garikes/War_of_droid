package droids;

import fighting.Battle;

public class IronMan extends PrimaryDroid {
    private final int handShots;
    private  final int rocket;
    public IronMan(String name){
        this.droidName = name;
        this.droidClass = "iron";
        droidHealth = droidFullHealth = 875;
        droidDamage = 150;
        handShots = (int)(Math.random()*11)+215;
        rocket =(int)(Math.random()*15)+195;
    }
    public void ironAttack(PrimaryDroid primaryDroid, Battle battle){
        if(primaryDroid.droidClass == "thor") {
            primaryDroid.droidHealth -= this.handShots;
            System.out.println("\u001B[32m" + this + " decreases life of"+ primaryDroid + "on " + handShots + " points \u001B[0m");
        } else if( primaryDroid.droidClass == "cap" ) {
            primaryDroid.droidHealth -= this.rocket;
            System.out.println("\u001B[34m" + this + " decreases life of"+ primaryDroid + "on " + rocket + " points \u001B[0m");
        } else {
            super.attack(primaryDroid);
        }
    }
}
