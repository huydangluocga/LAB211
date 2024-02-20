
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author saras
 */
public class GetData {

    public static int inputInteger(String mess, int min, int max) {
        Scanner sc = new Scanner(System.in);
        String input;
        int choose = 0;
        while (true) {
            System.out.print(mess);
            input = sc.nextLine();
            input = input.trim();
            //Check if input empty or have many space
            if (input.equals("")) {
                System.out.println("Input can't empty!");
                continue;
            }
            //Check if input have character
            if (containCharacter(input)) {
                System.out.println("Input can't have character!");
                continue;
            }
            try {
                choose = Integer.parseInt(input);
                //Check if input out of range
                if (choose < min || choose > max) {
                    System.out.println("Input must be in " + min + " -> " + max);
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter integer number only!");
                continue;
            }
        }

        return choose;
    }

    public static boolean containCharacter(String input) {

        //Loop to access separate character in string input
        for (int i = 0; i < input.length(); i++) {
            //Check if input has character
            if (Character.isLetter(input.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    public static String inputString(String mess) {
        Scanner sc = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println(mess);
            input = sc.nextLine();
            //Check if input empty or have many space
            if (input.trim().equals("")) {
                System.out.println("Input can't empty!");
                continue;
            }
            break;
        }
        return input;
    }

    public static float inputFloat(String mess) {
        Scanner sc = new Scanner(System.in);
        String input;
        float choose = 0;
        while (true) {
            System.out.println(mess);
            input = sc.nextLine();
            if (input.trim().equals("")) {
                System.out.println("Input can't empty!");
                continue;
            }
            // Check if input have character
            if (containCharacter(input)) {
                System.out.println("Input can't have character!");
                continue;
            }
            try {
                choose = Float.parseFloat(input);
                //Check if total area less than 0
                if (choose <= 0) {
                    System.out.println("Total area must be greater than 0");
                    continue;

                }
            } catch (Exception e) {
                System.out.println("Please input number only!");
            }
            break;

        }
        return choose;
    }

    public static String inputYesOrNo(String mess) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        while (true) {
            System.out.print(mess);
            input = sc.nextLine();
            //Check if input empty or have many space
            if (input.trim().equals("")) {
                System.out.println("Input can't empty!");
                continue;
            } else if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N")) {
                return input;
            } else {
                System.out.println("Please enter Y or N only!");
                continue;
            }

        }
    }
}
