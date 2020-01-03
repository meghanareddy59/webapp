package com.servlet;

import com.meghana.Status;
import com.meghana.Task;
import com.meghana.Taskmanager;
import com.meghana.database;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class TaskServlet extends HttpServlet {

    public TaskServlet(){

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Taskmanager tm=new Taskmanager();
        try {
            List<Task> list= tm.display();
            PrintWriter out =resp.getWriter();
            out.println(list);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Taskmanager tm=new Taskmanager();
        //super.doPost(req, resp);
        int id= Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        String description=req.getParameter("description");
        String dueDate=req.getParameter("dueDate");
        String status=req.getParameter("status");
        PrintWriter out = resp.getWriter();
        try {
            tm.add(id,name,description,dueDate,status);
            out.println(tm.FindById(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
