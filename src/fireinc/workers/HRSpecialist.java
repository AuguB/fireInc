package fireinc.workers;

import static fireinc.Settings.*;
import fireinc.visitors.Visitor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guus
 */
public class HRSpecialist<E> extends Employee {

    public HRSpecialist(String ID) {
        super(ID);
    }

    public HRSpecialist(String ID, double pref) {
        super(ID, pref);
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

    private void work() {
        if (days% 9 ==0) {
            needsCoffee = true;
        }
        double result = 0;
        result += randomNormal(); //mood factor
        result += 0.5 - Math.abs(0.5 - attitude);
        result += cleanliness;
        result += kitchening;
        result += social;
        result += workethics;
        result += experience;
        result += looks;
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
        result = result / 7.5;
        currentWork += result;
    }

}
