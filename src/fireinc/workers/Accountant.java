package fireinc.workers;

import fireinc.visitors.Visitor;
import static java.lang.Math.random;
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
        double result = 0;
        result += 3 * random(); //mood factor
        result += skill;
        result += punctuality;
        result += loyalty;
        result -= Math.abs(0.5 - attitude);
        result += experience;
        if (experience < 1) {
            experience += 0.0001;
        }
        if (skill < 1) {
            skill += 0.001;
        }
        if (needsCoffee) {
            result -= 0.6;
        }
        if (random() < 1 - skill/experience) {
            mistakes += 1;
        }
    }

    public void YouAreFired() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

