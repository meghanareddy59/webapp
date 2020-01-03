package com.meghana;

import java.sql.SQLException;
import java.util.List;

public class Taskmanager {
    public TaskRepository memory = new database();
    //????
  //  public static int id = 1;

    public void add( int id,String name, String description, String date, String status) throws SQLException {
        memory.addTask(new Task(id,name, description, date,Status.valueOf(status)));

    }

    public List<Task> display() throws SQLException {

        return memory.display();
    }


    public Task FindById(int id) throws SQLException {

        Task n = (Task) memory.FindById(id);
        return n;
    }


    public void delete(int del) throws SQLException {
        memory.delete(del);
    }

    public Task listByStatus(String requiredStatus) throws SQLException {
        return memory.listByStatus(requiredStatus);
    }
}


    //  public ArrayList<Task> listByStatus(String status)
       //  {
       //
    // }



         /*   public   ArrayList<Task> list = new ArrayList<Task>();



          Task task=
           list.add(task);
           memory.addTask(task);
           }





          public  boolean FindById(int id)
          {


          public void delete(int removableid)
          {
              for (Task obj : list) {
                  if (obj.id == (removableid))
                      list.remove(obj);
              }
          }



     public List<Task> ListByStatus(String requiredstatus)
     {
         ArrayList<Task> arr = new ArrayList<>();
         for (Task obj : list)
         {
             String stat = obj.getStatus().toString();
             if (stat.matches(requiredstatus))
                 arr.add(obj);

         }
         return arr;
     }

 }*/