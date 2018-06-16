package fireinc;


import fireinc.NameGenerator.NameGenerator;
import fireinc.enums.Gender;
import fireinc.enums.Owner;
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
        Manager productionManager = new Manager(1, new ProductionHire);
    }
    
    public String getName(Gender.MALE gen){
        return names.generateName(gen);
    }
        
    
    
}
