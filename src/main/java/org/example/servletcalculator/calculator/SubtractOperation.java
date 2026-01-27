package org.example.servletcalculator.calculator;

public class SubtractOperation implements Operation {
    @Override
    public double apply(double a, double b) {
        return a - b;
    }
}
