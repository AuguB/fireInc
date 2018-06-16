package fireinc.strategies;

import fireinc.workers.Employee;

public interface HiringStrategy {
    
    public default Employee hire(int ID, double managerThreshold){
        boolean hired = false;
        Employee current = null;
        while(!hired){
            current = getEmployee(ID);
            if(isSkilledEnough(current, managerThreshold))
                hired = true;
        }
        return current;
    }
    public boolean isSkilledEnough(Employee emp, double managerThreshold);
    public Employee getEmployee(int ID);
    public default double square(double doub){
        return doub*doub;
    }
}
