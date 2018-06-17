package fireinc.workers.promotions;

import fireinc.visitors.Visitor;

public class CompanyCar<E> extends Promotion {

    private double horsePower;

    public CompanyCar(String ID) {
        super(ID);
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
