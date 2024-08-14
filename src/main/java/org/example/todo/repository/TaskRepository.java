package org.example.todo.repository;

import org.example.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findAllByCompletedIsTrue();

    List<Task> findAllByCompletedIsFalse();

    Optional<Task> findFirstByTitle(String title);
}
