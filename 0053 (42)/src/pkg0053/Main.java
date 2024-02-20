/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0053;

import java.util.Scanner;

/**
 *
 * @author xeban
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array = null;
        while (true) {
            System.out.println("========= Bubble Sort program =========");
            System.out.println("1. Input element");
            System.out.println("2. Sort Ascending");
            System.out.println("3. Sort Descending");
            System.out.println("4. Exit");
            int choice = getInteger("Enter choice: ", "must be integer", 1, 4);
            switch (choice) {
                case 1:
                    array = inputElement();
                    break;
                case 2:
                    if (array != null) {
                        ascendingOrDescendingArray(array, true);
                        displayArray(array);
                    } else {
                        System.out.println("Please input elements first.");
                    }
                    break;
                case 3:
                    if (array != null) {
                        ascendingOrDescendingArray(array, false);
                        displayArray(array);
                    } else {
                        System.out.println("Please input elements first.");
                    }
                    break;
                case 4:
                    return;
            }
        }
    }

    public static int getInteger(String msg, String err, int min, int max) {
        Scanner sc = new Scanner(System.in);
        String input;
        int result;
        while (true) {
            System.out.print(msg);
            input = sc.nextLine().trim();
            if (input.length() == 0 || input.equals("")) {
                System.err.println("input must not empty");
                continue;
            }
            try {
                result = Integer.parseInt(input);
                if (result < min || result > max) {
                    System.out.println("must in range");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.println(err);
            }

        }
        return result;
    }

    public static int[] inputElement() {
        int size = getInteger("Input length of array: ", "length must be integer", 1, Integer.MAX_VALUE);
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = getInteger("Enter number: ", "number must be integer", 0, Integer.MAX_VALUE);
        }
        return array;
    }

    public static void ascendingOrDescendingArray(int[] array, boolean isAscending) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (isAscending) {
                    if (array[j] > array[j + 1]) {
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                } else {
                    if (array[j] < array[j + 1]) {
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
    }

    public static void displayArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]");
            if (i < array.length - 1) {
                System.out.print("->");
            }
        }
        System.out.println();
    }
}
