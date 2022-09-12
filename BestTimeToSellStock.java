package softnerve.tech.assement;

public class BestTimeToSellStock {
    public static int maximumProfitFromListOfStockPrices(int[] listOfPricesPerDay){
        if(listOfPricesPerDay.length ==0 || listOfPricesPerDay.length ==1) return 0;
        int currentSmallest = listOfPricesPerDay[0];
        int currentLargest = 0;
        int maxProfit = 0;
        for(int currentPrice: listOfPricesPerDay){
            //if the smallest is bigger then the new one, the new one is the current smallest
            //if (maxProfit < currentPrice-currentSmallest ) maxProfit = currentPrice-currentSmallest
            if (maxProfit < currentPrice-currentSmallest ) maxProfit = currentPrice-currentSmallest;
            if(currentSmallest>currentPrice){
                currentSmallest = currentPrice;
            }
        }
        return maxProfit;
    }
}
