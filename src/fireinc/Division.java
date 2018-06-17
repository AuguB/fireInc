package fireinc;


import fireinc.enums.DivisionIdentifier;
import fireinc.workers.Employee;
import fireinc.workers.Manager;
import java.util.ArrayList;

public class Division implements Runnable{
    
    private DivisionIdentifier div;

    private ArrayList<Employee> employees;

    private Employee manager;

    private double revenue;
    
    private boolean closed = false;

    public Division(DivisionIdentifier div) {
        this.div = div;
        this.revenue = 0;
    }
    
    public void setManager(Manager man){
        this.manager = man;
    }
    
    public double getRevenue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void run() {
        while(!closed){
            //do stuff
        }
    }
}
