package fireinc.visitors;

import fireinc.workers.Accountant;
import fireinc.workers.Coder;
import fireinc.workers.CompanyCar;
import fireinc.workers.Designer;
import fireinc.workers.Manager;
import fireinc.workers.OwnOffice;
import fireinc.workers.Raise;
import fireinc.workers.Tester;


public class PromotionVisitor implements Visitor{

    @Override
    public Boolean visit(Accountant a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean visit(Coder c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean visit(Tester t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean visit(Designer d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean visit(Raise r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean visit(CompanyCar c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean visit(OwnOffice o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean visit(Manager m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
