/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0006;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author xeban
 */
public class J1SP0006 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int sizeOfArray = getInteger("Enter number of array: ", "must be integer", 1, 1000);
        int[] array = new int[sizeOfArray];
        generateRandomInteger(array);
        sortArray(array);
        displayArray(array, "Sorted array: ");
        int searchValue = getInteger("Enter search value: ", "must be integer", 0, 1000);
        displayIndexBinarySearch(array, searchValue);
    }

    public static int getInteger(String msg, String err, int min, int max) {
        Scanner sc = new Scanner(System.in);
        String input;
        int result;
        while (true) {
            System.out.println(msg);
            input = sc.nextLine().trim();
            if (input.equals("") || input.length() == 0) {
                System.out.println("input must not empty");
                continue;
            }
            try {
                result = Integer.parseInt(input);
                if (result < min || result > max) {
                    System.err.println("Must in range from " + min + " to " + max);
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(err);
                continue;
            }
        }
        return result;
    }

    static void generateRandomInteger(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomNumber = random.nextInt(array.length);
            array[i] = randomNumber;
        }
    }

    static void displayArray(int[] array, String msg) {
        System.out.print(msg);
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[array.length - 1]);
        System.out.println("]");
    }

    static void sortArray(int[] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < (array.length - i); j++) {
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    private static int[] BinarySearch(int[] array, int searchValue) {
        int left = 0;
        int right = array.length - 1;
        int[] result = {-1, -1};

        while (left <= right) {
            int mid = (left + right) / 2;

            if (array[mid] == searchValue) {
                result[0] = mid;
                right = mid - 1; // Update to search for the first occurrence
            } else if (array[mid] < searchValue) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        left = 0;
        right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (array[mid] == searchValue) {
                result[1] = mid; // Update to search for the last occurrence
                left = mid + 1;
            } else if (array[mid] < searchValue) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static void displayIndexBinarySearch(int[] array, int searchValue) {
        int[] index = BinarySearch(array, searchValue);
        if (index[0] == -1) {
            System.out.println("Not found");
            return;
        } else {
            System.out.print("Found " + searchValue + " at indices: ");
            for (int i = index[0]; i <= index[1]; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
