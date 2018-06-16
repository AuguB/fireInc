package fireinc.workers;

import fireinc.visitors.Visitor;

public class Accountant<E> extends Employee {

    public Accountant( String ID) {
        super( ID);
    }

    public void run() {
    }

    @Override
    public E accept(Visitor v) {
        return (E) v.visit(this);
    }

    public void work() {
    }
}
