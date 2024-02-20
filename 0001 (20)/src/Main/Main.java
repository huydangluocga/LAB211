/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author xeban
 */
public class Main {

    public static void main(String[] args) {
        // enter size of array
        int sizeOfArray = Validation.getInteger("Enter number of array:", 1, Integer.MAX_VALUE);
        // Declaring array
        int[] array = new int[sizeOfArray];
        //Generate random integer in range
        BubbleSort.generateRandomNumber(array);
        //Display array before
        BubbleSort.displayArray(array, "Unsorted array: ");
        //Sort array
        BubbleSort.sortArray(array);
        //Display array after
        BubbleSort.displayArray(array, "Sorted array: ");

    }
}
