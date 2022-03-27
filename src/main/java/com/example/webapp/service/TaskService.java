package com.example.webapp.service;


import com.example.webapp.entity.Task;
import com.example.webapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;

    }


    public String getName(int id){
        Optional<Task> task = taskRepository.findById(id);
        return task.get().getName();
    }

    public String getStatement(int id){
        Optional<Task> task = taskRepository.findById(id);
        return task.get().getStatement();
    }

    public String gettingTask(int id)
    {
        Optional<Task> task = taskRepository.findById(id);

        return task.get().getStatement();
    }

    public Set<Task> getTaskList(String courseId)
    {
        Iterable<Task> tasks = taskRepository.findAll();
        Set<Task> tasksIdList = new LinkedHashSet<Task>();
        return tasksIdList;
    }

    public Iterable<Task> getTasks() {

        return taskRepository.findAll();
    }
}

