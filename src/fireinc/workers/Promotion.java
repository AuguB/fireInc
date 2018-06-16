package fireinc.workers;

import fireinc.visitors.Visitor;

public class Promotion extends Employee {

    private Employee employee;

    public Promotion( String ID) {
        super(ID);
    }

    public Visitor accept(Visitor v) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
