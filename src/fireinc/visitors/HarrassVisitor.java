package fireinc.visitors;

import fireinc.workers.Accountant;
import fireinc.workers.Coder;
import fireinc.workers.CompanyCar;
import fireinc.workers.Designer;
import fireinc.workers.Intern;
import fireinc.workers.Manager;
import fireinc.workers.OwnOffice;
import fireinc.workers.Promotion;
import fireinc.workers.Raise;
import fireinc.workers.Tester;
import java.util.Random;

public class HarrassVisitor implements Visitor<Void> {

    private Random random;

    public HarrassVisitor() {
        random = new Random();
    }

    @Override
    public Void visit(Accountant a) {
        a.setPunctuality(a.getPunctuality() - getRand());
        return null;
    }

    @Override
    public Void visit(Coder c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Void visit(Tester t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Void visit(Designer d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Void visit(Raise r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Void visit(CompanyCar c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Void visit(OwnOffice o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Void visit(Manager m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Void visit(Intern i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Void visit(Promotion p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private double getRand() {
        return random.nextDouble() * (0.3 - 0.1) + 0.1;
    }

}
