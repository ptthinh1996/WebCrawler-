package com.crawler.web;

import com.crawler.core.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Main")
public class Main extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String key = request.getParameter("key");
        String place = request.getParameter("place");
        List<Tour> tours1;
        List<Tour> tours2;
        List<Tour> tours3;
        if (place == "bac"){
            tours1 = QueryDatabase.Query(key,"DatVietBac");
            tours2 = QueryDatabase.Query(key,"SaiGonBac");
            tours3 = QueryDatabase.Query(key,"KimLien ");
            request.setAttribute("tours1",tours1);
            request.setAttribute("tours2",tours2);
            request.setAttribute("tours3",tours3);
            request.setAttribute("keyword",key);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/result");
            dispatcher.forward(request,response);
        }
        else if (place == "nam"){
            tours1 = QueryDatabase.Query(key,"DatVietNam");
            tours2 = QueryDatabase.Query(key,"SaiGonBNam");
            tours3 = QueryDatabase.Query(key,"KimLien");
            request.setAttribute("tours1",tours1);
            request.setAttribute("tours2",tours2);
            request.setAttribute("tours3",tours3);
            request.setAttribute("keyword",key);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/result");
            dispatcher.forward(request,response);
        }else{
            tours1 = QueryDatabase.Query(key,"DatVietTrung");
            tours2 = QueryDatabase.Query(key,"SaiGonTrung");
            tours3 = QueryDatabase.Query(key,"KimLien");
            request.setAttribute("tours1",tours1);
            request.setAttribute("tours2",tours2);
            request.setAttribute("tours3",tours3);
            request.setAttribute("keyword",key);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/result");
            dispatcher.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
