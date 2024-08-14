package org.example.todo.service;

import lombok.RequiredArgsConstructor;
import org.example.todo.dto.TaskDto;
import org.example.todo.model.Task;
import org.example.todo.model.User;
import org.example.todo.repository.TaskRepository;
import org.example.todo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public TaskDto createTask(TaskDto taskDto) {
        User user = userRepository.findById(taskDto.getUserId()).
                orElseThrow(() -> new RuntimeException("user with this id is not found"));

        Task newTask = Task.builder()
                .title(taskDto.getTitle())
                .completed(taskDto.isCompleted())
                .priority(taskDto.getPriority())
                .levelOfEffort(taskDto.getLevelOfEffort())
                .user(user)
                .build();

        taskRepository.save(newTask);

        return TaskDto.builder()
                .userId(newTask.getUser().getId())
                .priority(newTask.getPriority())
                .title(newTask.getTitle())
                .levelOfEffort(newTask.getLevelOfEffort())
                .completed(newTask.isCompleted())
                .build();
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }

    public Task updateTask(String title, Task updatedTask) {
        Optional<Task> taskOpt = taskRepository.findFirstByTitle(title);
        if(taskOpt.isEmpty()) {
            throw new RuntimeException("No such task!");
        }

        Task taskToUpdate = taskOpt.get();
        taskToUpdate.setTitle(updatedTask.getTitle());
        taskToUpdate.setLevelOfEffort(updatedTask.getLevelOfEffort());
        taskToUpdate.setPriority(updatedTask.getPriority());
        taskToUpdate.setCompleted(updatedTask.isCompleted());
        taskRepository.save(taskToUpdate);
        return taskToUpdate;
    }

    public List<Task> findAllCompleted() {
        return taskRepository.findAllByCompletedIsTrue();
    }

    public List<Task> findAllToBeDone() {
        return taskRepository.findAllByCompletedIsFalse();
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }
}
