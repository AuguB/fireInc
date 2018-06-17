package fireinc.workers;

import static fireinc.Settings.*;
import fireinc.visitors.Visitor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guus
 * @param <E>
 */
public class Caterer<E> extends Employee {
    
    private Lock lock;

    public Caterer(String ID) {
        super(ID);
        lock = new ReentrantLock();
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
        lock.lock();
        try {
            if (days%10 ==0) {
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
                
                result -= COFFEE_NEED_PENALTY;
                
            }
            if (randomNormal() > getPrecision()) {
                mistakes += 1;
            }
            decreaseFear();
            result = result / 7.5;
            currentWork += result;
        } finally {
            lock.unlock();
        }
    }
}
