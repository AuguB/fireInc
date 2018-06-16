package fireinc.strategies;

import fireinc.workers.Coder;
import fireinc.workers.Employee;

public class ProductionHireStrategy implements HiringStrategy {

    private String DivID = "PRO";


    public boolean isSkilledEnough(Employee emp) {
        double skillSquare = square(emp.getSkill());
        double punctualitySquare = square(emp.getPunctuality());
        double workethicsSquare = square(emp.getWorkethics());
        double experienceSquare = square(emp.getExperience());
        double socialSquare = square(emp.getSocial());
        
        double length = 
        
    }

    @Override
    public Employee getEmployee(int ID) {
        
    }
    
    
}
