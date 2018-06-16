package fireinc.strategies;

import fireinc.workers.Employee;
import static java.lang.Math.random;

public class CaterHireStrategy implements HiringStrategy {

    private String DivID = "CAT";
    private int nrOfQualities = 4;

    @Override
    public boolean isSkilledEnough(Employee emp, double managerThreshold) {
        double sum = (random() - 0.5);
        sum += square(emp.getPunctuality());
        sum += square(emp.getLoyalty());
        sum += square(emp.getCleanliness());
        sum += square(emp.getWorkethics());
        double length = Math.sqrt(sum);
        return (length > (managerThreshold * Math.sqrt(nrOfQualities)));
    }

    @Override
    public Employee getEmployee(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
