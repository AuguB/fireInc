package fireinc.workers;

import fireinc.Company;

import fireinc.Division;

import static fireinc.Settings.*;

import fireinc.visitors.Visitor;
import java.util.Random;

public class Intern<E> extends Employee {

    private Random random;

    public Intern(String ID) {
        super(ID);
    }

    @Override
    public void run() {
        while (!fired) {
            days++;
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
        if (days >= 10) {
            needsCoffee = true;
        }
        bringCoffee();

        int nrOfCopies = random.nextInt(3) + 1;
        print(nrOfCopies);

        double result = 0;
        result += randomNormal(); //mood factor
        result += 0.5 - Math.abs(0.5 - getAttitude());
        result += skill;
        result += cleanliness;
        result += social;
        result += loyalty;
        result += experience;
        result += kitchening;
        result += looks;
        if (experience < 1) {
            experience += EXP_GAIN;
        }
        if (skill < 1) {

            skill += 0.001;

            result /= 7.5;

            if (result < 0.5) {
                mistakes++;
            }
        }
        bringCoffee();

        skill += SKILL_GAIN;

        if (needsCoffee) {
            result -= COFFEE_NEED;
        }
        if (randomNormal() > getPrecision()) {
            mistakes += 1;
        }

        decreaseFear();
        result = result / 8.5;
        currentWork += result;

    }

    private void bringCoffee() {
        for (Division div : Company.divisions) {
            for (Employee emp : div.getEmps()) {
                if (emp.needsCoffee) {
                    emp.needsCoffee = false;
                }
            }
        }
    }

}
