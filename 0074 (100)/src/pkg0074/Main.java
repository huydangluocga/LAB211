/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0074;

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
        int[][] matrix1, matrix2, result;
        while (true) {
            System.out.println("1. Addition");
            System.out.println("2. Substraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Quit");
            int choice = getInteger("Your choice: ", "must be integer", 1, 4);
            switch (choice) {
                case 1:
                    matrix1 = getMatrix1();
                    matrix2 = getMatrix2(matrix1, false);
                    result = addOrSubtractMatrix(matrix1, matrix2, true);
                    displayResult(matrix1, matrix2, result, "Addition");
                    break;
                case 2:
                    matrix1 = getMatrix1();
                    matrix2 = getMatrix2(matrix1, false);
                    result = addOrSubtractMatrix(matrix1, matrix2, false);
                    displayResult(matrix1, matrix2, result, "Substraction");
                    break;
                case 3:
                    matrix1 = getMatrix1();
                    matrix2 = getMatrix2(matrix1, true);
                    result = multiplicationMatrix(matrix1, matrix2);
                    displayResult(matrix1, matrix2, result, "Multiplication");
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

    public static int[][] getMatrix1() {

        int row = getInteger("Enter Row Matrix 1:", "must be integer", 1, Integer.MAX_VALUE);
        int column = getInteger("Enter Column Matrix 1:", "must be integer", 1, Integer.MAX_VALUE);
        int[][] matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = getDataMatrix(String.format("Enter Matrix1" + "[%d][%d]:", i + 1, j + 1));
            }

        }

        return matrix;
    }

    public static int[][] getMatrix2(int[][] matrix1, boolean isMultiplication) {
        int[][] matrix2;
        int rowMatrix2, columnMatrix2;

        if (isMultiplication) {
            while (true) {
                rowMatrix2 = getInteger("Enter Row Matrix 2:", "must be integer", 1, Integer.MAX_VALUE);
                if (rowMatrix2 != matrix1[0].length) {
                    System.out.printf("Row Matrix 2 must equal with Column Matrix 1 (%d)\n", matrix1[0].length);
                    continue;
                }
                columnMatrix2 = getInteger("Enter Column Matrix 2:", "must be integer", 1, Integer.MAX_VALUE);
                break;
            }
        } else {
            while (true) {
                rowMatrix2 = getInteger("Enter Row Matrix 2:", "must be integer", 1, Integer.MAX_VALUE);
                columnMatrix2 = getInteger("Enter Column Matrix 2:", "must be integer", 1, Integer.MAX_VALUE);
                if (rowMatrix2 != matrix1.length || columnMatrix2 != matrix1[0].length) {
                    System.out.printf("Row Matrix 2 must equal Row Matrix 1 (%d) and Column Matrix 2 must equal Column Matrix 1 (%d)\n", matrix1.length, matrix1[0].length);
                    continue;
                }
                break;
            }
        }

        matrix2 = new int[rowMatrix2][columnMatrix2];
        for (int i = 0; i < rowMatrix2; i++) {
            for (int j = 0; j < columnMatrix2; j++) {
                matrix2[i][j] = getDataMatrix(String.format("Enter Matrix2" + "[%d][%d]:", i + 1, j + 1));
            }
        }
        return matrix2;
    }

    public static int getDataMatrix(String mess) {
        Scanner sc = new Scanner(System.in);
        String input;
        int output;
        while (true) {
            System.out.print(mess);
            input = sc.nextLine().trim();
            if (input.equals("") || input.length() == 0) {
                System.out.println("Value matrix can't empty!");
                continue;
            }
            try {
                output = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Value of matrix is digit");
                continue;
            }
        }
        return output;
    }

    public static int[][] addOrSubtractMatrix(int[][] matrix1, int[][] matrix2, boolean isAddition) {
        int row = matrix1.length;
        int column = matrix1[0].length;
        int[][] result = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (isAddition) {
                    result[i][j] = matrix1[i][j] + matrix2[i][j];
                } else {
                    result[i][j] = matrix1[i][j] - matrix2[i][j];
                }
            }
        }
        return result;
    }

    public static int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int rowMatrix1 = matrix1.length;
        int columnMatrix1 = matrix1[0].length;
        int columnMatrix2 = matrix2[0].length;
        int[][] result = new int[rowMatrix1][columnMatrix2];
        for (int i = 0; i < rowMatrix1; i++) {
            for (int j = 0; j < columnMatrix2; j++) {
                for (int k = 0; k < columnMatrix1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public static void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.printf("[%d]", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void displayResult(int[][] matrix1, int[][] matrix2, int[][] result, String calculation) {
        System.out.println("--------Result---------");
        displayMatrix(matrix1);
        if (calculation.equalsIgnoreCase("Addition")) {
            System.out.println("+");
        } else if (calculation.equalsIgnoreCase("Substraction")) {
            System.out.println("-");
        } else {
            System.out.println("*");
        }
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(result);
    }
}
