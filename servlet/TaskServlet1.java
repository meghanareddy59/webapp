package com.servlet;

import com.meghana.Taskmanager;
import org.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaskServlet1 extends HttpServlet {
        public TaskServlet1(){

        }
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Taskmanager tm=new Taskmanager();
            int id= Integer.parseInt(req.getParameter("id"));

            PrintWriter out =resp.getWriter();

            try {
                out.println(tm.FindById(id));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
