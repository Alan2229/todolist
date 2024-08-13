package org.example.todo.controller;

import lombok.AllArgsConstructor;
import org.example.todo.model.Task;
import org.example.todo.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
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
    @GetMapping("/completed")
    public List<Task> getCompletedTask(){
        if(taskRepository.findAll().stream().noneMatch(Task::isCompleted)){
            List<Task> x = new ArrayList<>();
            return x;
        }
        return taskRepository.findAll().stream().filter(Task::isCompleted).toList();
    }
    @GetMapping("/toBeDone")
    public List<Task> getToBeDoneTask(){
        if(taskRepository.findAll().stream().noneMatch(c-> !c.isCompleted())){
            List<Task> x = new ArrayList<>();
            return x;
        }
        return taskRepository.findAll().stream().filter(c-> !c.isCompleted()).toList();
    }
    @GetMapping("/getById")
    public Object getById(@PathVariable int id){
        if(taskRepository.findById((long) id).isEmpty()){
            HashMap<String,String> map = new HashMap<>();
            map.put("message","This task do not exists");
            return map;
        }
        return taskRepository.findById((long) id);
    }
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return task;
    }
}
