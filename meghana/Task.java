package com.meghana;


public class Task
{
    private int id;
    private String name;
    private String description;
    private String dueDate;
    private Status ts;
    public Task(){

    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", ts=" + ts +
                '}';
    }

    Task(int addId, String name, String descriptions, String date, Status status) {
        this.id = addId;
        this.name = name;
        this.description = descriptions;
        this.dueDate = date;
        this.ts = status;
    }
    public int getTaskId()
    {
        return id;
    }
    public void setTaskId(int taskId)
    {
        this.id=taskId;
    }
    public Status getStatus()
    {
        return ts;
    }

    public void setStatus(Status status)
    {
        this.ts = status;
    }

    public String getTaskName()
    {
        return name;
    }

    public void setTaskName(String taskName)
    {
        this.name = taskName;
    }

    public String getTaskDesc()
    {
        return description;
    }

    public void setTaskDesc(String taskDesc)
    {
        this.description = taskDesc;
    }

    public String getDueDate()
    {
        return dueDate;
    }

    public void setDueDate(String dueDate)
    {
        this.dueDate = dueDate;
    }

}


