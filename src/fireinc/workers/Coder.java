package fireinc.workers;

import fireinc.visitors.Visitor;
import static java.lang.Math.random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Coder<E> extends Employee {

    public Coder(String ID) {
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
        if (days >= 5) {
            needsCoffee = true;
        }
        double result = 0;
        result += random(); //mood factor
        result += 0.5 - Math.abs(0.5 - attitude);
        result += skill;
        result += punctuality;
        result += workethics;
        result += experience;
        if (experience < 1) {
            experience += 0.0001;
        }
        if (skill < 1) {
            skill += 0.001;
        }
        if (needsCoffee) {
            result -= 0.8;
        }
        if (randomNormal() < 1 - experience) {
            mistakes += 1;
        }
        decreaseFear();
        result = result / 5.5;
        currentWork += result;
    }
}
