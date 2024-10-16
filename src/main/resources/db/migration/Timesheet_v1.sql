CREATE TABLE projects (
                          project_id SERIAL PRIMARY KEY,
                          project_name VARCHAR(200) NOT NULL,
                          start_date DATE,
                          end_date DATE,
                          budget DECIMAL(10, 2)
);

CREATE TABLE tasks (
                       task_id SERIAL PRIMARY KEY,
                       project_id INT REFERENCES projects(project_id),
                       task_name VARCHAR(200) NOT NULL,
                       task_description TEXT,
                       start_date DATE,
                       due_date DATE
);

CREATE TABLE timesheet_entries (
                                   entry_id SERIAL PRIMARY KEY,
                                   employee_id INT REFERENCES employee(id),
                                   task_id INT REFERENCES tasks(task_id),
                                   date_worked DATE NOT NULL,
                                   hours_worked DECIMAL(4, 2) NOT NULL,
                                   description TEXT
);

-- To track weekly summaries
CREATE TABLE weekly_summaries (
                                  summary_id SERIAL PRIMARY KEY,
                                  employee_id INT REFERENCES employee(id),
                                  week_start_date DATE NOT NULL,
                                  total_hours DECIMAL(5, 2) NOT NULL
);

-- Indices for faster queries
CREATE INDEX idx_timesheet_employee ON timesheet_entries (employee_id);
CREATE INDEX idx_timesheet_task ON timesheet_entries (task_id);
CREATE INDEX idx_timesheet_date_worked ON timesheet_entries (date_worked);

ALTER TABLE timesheet_entries
    ALTER COLUMN employee_id TYPE BIGINT;

ALTER TABLE weekly_summaries
    ALTER COLUMN employee_id TYPE BIGINT;