package fireinc.workers;

import fireinc.visitors.Visitor;

public class Raise extends Promotion {

    private double value;

    public Raise(String name, String ID) {
        super(name, ID);
    }

    public Visitor accept(Visitor v) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
