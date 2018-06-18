package fireinc.workers;

import static fireinc.Settings.*;
import fireinc.Division;
import fireinc.strategies.HiringStrategy;
import fireinc.visitors.Visitor;

public class Manager<E> extends Employee {

    private final HiringStrategy hiring;
    private final Division div;

    public Manager(String ID, HiringStrategy hiring, Division div) {
        super(ID);
        this.hiring = hiring;
        this.div = div;
    }

    @Override
    public void run() {
        while (!fired) {
            incrementDays();
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

    /**
     *
     * @param v
     * @return
     */
    @Override
    public E accept(Visitor v) {
        return (E) v.visit(this);
    }

    public Division getDiv() {
        lock.lock();
        try {
            return div;
        } finally {
            lock.unlock();
        }
    }

    public void work() {

        if (days % 5 == 0) {
            setNeedsCoffee(true);
        }
        produceResult();
        hireNewPeople();

    }

    private void produceResult() {

        hireNewPeople();
        double result = 0;
        result += 0.5 - Math.abs(0.5 - getAttitude());
        result += getSkill();
        result += getExperience();
        result += getWorkethics();
        result += getLoyalty();
        result += getLooks();
        result += getPunctuality();

        if (experience < 1) {
            addExp(EXP_GAIN);
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
        decreaseFear();
        result = result / 6.5;
        addCurrentWork(result);
    }

    private void hireNewPeople() {
        if (div.getEmps().size() < div.getMax()) {
            Employee newEmp = hiring.hire(div.getNextEmpNR(), getSkill());
            div.getEmps().add(newEmp);
            System.out.println(div.getName() + " hired: " + newEmp);
            Thread thread = new Thread(newEmp);
            thread.start();
        }
    }
}
