package fireinc;

import static fireinc.Settings.*;
import fireinc.enums.DivisionIdentifier;
import fireinc.enums.Owner;
import fireinc.strategies.CaterHireStrategy;
import fireinc.strategies.FinanceHireStrategy;
import fireinc.strategies.HRHireStrategy;
import fireinc.strategies.ProductionHireStrategy;
import fireinc.visitors.FireVisitor;
import fireinc.visitors.PromotionVisitor;
import fireinc.workers.Employee;
import fireinc.workers.Manager;
import fireinc.workers.promotions.Raise;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

public class Company {

    public static ArrayList<Division> divisions;
    private ArrayList<Owner> owners;
    private Lock lock;
    public static ArrayList<Printer> printers;
    private final String NAME;
    private int cycles;
    private static double revenue;

    public Company(String name) {
        setOwners();
        setDivisions();
        setPrinters();
        NAME = name;
        revenue = 0;
        cycles = 0;

    }

    public void start() {
        for (Division d : divisions) {
            Thread thread = new Thread(d);
            thread.start();
        }
        while (true) {
            cycles++;
            if (cycles % COMPANY_CYCLES == 0) {
                for (Division d : divisions) {
                    if (d.growth() < 0.8) {
                        System.out.println(d.getMan().getDiv() +
                                " did very poorly this quater, fucking manager " +
                                d.getMan().getName() + "got his ass fired by "
                                + getRandomOwner() + "!");
                        d.getMan().YouAreFired();
                    } else if (d.growth() < 0.95) {
                        System.out.println(d.getMan().getDiv() +
                                " did poorly, so the firing season is starting!");
                        FireVisitor firing = new FireVisitor();
                        for (Employee emp : d.getEmps()) {
                            emp.accept(firing);
                        }
                    } else if (d.growth() > 1.2) {
                        System.out.println("Good news! " + d.getMan().getDiv() + " did very well, so promotion season starts!");
                        promotionRound(d);
                    }
                }
            }
        }
    }

    private void setDivisions() {
        this.divisions = new ArrayList<>();
        divisions.add(productionDivision());
        divisions.add(financeDivision());
        divisions.add(caterDivision());
        divisions.add(HRDivision());
    }

    private Division productionDivision() {
        Division div = new Division(DivisionIdentifier.PRODUCTION);
        System.out.println("Production division established");
        Manager man = new Manager("PROM1", new ProductionHireStrategy(), div);
        div.setManager(man);
        System.out.println("New manager " + man.getName() + " has been hired by " + getRandomOwner() + " for " + man.getDiv());
        return div;
    }

    private Division financeDivision() {
        Division div = new Division(DivisionIdentifier.FINANCE);
        System.out.println("Finance division established");
        Manager man = new Manager("FINM1", new FinanceHireStrategy(), div);
        div.setManager(man);
        System.out.println("New manager " + man.getName() + " has been hired by " + getRandomOwner() + " for " + man.getDiv());
        return div;
    }

    private Division caterDivision() {
        Division div = new Division(DivisionIdentifier.CATERING);
        System.out.println("Catering division established");
        Manager man = new Manager("CATM1", new CaterHireStrategy(), div);
        div.setManager(man);
        System.out.println("New manager " + man.getName() + " has been hired by " + getRandomOwner() + " for " + man.getDiv());
        return div;
    }

    private Division HRDivision() {
        Division div = new Division(DivisionIdentifier.HR);
        System.out.println("Human Resource division established");
        Manager man = new Manager("HRM1", new HRHireStrategy(), div);
        div.setManager(man);
        System.out.println("New manager " + man.getName() + " has been hired by " + getRandomOwner() + " for " + man.getDiv());
        return div;
    }

    private void setOwners() {
        this.owners = new ArrayList<>();
        owners.add(Owner.RON);
        owners.add(Owner.STIJN);
        owners.add(Owner.MANTAS);
        System.out.println("Owners have bought the compnay " + NAME);
    }

    private void setPrinters() {
        this.printers = new ArrayList<>();
        for (int x = 0; x < NROFPRINTERS; x++) {
            printers.add(new Printer(x + 1));
        }
    }

    public String getName() {
        return NAME;
    }

    public ArrayList<Printer> getPrinters() {
        return printers;
    }

    public void addRevenue(double rev) {
        lock.lock();
        try {
            revenue += rev;
        } finally {
            lock.unlock();
        }
    }

    private void promotionRound(Division d) {
        PromotionVisitor prom = new PromotionVisitor();
        for (Employee emp : d.getEmps()) {
            if ((Boolean) emp.accept(prom)) {
                if (emp.hasCar()) {
                    if (emp.hasOffice()) {
                        d.getEmps().remove(emp);
                        emp = new Raise(emp.getID(), emp);
                        d.getEmps().add(emp);
                        Thread thread = new Thread(emp);
                        thread.start();
                    }
                }
            }
        }

    }
}
