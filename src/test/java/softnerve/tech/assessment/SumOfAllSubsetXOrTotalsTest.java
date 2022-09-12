package softnerve.tech.assessment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfAllSubsetXOrTotalsTest {

    @Test
    void sumOfAllSubsetXOrTotals() {
        double xOrSum = SumOfAllSubsetXOrTotals.sumOfAllSubsetXOrTotals(new Integer[]{5,1,6});
        assertEquals(xOrSum, 28);

    }
}