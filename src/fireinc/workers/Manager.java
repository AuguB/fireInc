package fireinc.workers;

import fireinc.strategies.HiringStrategy;
import fireinc.visitors.Visitor;

public class Manager<E> extends Employee {

    private HiringStrategy hiring;

    public Manager(String ID) {
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
