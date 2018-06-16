package fireinc.workers;

import fireinc.visitors.Visitor;

public class Designer<E> extends Employee {

    public Designer( String ID) {
        super(ID);
    }

    public void run() {
    }

    public E accept(Visitor v){
        return (E) v.visit(this);
    }

    public void work() {
    }
}
