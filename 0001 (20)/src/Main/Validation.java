/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Scanner;

/**
 *
 * @author xeban
 */
public class Validation {

    public static int getInteger(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        String input;
        int choose = 0;
        while (true) {
            System.out.println(msg);
            input = sc.nextLine();
            input = input.trim();
            // check if input is empty or not
            if (input.equals("") || input.length() == 0) {
                System.err.println("Input number of bill must not empty");
                continue;
            }
            // check if input is contain character or not
            if (containCharacter(input)) {
                System.err.println("Input number of bill cannot contain character");
                continue;
            }
            try {
                choose = Integer.parseInt(input);
                if (choose < min || choose > max) {
                    System.err.println("Input must be in range from " + min + "to " + max);
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Wrong format! Please try again");
                continue;
            }
        }
        return choose;
    }

    public static boolean containCharacter(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
