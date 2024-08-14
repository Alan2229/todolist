package org.example.todo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.todo.model.enums.DayOfWeek;
import org.example.todo.model.enums.LevelOfEffort;
import org.example.todo.model.enums.Priority;

import java.util.Date;

@Data
@Entity
@Builder
@Table(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @Enumerated(EnumType.STRING)
    private LevelOfEffort levelOfEffort;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    private boolean completed;
    private DayOfWeek dueDate;
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
