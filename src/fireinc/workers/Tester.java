package fireinc.workers;

import static fireinc.Settings.*;
import fireinc.visitors.Visitor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tester<E> extends Employee {

    public Tester(String ID) {
        super(ID);
    }

    public void run() {
        while (!fired) {
            incrementDays();
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
        result += 0.5 - Math.abs(0.5 - getAttitude());
        if (days % 10 == 0) {
            setNeedsCoffee(true);
        }

        result += getSkill();
        result += getPunctuality();
        result += getCleanliness();
        result += getLoyalty();
        result += getWorkethics();
        if (experience < 1) {addExp(EXP_GAIN);
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
        result = result / 5.5;
        addCurrentWork(result);

    }
}
