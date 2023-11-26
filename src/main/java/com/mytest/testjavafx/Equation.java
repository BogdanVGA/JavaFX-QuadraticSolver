package com.mytest.testjavafx;

public class Equation {

    private final double a;
    private final double b;
    private final double c;

    public Equation(double[] coefficients) {
        this.a = coefficients[0];
        this.b = coefficients[1];
        this.c = coefficients[2];
    }

    protected String[] solveEquation() {
        String[] output = new String[3];

        if (a == 0) {
            output[0] = "This is a simple equation";

            double root;
            root = (-c) / b;
            output[1] = String.valueOf(root);
            output[2] = "0.0";
            return output;
        }

        double root1, root2;
        double determinant = b * b - 4 * a * c;

        if (determinant > 0) {
            output[0] = "The equation has real and different roots";

            root1 = (-b + Math.sqrt(determinant)) / (2 * a);
            root2 = (-b - Math.sqrt(determinant)) / (2 * a);

            output[1] = String.valueOf(root1);
            output[2] = String.valueOf(root2);
        } else if (determinant == 0) {
            output[0] = "The equation has real and equal roots";

            root1 = root2 = -b / (2 * a);

            output[1] = String.valueOf(root1);
            output[2] = String.valueOf(root2);
        } else {
            output[0] = "The equation has complex roots!";

            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-determinant) / (2 * a);

            output[1] = realPart + "+" + imaginaryPart + "i";
            output[2] = realPart + "-" + imaginaryPart + "i";
        }
        return output;
    }
}
