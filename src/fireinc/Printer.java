package fireinc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Printer {

    private int ID;
    private boolean occupied;
    private Lock lock;
    private Condition isFree, isOccupied;

    public Printer(int ID) {
        this.ID = ID;
        lock = new ReentrantLock();
        isFree = lock.newCondition();
        isOccupied = lock.newCondition();
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @return the occupied
     */
    public boolean isOccupied() {
        return occupied;
    }

    /**
     * @param occupied the occupied to set
     */
    public void setOccupied(boolean occupied) {

        lock.lock();

        this.occupied = occupied;

        lock.unlock();

    }
}
