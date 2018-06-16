package fireinc.workers;

import fireinc.visitors.Visitor;

public class OwnOffice<E> extends Promotion {

    private double squareMeters;

    private boolean window;

    private boolean airco;

    public OwnOffice(String ID) {
        super( ID);
    }

    public E accept(Visitor v) {
        return (E) v.visit(this);
    }
}
