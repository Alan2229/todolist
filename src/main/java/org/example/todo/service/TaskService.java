package org.example.todo.service;

import org.example.todo.dto.TaskDto;
import org.example.todo.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();

    public TaskDto createTask(Task taskDto) {
        Task newTask = new Task(
                taskDto.getTitle(),
                taskDto.getLevelOfEffort(),
                taskDto.getPriority(),
                taskDto.isCompleted()
        );
        tasks.add(newTask);

        return new TaskDto(
        newTask.getTitle(),
        newTask.getLevelOfEffort(),
        newTask.getPriority(),
        newTask.isCompleted()
        );
    }
}
