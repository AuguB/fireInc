package fireinc;

public class Printer {
    private int ID;
    private boolean occupied;
    public Printer(int ID){
        this.ID = ID;
    }
    
    public boolean getPrinterOcc() {
        return isOccupied();
    }
    
    public void setPrinterOcc(boolean use) {
        setOccupied(use);
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
        this.occupied = occupied;
    }
}
