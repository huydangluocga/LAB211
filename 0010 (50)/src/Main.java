
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author xeban
 */
public class Main {

    public static void main(String[] args) {
        int sizeOfArray = getInteger("Enter number of array: ", "must be integer", 1, Integer.MAX_VALUE);
        int[] array = new int[sizeOfArray];
        generateRandomInteger(array);
        displayArray(array, "The array: ");
        int searchValue = getInteger("Enter search value: ", "must be integer", Integer.MIN_VALUE, Integer.MAX_VALUE);
        displayIndexLinearSearch(array, searchValue);
    }

    public static int getInteger(String msg, String err, int min, int max) {
        Scanner sc = new Scanner(System.in);
        String input;
        int result;
        while (true) {
            System.out.println(msg);
            input = sc.nextLine().trim();
            if (input.equals("") || input.length() == 0) {
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
                System.err.println(err);
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

    static void displayIndexLinearSearch(int[] array, int searchValue) {
        boolean found = false;
        System.out.print("Found " + searchValue + " at index: ");
        for (int i = 0; i < array.length; i++) {
            if (searchValue == array[i]) {
                System.out.print(i + " ");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Not found");
        }
    }

}
