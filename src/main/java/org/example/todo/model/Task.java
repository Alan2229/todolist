package org.example.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.todo.model.enums.DayOfWeek;
import org.example.todo.model.enums.LevelOfEffort;
import org.example.todo.model.enums.Priority;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private LevelOfEffort levelOfEffort;
    private Priority priority;
    private boolean completed;
    private DayOfWeek dueDate;
    private Date createdAt;

}
