package fireinc.workers;

import static fireinc.Settings.*;
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
        produceResult();
        hireNewPeople();
    }

    private void produceResult() {
        double result = 0;
        result += 0.5 - Math.abs(0.5 - getAttitude());
        result += skill;
        result += experience;
        result += workethics;
        result += loyalty;
        result += looks;
        result += punctuality;

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
        decreaseFear();
        result = result / 6.5;
        currentWork += result;
    }

    private void hireNewPeople() {
        if (div.getEmps().size() < div.getMax()) {
            Employee newEmp = hiring.hire(div.getNextEmpNR(), skill);
            div.getEmps().add(newEmp);
            System.out.println(div + " hired: " + newEmp);

        }
    }
}
