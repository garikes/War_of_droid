package droids;

import fighting.Battle;

public class CaptainAmerica extends PrimaryDroid{
    private final int shieldThrow;
    private final int brutalKick;
    public CaptainAmerica(String name){
        this.droidName = name;
        this.droidClass = "cap";
        droidHealth = droidFullHealth = 925;
        droidDamage = 125;
        shieldThrow = (int)(Math.random()*10)+205;
        brutalKick =(int)(Math.random()*15)+175;
    }
    public void capAttack(PrimaryDroid primaryDroid, Battle battle){
        if( primaryDroid.droidClass == "hawk" ) {
            primaryDroid.droidHealth -= this.shieldThrow;
            System.out.println("\u001B[32m" + this + " decreases life of"+ primaryDroid + "on " + shieldThrow + " points \u001B[0m");
        } else if( primaryDroid.droidClass == "hulk" ) {
            primaryDroid.droidHealth -= this.brutalKick;
            System.out.println("\u001B[34m" + this + " decreases life of"+ primaryDroid + "on " + brutalKick + " points \u001B[0m");
        } else {
            super.attack(primaryDroid);
        }
    }
}


