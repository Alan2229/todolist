package org.example.todo.dto;

import lombok.*;
import org.example.todo.model.enums.LevelOfEffort;
import org.example.todo.model.enums.Priority;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class TaskDto {
    private String title;
    private LevelOfEffort levelOfEffort;
    private Priority priority;
    private boolean completed;
    private Long userId;



    public TaskDto(String title, LevelOfEffort levelOfEffort, Priority priority, boolean completed, Long id) {
    }

    public TaskDto(String title, Priority priority, int id, boolean completed) {
    }
}
