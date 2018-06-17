package fireinc.workers.promotions;

import fireinc.visitors.Visitor;

public class OwnOffice<E> extends Promotion {

    private double squareMeters;

    private boolean window;

    private boolean airco;

    public OwnOffice(String ID) {
        super( ID);
    }
    
    @Override
    public boolean hasOffice(){
        return true;
    }

    public E accept(Visitor v) {
        return (E) v.visit(this);
    }
}
