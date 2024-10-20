package com.selva.securityjwt.DTO;

import java.time.LocalDate;

public class TaskDTO {
    private Integer id;
    private Integer projectId;
    private LocalDate startDate;
    private LocalDate dueDate;
    private String taskDescription;

    public TaskDTO(Integer id, String taskDescription, Integer id1, LocalDate startDate, LocalDate dueDate) {
        this.id = id;
        this.taskDescription = taskDescription;
        this.projectId = id1;
        this.startDate = startDate;
        this.dueDate = dueDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
}

