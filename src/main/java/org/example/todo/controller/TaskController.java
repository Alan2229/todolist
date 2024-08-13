package org.example.todo.controller;

import lombok.AllArgsConstructor;
import org.example.todo.model.Task;
import org.example.todo.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class TaskController {
    private TaskRepository taskRepository;
    @GetMapping("/all")
    public List<Task> getAllTask(){
        if(taskRepository.findAll().isEmpty()){
            List<Task> ans = new ArrayList<>();
            return ans;
        }
        return taskRepository.findAll();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return task;
    }
}
