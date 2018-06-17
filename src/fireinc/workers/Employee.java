package fireinc.workers;

import static fireinc.NameGenerator.NameGenerator.*;
import static fireinc.Settings.*;
import fireinc.enums.Gender;
import fireinc.visitors.Visitor;
import static java.lang.Math.random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Employee<E> implements Runnable {

    protected String name;
    protected Lock lock;
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
    protected int attemptsToFire;
    protected boolean fired;
    protected boolean needsCoffee;
    private double salary;

    public Employee(String ID) {
        this(ID, 0.5);
    }

    public Employee(String ID, double preference) {
        this.lock = new ReentrantLock();
        this.ID = ID;
        if (random() > preference) {
            this.gender = Gender.MALE;
        } else {
            this.gender = Gender.FEMALE;
        }
        this.name = NAME_GENERATOR.generateName(gender).toString();
        fired = false;
        needsCoffee = false;
        attitude = .4;
        currentWork = 0;
        workDone = 0;
        makeRandomAttributes();
    }

    public int getAttemptsToFire() {
        lock.lock();
        try {
            return attemptsToFire;
        } finally {
            lock.unlock();
        }
    }

    public void increaseAttemptsToFire() {
        lock.lock();
        try {
            this.attemptsToFire++;
        } finally {
            lock.unlock();
        }
    }

    public int getMistakes() {
        lock.lock();
        try {
            return mistakes;
        } finally {
            lock.unlock();
        }
    }

    public E accept(Visitor v) {
        return null;
    }

    public double getCurrentWork() {
        lock.lock();
        try {
            workDone += currentWork;
            double temp = currentWork;
//        currentWork = 0;
            return temp;
        } finally {
            lock.unlock();
        }
    }

    public void run() {
    }

    public double getAverageWork() {
        lock.lock();
        try {
            return (workDone + currentWork) / days;
        } finally {
            lock.unlock();
        }
    }

    public double getWorkDone() {
        lock.lock();
        try {
            return workDone;
        } finally {
            lock.unlock();
        }
    }

    public double getDays() {
        lock.lock();
        try {
            return days;
        } finally {
            lock.unlock();
        }
    }

    public void decreaseFear() {
        lock.lock();
        if (getAttitude() > 0) {
            setAttitude(getAttitude() - 0.0001);
        }
        lock.unlock();
    }

    public boolean hasCar() {
        return false;
    }

    public double getSalary() {
        lock.lock();
        try {
            return salary;
        } finally {
            lock.unlock();
        }
    }

    public boolean hasOffice() {
        return false;
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
        lock.lock();
        try {
            return name;
        } finally {
            lock.unlock();
        }
    }

    public String getID() {
        lock.lock();
        try {
            return ID;
        } finally {
            lock.unlock();
        }
    }

    public double getSkill() {
        lock.lock();
        try {
            return skill;
        } finally {
            lock.unlock();
        }
    }

    public Gender getGender() {
        return gender;
    }

    public double getPunctuality() {
        lock.lock();
        try {
            return punctuality;
        } finally {
            lock.unlock();
        }
    }

    public double getCleanliness() {
        lock.lock();
        try {
            return cleanliness;
        } finally {
            lock.unlock();
        }
    }

    public double getSocial() {
        lock.lock();
        try {
            return social;
        } finally {
            lock.unlock();
        }
    }

    public double getLoyalty() {
        lock.lock();
        try {
            return loyalty;
        } finally {
            lock.unlock();
        }
    }

    public double getLooks() {
        lock.lock();
        try {
            return looks;
        } finally {
            lock.unlock();
        }
    }

    public double getWorkethics() {
        lock.lock();
        try {
            return workethics;
        } finally {
            lock.unlock();
        }
    }

    public double getExperience() {
        lock.lock();
        try {
            return experience;
        } finally {
            lock.unlock();
        }
    }

    public double getKitchening() {
        lock.lock();
        try {
            return kitchening;
        } finally {
            lock.unlock();
        }
    }

    public boolean isFired() {
        lock.lock();
        try {
            return isFired();
        } finally {
            lock.unlock();
        }
    }

    public void YouAreFired() {
        lock.lock();
        try {
            fired = true;
        } finally {
            lock.unlock();
        }
    }

    public boolean isNeedsCoffee() {
        lock.lock();
        try {
            return needsCoffee;
        } finally {
            lock.unlock();
        }
    }

    public void setSkill(double skill) {
        lock.lock();
        try {
            this.skill = skill;
        } finally {
            lock.unlock();
        }
    }

    public void setPunctuality(double punctuality) {
        lock.lock();
        try {
            this.punctuality = punctuality;
        } finally {
            lock.unlock();
        }
    }

    public void setCleanliness(double cleanliness) {
        lock.lock();
        try {
            this.cleanliness = cleanliness;
        } finally {
            lock.unlock();
        }
    }

    public void setSocial(double social) {
        lock.lock();
        try {
            this.social = social;
        } finally {
            lock.unlock();
        }
    }

    public void setLoyalty(double loyalty) {
        lock.lock();
        try {
            this.loyalty = loyalty;
        } finally {
            lock.unlock();
        }
    }

    public void setWorkethics(double workethics) {
        lock.lock();
        try {
            this.workethics = workethics;
        } finally {
            lock.unlock();
        }
    }

    public void setWorkDone(double workDone) {
        lock.lock();
        try {
            this.workDone = workDone;
        } finally {
            lock.unlock();
        }
    }

    public void setMistakes(int mistakes) {
    lock.lock();
        try {
            this.mistakes = mistakes;
        } finally {
            lock.unlock();
        }
}

    public void setNeedsCoffee(boolean needsCoffee) {
        lock.lock();
        try {
            this.needsCoffee = needsCoffee;
        } finally {
            lock.unlock();
        }
    }

    public void setKitchening(double kitchening) {
        lock.lock();
        try {
            this.kitchening = kitchening;
        } finally {
            lock.unlock();
        }
    }

    public double getPrecision() {
        lock.lock();
        try {
            return (skill + experience) / 2;
        } finally {
            lock.unlock();
        }
    }

    public double getAttitude() {
        lock.lock();
        try {
            return attitude;
        } finally {
            lock.unlock();
        }
    }

    public void setAttitude(double attitude) {
        lock.lock();
        try {
            this.attitude = attitude;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        lock.lock();
        try {
            return name + " " + ID;
        } finally {
            lock.unlock();
        }
    }
}
