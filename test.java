package softnerve.tech.assement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test {

  @Test
    void getLeaderInTheArray() {
        assertEquals(LeaderInTheArray.getLeaderInTheArray(new int[] {7, 10, 4, 10, 6, 5, 2}), 10);
        //10 is on the right side of the array and  is bigger than 7
        assertNotEquals(LeaderInTheArray.getLeaderInTheArray(new int[] {7, 10, 4, 10, 6, 5, 2}), 7);
    }
  
    @Test
    void maximumProfitFromListOfStockPrices() {
        assertEquals( BestTimeToSellStock.maximumProfitFromListOfStockPrices(new int[]{7,1,5,3,6,4}), 5);
        assertEquals( BestTimeToSellStock.maximumProfitFromListOfStockPrices(new int[]{7,6,4,3,1}), 0);

    }
  
  @Test
    void sumOfAllSubsetXOrTotals() {
        double xOrSum = SumOfAllSubsetXOrTotals.sumOfAllSubsetXOrTotals(new Integer[]{5,1,6});
        assertEquals(xOrSum, 28);

    }
  
}
