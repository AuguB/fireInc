package fireinc.workers;

import fireinc.visitors.Visitor;

public class Intern<E> extends Employee {

    public Intern(String ID) {
        super(ID);
    }

    public void run() {
         while (!fired) {
            days++;
            try {
                work();
                Thread.sleep(200); //lunchbreak
                work();
                Thread.sleep(1000); //sleep
            } catch (InterruptedException ex) {
            }
        }
    }

    @Override
    public E accept(Visitor v) {
        return (E) v.visit(this);
    }

    public void print(int amount) {
    }

    
    public void work() {
        double result = 0;
        result += skill 
               += cleanliness
               += social
               += loyalty
               += experience 
               += kitchening
               += looks
               += 0.5-Math.abs(0.5-getAttitude());
        
        if(experience < 1)
            experience += 0.001;
        if(skill < 1)
            skill += 0.001;
        
        result /= 8.5;
        
        if(result < 0.5)
            mistakes++;
        
        decreaseFear();
        
        currentWork += result;
    }
}
