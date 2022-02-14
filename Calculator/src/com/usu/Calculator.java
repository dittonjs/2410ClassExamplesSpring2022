package com.usu;

public class Calculator {

    public static double evaluate(String expression) {
        String[] parts = expression.split(" ");
        int state = 0;

        try {
            if (parts.length == 1) {
                return Double.parseDouble(parts[0]);
            }
            if (parts.length % 2 == 0) {
                throw new ArithmeticException("Invalid");
            }
            double result = Double.parseDouble(parts[0]);
            String operator = parts[1];
            for (int i = 2; i < parts.length; i++) {
                if (state == 0) {
                    if (operator.equals("+")) {
                        result = result + Double.parseDouble(parts[i]);
                    } else if (operator.equals("-")) {
                        result = result - Double.parseDouble(parts[i]);
                    } else if (operator.equals("*")) {
                        result = result * Double.parseDouble(parts[i]);
                    } else if (operator.equals("/")) {
                        result = result / Double.parseDouble(parts[i]);
                    } else {
                        throw new ArithmeticException("bad");
                    }
                    state = 1;
                } else {
                    if (!"+*/-".contains(parts[i])) {
                        throw new ArithmeticException("bad");
                    }
                    operator = parts[i];
                    state = 0;
                }
            }


            return result;
        } catch (RuntimeException e) {
            return Double.NaN;
        }

    }
}
