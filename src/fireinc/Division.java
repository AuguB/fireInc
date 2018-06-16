package fireinc;


import fireinc.workers.Employee;
import fireinc.workers.Manager;
import java.util.ArrayList;

public class Division {
    
    private String name;

    private ArrayList<Employee> employees;

    private Employee manager;

    private double revenue;

    private int max;

    private int min;

    public Division(String name, int max, int min) {
        this.revenue = 0;
        this.name = name;
        this.max = max;
        this.min = min;
    }
    
    public void setManager(Manager man){
        this.manager = man;
    }
    
    public double getRevenue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
