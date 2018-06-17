package fireinc.visitors;

import fireinc.enums.Gender;
import fireinc.workers.Accountant;
import fireinc.workers.Caterer;
import fireinc.workers.Coder;
import fireinc.workers.promotions.CompanyCar;
import fireinc.workers.Designer;
import fireinc.workers.HRSpecialist;
import fireinc.workers.Intern;
import fireinc.workers.Manager;
import fireinc.workers.promotions.OwnOffice;
import fireinc.workers.promotions.Promotion;
import fireinc.workers.promotions.Raise;
import fireinc.workers.Tester;

public class PromotionVisitor implements Visitor<Boolean> {

    @Override
    public Boolean visit(Accountant a) {
        double points = 0;
        double average = a.getWorkDone() / a.getDays();
        if (average > 0.9) {
            points += 1;
        }
        if (a.getMistakes() <= 3) {
            points += 1;
        }
        if (a.getGender() == Gender.FEMALE) {
            if (a.getLooks() > 0.8) {
                points += 1;
            }
        } else {
            if (a.getSocial() > 0.8) {
                points += 1;
            }
        }
        return points >= 2;
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
        return (Boolean) r.getEmp().accept(this);
    }

    @Override
    public Boolean visit(CompanyCar c) {
        return (Boolean) c.getEmp().accept(this);
    }

    @Override
    public Boolean visit(OwnOffice o) {
        return (Boolean) o.getEmp().accept(this);
    }

    @Override
    public Boolean visit(Manager m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean visit(Intern i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean visit(Promotion p) {
        return (Boolean) p.getEmp().accept(this);
    }

    @Override
    public Boolean visit(Caterer c) {

    }

    @Override
    public Boolean visit(HRSpecialist h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
