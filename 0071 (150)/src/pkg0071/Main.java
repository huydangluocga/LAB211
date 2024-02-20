/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0071;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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
        ArrayList<Task> list = new ArrayList<>();
        while (true) {
            System.out.println("========= Task program =========");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Task");
            System.out.println("4. exit");
            int choice = getInteger("Enter choice: ", "choice must be integer", 1, 4);
            switch (choice) {
                case 1:
                    addTask(list);
                    break;
                case 2:
                    deleteTask(list);
                    break;
                case 3:
                    getDataTask(list);
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        while (true) {
            System.out.print(msg);
            input = sc.nextLine().trim();
            if (!input.matches("\\d{2}-\\d{2}-\\d{4}")) {
                System.out.println("Must follow format dd-MM-yyyy");
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

    private static void addTask(ArrayList<Task> list) {
        do {
            int id;
            if (list.isEmpty()) {
                id = 1;
            } else {
                id = list.get(list.size() - 1).getId() + 1;
            }
            System.out.println("------------ Add Task ---------------");
            String name = getString("Requirement Name: ", "Name must not be empty");
            int taskId = getInteger("Task type: ", "Type must be an integer", 1, 4);
            String date = getDate("Date: ", "Date must be valid (dd-MM-yyyy)");
            double from = getDouble("From: ", "Must be a valid double", 8, 17);
            double to = getDouble("To: ", "Must be a valid double", from + 0.5, 17.5);
            String assignee = getString("Assignee: ", "Assignee must not be empty");
            String reviewer = getString("Reviewer: ", "Reviewer must not be empty");
            if (checkDuplicateTask(list, date, assignee, from, to)) {
                boolean cont = getYN("This person is doing another task, do you want to continue(Y/N)?: ");
                if (!cont) {
                    return;
                }
            } else {
                list.add(new Task(id, taskId, name, date, from, to, assignee, reviewer));
                boolean confirm = getYN("Added successfully! Do you want to continue (Y/N)?: ");
                if (!confirm) {
                    return;
                }
            }
        } while (true);
    }

    public static boolean checkDuplicateTask(ArrayList<Task> list, String date, String assignee, double from, double to) {
        for (Task task : list) {
            if (task.getDate().equals(date) && task.getAssignee().equals(assignee)) {
                if (from >= task.getFrom() && from <= task.getTo()) {
                    return true;
                }
                if (to >= task.getFrom() && to <= task.getTo()) {
                    return true;
                }
                if (task.getFrom() >= from && task.getFrom() <= to) {
                    return true;
                }
            }
        }

        return false;
    }

    private static void deleteTask(ArrayList<Task> list) {
        if (list.isEmpty()) {
            System.out.println("No data to delete");
            return;
        }
        System.out.println("----- Del Task -----");
        int id = getInteger("ID: ", "id must be integer", 1, Integer.MAX_VALUE);
        int checkId = checkIdExist(list, id);
        if (checkId != -1) {
            list.remove(checkId);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setId(i + 1);
            }
            System.out.println("delete successful!");
        } else {
            System.out.println("Delete task fail");

        }
    }

    private static int checkIdExist(ArrayList<Task> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1; // not found
    }

    private static void getDataTask(ArrayList<Task> list) {
        if (list.isEmpty()) {
            System.out.println("No data to display");
            return;
        }
        System.out.printf("%-7s%-20s%-12s%-13s%-10s%-12s%-15s\n", "ID", "Name", "Task Type", "Date",
                "Time", "Assignee", "Reviewer");
        for (Task task : list) {
            double time = task.getTo() - task.getFrom();
            System.out.printf("%-7d%-20s%-12s%-13s%-10.1f%-12s%-15s\n", task.getId(), task.getName(), task.typeName(),
                    task.getDate(), time, task.getAssignee(), task.getReviewer());
        }
    }

    public static boolean getYN(String msg) {
        Scanner sc = new Scanner(System.in);
        String input;
        while (true) {
            System.out.print(msg);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("must not empty");
                continue;
            }
            if (input.equalsIgnoreCase("Y")) {
                return true;
            } else if (input.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Must enter y/n");
            }
        }
    }
}
