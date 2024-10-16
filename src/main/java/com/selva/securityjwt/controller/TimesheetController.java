package com.selva.securityjwt.controller;

import com.selva.securityjwt.model.Timesheet;
import com.selva.securityjwt.service.TimesheetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timesheets")
public class TimesheetController {

    private final TimesheetService timesheetService;

    public TimesheetController(TimesheetService timesheetService) {
        this.timesheetService = timesheetService;
    }

    @PostMapping
    public Timesheet createTimesheet(@RequestBody Timesheet timesheet) {
        return timesheetService.createTimesheet(timesheet);
    }

    @GetMapping
    public List<Timesheet> getAllTimesheets() {
        return timesheetService.getAllTimesheets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Timesheet> getTimesheetById(@PathVariable Long id) {
        Timesheet timesheet = timesheetService.getTimesheetById(id);
        if (timesheet == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(timesheet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTimesheet(@PathVariable Long id) {
        timesheetService.deleteTimesheet(id);
        return ResponseEntity.noContent().build();
    }
}