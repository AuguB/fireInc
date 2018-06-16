package fireinc.workers;

import fireinc.enums.Gender;
import java.lang.Runnable;
import fireinc.visitors.Visitor;
import static java.lang.Math.random;

public class Employee<E> implements Runnable {

    private String name;
    private String ID;
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
    private double workDone;
    private int days;
    private int mistakes;
    protected boolean fired;
    private boolean needsCoffee;

    public Employee(String ID) {
        this.name = name;
        this.ID = ID;
        if (random() > 0.5) {
            this.gender = Gender.FEMALE;
        }
        fired = false;
        needsCoffee = false;
        makeRandomAttributes();
    }

    public E accept(Visitor v) {
        return null;
    }

    public void run() {
        
    }

    private void makeRandomAttributes() {
        this.cleanliness = random();
        this.experience = random();
        this.kitchening = random();
        this.looks = random();
        this.loyalty = random();
        this.punctuality = random();
        this.skill = random();
        this.social = random();
        this.workethics = random();
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public double getSkill() {
        return skill;
    }

    public Gender getGender() {
        return gender;
    }

    public double getPunctuality() {
        return punctuality;
    }

    public double getCleanliness() {
        return cleanliness;
    }

    public double getSocial() {
        return social;
    }

    public double getLoyalty() {
        return loyalty;
    }

    public double getLooks() {
        return looks;
    }

    public double getWorkethics() {
        return workethics;
    }

    public double getExperience() {
        return experience;
    }

    public double getKitchening() {
        return kitchening;
    }

    public boolean isFired() {
        return fired;
    }

    public boolean isNeedsCoffee() {
        return needsCoffee;
    }

}
