package fireinc.visitors;

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

public interface Visitor<E> {

    public E visit(Accountant a);

    public E visit(Coder c);

    public E visit(Tester t);

    public E visit(Designer d);

    public E visit(Raise r);

    public E visit(CompanyCar c);

    public E visit(OwnOffice o);

    public E visit(Manager m);

    public E visit(Intern i);

    public E visit(Promotion p);

    public E visit(Caterer c);
    
    public E visit(HRSpecialist h);
}
