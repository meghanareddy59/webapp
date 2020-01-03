package com.meghana;

import java.sql.SQLException;
import java.util.List;

public interface TaskRepository {
    public void addTask(Task task) throws SQLException;

    public List<Task> display() throws SQLException;
    public Task FindById(int taskId) throws SQLException;
    public void delete(int taskId) throws SQLException;

   public  Task listByStatus(String requiredStatus) throws SQLException;


}
