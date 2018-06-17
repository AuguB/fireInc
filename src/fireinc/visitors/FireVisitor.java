package fireinc.visitors;

import fireinc.workers.Accountant;
import fireinc.workers.Caterer;
import fireinc.workers.Coder;
import fireinc.workers.promotions.CompanyCar;
import fireinc.workers.Designer;
import fireinc.workers.Employee;
import fireinc.workers.Intern;
import fireinc.workers.Manager;
import fireinc.workers.promotions.OwnOffice;
import fireinc.workers.promotions.Promotion;
import fireinc.workers.promotions.Raise;
import fireinc.workers.Tester;

public class FireVisitor implements Visitor<Void> {

    @Override
    public Void visit(Accountant a) {
        double score = 
        fire(a);
        return null;
    }

    @Override
    public Void visit(Coder c) {
        fire(c);
        return null;
    }

    @Override
    public Void visit(Tester t) {
        fire(t);
        return null;
    }

    @Override
    public Void visit(Designer d) {
        fire(d);
        return null;
    }

    @Override
    public Void visit(Raise r) {
        fire(r);
        return null;
    }

    @Override
    public Void visit(CompanyCar c) {
        fire(c);
        return null;
    }

    @Override
    public Void visit(OwnOffice o) {
        fire(o);
        return null;
    }

    @Override
    public Void visit(Manager m) {
        fire(m);
        return null;
    }

    @Override
    public Void visit(Intern i) {
        fire(i);
        return null;
    }

    @Override
    public Void visit(Promotion p) {
        fire(p);
        return null;
    }
    
    private void fire(Employee e) {
        e.YouAreFired();
        System.out.println(this.getRandomOwner() + " has fired " + e.getName());
    }

    @Override
    public Void visit(Caterer c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
