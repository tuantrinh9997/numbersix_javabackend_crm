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