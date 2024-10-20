alter table leave ADD column bal_annual_leave int not null default 0;
alter table leave add column bal_sick_leave int not null default 0;
alter table leave add column bal_child_care_leave int not null default 0;