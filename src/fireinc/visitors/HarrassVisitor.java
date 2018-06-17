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
import java.util.Random;

public class HarrassVisitor implements Visitor<Void> {

    private Random random;

    public HarrassVisitor() {
        random = new Random();
    }

    @Override
    public Void visit(Accountant a) {
        a.setPunctuality(a.getPunctuality() - getNormalRand());
        a.setLoyalty(a.getLoyalty() - getNormalRand());
        a.setWorkethics(a.getWorkethics() - getNormalRand());
        a.setAttitude(a.getAttitude() - getNormalRand());
        a.setNeedsCoffee(true);
        return null;
    }

    @Override
    public Void visit(Coder c) {
        c.setCleanliness(c.getCleanliness() - getNormalRand());
        c.setWorkethics(c.getWorkethics() - getNormalRand());
        c.setAttitude(c.getAttitude() + getNormalRand());
        c.setNeedsCoffee(true);
        return null;
    }

    @Override
    public Void visit(Tester t) {
        t.setLoyalty(t.getLoyalty() - getNormalRand());
        t.setAttitude(t.getAttitude() + getNormalRand());
        t.setWorkethics(t.getWorkethics() - getNormalRand());
        t.setNeedsCoffee(true);
        return null;
    }

    @Override
    public Void visit(Designer d) {
        d.setCleanliness(d.getCleanliness() - getNormalRand());
        d.setPunctuality(d.getPunctuality() - getNormalRand());
        d.setSocial(d.getSocial() - getNormalRand());
        d.setNeedsCoffee(true);
        return null;
    }

    @Override
    public Void visit(Raise r) {
        return (Void) r.getEmp().accept(this);
    }

    @Override
    public Void visit(CompanyCar c) {
        return (Void) c.getEmp().accept(this);
    }

    @Override
    public Void visit(OwnOffice o) {
        return (Void) o.getEmp().accept(this);
    }

    @Override
    public Void visit(Manager m) {
        m.setWorkethics(m.getWorkethics() - getNormalRand());
        m.setCleanliness(m.getCleanliness() - getNormalRand());
        m.setPunctuality(m.getPunctuality() - getNormalRand());
        m.setNeedsCoffee(true);
        if (existentialCrisis()) {
            m.setAttitude(1);
            m.setSocial(0);
            m.setCleanliness(0);
        }
        return null;
    }

    @Override
    public Void visit(Intern i) {
        i.setAttitude(i.getAttitude() + getNormalRand());
        i.setCleanliness(i.getCleanliness() - getNormalRand());
        i.setMistakes(i.getMistakes() + 1);
        i.setPunctuality(i.getPunctuality() - getNormalRand());
        i.setNeedsCoffee(true);
        return null;
    }

    @Override
    public Void visit(Promotion p) {
        return (Void) p.getEmp().accept(this);
    }

    @Override
    public Void visit(Caterer c) {
        c.setAttitude(c.getAttitude() - getNormalRand());
        c.setCleanliness(c.getCleanliness() - getNormalRand());
        c.setWorkethics(c.getWorkethics() - getNormalRand());
        c.setPunctuality(c.getPunctuality() - getNormalRand());
        c.setKitchening(c.getKitchening() - getNormalRand());
        c.setNeedsCoffee(true);
        return null;
    }

    @Override
    public Void visit(HRSpecialist h) {
        h.setLoyalty(h.getLoyalty() - getNormalRand());
        h.setSocial(h.getSocial() - getNormalRand());
        h.setWorkethics(h.getWorkethics() - getNormalRand());
        h.setNeedsCoffee(true);
        return null;
    }

    private double getNormalRand() {
        return getNormalRand(0.01, 0.12);
    }

    private double getNormalRand(double from, double to) {
        return ((random.nextDouble() * (to - from) + from)
                + (random.nextDouble() * (to - from) + from))
                / 2;
    }

    private boolean existentialCrisis() {
        int exCri = random.nextInt(1000);
        return exCri == 1;
    }

}
