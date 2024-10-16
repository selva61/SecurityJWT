package com.selva.securityjwt.service;


import com.selva.securityjwt.model.Task;
import com.selva.securityjwt.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(int id) {
        Optional<Task> result = taskRepository.findById(id);
        return result.orElse(null);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(int id, Task taskDetails) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTaskName(taskDetails.getTaskName());
                    task.setTaskDescription(taskDetails.getTaskDescription());
                    task.setStartDate(taskDetails.getStartDate());
                    task.setDueDate(taskDetails.getDueDate());
                    return taskRepository.save(task);
                })
                .orElse(null);
    }

    public boolean deleteTask(int id) {
        return taskRepository.findById(id)
                .map(task -> {
                    taskRepository.delete(task);
                    return true;
                })
                .orElse(false);
    }
}
