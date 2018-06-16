package fireinc.workers;

import fireinc.visitors.Visitor;

public class Tester extends Employee {

    public Tester(String ID) {
        super(ID);
    }

    public void run() {
    }

    public Visitor accept(Visitor v) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void work() {
    }
}
