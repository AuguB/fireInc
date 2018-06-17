package fireinc.workers.promotions;

import fireinc.visitors.Visitor;
import fireinc.workers.Employee;

public class CompanyCar<E> extends Promotion {

    private double horsePower;

    public CompanyCar(String ID, Employee emp) {
        super(ID, emp);
    }

    @Override
    public boolean hasCar() {
        return true;
    }

    @Override
    public E accept(Visitor v) {
        return (E) v.visit(this);
    }
}
