package fireinc.workers;

import fireinc.visitors.Visitor;

public class Promotion<E> extends Employee {

    private Employee employee;

    public Promotion( String ID) {
        super(ID);
    }

    public E accept(Visitor v) {
        return (E) v.visit(this);
    }
    @Override
    public void run(){
        Thread thread = new Thread(employee);
        thread.start();
    }
}
