package fireinc.workers;

import fireinc.visitors.Visitor;

public class Raise extends Promotion {

    private double value;

    public Visitor accept(Visitor v) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
