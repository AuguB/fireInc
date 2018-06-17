package fireinc;

import fireinc.enums.DivisionIdentifier;
import fireinc.workers.Employee;
import fireinc.workers.Manager;
import java.util.ArrayList;

public class Division implements Runnable {

    private DivisionIdentifier div;
    private int nrOfHiredEmps;

    private ArrayList<Employee> employees;

    private Employee manager;

    private double revenue;

    private boolean closed = false;

    public Division(DivisionIdentifier div) {
        this.div = div;
        this.revenue = 0;
        this.nrOfHiredEmps = 0;
    }

    public double getAverageWork() {
        double sum = 0;
        for (Employee e : employees) {
            sum += (e.getCurrentWork() + e.getWorkDone());
        }
        sum = sum / employees.size();
        return sum;
    }

    public void setManager(Manager man) {
        this.manager = man;
    }

    public double getRevenue() {
        double totalRev = 0;
        for (Employee emp : employees) {
            totalRev += emp.getCurrentWork();
        }
        return totalRev;
    }

    @Override
    public void run() {

        while (!closed) {
            if (employees.size() < div.getMaximum()) {

            }
        }
    }

    public ArrayList<Employee> getEmps() {
        return employees;
    }

    public int getMax() {
        return div.getMaximum();
    }

    public int getMin() {
        return div.getMinimum();
    }

    public int getNextEmpNR() {
        nrOfHiredEmps++;
        return nrOfHiredEmps;
    }
    
    public double getGrowth() {
        
    }
    
    
}
