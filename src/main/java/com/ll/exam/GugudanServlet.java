package com.ll.exam;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Rq rq = new Rq(request, response);

        int dan = rq.getIntParam("dan", 9);
        int limit = rq.getIntParam("limit", 9);

        request.setAttribute("dan", dan);
        request.setAttribute("limit", limit);

        RequestDispatcher dispatcher = request.getRequestDispatcher("gugudan2.jsp");
        dispatcher.forward(request, response);
    }
}
