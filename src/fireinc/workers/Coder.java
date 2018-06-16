package fireinc.workers;

import fireinc.visitors.Visitor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Coder<E> extends Employee {

    public Coder(String ID) {
        super(ID);
    }

    public void run() {
        while (!fired) {
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

    public E accept(Visitor v) {
        return (E) v.visit(this);
    }

    public void work() {
    }
}
