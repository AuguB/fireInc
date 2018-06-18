package fireinc;

import static fireinc.Settings.*;
import fireinc.enums.DivisionIdentifier;
import fireinc.enums.Gender;
import fireinc.enums.Owner;
import fireinc.strategies.CaterHireStrategy;
import fireinc.strategies.FinanceHireStrategy;
import fireinc.strategies.HRHireStrategy;
import fireinc.strategies.ProductionHireStrategy;
import fireinc.visitors.FireVisitor;
import fireinc.visitors.PromotionVisitor;
import fireinc.workers.Employee;
import fireinc.workers.Manager;
import fireinc.workers.promotions.CompanyCar;
import fireinc.workers.promotions.OwnOffice;
import fireinc.workers.promotions.Raise;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Company {

    public static ArrayList<Division> divisions;
    private ArrayList<Owner> owners;
    private Lock lock;
    public static ArrayList<Printer> printers;
    private final String NAME;
    private int cycles;
    private static double revenue;

    public Company(String name) {
        lock = new ReentrantLock();
        NAME = name;
        revenue = 0;
        cycles = 0;
        setOwners();
        setDivisions();
        setPrinters();
    }

    public void start() {
        for (Division d : divisions) {
            Thread thread = new Thread(d);
            thread.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Company.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true) {
            lock.lock();
            try {
                cycles++;
            } finally {
                lock.unlock();
            }
            if (cycles % COMPANY_CYCLES == 0) {
                revenue = 0;
                for (Division d : divisions) {
                    d.addRevenue(d.getRevenueFromEmployees());
                    double divGrowth = d.growth();
                    revenue+=d.getRevenue();
                    if (divGrowth < 0.8) {
                        String firedSucker = d.getMan().getDiv().getName()
                                + " did very poorly this quater, fucking manager "
                                + d.getMan().getName() + " got ";
                        if (d.getMan().getGender() == Gender.FEMALE) {
                            firedSucker += "her ";
                        } else {
                            firedSucker += "his ";
                        }
                        System.out.println(firedSucker + "ass fired by "
                                + getRandomOwner().toString() + "!");
                        d.getMan().YouAreFired();
                    } else if (divGrowth < 1) {
//                    } else if (true) {
                        fireSequence(d);
                    } else if (divGrowth > 1.2) {
                        System.out.println("Good news! " + d.getMan().getDiv().getName() + " did very well, so promotion season starts!");
                        promotionRound(d);
                    }
                }
                System.out.println("Total revenue so far: "+revenue);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Company.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void fireSequence(Division d) {
        //for testing purposes only
        System.out.println(d.getMan().getDiv().getName()
                + " did poorly, so the firing season is starting!");
        FireVisitor firing = new FireVisitor();
        ArrayList<Employee> fired = new ArrayList<>();
        try {
            for (Employee emp : d.getEmps()) {
                emp.accept(firing);
                if (emp.isFired()) {
                    fired.add(emp);
                }
            }
        } catch (ConcurrentModificationException e) {
        }
        d.getEmps().removeAll(fired);
    }

    private void setDivisions() {
        this.divisions = new ArrayList<>();
        divisions.add(productionDivision());
        divisions.add(financeDivision());
        divisions.add(caterDivision());
        divisions.add(HRDivision());
    }

    private Division productionDivision() {
        Division div = new Division(DivisionIdentifier.PR);
        System.out.println("Production division established");
        Manager man = new Manager("PROM1", new ProductionHireStrategy(), div);
        div.setManager(man);
        System.out.println("New manager " + man.getName() + " has been hired by " + getRandomOwner() + " for " + man.getDiv().getName());
        return div;
    }

    private Division financeDivision() {
        Division div = new Division(DivisionIdentifier.FI);
        System.out.println("Finance division established");
        Manager man = new Manager("FINM1", new FinanceHireStrategy(), div);
        div.setManager(man);
        System.out.println("New manager " + man.getName() + " has been hired by " + getRandomOwner() + " for " + man.getDiv().getName());
        return div;
    }

    private Division caterDivision() {
        Division div = new Division(DivisionIdentifier.CA);
        System.out.println("Catering division established");
        Manager man = new Manager("CATM1", new CaterHireStrategy(), div);
        div.setManager(man);
        System.out.println("New manager " + man.getName() + " has been hired by " + getRandomOwner() + " for " + man.getDiv().getName());
        return div;
    }

    private Division HRDivision() {
        Division div = new Division(DivisionIdentifier.HR);
        System.out.println("Human Resource division established");
        Manager man = new Manager("HRM1", new HRHireStrategy(), div);
        div.setManager(man);
        System.out.println("New manager " + man.getName() + " has been hired by " + getRandomOwner() + " for " + man.getDiv().getName());
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
        try {
            PromotionVisitor prom = new PromotionVisitor();
            for (Employee emp : d.getEmps()) {
                if ((Boolean) emp.accept(prom)) {
                    emp.YouAreFired();
                    d.getEmps().remove(emp);
                    String congratz = emp.getName() + " from " + DivisionIdentifier.valueOf(emp.getID().substring(0,2)).getName() + " got ";
                    if (emp.hasCar()) {
                        if (emp.hasOffice()) {
                            emp = new Raise(emp.getID(), emp);
                            System.out.println(congratz + " a raise!");
                        } else {
                            emp = new OwnOffice(emp.getID(), emp);
                            if (emp.getGender() == Gender.FEMALE) {
                                congratz += "her ";
                            } else {
                                congratz += "his ";
                            }
                            System.out.println(congratz + "own office!");
                        }
                    } else {
                        emp = new CompanyCar(emp.getID(), emp);
                        System.out.println(congratz + "a company car!");
                    }
                    d.getEmps().add(emp);
                    Thread thread = new Thread(emp);
                    thread.start();
                }
            }
        } catch (ConcurrentModificationException e) {
        }

    }
}
