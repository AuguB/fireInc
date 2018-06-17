package fireinc;

import static fireinc.Settings.*;
import fireinc.enums.DivisionIdentifier;
import fireinc.enums.Owner;
import fireinc.strategies.CaterHireStrategy;
import fireinc.strategies.FinanceHireStrategy;
import fireinc.strategies.HRHireStrategy;
import fireinc.strategies.ProductionHireStrategy;
import fireinc.workers.Manager;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

public class Company {

    private ArrayList<Division> divisions;
    private ArrayList<Owner> owners;
    private Lock lock;
    public static ArrayList<Printer> printers;
    private final String NAME;
    private static double revenue;

    public Company(String name) {
        setDivisions();
        setOwners();
        setPrinters();
        this.NAME = name;
        this.revenue = 0;
    }

    public void start() {
        for (Division d : divisions) {
            Thread thread = new Thread(d);
            thread.start();
        }
        while(true){
            
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
        Manager man = new Manager("PROM1", new ProductionHireStrategy(), div);
        div.setManager(man);
        return div;
    }

    private Division financeDivision() {
        Division div = new Division(DivisionIdentifier.FINANCE);
        Manager man = new Manager("FINM1", new FinanceHireStrategy(), div);
        div.setManager(man);
        return div;
    }

    private Division caterDivision() {
        Division div = new Division(DivisionIdentifier.CATERING);
        Manager man = new Manager("CATM1", new CaterHireStrategy(), div);
        div.setManager(man);
        return div;
    }

    private Division HRDivision() {
        Division div = new Division(DivisionIdentifier.HR);
        Manager man = new Manager("HRM1", new HRHireStrategy(), div);
        div.setManager(man);
        return div;
    }

    private void setOwners() {
        this.owners = new ArrayList<>();
        owners.add(Owner.RON);
        owners.add(Owner.STIJN);
        owners.add(Owner.MANTAS);
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
}
