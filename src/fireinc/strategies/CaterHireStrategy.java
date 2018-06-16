package fireinc.strategies;

import fireinc.enums.Gender;
import fireinc.workers.Employee;
import static java.lang.Math.random;

public class CaterHireStrategy implements HiringStrategy {

    private String DivID = "CAT";
    private int nrOfQualities = 6;

    @Override
    public boolean isSkilledEnough(Employee emp, double managerThreshold) {
        double sum = (random() - 0.5);
        sum += square(emp.getKitchening());
        sum += square(emp.getLooks());
        sum += square(emp.getCleanliness());
        sum += square(emp.getWorkethics());
        sum += square(emp.getExperience());
        sum += square(emp.getSkill());
        if (emp.getGender() == Gender.FEMALE) {
            sum += 1;
        }
        double length = Math.sqrt(sum);
        return (length > (managerThreshold * Math.sqrt(nrOfQualities)));
    }

    @Override
    public Employee getEmployee(int ID) {
        return new Employee(DivID + "-" + ID);
    }

}
