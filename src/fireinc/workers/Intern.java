package fireinc.workers;

import fireinc.Company;
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

    public void print(int amount) {
        int gotPrinters = amount;
        for (int i = 0; i < Company.printers.size(); i++) {
            while (gotPrinters > 0) {
                if (!Company.printers.get(i).getPrinterOcc()) {
                    Company.printers.get(i).setPrinterOcc(true);
                    gotPrinters--;
                }
            }
        }
    }

    public void work() {

        int nrOfCopies = random.nextInt(3) + 1;
        print(nrOfCopies);

        double result = 0;
        result += skill;
        result += cleanliness;
        result += social;
        result += loyalty;
        result += experience;
        result += kitchening;
        result += looks;
        result += 0.5 - Math.abs(0.5 - getAttitude());

        if (experience < 1) {
            experience += 0.001;
        }
        if (skill < 1) {
            skill += 0.001;
        
        result /= 7.5;
        
        if(result < 0.5)
            mistakes++;
        }

        decreaseFear();

        currentWork += result;
    }
}
