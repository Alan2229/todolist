package org.example.todo.controller;

import lombok.Getter;
import org.example.todo.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return task;
    }
}
