package fireinc.workers;

import fireinc.visitors.Visitor;

public class Intern<E> extends Employee {

    public Intern(String ID) {
        super(ID);
    }

    public void run() {
    }

    @Override
    public E accept(Visitor v) {
        return (E) v.visit(this);
    }

    public void print(int amount) {
    }

    public void work() {
    }
}
