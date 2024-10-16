package com.selva.securityjwt.service;

import com.selva.securityjwt.exception.ResourceNotFoundException;
import com.selva.securityjwt.model.Project;
import com.selva.securityjwt.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Long id, Project projectDetails) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + id));

        project.setProjectName(projectDetails.getProjectName());
        project.setStartDate(projectDetails.getStartDate());
        project.setEndDate(projectDetails.getEndDate());
        project.setBudget(projectDetails.getBudget());

        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + id));

        projectRepository.delete(project);
    }
}
