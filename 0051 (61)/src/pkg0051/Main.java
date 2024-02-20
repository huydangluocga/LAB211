/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0051;

import java.util.Scanner;

/**
 *
 * @author xeban
 */
public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Normal Calculator");
            System.out.println("2. BMI Calculator");
            System.out.println("3. Exit");
            int choice = getInteger("Please choice one option: ", "must be integer", 1, 3);
            switch (choice) {
                case 1:
                    NormalCalculator();
                    break;
                case 2:
                    BMICalculator();
                    break;
                case 3:
                    System.exit(0);
            }
        }
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

    public static String getOperator(String msg) {
        Scanner sc = new Scanner(System.in);
        String operator;
        while (true) {
            System.out.print(msg);
            operator = sc.nextLine().trim();
            if (operator.isEmpty()) {
                System.out.println("input must not empty");
                continue;
            } else if (operator.equalsIgnoreCase("+") || operator.equalsIgnoreCase("-")
                    || operator.equalsIgnoreCase("*") || operator.equalsIgnoreCase("/")
                    || operator.equalsIgnoreCase("^") || operator.equalsIgnoreCase("=")) {
                return operator;
            } else {
                System.out.println("Please input (+, -, *, /, ^)");
            }

        }
    }

    public static double getDouble(String msg, String err, double min, double max) {
        Scanner sc = new Scanner(System.in);
        String input;
        double result;
        while (true) {
            System.out.println(msg);
            input = sc.nextLine().trim();
            if (input.equals("") || input.length() == 0) {
                System.out.println("input must not empty");
                continue;
            }
            try {
                result = Double.parseDouble(input);
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

    public static double calculate(double a, String operator, double b) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b != 0) {
                    return a / b;
                } else {
                    System.out.println("Cannot divide by 0");
                    return a;
                }
            case "^":
                return Math.pow(a, b);
            default:
                System.out.println("Invalid operator. Please input (+, -, *, /, ^, =)");
                return a;
        }
    }

    static void NormalCalculator() {
        System.out.println("----Normal Calculator----");
        double num1 = getDouble("Enter number: ", "Must be a double", 0, Double.MAX_VALUE);
        double memory = num1;

        while (true) {
            String operator = getOperator("Enter Operator: ");
            if ("=".equals(operator)) {
                System.out.println("Result: " + memory);
                return;
            }

            double num2 = getDouble("Enter number: ", "Must be a double", 0, Double.MAX_VALUE);
            memory = calculate(memory, operator, num2);

            System.out.println("Memory: " + memory);
        }
    }

    public static void calculateBMI(double weight, double height) {
        height /= 100;
        double bmi = weight / (height * height);
        if (bmi < 19) {
            System.out.println("UNDER STANDARD");
        } else if (bmi >= 19 && bmi < 25) {
            System.out.println("STANDARD");;
        } else if (bmi >= 25 && bmi < 30) {
            System.out.println("OVERWEIGHT");;
        } else if (bmi >= 30 && bmi < 40) {
            System.out.println("FAT");
        } else {
            System.out.println("VERY FAT");
        }
    }

    public static void BMICalculator() {
        System.out.println("----- BMI Calculator -----");
        double weight = getDouble("Enter weight (kg): ", "BMI is digit", 1, Double.MAX_VALUE);
        double height = getDouble("Enter height in meters: ", "BMI is digit", 1, Double.MAX_VALUE);
        double bmi = weight * 10000 / (height * height);
        System.out.printf("BMI status: %.2f\n", bmi);
        calculateBMI(weight, height);
    }
}
