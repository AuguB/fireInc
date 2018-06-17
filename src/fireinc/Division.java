package fireinc;

import fireinc.enums.DivisionIdentifier;
import fireinc.strategies.HiringStrategy;
import fireinc.visitors.FireVisitor;
import fireinc.workers.Employee;
import fireinc.workers.Manager;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Division implements Runnable {

    private DivisionIdentifier divID;
    private Lock lock;
    private int nrOfHiredEmps;
    private int nrOfManagers;
    private ArrayList<Employee> employees;

    private Manager manager;

    private volatile double revenue;

    private boolean closed;
    private volatile double prevRev;

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
        Thread newThread = new Thread(manager);
        newThread.start();
        while (!closed) {
            if (manager.isFired()) {
                String ID = (nrOfManagers++ + divID.getCode());
                HiringStrategy hiring = divID.getHiring();
                manager = new Manager(ID, hiring, this);
                System.out.println(divID.getCode() + " hired a new manager: " + manager);
                newThread = new Thread(manager);
                newThread.start();
            }
//            System.out.println(revenue+" made by "+divID.getName());
        }
    }

    public double getAverageWork() {
        lock.lock();
        try {
            double sum = 0;
            sum = employees.stream().map((e) -> (e.getCurrentWork() + e.getWorkDone())).reduce(sum, (accumulator, _item) -> accumulator + _item);
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
            for (int x = 0; x < employees.size(); x++) {
                try {
                    totalRev += employees.get(x).getCurrentWork();
                } catch (NullPointerException e) {
                }
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

    public void addRevenue(double revenueFromEmployees) {
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
            double growth = revenue / prevRev;
//            System.out.println(revenue + "Revenue");
//            System.out.println(prevRev + "Previously");
//            System.out.println(growth);
            return growth;
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
            return divID.getCode();
        } finally {
            lock.unlock();
        }
    }

    public String getName() {
        lock.lock();
        try {
            return divID.getName();
        } finally {
            lock.unlock();
        }
    }
}
