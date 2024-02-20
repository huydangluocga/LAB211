/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0073;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author xeban
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        ArrayList<Expense> list = new ArrayList<>();
        while (true) {
            System.out.println("1. Add an expense");
            System.out.println("2. Display all expenses");
            System.out.println("3. Delete an expense");
            System.out.println("4. Quit");
            int choice = getInteger("Enter your choice: ", "Must be integer", 1, 4);
            switch (choice) {
                case 1:
                    addExpense(list);
                    break;
                case 2:
                    displayExpense(list);
                    break;
                case 3:
                    deleteExpense(list);
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

    public static double getDouble(String msg, String err, double min, double max) {
        Scanner sc = new Scanner(System.in);
        String input;
        double result;
        while (true) {
            System.out.print(msg);
            input = sc.nextLine().trim();
            if (input.length() == 0 || input.equals("")) {
                System.err.println("input must not empty");
                continue;
            }
            try {
                result = Double.parseDouble(input);
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

    public static String getString(String msg, String err) {
        Scanner sc = new Scanner(System.in);
        String input;
        while (true) {
            System.out.print(msg);
            input = sc.nextLine().trim();
            if (input.equals("") || input.length() == 0) {
                System.out.println(err);
                continue;
            }
            break;
        }
        return input;
    }

    public static String getDate(String msg, String err) {
        Scanner sc = new Scanner(System.in);
        String input;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        sdf.setLenient(false);
        while (true) {
            System.out.println(msg);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("not empty");
                continue;
            }
            try {
                SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                inputDateFormat.setLenient(false);
                Date date = inputDateFormat.parse(input);

                input = sdf.format(date);
                return input;
            } catch (ParseException e) {
                System.err.println(err);
            }
        }
    }

    public static void addExpense(ArrayList<Expense> list) {
        int id;
        if (list.isEmpty()) {
            id = 1;
        } else {
            id = list.get(list.size() - 1).getId() + 1;
        }
        String date = getDate("Enter date: ", "Date must be valid and must follow dd-MM-yyyy");
        double amount = getDouble("Enter amount: ", "must be double", 0, Double.MAX_VALUE);
        String content = getString("Enter content: ", "content must not empty");
        Expense expense = new Expense(id, date, amount, content);
        list.add(expense);
        System.out.println("Added sucessfully!");
    }

    public static void displayExpense(ArrayList<Expense> list) {
        if (list.isEmpty()) {
            System.out.println("No data to display!");
            return;
        }
        double total = 0;
        System.out.printf("%-7s%-20s%-20s%-20s\n", "ID", "Date", "Amount of money", "Content");
        for (Expense expense : list) {
            System.out.printf("%-7d%-20s%-20.0f%-20s\n", expense.getId(),
                    expense.getDate(), expense.getAmount(), expense.getContent());
            total += expense.getAmount();
        }
        System.out.printf("Total: %-20.0f\n", total);
    }

    public static void deleteExpense(ArrayList<Expense> list) {
        if (list.isEmpty()) {
            System.out.println("No data to delete!");
            return;
        }
        int id = getInteger("Enter id: ", "id must be integer", 1, Integer.MAX_VALUE);
        int checkID = checkIdExist(list, id);
        if (checkID != -1) {
            list.remove(checkID);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setId(i + 1);
            }

            System.out.println("delete successful!");
        } else {
            System.out.println("Delete an expense fail");

        }

    }

    private static int checkIdExist(ArrayList<Expense> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1; // not found
    }
}
