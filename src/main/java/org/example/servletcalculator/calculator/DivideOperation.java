package org.example.servletcalculator.calculator;

public class DivideOperation implements Operation {
    @Override
    public double apply(double a, double b) {
        return a / b;
    }
}
