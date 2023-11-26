package com.mytest.testjavafx;

public class QuadFunction {

    private final double a;
    private final double b;
    private final double c;

    public QuadFunction(double[] input) {
        this.a = input[0];
        this.b = input[1];
        this.c = input[2];
    }

    protected double evaluateFunction(double x) {
        return a * x * x + b * x + c;
    }
}
