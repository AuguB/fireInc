package fireinc.workers;

import fireinc.Company;
import fireinc.Division;
import fireinc.strategies.HiringStrategy;
import fireinc.visitors.Visitor;

public class Manager<E> extends Employee {

    private HiringStrategy hiring;
    private Division div;

    public Manager(String ID, HiringStrategy hiring, Division div) {
        super(ID);
        this.hiring = hiring;
        this.div = div;
    }

    public void run() {
        while (!fired) {
            days++;
            try {
                work();
                Thread.sleep(200); //lunchbreak
                work();
                Thread.sleep(200); //break for drinks
                work();
                Thread.sleep(1500); //sleep
            } catch (InterruptedException ex) {
            }
        }
    }

    public E accept(Visitor v) {
        return (E) v.visit(this);
    }

    public Division getDiv() {
        return div;
    }

    public void work() {
        double result = 0;
        result += skill;
        result += experience;
        result += workethics;
        result += loyalty;
        result += looks;
        result += punctuality;
        result += 0.5 - Math.abs(0.5 - getAttitude());

        if (experience < 1) {
            experience += 0.001;
        }
        if (skill < 1) {
            skill += 0.001;
        }
        result /= 6.5;
        if (result < 0.5) {
            mistakes++;
        }
        decreaseFear();
        currentWork += result;

        if (div.getEmps().size() < div.getMax()) {
            div.getEmps().add(hiring.hire(div.getNextEmpNR(), skill));
        }
    }
}
