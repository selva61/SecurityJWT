package com.selva.securityjwt.controller;

import com.selva.securityjwt.DTO.ProjectDTO;
import com.selva.securityjwt.model.Project;
import com.selva.securityjwt.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<ProjectDTO> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable(value = "id") Long projectId) {
        Optional<ProjectDTO> project = projectService.getProjectById(projectId);
        return project.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@RequestBody Project project) {
        ProjectDTO savedTask = projectService.addProject(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable(value = "id") Long projectId,
                                                 @RequestBody Project projectDetails) {
        ProjectDTO updatedProject = projectService.updateProject(projectId, projectDetails);
        return ResponseEntity.ok(updatedProject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable(value = "id") Long projectId) {
        projectService.deleteProject(projectId);
        return ResponseEntity.ok().build();
    }
}
