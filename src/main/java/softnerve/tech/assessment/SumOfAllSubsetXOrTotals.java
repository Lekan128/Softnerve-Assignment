package softnerve.tech.assessment;

import java.util.ArrayList;
import java.util.List;

public class SumOfAllSubsetXOrTotals {

    public static double sumOfAllSubsetXOrTotals(Integer[] array) {
        double sum = 0;
        ArrayList<Integer[]> listOfSubsetOfArray = new ArrayList<>();
        findSubsets(listOfSubsetOfArray, array, new ArrayList<>(), 0);
        for (Integer[] subset : listOfSubsetOfArray) {
            System.out.println(xOrAdditionOfAnArray(subset));
            sum += xOrAdditionOfAnArray(subset);
        }
        return sum;
    }

    public static ArrayList<Integer[]> getAllSubsetOfArray1(Integer[] array){
        /*
        * if the array is empty return empty array
        * if two or more
        *   add empty array
        *   add each single element
        *   Use first element to add the ones in front of it to make arrays with 2 elements
        *       then second, third and for the last element don't add it because there's nothing in-front
        *   Use the first two elements to add each of the elements in front if there, then the next two elements
        *       until the last two elements without an additional element in-front
        *   ... the loop:
        *   Use the first N elements to add each of the elements in-front of it to make N+1 elements,
        *       then the next N elements until there is no N+1 element
        *
        *  */

        /*
        * go through each required length from 2 upwards
        *   //the last element will have the index currentRequiredLength-1
        *   while(firstElementIndex+currentRequiredLength-1)
        *   take the firstElementIndex till firstElementIndex+currentRequiredLength-2 add it to subsetArrayList
        *       lastElementIndex = firstElementIndex+currentRequiredLength-1
        *       while(lastElementIndex<array.length)
        *           subsetArrayList.add(array[lastElementIndex])
        *           //now it has gotten to the required length
        *           listOfSubsets.add(subsetArrayList as array)
        *           subsetArrayList.remove(subsetArrayList.size()-1)
        *           ++lastElementIndex
        *       subsetArrayList.add(Array)
        * */
        ArrayList<Integer[]> listOfSubsets = new ArrayList<>();
        listOfSubsets.add(new Integer[]{});
        for(int element : array){
            listOfSubsets.add(new Integer[]{element});
        }
        for(int currentRequiredLength = 2; currentRequiredLength<=array.length; ++currentRequiredLength){//currentRequiredLength is used to get the length that used be used
            int firstElementIndex = 0;
            //add first 0-firstElementIndex elements
            while (firstElementIndex+currentRequiredLength-1<array.length){
                ArrayList<Integer> subsetArrayList = new ArrayList<>();
                //get element from firstElementIndex to firstElementIndex+currentRequiredLength
                //adding from firstElementIndex till firstElementIndex+currentRequiredLength-2
                int lastElementIndex = firstElementIndex+currentRequiredLength-1;
                for (int elementIndex = firstElementIndex; elementIndex<lastElementIndex ; ++elementIndex){
                    subsetArrayList.add(array[elementIndex]);
                }
                while (lastElementIndex<array.length){
                    subsetArrayList.add(array[lastElementIndex]);
                    //now it has gotten to the required length
                    listOfSubsets.add(turnArrayListIntoArray(subsetArrayList));
                    subsetArrayList.remove(subsetArrayList.size()-1);
                    ++lastElementIndex;
                }
                ++firstElementIndex;
            }
        }
//        listOfSubsets.add(array);


        return listOfSubsets;
    }

    public static ArrayList<Integer[]> getAllSubsetOfArray(Integer[] array){
        ArrayList<Integer[]> listOfSubsets = new ArrayList<>();
        //for each i print the i elements in the array
        //if i = 0 print 0
        //if i is one print all one elements
        //if i = 2 print double elements
        //take j = 0 for every i,
        //  increment j for every check of a new element
        //  make sure that there are still j+i elements
        //  print from j to j+i elements
        for(int i = 0; i<array.length; i++){//go through all the element lengths in the array
            int j = 0;
            while (j+i<array.length){//for each length of element
                //from j to j+i is a subset
                getEachSubsetForLength_i_to_j_plus_i(array, listOfSubsets, i, j);
                ++j;
            }
        }
        listOfSubsets.add(array);
        return listOfSubsets;
    }

    private static void getEachSubsetForLength_i_to_j_plus_i(Integer[] array, ArrayList<Integer[]> listOfSubsets, int i, int j) {
        ArrayList<Integer> subSetArrayList = new ArrayList<>();
        for (int last = j; last<= j+i ; ++last){//to put all the elements in the array together
//            if(last>=array.length) subSetArrayList.add(array[last - array.length]);
//            else
                subSetArrayList.add(array[last]);
        }

        Integer[] subSetArray = turnArrayListIntoArray(subSetArrayList);
        listOfSubsets.add(subSetArray);
    }

    private static Integer[]  turnArrayListIntoArray(ArrayList<Integer> arrayList){
        Integer[] array = new Integer[arrayList.size()];
        for(int i=0; i<arrayList.size(); ++i){
            array[i] = arrayList.get(i);
        }
        return array;
    }

    public static double xOrAdditionOfAnArray(Integer[] array){
        if(array.length ==0) return 0;
        if(array.length<2) return array[0];

        int sum = xOrAdditionOfTwoNumbers(array[0], array[1]);
        for(int i = 2; i < array.length; ++i){
            sum = xOrAdditionOfTwoNumbers(sum, array[i]);
        }
        return sum;
    }

    public static int xOrAdditionOfTwoNumbers(int number1, int number2){
        String binaryRepresentationOf1 = convertTo8BitBinary(number1);
        String binaryRepresentationOf2 = convertTo8BitBinary(number2);
        StringBuilder answerStringBuilder = new StringBuilder();

        if(binaryRepresentationOf1.length() == binaryRepresentationOf2.length()){
            for(int i=0; i<binaryRepresentationOf1.length(); ++i){
                if(binaryRepresentationOf1.charAt(i) == binaryRepresentationOf2.charAt(i)){
                    answerStringBuilder.append(0);
                }else answerStringBuilder.append(1);
            }
        }
//        System.out.println(answerStringBuilder);
        return convertToBase10(answerStringBuilder.toString(), 2);
    }

    private static int convertToBase10(String number, int base){
        int answer = 0;
        for(int i = 0; i<number.length(); ++i){
            char currentNumberChar = number.charAt(number.length()-1-i);
            int currentNumber = Integer.parseInt(String.valueOf( currentNumberChar));
            answer += (currentNumber * Math.pow(base, i));
        }
//        Math.pow(3d, 4d);
        return answer;
    }
    private static String convertTo8BitBinary(int number){
        if(number<0)number=number*-1;
        int remainder = number%2;
        int times = number/2;
        StringBuilder answerStringBuilder = new StringBuilder();
        answerStringBuilder.append(remainder);

        while (times>1){
            remainder = times%2;
            answerStringBuilder.append(remainder);
            times = times/2;
        }
        answerStringBuilder.append(times);
        while (answerStringBuilder.length() % 8 != 0){
            answerStringBuilder.append(0);
        }
        answerStringBuilder.reverse();

//        int answer = Integer.parseInt(answerStringBuilder.toString());
        return answerStringBuilder.toString();
    }

    private static void findSubsets(List<Integer[]> listOfSubset, Integer[] array, ArrayList<Integer> subset, int index)
    {
        // Base Condition
        //check if the index of the current element is the last index
        if (index == array.length) {
            listOfSubset.add(turnArrayListIntoArray(subset));
            return;
        }

        // Not Including Value which is at Index
        // find subsets of elements 1+index and add it
        findSubsets(listOfSubset, array, new ArrayList<>(subset), index + 1);

        // Including Value which is at Index
        // find subsets of elements 1+index and add it
        subset.add(array[index]);
        findSubsets(listOfSubset, array, new ArrayList<>(subset), index + 1);
    }
}
