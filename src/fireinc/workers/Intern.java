package fireinc.workers;

import fireinc.visitors.Visitor;

public class Intern<E> extends Employee {

    public Intern(String name, String ID) {
        super(ID);
    }

    public void run() {
         while (!fired) {
            days++;
            try {
                work();
                Thread.sleep(300); //lunchbreak
                work();
                Thread.sleep(2000); //sleep
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
               += 2*looks;
        
        if(experience < 1)
            experience += 0.01;
        if(skill < 1)
            skill += 0.01;
        if(result < 0.6)
            mistakes++;
        
        
        
    }
}
