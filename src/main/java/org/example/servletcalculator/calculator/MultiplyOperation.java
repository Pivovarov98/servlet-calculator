package org.example.servletcalculator.calculator;

public class MultiplyOperation implements Operation {
    @Override
    public double apply(double a, double b) {
        return a * b;
    }
}
