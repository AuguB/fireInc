package fireinc.workers.promotions;

import fireinc.visitors.Visitor;

public class Raise<E> extends Promotion {

    private double value;

    public Raise(String ID) {
        super( ID);
    }
    
    @Override
    public double getSalary(){
        return 1.02*employee.getSalary();
    }

    public E accept(Visitor v) {
        return (E) v.visit(this);
    }
}
