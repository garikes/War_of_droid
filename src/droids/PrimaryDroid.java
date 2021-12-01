package droids;

public abstract class PrimaryDroid {
    protected  String droidName;
    protected  String droidClass;
    protected int droidFullHealth;
    protected int environmentalFactor = 0;
    protected int droidHealth;
    public int droidDamage;
    public int getDroidHealth(){
        return droidHealth;
    }

    public void setDroidDamage(int droidDamage) {
        this.droidDamage = droidDamage;
    }

    public int getDroidFullHealth() {
        return droidFullHealth;
    }
    public void setDroidHealth(int droidHealth) {
        this.droidHealth = droidHealth;
    }
    public  String getDroidName(){
        return droidName;
    }
    public  String getDroidClass(){
        return droidClass;
    }
    public boolean isAlive(){ if(getDroidHealth() > 0) return true; else return false;}
    @Override
    public String toString(){
        return droidName + "[" + getDroidHealth() + "]" + "(" + getDroidClass() + ")";
    }
    public void attack(PrimaryDroid primaryDroid){
        int currentDamage;
        if(environmentalFactor == 0) currentDamage = droidDamage;
        else currentDamage = droidDamage - (((int) (Math.random() * 10.0)) % environmentalFactor);
        primaryDroid.droidHealth -= currentDamage;
        System.out.println("\u001B[35m" +  this +  " decreases life of"+ primaryDroid + "on " + currentDamage + " points \u001B[0m");
    }
}
