CREATE SEQUENCE IF NOT EXISTS user_id_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE employee
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    CONSTRAINT pk_employee PRIMARY KEY (id)
);

CREATE TABLE employee_role
(
    employee_id BIGINT NOT NULL,
    role_id     BIGINT NOT NULL,
    CONSTRAINT pk_employee_role PRIMARY KEY (employee_id, role_id)
);

CREATE TABLE leave
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    start_date  date,
    end_date    date,
    type        VARCHAR(255),
    employee_id BIGINT,
    CONSTRAINT pk_leave PRIMARY KEY (id)
);

CREATE TABLE payroll
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    salary      DOUBLE PRECISION,
    pay_date    date,
    employee_id BIGINT,
    CONSTRAINT pk_payroll PRIMARY KEY (id)
);

CREATE TABLE role
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_role PRIMARY KEY (id)
);

CREATE TABLE users
(
    id         BIGINT       NOT NULL,
    username   VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE leave
    ADD CONSTRAINT FK_LEAVE_ON_EMPLOYEE FOREIGN KEY (employee_id) REFERENCES employee (id);

ALTER TABLE payroll
    ADD CONSTRAINT FK_PAYROLL_ON_EMPLOYEE FOREIGN KEY (employee_id) REFERENCES employee (id);

ALTER TABLE employee_role
    ADD CONSTRAINT fk_emprol_on_employee FOREIGN KEY (employee_id) REFERENCES employee (id);

ALTER TABLE employee_role
    ADD CONSTRAINT fk_emprol_on_role FOREIGN KEY (role_id) REFERENCES role (id);