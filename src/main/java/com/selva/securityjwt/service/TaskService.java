package com.selva.securityjwt.service;


import com.selva.securityjwt.DTO.ProjectDTO;
import com.selva.securityjwt.DTO.TaskDTO;
import com.selva.securityjwt.exception.ResourceNotFoundException;
import com.selva.securityjwt.mapper.DTOMapper;
import com.selva.securityjwt.model.Project;
import com.selva.securityjwt.model.Task;
import com.selva.securityjwt.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Transactional(readOnly = true)
    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return DTOMapper.toTaskDTOs(tasks);
    }

    public Optional<TaskDTO> getTaskById(int id) {
        Optional<Task> result = taskRepository.findById(id);
        return result.map(DTOMapper::toDTO);
    }

    public TaskDTO createTask(Task task) {
        Task savedTask = taskRepository.save(task);
        return DTOMapper.toDTO(savedTask);
    }

    public TaskDTO updateTask(int id, Task taskDetails) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found for this id :: " + id));

        task.setTaskDescription(taskDetails.getTaskDescription());
        task.setStartDate(taskDetails.getStartDate());
        task.setDueDate(taskDetails.getDueDate());
        task.setProject(taskDetails.getProject());
        task.setTaskName(taskDetails.getTaskName());

        Task updatedTask = taskRepository.save(task);
        return DTOMapper.toDTO(updatedTask);
    }

    public void deleteTask(int id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found for this id :: " + id));

        taskRepository.delete(task);
    }
}
