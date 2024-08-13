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

    public boolean deleteTask(Task task) {
        return tasks.remove(task);
    }

    public Task updateTask(String title, Task task) {
        for(Task task1 : tasks) {
            if(task1.getTitle().equals(title)) {
                task1.setTitle(task.getTitle());
                task1.setLevelOfEffort(task.getLevelOfEffort());
                task1.setPriority(task.getPriority());
                task1.setCompleted(task.isCompleted());
                return task1;
            }
        }
        return null;
    }
}
