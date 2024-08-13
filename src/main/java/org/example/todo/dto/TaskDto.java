package org.example.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.todo.model.enums.LevelOfEffort;
import org.example.todo.model.enums.Priority;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private String title;
    private LevelOfEffort levelOfEffort;
    private Priority priority;
    private boolean completed;
}
