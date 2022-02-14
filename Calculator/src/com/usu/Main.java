package com.usu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println(Double.isNaN(Double.NaN));
            String input = scanner.nextLine();
            if (input.equals("stop")) {
                break;
            }
            System.out.println(Calculator.evaluate(input));

        }
    }
}
// 1 + 2 - 4 * 6 / 8
// 1 + 1 +1
/*


expression = number | expression \s operator \s expression
operator = + - / *
number = 0...n

 */
