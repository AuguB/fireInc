package fireinc.workers.promotions;

import fireinc.visitors.Visitor;
import fireinc.workers.Employee;

public class OwnOffice<E> extends Promotion {

    private double squareMeters;

    private boolean window;

    private boolean airco;

    public OwnOffice(String ID, Employee emp) {
        super( ID, emp);
    }
    
    @Override
    public boolean hasOffice(){
        return true;
    }

    public E accept(Visitor v) {
        return (E) v.visit(this);
    }
}
