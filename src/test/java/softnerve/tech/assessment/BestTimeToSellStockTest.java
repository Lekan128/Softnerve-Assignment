package softnerve.tech.assessment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestTimeToSellStockTest {

    @Test
    void maximumProfitFromListOfStockPrices() {
        assertEquals( BestTimeToSellStock.maximumProfitFromListOfStockPrices(new int[]{7,1,5,3,6,4}), 5);
        assertEquals( BestTimeToSellStock.maximumProfitFromListOfStockPrices(new int[]{7,6,4,3,1}), 0);
        Integer.parseInt(String.valueOf('n'));
    }
}