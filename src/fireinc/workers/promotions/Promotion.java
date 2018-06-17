package fireinc.workers.promotions;

import fireinc.visitors.Visitor;
import fireinc.workers.Employee;

public class Promotion<E> extends Employee {

    protected Employee employee;

    public Promotion(String ID) {
        super(ID);
    }

    public E accept(Visitor v) {
        return (E) v.visit(this);
    }
    
    @Override
    public boolean hasCar(){
        return employee.hasCar();
    }
    
    @Override
    public boolean hasOffice(){
        return employee.hasCar();
    }

    @Override
    public void run() {
        Thread thread = new Thread(employee);
        thread.start();
    }

    public Employee getEmp() {
        return employee;
    }
}
