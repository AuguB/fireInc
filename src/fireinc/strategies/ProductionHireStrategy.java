package fireinc.strategies;

import fireinc.workers.Coder;
import fireinc.workers.Designer;
import fireinc.workers.Employee;
import fireinc.workers.Intern;
import fireinc.workers.Tester;
import static java.lang.Math.random;

public class ProductionHireStrategy implements HiringStrategy {

    private final String DivID = "PRO";
    private final int nrOfQualities = 5;

    @Override
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
        double randomEmp = random();
        if (randomEmp < 0.32) {
            return new Tester(DivID + "-" + ID);
        } else if (randomEmp < 0.64) {
            return new Coder(DivID + "-" + ID);
        } else if (randomEmp < 0.85) {
            return new Designer(DivID + "-" + ID);
        } else {
            return new Intern(DivID + "-" + ID);
        }
    }
}
