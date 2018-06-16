package fireinc.strategies;

import fireinc.workers.Coder;
import fireinc.workers.Employee;

public class ProductionHireStrategy implements HiringStrategy {

    private String DivID = "PRO";


    public boolean isSkilledEnough(Employee current) {
        return false;
    }

    @Override
    public Employee getEmployee(int ID) {
        
    }
}
