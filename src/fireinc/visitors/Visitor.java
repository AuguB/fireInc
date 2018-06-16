package fireinc.visitors;

import fireinc.workers.Accountant;
import fireinc.workers.Coder;
import fireinc.workers.CompanyCar;
import fireinc.workers.Designer;
import fireinc.workers.Manager;
import fireinc.workers.OwnOffice;
import fireinc.workers.Raise;
import fireinc.workers.Tester;

public interface Visitor<E> {

    public E visit(Accountant a);

    public E visit(Coder c);

    public E  visit(Tester t);

    public E visit(Designer d);

    public E visit(Raise r);

    public E visit(CompanyCar c);

    public E visit(OwnOffice o);

    public E visit(Manager m);
}
