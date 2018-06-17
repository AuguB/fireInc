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

    FINANCE(FINMIN, FINMAX, "FIN", "Finance", new FinanceHireStrategy()),
    PRODUCTION(PRODMIN, PRODMAX, "PROD", "Production", new ProductionHireStrategy()),
    CATERING(CATMIN, CATMAX, "CAT", "Catering", new CaterHireStrategy()),
    HR(HRMIN, HRMAX, "HR", "Human Resources", new HRHireStrategy());

    private final int minimum;
    private final int maximum;
    private final String code;
    private final HiringStrategy hiring;
    private final String name;

    DivisionIdentifier(int min, int max, String code, String name, HiringStrategy hiring) {
        this.minimum = min;
        this.maximum = max;
        this.code = code;
        this.hiring = hiring;
        this.name = name;
    }

    public int getMinimum() {
        return minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public String getCode() {
        return code;
    }

    public HiringStrategy getHiring() {
        return hiring;
    }
    
    public String getName(){
        return name;
    }
}
