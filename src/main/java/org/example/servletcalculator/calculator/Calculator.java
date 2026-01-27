package org.example.servletcalculator.calculator;

import java.util.Map;

public class Calculator {
    private final Map<String, Operation> operations;

    public Calculator(Map<String, Operation> operations) {
        this.operations = operations;
    }

    public double calculate(double a, double b, String operator) {
        Operation operation = operations.get(operator);
        return operation.apply(a, b);
    }
}
