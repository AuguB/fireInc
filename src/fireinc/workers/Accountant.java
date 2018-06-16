package fireinc.workers;

import fireinc.visitors.Visitor;

public class Accountant<E> extends Employee {

    public Accountant(String name, String ID) {
        super(name, ID);
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
