package com.meghana;

import javax.xml.transform.Source;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class database implements TaskRepository {
    public database() {
    }



        @Override
        public void addTask (Task task) throws SQLException {

            String url = "jdbc:mysql://localhost:3306/testdb";
            String userName = "testuser";
            String password = "password";
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement stmt = con.createStatement();
            String q = "insert into taske values(" + task.getTaskId() + ",\"" + task.getTaskName() + "\",\"" + task.getTaskDesc() + "\",\"" + task.getDueDate()
                    + "\",\"" + task.getStatus() + "\")";

            stmt.executeUpdate(q);
            con.close();

        }

        @Override
        public List<Task> display () throws SQLException {
            List<Task> ar=new ArrayList();
            String url = "jdbc:mysql://localhost:3306/testdb";
            String userName = "testuser";
            String password = "password";
            try {
            Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement stmt = con.createStatement();
            String q = "select * from taske";

            ResultSet rs = stmt.executeQuery(q);
            if (rs.next()) {
                do {
                    Task n=new Task();
                    n.setTaskId(rs.getInt(1));
                    n.setTaskName(rs.getString(2));
                    n.setTaskDesc(rs.getString(3));
                    n.setDueDate(rs.getString(4));
                   // System.out.println(rs.getString(5));
                    n.setStatus(Status.valueOf(rs.getString(5)));
                    ar.add(n);
                    System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4) + "," + rs.getString(5));
                } while (rs.next());
            } else {
                System.out.println("Record Not Found...");
            }
            con.close();
            return ar;
        }

        @Override
        public Task FindById (int taskId) throws SQLException {
            String Url = "jdbc:mysql://localhost:3306/testdb";
            String username = "testuser";
            String password = "password";
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Connection con = DriverManager.getConnection(Url, username, password);
            Statement stmt = con.createStatement();
            String sql = "select * from taske where id=" + taskId;
            Task ne=new Task();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {


                    ne.setTaskId(rs.getInt(1));
                    ne.setTaskName(rs.getString(2));
                    ne.setTaskDesc(rs.getString(3));
                    ne.setDueDate(rs.getString(4));
                    // System.out.println(rs.getString(5));
                    ne.setStatus(Status.valueOf(rs.getString(5)));
                    //System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4) + "," + rs.getString(5));
                }
             else
                System.out.println("Record Not Found...");
            return  ne;
        }
        @Override
        public void delete ( int taskId){
        try {
            String Url = "jdbc:mysql://localhost:3306/testdb";
            String username = "testuser";
            String password = "password";
            Connection con = DriverManager.getConnection(Url, username, password);
            Statement stmt = con.createStatement();
            String sql = "delete from taske where id=" + taskId;

            stmt.executeUpdate(sql);
            // System.out.println("Record deleted successfully");
        }
        catch (Exception e)
        {
            System.out.println("No data");
        }

        }

        @Override
        public Task listByStatus (String requiredStatus) throws SQLException {
            String Url = "jdbc:mysql://localhost:3306/testdb";
            String username = "testuser";
            String password = "password";
            Connection con = DriverManager.getConnection(Url, username, password);
            Statement stmt = con.createStatement();
            String sql = "select * from taske where status= '" + requiredStatus + "'";

            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                do {
                    System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4) + "," + rs.getString(5));
                }
                while (rs.next());
            } else
                System.out.println("Record Not Found...");
            return null;
        }


}

