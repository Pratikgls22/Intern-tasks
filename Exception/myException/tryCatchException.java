package myException;

import java.util.Scanner;

public class tryCatchException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter num1 :");
        int num1 = sc.nextInt();
        System.out.print("Enter num2 :");
        int num2 = sc.nextInt();

        try {
            System.out.println("Multiplication of two Numbers :" + num1 * num2);
            System.out.println("Division of two Numbers :"+num1/num2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
