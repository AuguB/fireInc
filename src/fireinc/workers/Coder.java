package fireinc.workers;

import static fireinc.Settings.*;
import fireinc.visitors.Visitor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Coder<E> extends Employee {
    
    public Coder(String ID) {
        super(ID);
    }
    
    @Override
    public void run() {
        while (!fired) {
            incrementDays();
            try {
                work();
                Thread.sleep(300); //lunchbreak
                work();
                Thread.sleep(2000); //sleep
            } catch (InterruptedException ex) {
                Logger.getLogger(Accountant.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public E accept(Visitor v) {
        return (E) v.visit(this);
    }
    
    public void work() {
        
        if (days % 5 == 0) {
            setNeedsCoffee(true);
        }
        double result = 0;
        result += randomNormal(); //mood factor
        result += 0.5 - Math.abs(0.5 - getAttitude());
        result += getSkill();
        result += getPunctuality();
        result += getWorkethics();
        result += getExperience();
        if (experience < 1) {
            addExp(EXP_GAIN);
        }
        
        if (skill < 1) {
            addSkill(SKILL_GAIN);
        }
        if (needsCoffee) {
            
            result -= COFFEE_NEED_PENALTY;
            
        }
        if (randomNormal() > getPrecision()) {
            incrementMistakes(1);
        }
        decreaseFear();
        result = result / 5.5;
        addCurrentWork(result);
    }
}
