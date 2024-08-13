package org.example.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.example.todo.model.enums.DayOfWeek;
import org.example.todo.model.enums.LevelOfEffort;
import org.example.todo.model.enums.Priority;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private LevelOfEffort levelOfEffort;
    private Priority priority;
    private boolean isCompleted;
    private DayOfWeek dueDate;
    private Date createdAt;


    public Task(String title, LevelOfEffort levelOfEffort, Priority priority, boolean completed) {
    }
}
