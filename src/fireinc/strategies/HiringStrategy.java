package fireinc.strategies;

import fireinc.workers.Coder;
import fireinc.workers.Employee;

public interface HiringStrategy {

    public String getDivisionID();
    
    public default Employee hire(int ID){
        boolean hired = false;
        Employee current = new Coder("John", this.getDivisionID()+ID);
        while(!hired){
            current = new Coder("John", "P1");
            if(isSkilledEnough(current))
                hired = true;
        }
        return current;
    }
    public boolean isSkilledEnough(Employee emp);
}
