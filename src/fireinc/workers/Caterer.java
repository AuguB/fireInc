/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fireinc.workers;

import fireinc.visitors.Visitor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guus
 * @param <E>
 */
public class Caterer<E> extends Employee {

    public Caterer(String ID) {
        super(ID);
    }

    @Override
    public void run() {
        while (!fired) {
            days++;
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

    @Override
    public E accept(Visitor v) {
        return (E) v.visit(this);
    }

    private void work() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
