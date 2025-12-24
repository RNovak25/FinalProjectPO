CREATE TABLE t_teacher (
id BIGSERIAL PRIMARY KEY,
full_name VARCHAR(255),
specialization VARCHAR(255),
experience_years INT
);

CREATE TABLE t_student (
id BIGSERIAL PRIMARY KEY,
first_name VARCHAR(255),
last_name VARCHAR(255),
email VARCHAR(255),
age INT
);

CREATE TABLE t_course (
id BIGSERIAL PRIMARY KEY,
course_name VARCHAR(255),
description VARCHAR(255),
duration_months INT
);