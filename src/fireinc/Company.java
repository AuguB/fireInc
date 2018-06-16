package fireinc;

import fireinc.NameGenerator.NameGenerator;
import fireinc.enums.Gender;
import fireinc.enums.Owner;
import fireinc.strategies.CaterHireStrategy;
import fireinc.strategies.FinanceHireStrategy;
import fireinc.strategies.HRHireStrategy;
import fireinc.strategies.ProductionHireStrategy;
import fireinc.workers.Manager;
import java.util.ArrayList;

public class Company {

    private NameGenerator names;

    private ArrayList<Division> divisions;

    private ArrayList<Owner> owners;

    private ArrayList<Printer> printers;

    private String name;

    public Company(String name) {
        this.names = new NameGenerator();
        this.divisions = new ArrayList<>();
        setDivisions();
        this.owners = new ArrayList<>();
        this.printers = new ArrayList<>();
        this.name = name;
    }

    private void setDivisions() {
        divisions.add(productionDivision());
        divisions.add(financeDivision());
        divisions.add(caterDivision());
        divisions.add(HRDivision());
    }

    public String getName(Gender gen) {
        return names.generateName(gen).toString();
    }

    private Division productionDivision() {
        Division div = new Division("Production", 50, 60);
        Manager man = new Manager("PROM1", new ProductionHireStrategy(), div);
        div.setManager(man);
        return div;
    }

    private Division financeDivision() {
        Division div = new Division("Finance", 10, 18);
        Manager man = new Manager("FINM1", new FinanceHireStrategy(), div);
        div.setManager(man);
        return div;
    }

    private Division caterDivision() {
        Division div = new Division("Catering", 20, 25);
        Manager man = new Manager("CATM1", new CaterHireStrategy(), div);
        div.setManager(man);
        return div;
    }
    
    private Division HRDivision() {
        Division div = new Division("Human Resources", 10, 15);
        Manager man = new Manager("HRM1", new HRHireStrategy(), div);
        div.setManager(man);
        return div;
    }

}
