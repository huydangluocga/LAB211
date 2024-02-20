/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibo;

/**
 *
 * @author xeban
 */
public class Fibo {

    public static int Recursion(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        return Recursion(i-1) + Recursion(i-2);
    }
    public static void main(String[] args) {
        for (int i = 0; i < 45; i++) {
            System.out.println("Index " + (i+1) + ": " + Recursion(i));
        }
    }
    
}
