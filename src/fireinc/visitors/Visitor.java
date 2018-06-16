package fireinc.visitors;

import fireinc.enums.Owner;
import fireinc.workers.Accountant;
import fireinc.workers.Coder;
import fireinc.workers.CompanyCar;
import fireinc.workers.Designer;
import fireinc.workers.Manager;
import fireinc.workers.OwnOffice;
import fireinc.workers.Raise;
import fireinc.workers.Tester;
import static java.lang.Math.random;

public interface Visitor<E> {

    public E visit(Accountant a);

    public E visit(Coder c);

    public E visit(Tester t);

    public E visit(Designer d);

    public E visit(Raise r);

    public E visit(CompanyCar c);

    public E visit(OwnOffice o);

    public E visit(Manager m);

    public default Owner getRandomOwner() {
        double select = random();
        if (select < 0.33) {
            return Owner.MANTAS;
        } else if (select < 0.66) {
            return Owner.STIJN;
        } else {
            return Owner.RON;
        }
    }
}
