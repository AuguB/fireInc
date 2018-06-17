package fireinc.visitors;

import static fireinc.Settings.*;
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
        if (average > HARD_WORK) {
            points += 1;
        }
        if (a.getMistakes() <= FIN_TOLERABLE_MISTAKES / 2) {
            points += 1;
        }
        if (a.getGender() == Gender.FEMALE) {
            if (a.getLooks() > GOOD_LOOKS) {
                points += 1;
            }
        } else {
            if (a.getSocial() > VERY_SOCIAL) {
                points += 1;
            }
        }
        return points >= 2;
    }

    @Override
    public Boolean visit(Coder a) {
        double points = 0;
        double average = a.getAverageWork();
        if (average > HARD_WORK) {
            points += 1;
        }
        if (a.getSkill() > VERY_SKILLED) {
            points += 1;
        }
        if (a.getMistakes() <= PRO_TOLERABLE_MISTAKES / 2) {
            points += 1;
        }
        if (a.getGender() == Gender.FEMALE) {
            if (a.getLooks() > GOOD_LOOKS) {
                points += 2;
            }
        } else {
            if (a.getSocial() > VERY_SOCIAL) {
                points += 1;
            }
        }
        return points >= 3;
    }

    @Override
    public Boolean visit(Tester a) {
        double points = 0;
        double average = a.getAverageWork();
        if (average > HARD_WORK) {
            points += 1;
        }
        if (a.getSkill() > VERY_SKILLED) {
            points += 1;
        }
        if (a.getMistakes() <= PRO_TOLERABLE_MISTAKES / 2) {
            points += 1;
        }
        if (a.getGender() == Gender.FEMALE) {
            if (a.getLooks() > GOOD_LOOKS) {
                points += 2;
            }
        } else {
            if (a.getSocial() > VERY_SOCIAL) {
                points += 1;
            }
        }
        return points >= 3;
    }

    @Override
    public Boolean visit(Designer a) {
        double points = 0;
        double average = a.getAverageWork();
        if (average > HARD_WORK) {
            points += 1;
        }
        if (a.getMistakes() <= PRO_TOLERABLE_MISTAKES / 2) {
            points += 1;
        }
        if (a.getGender() == Gender.FEMALE) {
            if (a.getLooks() > GOOD_LOOKS) {
                points += 2;
            }
        } else {
            if (a.getSocial() > VERY_SOCIAL) {
                points += 1;
            }
        }
        if (0.5 - Math.abs(a.getAttitude() - 0.5) > 0.1) {
            points -= 1;
        }
        return points >= 3;
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
    public Boolean visit(Manager a) {
        double points = 0;
        double average = a.getAverageWork();
        if (average > HARD_WORK) {
            points += 1;
        }
        if (a.getMistakes() <= PRO_TOLERABLE_MISTAKES / 2) {
            points += 1;
        }
        if (a.getGender() == Gender.FEMALE) {
            if (a.getLooks() > GOOD_LOOKS) {
                points += 2;
            }
        } else {
            if (a.getSocial() > VERY_SOCIAL) {
                points += 1;
            }
        }
        if (0.5 - Math.abs(a.getAttitude() - 0.5) > 0.1) {
            points -= 1;
        }
        return points >= 3;
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
        return null;
    }

    @Override
    public Boolean visit(HRSpecialist h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
