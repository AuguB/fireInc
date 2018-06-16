package fireinc.strategies;

import fireinc.workers.Coder;
import fireinc.workers.Employee;

public class ProductionHireStrategy implements HiringStrategy {

    String DivID = "P";

    public Employee hire(int ID) {
        boolean hired = false;
        Employee current = new Coder("John", "P" + ID);
        while (!hired) {
            current = new Coder("John", "P1");
            if (isSkilledEnough(current)) {
                hired = true;
            }
        }
        return current;
    }

    public boolean isSkilledEnough(Employee current) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDivisionID() {
        return DivID;
    }
}
