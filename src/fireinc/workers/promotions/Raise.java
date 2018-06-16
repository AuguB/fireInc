package fireinc.workers.promotions;

import fireinc.visitors.Visitor;

public class Raise<E> extends Promotion {

    private double value;

    public Raise(String ID) {
        super( ID);
    }

    public E accept(Visitor v) {
        return (E) v.visit(this);
    }
}
