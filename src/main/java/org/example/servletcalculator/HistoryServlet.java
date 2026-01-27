package org.example.servletcalculator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.servletcalculator.history.InMemoryHistoryOfExpressions;

import java.io.IOException;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        InMemoryHistoryOfExpressions history = (InMemoryHistoryOfExpressions) session.getAttribute("history");

        if (history != null) {
            req.setAttribute("history", history.getHistory());
        } else {
            req.setAttribute("alert", "There is no history of expressions yet!");
        }

        req.getRequestDispatcher("/pages/history.jsp").forward(req, resp);
    }
}
