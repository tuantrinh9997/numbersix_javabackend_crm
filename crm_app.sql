create database if not exists crm_applycation;

use crm_applycation;

create table if not exists roles(
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(100),
    PRIMARY KEY (id)
);

create table if not exists users(
	id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    fullname VARCHAR(100) NOT NULL,
    phone VARCHAR(36),
    role_id INT NOT NULL,
    PRIMARY KEY (id)
);

create table if not exists status(
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    description varchar(255),
    PRIMARY KEY (id)
);

create table if not exists task(
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    start_date DATE,
    end_date DATE,
    assignee INT NOT NULL,
    project INT NOT NULL,
    status INT NOT NULL,
    description varchar(255),
    PRIMARY KEY (id)
);

create table if not exists project(
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    start_date DATE,
    end_date DATE,
    description varchar(255),
    creat_user int,
    PRIMARY KEY (id)
);

alter table users add address varchar(255);
ALTER TABLE users
ADD CONSTRAINT FK_users_roles FOREIGN KEY (role_id) REFERENCES users(id);

ALTER TABLE project
ADD CONSTRAINT FK_users_project FOREIGN KEY (creat_user) REFERENCES roles(id);

ALTER TABLE task
ADD CONSTRAINT FK_tasks_users FOREIGN KEY (assignee) REFERENCES users(id);

ALTER TABLE task
ADD CONSTRAINT FK_tasks_project FOREIGN KEY (project) REFERENCES project(id);

ALTER TABLE task
ADD CONSTRAINT FK_tasks_status FOREIGN KEY (status) REFERENCES status(id);

insert into roles
values 
	(1, 'admin', 'admin'),
    (2, 'leader', 'leader'),
    (3, 'pg', 'manager'),
    (4, 'user1', 'user1');

insert into users
values
	(1, 'taithan', '12345', 'nguyen tai', '8736282', 1, 'tphcm'),
    (2, 'huyennguyen', '12345', 'nguyen huyen', '8736282', 2, 'soc trang'),
	(3, 'dungtran', '12345', 'tran dung', '8736282', 3, 'ha noi'),
    (4, 'tuyenhoang', '12345', 'hoang tuyen', '8736282', 4, 'da nang');
    
insert into users (email, password, fullname, phone, role_id, address)
values
	('minhbeo', '12345', 'nguyen minh', '8736282', 4, 'tphcm');
    
ALTER TABLE users
DROP FOREIGN KEY FK_users_roles;

ALTER TABLE users
ADD CONSTRAINT FK_users_roles FOREIGN KEY (role_id) REFERENCES roles(id);

ALTER TABLE project
DROP FOREIGN KEY FK_users_project;

ALTER TABLE project
ADD CONSTRAINT FK_users_project FOREIGN KEY (creat_user) REFERENCES users(id);

insert into project (name, start_date, end_date, description, creat_user)
values
	('HCM Tower', '2021-11-28', '2021-12-28', 'du an xay dung building', 4),
    ('Beach Valley', '2021-11-29', '2021-12-29', 'du an xay dung ven bien', 8),
    ('Sunrise Tower', '2021-11-30', '2021-12-30', 'du an xay dung building', 8);
    
insert into status (name, description)
values
	('Not yet', 'Chua bat dau lam'),
    ('Processing', 'Dang thuc hien'),
    ('Done', 'Da hoan thanh');
    
insert into task (name, start_date, end_date, assignee, project, status, description)
values
	('lam duong', '2021-11-30', '2021-12-7', 9, 6, 1, 'lam duong dan vao du an');
    
ALTER TABLE users
DROP FOREIGN KEY FK_users_roles;

ALTER TABLE users
ADD CONSTRAINT FK_users_roles FOREIGN KEY (role_id) REFERENCES roles(id);

delete
from roles
where id=3;

UPDATE roles
SET name = 'user', description = 'user'
WHERE id = 4;

delete
from users
where id=3;

ALTER TABLE users
DROP FOREIGN KEY FK_users_roles;

ALTER TABLE users
ADD CONSTRAINT FK_users_roles FOREIGN KEY (role_id) REFERENCES roles(id)
on update cascade
on delete cascade;

ALTER TABLE project
DROP FOREIGN KEY FK_users_project;

ALTER TABLE project
ADD CONSTRAINT FK_project_creat_user FOREIGN KEY (creat_user) REFERENCES users(id)
on update cascade
on delete cascade;

ALTER TABLE task
DROP FOREIGN KEY FK_tasks_users;

ALTER TABLE task
ADD CONSTRAINT FK_tasks_users FOREIGN KEY (assignee) REFERENCES users(id)
on update cascade
on delete cascade;

ALTER TABLE task
DROP FOREIGN KEY FK_tasks_project;

ALTER TABLE task
ADD CONSTRAINT FK_tasks_project FOREIGN KEY (project) REFERENCES project(id)
on update cascade
on delete cascade;

ALTER TABLE task
DROP FOREIGN KEY FK_tasks_status;

ALTER TABLE task
ADD CONSTRAINT FK_tasks_status FOREIGN KEY (status) REFERENCES status(id)
on update cascade
on delete cascade;

ALTER TABLE task
ALTER status SET DEFAULT 1;