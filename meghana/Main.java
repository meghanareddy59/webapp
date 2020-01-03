package com.meghana;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

class MAIN {

   public static void main(String args[]) throws SQLException {
       Taskmanager taskmanager=new Taskmanager();
       while (true) {
           System.out.println("1 for adding data\n2 for printing entire data\n3 for searching data");
           System.out.println( "4 for removing data\n5 displaying data by using status\n6 for exit");
           System.out.println("Enter your option");
           Scanner sc = new Scanner(System.in);
           int option = sc.nextInt();
           switch (option) {
               case 1:
                   System.out.println("Enter id");
                   int id = sc.nextInt();
                   System.out.println("Enter name");
                   String name = sc.next();
                   System.out.println("Enter description");
                   String description = sc.next();
                   System.out.println("Enter date");
                   String date = sc.next();
                   System.out.println("Enter status");
                   String status=sc.next();

                   taskmanager.add(id,name, description, date, status);
               break;
               case 2:
                      List <Task> taskList=taskmanager.display();
                      for (Task obj : taskList) {
                          System.out.println("Id:"+obj.getTaskId());
                          System.out.println("Name:"+obj.getTaskName());
                          System.out.println("Description:"+obj.getTaskDesc());
                          System.out.println("Date:"+obj. getDueDate());
                          System.out.println("Status:"+obj. getStatus());
                      }
               break;

               case 3:
                   System.out.println("Enter id to search:");
                         int ID = sc.nextInt();

                       System.out.println(taskmanager.FindById(ID));

                break;
               case 4:
                   System.out.println("Enter id to remove:");
                   int removableid= sc.nextInt();
                   taskmanager.delete(removableid);
               break;
               case 5:
                   System.out.println("Enter  status");
                   String requiredStatus= sc.next();
                  // Status s=Status.valueOf(requiredStatus);
                   System.out.println(taskmanager.listByStatus(requiredStatus));


               break;

               case 6:
                   System.exit(0);
               default:
                   System.out.println("Incorrect option");
           }

       }
   }
}
