package fireinc.workers;

import fireinc.strategies.HiringStrategy;
import fireinc.visitors.Visitor;

public class Manager<E> extends Employee {

    private HiringStrategy hiring;

    public Manager(String ID) {
        super(ID);
    }

    public void run() {
        while (!fired) {
            try {
                work();
                Thread.sleep(100); //lunchbreak
                work();
                Thread.sleep(100); //lunchbreak
                work();
                Thread.sleep(2000); //sleep
            } catch (InterruptedException ex) {

            }
        }
    }

    public E accept(Visitor v) {
        return (E) v.visit(this);
    }

    public void work() {
        double result = 0;
    }
}
