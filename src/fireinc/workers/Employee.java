package fireinc.workers;

import fireinc.Company;
import static fireinc.NameGenerator.NameGenerator.*;
import fireinc.NameGenerator.Name;
import fireinc.NameGenerator.NameGenerator;
import fireinc.enums.Gender;
import fireinc.visitors.Visitor;
import static java.lang.Math.random;

public abstract class Employee<E> implements Runnable {

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
    protected double currentWork;
    protected double attitude;
    protected int days;
    protected int mistakes;
    protected boolean fired;
    protected boolean needsCoffee;

    public Employee(String ID) {
        this(ID, 0.5);
    }

    public Employee(String ID, double preference) {
        this.ID = ID;
        if (random() > preference) {
            this.gender = Gender.MALE;
        } else {
            this.gender = Gender.FEMALE;
        }
        this.name = generateName(gender).toString();
        fired = false;
        needsCoffee = false;
        attitude = .4;
        makeRandomAttributes();
    }

    public E accept(Visitor v) {
        return null;
    }

    public double getCurrentWork() {
        workDone += currentWork;
        double temp = currentWork;
        currentWork = 0;
        return temp;
    }

    public void run() {
    }

    public double results() {
        return workDone / days;
    }

    public void decreaseFear() {
        if (getAttitude() > 0) {
            setAttitude(getAttitude() - 0.0001);
        }
    }

    private void makeRandomAttributes() {
        this.cleanliness = randomNormal();
        this.experience = randomNormal();
        this.kitchening = randomNormal();
        this.looks = randomNormal();
        this.loyalty = randomNormal();
        this.punctuality = randomNormal();
        this.skill = randomNormal();
        this.social = randomNormal();
        this.workethics = randomNormal();
    }

    protected double randomNormal() {
        return (random() + random()) / 2;
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
    
    public void setKitchening(double kitchening) {
        this.kitchening = kitchening;
    }
    
    public int getMistakes() {
        return mistakes;
    }
            
    public double getPrecision() {
        return (skill+experience)/2;
    }

    /**
     * @return the attitude
     */
    public double getAttitude() {
        return attitude;
    }

    /**
     * @param attitude the attitude to set
     */
    public void setAttitude(double attitude) {
        this.attitude = attitude;
    }
}
