package com.selva.securityjwt.mapper;

import com.selva.securityjwt.DTO.TaskDTO;
import com.selva.securityjwt.model.Task;

import java.util.List;
import java.util.stream.Collectors;

public class DTOMapper {
    public static TaskDTO toDTO(Task task) {
        return new TaskDTO(task.getId(), task.getTaskDescription(), task.getProject().getId(), task.getStartDate(), task.getDueDate());
    }

    public static List<TaskDTO> toDTOs(List<Task> tasks) {
        return tasks.stream().map(DTOMapper::toDTO).collect(Collectors.toList());
    }
}
