package org.example.todo.dto;

import lombok.*;
import org.example.todo.model.enums.LevelOfEffort;
import org.example.todo.model.enums.Priority;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private String title;
    private LevelOfEffort levelOfEffort;
    private Priority priority;
    private boolean completed;
    private Long userId;
}
