/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fireinc.workers;

import fireinc.visitors.Visitor;
import static java.lang.Math.random;
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
        double result = 0;
        result += random(); //mood factor
        result += cleanliness;
        result += kitchening;
        result += social;
        result += workethics;
        result += experience;
        result += looks;
        if (experience < 1) {
            experience += 0.0001;
        }
        if (skill < 1) {
            skill += 0.001;
        }
        if (needsCoffee) {
            result -= 0.6;
        }
        if (randomNormal() < 1 - experience) {
            mistakes += 1;
        }
        result = result / 7;
        currentWork += result;
    }

}
