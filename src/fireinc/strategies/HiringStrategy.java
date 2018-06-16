package fireinc.strategies;

import fireinc.workers.Coder;
import fireinc.workers.Employee;

public interface HiringStrategy {
    
    public default Employee hire(int ID){
        boolean hired = false;
        Employee current = getEmployee(ID);
        while(!hired){
            current = new Coder("P1");
            if(isSkilledEnough(current))
                hired = true;
        }
        return current;
    }
    public boolean isSkilledEnough(Employee emp);
    public Employee getEmployee(int ID);
    public default double square(double doub){
        return doub*doub;
    }
}
