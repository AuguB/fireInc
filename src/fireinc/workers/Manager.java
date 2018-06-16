package fireinc.workers;

import fireinc.strategies.HiringStrategy;
import fireinc.visitors.Visitor;

public class Manager extends Employee {

    private HiringStrategy hiring;

    public Manager(String name, String ID) {
        super(name, ID);
    }

    public void run() {
    }

    public Visitor accept(Visitor v) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void work() {
    }
}
