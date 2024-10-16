package com.selva.securityjwt.controller;

import com.selva.securityjwt.model.Project;
import com.selva.securityjwt.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable(value = "id") Long projectId) {
        Optional<Project> project = projectService.getProjectById(projectId);
        return project.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.addProject(project);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable(value = "id") Long projectId,
                                                 @RequestBody Project projectDetails) {
        Project updatedProject = projectService.updateProject(projectId, projectDetails);
        return ResponseEntity.ok(updatedProject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable(value = "id") Long projectId) {
        projectService.deleteProject(projectId);
        return ResponseEntity.ok().build();
    }
}
