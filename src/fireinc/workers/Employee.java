package fireinc.workers;

import fireinc.enums.Gender;
import java.lang.Runnable;
import fireinc.visitors.Visitor;

public class Employee implements Runnable {

    private String name;

    private int ID;

    private double skill;

    private Gender gender;

    private double punctuality;

    private double cleanliness;

    private double social;

    private double loyalty;

    private double looks;

    private double workethics;

    private double experience;

    private double kitchening;

    private boolean fired;

    private boolean needsCoffee;

    public Visitor accept(Visitor v) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void run() {
    }
}
