package org.example.servletcalculator.history;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryOfExpressions {
    private final List<String> history;

    public InMemoryHistoryOfExpressions(){
        history = new ArrayList<>();
    }

    public void add(String expression){
        history.add(expression);
    }

    public List<String> getHistory(){
        return history;
    }
}
