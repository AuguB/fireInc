package fireinc;

import fireinc.enums.DivisionIdentifier;
import fireinc.strategies.HiringStrategy;
import fireinc.visitors.FireVisitor;
import fireinc.workers.Employee;
import fireinc.workers.Manager;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Division implements Runnable {

    private DivisionIdentifier divID;
    private Lock lock;
    private int nrOfHiredEmps;
    private int nrOfManagers;
    private ArrayList<Employee> employees;

    private Manager manager;

    private double revenue;

    private boolean closed = false;
    private double prevRev;

    public Division(DivisionIdentifier div) {
        lock = new ReentrantLock();
        prevRev = 0;
        revenue = 0;
        this.nrOfManagers = 1;
        this.divID = div;
        this.revenue = 0;
        this.nrOfHiredEmps = 0;
    }

    @Override
    public void run() {
        Thread thread = new Thread(manager);
        thread.run();
        while (!closed) {
            if (manager.isFired()) {
                String ID = (nrOfManagers++ + divID.getName());
                HiringStrategy hiring = divID.getHiring();
                manager = new Manager(ID, hiring, this);
                System.out.println(divID.getName() + " hired a new manager: " + manager);
            }
            addRevenue(getRevenueFromEmployees());
        }
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

    public double getRevenueFromEmployees() {
        double totalRev = 0;
        for (Employee emp : employees) {
            totalRev += emp.getCurrentWork();
        }
        prevRev = revenue;
        revenue = totalRev;
        return totalRev;
    }

    public ArrayList<Employee> getEmps() {
        return employees;
    }

    public int getMax() {
        return divID.getMaximum();
    }

    public int getMin() {
        return divID.getMinimum();
    }

    public int getNextEmpNR() {
        nrOfHiredEmps++;
        return nrOfHiredEmps;
    }


    private void addRevenue(double revenueFromEmployees) {
        lock.lock();
        try {
            revenue += revenueFromEmployees;
        } finally {
            lock.unlock();
        }
    }

    public double growth() {
        return revenue / prevRev;
    }
    
    public Manager getMan(){
        return manager;
    }
    
    @Override
    public String toString(){
        return divID.getName();
    }
}
