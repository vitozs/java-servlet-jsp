package com.br.servlets;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "Servlet", urlPatterns = "/servlet")
public class Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //encaminhar a requisição atual para outro recurso.
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("pg2.jsp");

        //Pega o parametro "texto", que foi passado no forms do index.html
        String texto = request.getParameter("texto");

        //Seta o nome do atributo que vai ser resgatado na pg .jsp e o valor dele.
        request.setAttribute("texto", texto);


        //Passa adiante o request e a response para o recurso, no caso pg2.jsp
        requestDispatcher.forward(request, response);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);

    }
}
