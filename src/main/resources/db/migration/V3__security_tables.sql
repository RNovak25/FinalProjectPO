CREATE TABLE t_permission (
id BIGSERIAL PRIMARY KEY,
name VARCHAR(255)
);

CREATE TABLE t_user (
id BIGSERIAL PRIMARY KEY,
email VARCHAR(255),
password VARCHAR(255),
username VARCHAR(255)
);

CREATE TABLE t_user_permissions (
user_model_id BIGINT NOT NULL,
permissions_id BIGINT NOT NULL,
CONSTRAINT fk_user_permissions_user FOREIGN KEY (user_model_id) REFERENCES t_user(id),
CONSTRAINT fk_user_permissions_permission FOREIGN KEY (permissions_id) REFERENCES t_permission(id)
);

CREATE TABLE t_item (
id BIGSERIAL PRIMARY KEY,
name_item VARCHAR(255),
desc_item VARCHAR(255)
);

INSERT INTO t_permission (name) VALUES ('ROLE_USER');
INSERT INTO t_permission (name) VALUES ('ROLE_ADMIN');
INSERT INTO t_permission (name) VALUES ('ROLE_TEACHER');