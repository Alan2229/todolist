package org.example.todo.controller;

import lombok.RequiredArgsConstructor;
import org.example.todo.dto.CommonResponse;
import org.example.todo.dto.TaskDto;
import org.example.todo.model.Task;
import org.example.todo.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tasks")
@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/all")
    public List<Task> getAllTask() {
        return taskService.findAll();
    }

    @GetMapping("/completed")
    public List<Task> getCompletedTask() {
        return taskService.findAllCompleted();
    }

    @GetMapping("/toBeDone")
    public List<Task> getToBeDoneTask() {
        return taskService.findAllToBeDone();
    }

    @GetMapping("/getById/{id}")
    public Object getById(@PathVariable Long id) {
        var taskOpt = taskService.findById(id);
        if (taskOpt.isPresent()) {
            return taskOpt.get();
        }
        return CommonResponse.builder().message("No such task").build();
    }

    @PostMapping("/create")
    public TaskDto createTask(@RequestBody TaskDto taskDto) {
        return taskService.createTask(taskDto);
    }

    @DeleteMapping("/deleteTask/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTaskById(id);
    }

    @PutMapping("/update/{title}")
    public TaskDto updateTask(@PathVariable String title, @RequestBody Task task) {
        Task updatedTask = taskService.updateTask(title, task);
        if (updatedTask != null) {
            return new TaskDto(
                    updatedTask.getTitle(),
                    updatedTask.getLevelOfEffort(),
                    updatedTask.getPriority(),
                    updatedTask.isCompleted(),
                    updatedTask.getId()
            );
        }
        throw new RuntimeException("This task is not found");
    }

}
