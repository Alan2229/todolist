package org.example.todo.dto;

import lombok.*;
import org.example.todo.model.enums.LevelOfEffort;
import org.example.todo.model.enums.Priority;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class TaskDto {
    private String title;
    private LevelOfEffort levelOfEffort;
    private Priority priority;
    private boolean isCompleted;

    public TaskDto(String title, Priority priority, int id, boolean completed) {
    }
}
