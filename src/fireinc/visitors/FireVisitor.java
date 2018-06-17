package fireinc.visitors;

import static fireinc.Settings.*;
import static fireinc.enums.Gender.*;
import fireinc.workers.Accountant;
import fireinc.workers.Caterer;
import fireinc.workers.Coder;
import fireinc.workers.promotions.CompanyCar;
import fireinc.workers.Designer;
import fireinc.workers.Employee;
import fireinc.workers.HRSpecialist;
import fireinc.workers.Intern;
import fireinc.workers.Manager;
import fireinc.workers.promotions.OwnOffice;
import fireinc.workers.promotions.Promotion;
import fireinc.workers.promotions.Raise;
import fireinc.workers.Tester;

public class FireVisitor implements Visitor<Void> {

    @Override
    public Void visit(Accountant a) {
        if (a.getAverageWork() < MIN_RESULTS || FIN_TOLERABLE_MISTAKES <= a.getMistakes()) {
            if (!persuade(a)) {
                fire(a);
            } else {
                a.increaseAttemptsToFire();
            }
        }
        return null;
    }

    @Override
    public Void visit(Coder c) {
        if (c.getAverageWork() < MIN_RESULTS || PRO_TOLERABLE_MISTAKES <= c.getMistakes()) {
            if (!persuade(c)) {
                fire(c);
            } else {
                c.increaseAttemptsToFire();
            }
        }
        return null;
    }

    @Override
    public Void visit(Tester t) {
        if (t.getAverageWork() < MIN_RESULTS || PRO_TOLERABLE_MISTAKES <= t.getMistakes()) {
            if (!persuade(t)) {
                fire(t);
            } else {
                t.increaseAttemptsToFire();
            }
        }
        return null;
    }

    @Override
    public Void visit(Designer d) {
        if (d.getAverageWork() < MIN_RESULTS || PRO_TOLERABLE_MISTAKES <= d.getMistakes()) {
            if (!persuade(d)) {
                fire(d);
            } else {
                d.increaseAttemptsToFire();
            }
        }
        return null;
    }

    @Override
    public Void visit(Caterer c) {

        if (c.getAverageWork() < MIN_RESULTS || CAT_TOLERABLE_MISTAKES <= c.getMistakes()) {
            if (!persuade(c)) {
                fire(c);
            } else {
                c.increaseAttemptsToFire();
            }
        }
        return null;
    }

    @Override
    public Void visit(HRSpecialist h) {

        if (h.getAverageWork() < MIN_RESULTS || HR_TOLERABLE_MISTAKES <= h.getMistakes()) {
            if (!persuade(h)) {
                fire(h);
            } else {
                h.increaseAttemptsToFire();
            }
        }
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
    public Void visit(Raise r) {
        r.getEmp().accept(this);
        return null;
    }

    @Override
    public Void visit(CompanyCar c) {
        c.getEmp().accept(this);
        return null;
    }

    @Override
    public Void visit(OwnOffice o) {
        o.getEmp().accept(this);
        return null;
    }

    @Override
    public Void visit(Promotion p) {
        p.getEmp().accept(this);
        return null;
    }

    /**
     * Employee tries to persuade to not get fired
     *
     * @return true/false for fired
     */
    private boolean persuade(Employee emp) {
        double score = 0;
        if (emp.getGender() == FEMALE && GOOD_LOOKS <= emp.getLooks()) {
            score++;
        }
        if (VERY_SKILLED <= emp.getSkill()) {
            score++;
        }
        if (VERY_SOCIAL <= emp.getSocial()) {
            score++;
        }
        if (VERY_LOYAL <= emp.getLoyalty()) {
            score++;
        }
        if (EXPERIENCED_WORKER <= emp.getDays()) {
            score += 0.5;
            if (VETERAN_WORKER <= emp.getDays()) {
                score += 0.5;
                if (ANCIENT_WORKER <= emp.getDays()) {
                    score += 0.5;
                    if (LEGENDARY_WORKER <= emp.getDays()) {
                        score += 0.5;
                    }
                }
            }
        }
        score -= emp.getAttemptsToFire() * 0.25;
        score -= Math.abs(MIN_RESULTS - emp.getAverageWork()) * 3;

        return score < 3;
    }

    private void fire(Employee e) {
        e.YouAreFired();
        System.out.println(this.getRandomOwner() + " has fired " + e.getName());
    }
}
