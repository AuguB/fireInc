/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fireinc.enums;

import static fireinc.Settings.*;
import fireinc.strategies.CaterHireStrategy;
import fireinc.strategies.FinanceHireStrategy;
import fireinc.strategies.HRHireStrategy;
import fireinc.strategies.HiringStrategy;
import fireinc.strategies.ProductionHireStrategy;

/**
 *
 * @author guus
 */
public enum DivisionIdentifier {

    FINANCE(FINMIN, FINMAX, "FIN", new FinanceHireStrategy()),
    PRODUCTION(PRODMIN, PRODMAX, "PROD", new ProductionHireStrategy()),
    CATERING(CATMIN, CATMAX, "CAT", new CaterHireStrategy()),
    HR(HRMIN, HRMAX, "HR", new HRHireStrategy());

    private final int minimum;
    private final int maximum;
    private final String name;
    private final HiringStrategy hiring;

    DivisionIdentifier(int min, int max, String name, HiringStrategy hiring) {
        this.minimum = min;
        this.maximum = max;
        this.name = name;
        this.hiring = hiring;
    }

    public int getMinimum() {
        return minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public String getName() {
        return name;
    }
    
    public HiringStrategy getHiring(){
        return hiring;
    }
}
