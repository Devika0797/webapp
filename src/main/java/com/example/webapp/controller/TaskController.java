package com.example.webapp.controller;

import com.example.webapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TaskController {
    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;

    }

    @GetMapping("/task/{id}")
    public String task(@PathVariable("id") int id, Model model) {
        String name = taskService.getName(id);
        model.addAttribute("greeting", taskService.gettingTask((int)id));
        model.addAttribute("statement", taskService.getStatement(id));
        return "task";
    }

    @GetMapping("/tasks/{id}")
    public String TaskList(@PathVariable("id") String courseId, Model model) { //
        model.addAttribute("tasks", taskService.getTaskList(courseId));
        return "tasks";
    }
}
