package fireinc.workers;

import fireinc.visitors.Visitor;

public class CompanyCar extends Promotion {

    private double horsePower;

    public CompanyCar(String name, String ID) {
        super(name, ID);
    }

    public Visitor accept(Visitor v) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
