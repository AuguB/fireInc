package fireinc.workers.promotions;

import fireinc.visitors.Visitor;
import fireinc.workers.Employee;

public class Raise<E> extends Promotion {

    private double value;

    public Raise(String ID, Employee emp) {
        super( ID, emp);
    }
    
    @Override
    public double getSalary(){
        return 1.02*employee.getSalary();
    }

    public E accept(Visitor v) {
        return (E) v.visit(this);
    }
}
