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

    private boolean closed;
    private double prevRev;

    public Division(DivisionIdentifier div) {
        closed = false;
        employees = new ArrayList<Employee>();
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
        thread.start();
        Thread newThread = new Thread(manager);
        newThread.start();
        while (!closed) {
            if (manager.isFired()) {
                String ID = (nrOfManagers++ + divID.getName());
                HiringStrategy hiring = divID.getHiring();
                manager = new Manager(ID, hiring, this);
                System.out.println(divID.getName() + " hired a new manager: " + manager);
                newThread = new Thread(manager);
                newThread.start();
            }
            addRevenue(getRevenueFromEmployees());
//            System.out.println(revenue+" made by "+divID.getName());
        }
    }

    public double getAverageWork() {
        lock.lock();
        try {
            double sum = 0;
            for (Employee e : employees) {
                sum += (e.getCurrentWork() + e.getWorkDone());
            }
            sum = sum / employees.size();
            return sum;
        } finally {
            lock.unlock();
        }
    }

    public void setManager(Manager man) {
        lock.lock();
        try {
            this.manager = man;
        } finally {
            lock.unlock();
        }
    }

    public double getRevenueFromEmployees() {
        lock.lock();
        try {
            double totalRev = 0;
            for (Employee emp : employees) {
                totalRev += emp.getCurrentWork();
            }
            prevRev = revenue;
            revenue = totalRev;
            return totalRev;
        } finally {
            lock.unlock();
        }
    }

    public ArrayList<Employee> getEmps() {
        lock.lock();
        try {
            return employees;
        } finally {
            lock.unlock();
        }
    }

    public int getMax() {
        lock.lock();
        try {
            return divID.getMaximum();
        } finally {
            lock.unlock();
        }
    }

    public int getMin() {
        lock.lock();
        try {
            return divID.getMinimum();
        } finally {
            lock.unlock();
        }
    }

    public int getNextEmpNR() {
        lock.lock();
        try {
            nrOfHiredEmps++;
            return nrOfHiredEmps;
        } finally {
            lock.unlock();
        }
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
        lock.lock();
        try {
            return revenue / prevRev;
        } finally {
            lock.unlock();
        }
    }

    public Manager getMan() {
        lock.lock();
        try {
            return manager;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        lock.lock();
        try {
            return divID.getName();
        } finally {
            lock.unlock();
        }
    }
}
