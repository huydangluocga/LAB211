/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0008;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author xeban
 */
public class J1SP0008 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String string = getString("Enter your content: ", "Input string must not contain numbers");

        // Initialize maps to count words and characters
        Map<Character, Integer> charCount = new HashMap<>();
        Map<String, Integer> wordCount = new LinkedHashMap<>();

        StringTokenizer tokenizer = new StringTokenizer(string);

        // word
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!wordCount.containsKey(token)) {
                wordCount.put(token, 1);
            } else {
                wordCount.put(token, wordCount.get(token) + 1);
            }
        }

        // char
        for (char ch : string.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                continue;
            }
            if (!charCount.containsKey(ch)) {
                charCount.put(ch, 1);
            } else {
                charCount.put(ch, charCount.get(ch) + 1);
            }
        }
        System.out.println(wordCount);
        System.out.println(charCount);
    }

    public static String getString(String msg, String err) {
        Scanner sc = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println(msg);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("input string must not empty");
                continue;
            }
            if (containDigit(input)) {
                System.out.println(err);
                continue;
            }
            break;
        }
        return input;
    }

    private static boolean containDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                return true;
            }

        }
        return false;
    }
}
