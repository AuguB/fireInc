package fireinc.strategies;

import fireinc.workers.Accountant;
import fireinc.workers.Caterer;
import fireinc.workers.Employee;
import fireinc.workers.Intern;
import static java.lang.Math.random;

public class FinanceHireStrategy implements HiringStrategy {

    private final String DivID = "FIN";
    private final int nrOfQualities = 4;

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
        double randomEmp = random();
        if (randomEmp > 0.75) {
            return new Accountant(DivID + "-" + ID);
        } else {
            return new Intern(DivID + "-" + ID);
        }
    }

}
