package fighting;
import droids.*;
public abstract class Battle {
    public void fight(PrimaryDroid attacker, PrimaryDroid defender){    //логіка бою
        if(attacker instanceof CaptainAmerica) ((CaptainAmerica)attacker).capAttack(defender, this);
        else if(attacker instanceof HawkEye) ((HawkEye)attacker).hawkAttack(defender, this);
        else if(attacker instanceof Hulk) ((Hulk)attacker).hulkAttack(defender, this);
        else if(attacker instanceof IronMan) ((IronMan)attacker).ironAttack(defender, this);
        else if(attacker instanceof Thor) ((Thor)attacker).thorAttack(defender, this);
        else attacker.attack(defender);
        if(!defender.isAlive()) return;
        if(!attacker.isAlive()) return;
    }
}

