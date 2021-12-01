package droids;

import fighting.Battle;

public class Hulk extends PrimaryDroid {
    private final int jumpBody;  //критична атака
    private final int punch;
    public Hulk(String name){
        this.droidName = name;
        this.droidClass = "hulk";
        droidHealth = droidFullHealth = 750;
        droidDamage = 200;
        jumpBody =(int)(Math.random()*10)+220;
        punch =(int)(Math.random()*16)+207;
    }
    public void hulkAttack(PrimaryDroid primaryDroid, Battle battle){
        if(primaryDroid.droidClass == "iron") {
            primaryDroid.droidHealth -= this.jumpBody;
            System.out.println("\u001B[32m" + this + " decreases life of"+ primaryDroid + "on " + jumpBody + " points \u001B[0m");
        } else if( primaryDroid.droidClass == "thor" ) {
            primaryDroid.droidHealth -= this.punch;
            System.out.println("\u001B[34m" + this + " decreases life of"+ primaryDroid + "on " + punch + " points \u001B[0m");
        }  else {
            super.attack(primaryDroid);
        }
    }
}
