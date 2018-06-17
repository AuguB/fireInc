/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fireinc.enums;

import static fireinc.Settings.*;

/**
 *
 * @author guus
 */
public enum DivisionIdentifier {

    FINANCE(FINMIN, FINMAX, "FIN"),
    PRODUCTION(PRODMIN, PRODMAX, "PROD"),
    CATERING(CATMIN, CATMAX, "CAT"),
    HR(HRMIN, HRMAX, "HR");

    private final int minimum;
    private final int maximum;
    private final String name;

    DivisionIdentifier(int min, int max, String name) {
        this.minimum = min;
        this.maximum = max;
        this.name = name;
    }

    public int getMinimum() {
        return minimum;
    }

    public int getMaximum() {
        return maximum;
    }
}
