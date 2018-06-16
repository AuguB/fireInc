package fireinc.workers.promotions;

import fireinc.visitors.Visitor;
import fireinc.workers.Employee;

public class Promotion<E> extends Employee {

    private Employee employee;

    public Promotion( String ID) {
        super(ID);
    }

    public E accept(Visitor v) {
        return (E) v.visit(this);
    }
    @Override
    public void run(){
        Thread thread = new Thread(employee);
        thread.start();
    }
}
