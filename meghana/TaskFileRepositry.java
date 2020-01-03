package com.meghana;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskFileRepositry implements TaskRepository {

    private static final String TASKS_JSON_FILE = "/home/meghana/IdeaProjects/tasks-console/src/com/meghana/file.json";
    private ObjectMapper objectMapper = new ObjectMapper();

    List<Task> tasks;
    File file = new File(TASKS_JSON_FILE);


    public TaskFileRepositry() {

        tasks = readFromFile();
    }

    private void writeToFile(List<Task> tasks) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new FileWriter(TASKS_JSON_FILE), tasks);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private List<Task> readFromFile() {
        final File file = new File(TASKS_JSON_FILE);
        if (file.exists()) {
            try {
                return (List<Task>) objectMapper.readValue(file, TaskList.class);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
        writeToFile(tasks);
    }

    @Override
    public List<Task> display() {
        return readFromFile();
    }

    @Override
    public Task FindById(int taskId) {
        for (Task task : tasks) {
            if (task.getTaskId() == taskId)
                return task;
        }
        return null;
    }

    @Override
    public void delete(int taskId) {
        for (Task task : tasks) {
            if (task.getTaskId() == taskId) {

                tasks.remove(task);
            }
        }
    }

    @Override
    public Task listByStatus(String requiredStatus) throws SQLException {
        return null;
    }



}
