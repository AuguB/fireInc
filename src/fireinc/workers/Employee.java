package fireinc.workers;

import fireinc.enums.Gender;
import java.lang.Runnable;
import fireinc.visitors.Visitor;
import static java.lang.Math.random;

public class Employee<E> implements Runnable {

    protected String name;
    protected String ID;
    protected double skill;
    protected Gender gender;
    protected double punctuality;
    protected double cleanliness;
    protected double social;
    protected double loyalty;
    protected double looks;
    protected double workethics;
    protected double experience;
    protected double kitchening;
    protected double workDone; 
    protected double attitude;
    protected int days;
    protected int mistakes;
    protected boolean fired;
    protected boolean needsCoffee;

    public Employee(String ID) {
        this.name = name;
        this.ID = ID;
        if (random() > 0.5) {
            this.gender = Gender.FEMALE;
        }
        fired = false;
        needsCoffee = false;
        attitude = .4;
        makeRandomAttributes();
    }

    public E accept(Visitor v) {
        return null;
    }

    public void run() {

    }

    public double results() {
        return workDone / days;
    }

    public void decreaseFear() {
        if (attitude > 0) {
            attitude -= 0.0001;
        }
    }

    private void makeRandomAttributes() {
        this.setCleanliness(random());
        this.experience = random();
        this.kitchening = random();
        this.looks = random();
        this.setLoyalty(random());
        this.setPunctuality(random());
        this.setSkill(random());
        this.setSocial(random());
        this.setWorkethics(random());
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

    public void YouAreFired() {
        fired = true;
    }
    
    public boolean isNeedsCoffee() {
        return needsCoffee;
    }

    public void setSkill(double skill) {
        this.skill = skill;
    }

    public void setPunctuality(double punctuality) {
        this.punctuality = punctuality;
    }

    public void setCleanliness(double cleanliness) {
        this.cleanliness = cleanliness;
    }

    public void setSocial(double social) {
        this.social = social;
    }

    public void setLoyalty(double loyalty) {
        this.loyalty = loyalty;
    }

    public void setWorkethics(double workethics) {
        this.workethics = workethics;
    }

    public void setWorkDone(double workDone) {
        this.workDone = workDone;
    }
    
    public void setMistakes(int mistakes) {
        this.mistakes = mistakes;
    }

    public void setNeedsCoffee(boolean needsCoffee) {
        this.needsCoffee = needsCoffee;
    }

}
