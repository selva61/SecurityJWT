-- Time Entries Table
CREATE TABLE time_entries (
                              entry_id SERIAL PRIMARY KEY,
                              employee_id INT REFERENCES employee(id) ON DELETE CASCADE,
                              task_id INT REFERENCES tasks(task_id) ON DELETE CASCADE,
                              project_id INT REFERENCES projects(project_id) ON DELETE CASCADE,
                              client_id INT REFERENCES clients(client_id) ON DELETE SET NULL,
                              entry_date DATE NOT NULL,
                              start_time TIME NOT NULL,
                              end_time TIME NOT NULL,
                              hours_worked NUMERIC GENERATED ALWAYS AS (EXTRACT(EPOCH FROM (end_time - start_time)) / 3600) STORED,
                              description TEXT
);

-- Clients Table
CREATE TABLE clients (
                         client_id SERIAL PRIMARY KEY,
                         client_name VARCHAR(100) NOT NULL,
                         contact_email VARCHAR(100) UNIQUE NOT NULL
);

INSERT INTO clients (client_name, contact_email)
VALUES ('LTA', 'contact@clienta.com');

ALTER TABLE projects ADD COLUMN client_id INT;

ALTER TABLE projects
    ADD CONSTRAINT fk_client
        FOREIGN KEY (client_id)
            REFERENCES clients(client_id)
            ON DELETE SET NULL;

ALTER TABLE time_entries
    ALTER COLUMN employee_id TYPE BIGINT;