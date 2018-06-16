package fireinc.workers;

import fireinc.visitors.Visitor;

public class Intern extends Employee {

    public void run() {
    }

    public Visitor accept(Visitor v) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void print(int amount) {
    }

    public void work() {
    }
}
