package fireinc.workers;

import fireinc.visitors.Visitor;

public class Coder extends Employee {

    public Coder(String name, String ID) {
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
