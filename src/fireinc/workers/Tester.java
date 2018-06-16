package fireinc.workers;

import fireinc.visitors.Visitor;

public class Tester<E> extends Employee {

    public Tester(String ID) {
        super(ID);
    }

    public void run() {
    }

    public E accept(Visitor v) {
        return (E) v.visit(this);
    }

    public void work() {
    }
}
