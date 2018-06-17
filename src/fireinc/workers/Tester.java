package fireinc.workers;

import fireinc.Settings;
import fireinc.visitors.Visitor;
import static java.lang.Math.random;
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
        if (days >= 10) {
            needsCoffee = true;
        }
        double result = 0;
        result += skill;
        result += punctuality;
        result += cleanliness;
        result += loyalty;
        result += workethics;
        result += 0.5 - Math.abs(0.5 - attitude);
        if (experience < 1) {
            experience += Settings.EXP_GAIN;
        }
        if (skill < 1) {
            skill += Settings.SKILL_GAIN;
        }
        if (random() > getPrecision()) {
            mistakes++;
        }
        workDone += result;
    }
}
