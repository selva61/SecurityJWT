package com.selva.securityjwt.service;

import com.selva.securityjwt.model.Timesheet;
import com.selva.securityjwt.repository.TimesheetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimesheetService {

    private final TimesheetRepository timesheetRepository;

    public TimesheetService(TimesheetRepository timesheetRepository) {
        this.timesheetRepository = timesheetRepository;
    }

    public Timesheet createTimesheet(Timesheet timesheet) {
        return timesheetRepository.save(timesheet);
    }

    public List<Timesheet> getAllTimesheets() {
        return timesheetRepository.findAll();
    }

    public Timesheet getTimesheetById(Long id) {
        return timesheetRepository.findById(id).orElse(null);
    }

    public void deleteTimesheet(Long id) {
        timesheetRepository.deleteById(id);
    }
}