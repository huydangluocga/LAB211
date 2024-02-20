/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Random;

/**
 *
 * @author xeban
 */
public class BubbleSort {

    public static void generateRandomNumber(int[] array) {
        Random random = new Random();
        //Generate random number
        for (int i = 0; i < array.length; i++) {
            int randomNumber = random.nextInt(array.length);
            array[i] = randomNumber;
        }

    }

    public static void displayArray(int[] array, String msg) {
        System.out.print(msg);
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");

        }
        System.out.print(array[array.length - 1]);
        System.out.println("]");
    }

    public static void sortArray(int[] array) {
        int length = array.length;
        int temp = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < (length - i); j++) {
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }

            }
        }
    }

}
