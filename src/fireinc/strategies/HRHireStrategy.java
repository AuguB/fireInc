package fireinc.strategies;

import fireinc.enums.Gender;
import fireinc.workers.Employee;
import static java.lang.Math.random;

public class HRHireStrategy implements HiringStrategy {

    private final String DivID = "HR";
    private final int nrOfQualities = 6;

    @Override
    public boolean isSkilledEnough(Employee emp, double managerThreshold) {
        double sum = (random() - 0.5);
        sum += square(emp.getSocial());
        sum += square(emp.getLooks());
        sum += square(emp.getLoyalty());
        sum += square(emp.getExperience());
        sum += square(emp.getKitchening());
        sum += square(emp.getCleanliness());
        if (emp.getGender() == Gender.FEMALE) {
            sum += 0.8;
        }
        double length = Math.sqrt(sum);
        return (length > (managerThreshold * Math.sqrt(nrOfQualities)));
    }

    @Override
    public Employee getEmployee(int ID) {

        return new Employee(DivID + "-" + ID);

    }

}
