package com.selva.securityjwt.service;

import com.selva.securityjwt.DTO.ProjectDTO;
import com.selva.securityjwt.exception.ResourceNotFoundException;
import com.selva.securityjwt.mapper.DTOMapper;
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

    public List<ProjectDTO> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return DTOMapper.toProjectDTOs(projects);
    }

    public Optional<ProjectDTO> getProjectById(Long id) {
        Optional<Project> project = projectRepository.findById(id);
        return project.map(DTOMapper::toDTO);
    }

    public ProjectDTO addProject(Project project) {
        Project savedProject = projectRepository.save(project);
        return DTOMapper.toDTO(savedProject);
    }

    public ProjectDTO updateProject(Long id, Project projectDetails) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + id));

        project.setProjectName(projectDetails.getProjectName());
        project.setStartDate(projectDetails.getStartDate());
        project.setEndDate(projectDetails.getEndDate());
        project.setClient(projectDetails.getClient());
        project.setBudget(projectDetails.getBudget());

        Project updatedProject = projectRepository.save(project);
        return DTOMapper.toDTO(updatedProject);
    }

    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + id));

        projectRepository.delete(project);
    }
}
