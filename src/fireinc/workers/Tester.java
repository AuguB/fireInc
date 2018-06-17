package fireinc.workers;

import static fireinc.Settings.*;
import fireinc.visitors.Visitor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tester<E> extends Employee {

    public Tester(String ID) {
        super(ID);
    }

    public void run() {
        while (!fired) {
            days++;
            try {
                work();
                Thread.sleep(500);
                work();
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Designer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public E accept(Visitor v) {
        return (E) v.visit(this);
    }

    public void work() {
        double result = 0;
        result += 0.5 - Math.abs(0.5 - attitude);
        result += skill;
        result += punctuality;
        result += cleanliness;
        result += loyalty;
        result += workethics;
        if (experience < 1) {
            experience += EXP_GAIN;
        }
        if (skill < 1) {
            skill += SKILL_GAIN;
        }
        if (needsCoffee) {
            result -= COFFEE_NEED;
        }
        if (randomNormal() > getPrecision()) {
            mistakes++;
        }
        result = result / 5.5;
        currentWork += result;
    }
}
