package fireinc.visitors;

import fireinc.workers.Accountant;
import fireinc.workers.Coder;
import fireinc.workers.CompanyCar;
import fireinc.workers.Designer;
import fireinc.workers.Manager;
import fireinc.workers.OwnOffice;
import fireinc.workers.Raise;
import fireinc.workers.Tester;

public interface Visitor {

    public Accountant visit(Accountant a);

    public Coder visit(Coder c);

    public Tester visit(Tester t);

    public Designer visit(Designer d);

    public Raise visit(Raise r);

    public CompanyCar visit(CompanyCar c);

    public OwnOffice visit(OwnOffice o);

    public Manager visit(Manager m);
}
