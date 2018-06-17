package fireinc;

import static fireinc.Settings.*;
import fireinc.enums.Owner;
import fireinc.strategies.CaterHireStrategy;
import fireinc.strategies.FinanceHireStrategy;
import fireinc.strategies.HRHireStrategy;
import fireinc.strategies.ProductionHireStrategy;
import fireinc.workers.Manager;
import java.util.ArrayList;

public class Company {

    private ArrayList<Division> divisions;
    private ArrayList<Owner> owners;
    private ArrayList<Printer> printers;
    private final String NAME;

    public Company(String name) {
        setDivisions();
        setOwners();
        setPrinters();
        this.NAME = name;
    }

    private void setDivisions() {
        this.divisions = new ArrayList<>();
        divisions.add(productionDivision());
        divisions.add(financeDivision());
        divisions.add(caterDivision());
        divisions.add(HRDivision());
    }

    private Division productionDivision() {
        Division div = new Division("Production", PRODMIN, PRODMAX);
        Manager man = new Manager("PROM1", new ProductionHireStrategy(), div);
        div.setManager(man);
        return div;
    }

    private Division financeDivision() {
        Division div = new Division("Finance", FINMIN, FINMAX);
        Manager man = new Manager("FINM1", new FinanceHireStrategy(), div);
        div.setManager(man);
        return div;
    }

    private Division caterDivision() {
        Division div = new Division("Catering", CATMIN, CATMAX);
        Manager man = new Manager("CATM1", new CaterHireStrategy(), div);
        div.setManager(man);
        return div;
    }

    private Division HRDivision() {
        Division div = new Division("Human Resources", HRMIN, HRMAX);
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

}
