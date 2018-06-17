package fireinc.workers;

import static fireinc.Settings.*;
import fireinc.visitors.Visitor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Accountant<E> extends Employee {

    public Accountant(String ID) {
        super(ID);
    }

    @Override
    public void run() {
        while (!fired) {
            days++;
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
        if(days%10 ==0)
            needsCoffee = true;
        double result = 0;
        result += randomNormal(); //mood factor
        result += 0.5 - Math.abs(0.5 - attitude);
        result += skill;
        result += punctuality;
        result += loyalty;
        result += experience;
        if (experience < 1) {
            experience += EXP_GAIN;
        }
        if (skill < 1) {
            skill += SKILL_GAIN;
        }
        if (needsCoffee) {

            result -= COFFEE_NEED;

            result -= COFFEE_NEED_PENALTY;

        }
        if (randomNormal() > getPrecision()) {
            mistakes += 1;
        }
        decreaseFear();
        result = result / 5.5;
        currentWork += result;
        System.out.println(result);
    }


    
    
}
