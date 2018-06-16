package fireinc.workers;

import fireinc.Company;
import fireinc.Division;
import fireinc.strategies.HiringStrategy;
import fireinc.visitors.Visitor;

public class Manager<E> extends Employee {

    private HiringStrategy hiring;
    private Division div;

    public Manager(String ID, HiringStrategy hiring, Division div) {
        super(ID);
        this.hiring = hiring;
        this.div = div;
    }

    public void run() {
    }

    public E accept(Visitor v) {
        return (E) v.visit(this);
    }

    public void work() {
    }
}
