package org.example.todo.controller;

import lombok.AllArgsConstructor;
import org.example.todo.repository.TaskRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("task")
public class TaskController {
    private TaskRepository taskRepository;
}
