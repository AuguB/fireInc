package fireinc.strategies;

import fireinc.workers.Coder;
import fireinc.workers.Employee;
import static java.lang.Math.random;

public class ProductionHireStrategy implements HiringStrategy {

    private String DivID = "PRO";
    private int nrOfQualities = 5;

    public boolean isSkilledEnough(Employee emp, double managerThreshold) {
        double sum = (random() - 0.5);
        sum += square(emp.getSkill());
        sum += square(emp.getPunctuality());
        sum += square(emp.getWorkethics());
        sum += square(emp.getExperience());
        sum += square(emp.getSocial());
        double length = Math.sqrt(sum);
        return (length > (managerThreshold * Math.sqrt(nrOfQualities)));
    }

    @Override
    public Employee getEmployee(int ID) {
        return null;
    }
}
