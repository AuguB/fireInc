package fireinc.workers;

import fireinc.Company;

import fireinc.Division;

import static fireinc.Settings.*;

import static fireinc.Settings.*;

import fireinc.visitors.Visitor;
import java.util.ConcurrentModificationException;
import java.util.Random;
import java.util.concurrent.locks.Lock;

public class Intern<E> extends Employee {

    private Random random;

    public Intern(String ID) {
        super(ID);
        random = new Random();
    }

    @Override
    public void run() {
        while (!fired) {
            incrementDays();
            try {
                work();
                Thread.sleep(200); //lunchbreak
                work();
                Thread.sleep(1000); //sleep
            } catch (InterruptedException ex) {
            }
        }
    }

    @Override
    public E accept(Visitor v) {
        return (E) v.visit(this);
    }

    private void print(int amount) {
        int gotPrinters = amount;
        for (int i = 0; i < Company.printers.size(); i++) {
            while (gotPrinters > 0) {
                if (!Company.printers.get(i).isOccupied()) {
                    Company.printers.get(i).setOccupied(true);
                    gotPrinters--;
                    try {
                        Thread.sleep(50); // time it takes to print
                        Company.printers.get(i).setOccupied(false);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

            }
        }
    }

    public void work() {

        if (days % 10 == 0) {
            setNeedsCoffee(true);
        }
        bringCoffee();

        int nrOfCopies = random.nextInt(3) + 1;
        print(nrOfCopies);

        double result = 0;
        result += randomNormal(); //mood factor
        result += 0.5 - Math.abs(0.5 - getAttitude());
        result += getSkill();
        result += getCleanliness();
        result += getSocial();
        result += getLoyalty();
        result += getExperience();
        result += getKitchening();
        result += getLooks();
        if (experience < 1) {
            addExp(EXP_GAIN);
        }
        if (skill < 1) {
            addSkill(SKILL_GAIN);
        }

        if (result < 0.5) {
            incrementMistakes(1);
        }
        bringCoffee();

        if (needsCoffee) {
            result -= COFFEE_NEED_PENALTY;
        }

        decreaseFear();
        result = result / 8.5;
        addCurrentWork(result);
    }

    private void bringCoffee() {
        try {
            for (Division div : Company.divisions) {
                for (Employee emp : div.getEmps()) {
                    if (emp.needsCoffee) {
                        emp.needsCoffee = false;
                    }
                }
            }
        } catch (ConcurrentModificationException e) {
        }
    }

}
