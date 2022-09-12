package softnerve.tech.assement;

public class LeaderInTheArray {
    public static int getLeaderInTheArray(int[] array){
        if(array.length == 0 || array.length == 1) return 0;
        int largestNumber = array[0];
        for(int element: array){
            if(largestNumber<element){
                largestNumber=element;
            }
        }
        return largestNumber;
    }
}
