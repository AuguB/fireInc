package fireinc.workers;

import static fireinc.Settings.*;
import fireinc.visitors.Visitor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tester<E> extends Employee {
    private Lock lock;

    public Tester(String ID) {
        super(ID);
        lock = new ReentrantLock();
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
        lock.lock();
        try {
            double result = 0;
            result += 0.5 - Math.abs(0.5 - attitude);
            if (days % 10 ==0) {
                needsCoffee = true;
            }
            
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
                
                result -= COFFEE_NEED_PENALTY;
                
            }
            if (randomNormal() > getPrecision()) {
                mistakes++;
            }
            result = result / 5.5;
            currentWork += result;
        } finally {
            lock.unlock();
        }
    }
}
