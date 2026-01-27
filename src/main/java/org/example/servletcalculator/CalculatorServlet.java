package org.example.servletcalculator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.servletcalculator.calculator.*;
import org.example.servletcalculator.history.InMemoryHistoryOfExpressions;

import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/calculator.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        InMemoryHistoryOfExpressions history = (InMemoryHistoryOfExpressions) session.getAttribute("history");

        if (history == null){
            history = new InMemoryHistoryOfExpressions();
            session.setAttribute("history", history);
        }

        Pattern pattern = Pattern.compile("\\s*(-?\\d+(?:\\.\\d+)?)\\s*([+\\-*/])\\s*(-?\\d+(?:\\.\\d+)?)\\s*");

        Map<String, Operation> operations = Map.of(
                "+", new AddOperation(),
                "-", new SubtractOperation(),
                "*", new MultiplyOperation(),
                "/", new DivideOperation()
        );

        String expression = req.getParameter("expression");

        Matcher matcher = pattern.matcher(expression);
        if (matcher.matches()) {
            double num1 = Double.parseDouble(matcher.group(1));
            double num2 = Double.parseDouble(matcher.group(3));
            String operator = matcher.group(2);

            if (num2 == 0){
                req.setAttribute("alert", "You can't divide by zero");
                req.getRequestDispatcher("/pages/calculator.jsp").forward(req, resp);
                return;
            }

            Calculator calculator = new Calculator(operations);
            double result = calculator.calculate(num1, num2, operator);

            if (result % 1 == 0){
                req.setAttribute("result", (int) result);
                history.add(expression + "=" + (int) result);
            } else {
                req.setAttribute("result", result);
                history.add(expression + "=" + result);
            }

        } else {
            req.setAttribute("alert", "Incorrect expression");
        }

        req.getRequestDispatcher("/pages/calculator.jsp").forward(req, resp);
    }
}
