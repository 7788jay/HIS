/*5.权限类型表*/
create table type(
	tp_id varchar(40) primary key,
	tp_name varchar(100) not null
);
/*1.权限*/
create table privilege(
	pid varchar(40) primary key,
	pname varchar(50) not null unique,
	pdescription varchar(100),
	type_name varchar(40) not null,
	resourcename varchar(100) not null unique,
	foreign key(type_name) references type(tp_name)
);
/*2.角色*/
create table role(
	roleid varchar(40) primary key,
	rolename varchar(50) not null unique
);
/*3.权限-角色（多对多）*/
create table privilege_role(
	pid varchar(40) not null,
	roleid varchar(40) not null,
	foreign key(pid) references privilege(pid),
	foreign key(roleid) references role(roleid)
);
/*4.角色-用户（多对多）*/
create table role_outpatient_docter(
	roleid varchar(40) not null,
	outpatient_docter_id varchar(40) not null,
	foreign key(roleid) references role(roleid),
	foreign key(outpatient_docter_id) references outpatient_docter(doctor_id)
);

++++++++用户角色++++


++++++++医生时间安排表++++++++
CREATE TABLE schedule(
  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY ,
  doctor_id VARCHAR(40) NOT NULL ,
  time INT NOT NULL ,
  week INT NOT NULL ,
  sum INT NOT NULL ,
  left_sum INT NOT NULL

);
++++++++挂号表+++++
create TABLE appointment (
    id INT not null,
    patient_id VARCHAR(40) not null default '',
    doctor_id VARCHAR(40) not null default '',
    appoint_time DATE not null default '',
    "time" INT not null,
    week INT not null,
    priority INT not null,
    status INT default 0,
    create_time TIMESTAMP not null default CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);