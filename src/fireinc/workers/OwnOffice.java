package fireinc.workers;

import fireinc.visitors.Visitor;

public class OwnOffice extends Promotion {

    private double squareMeters;

    private boolean window;

    private boolean airco;

    public Visitor accept(Visitor v) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
