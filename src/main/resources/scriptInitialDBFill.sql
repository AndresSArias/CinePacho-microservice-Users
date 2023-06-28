/*
	Script for the fill the initial register of cinepacho_dbusers
*/
USE cinepacho_dbusers;

INSERT INTO roles (id, description, name) VALUES ('1', 'ROLE_DIRECTOR', 'ROLE_DIRECTOR');
INSERT INTO roles (id, description, name) VALUES ('2', 'ROLE_ADMIN', 'ROLE_ADMIN');
INSERT INTO roles (id, description, name) VALUES ('3', 'ROLE_EMPLOYEE', 'ROLE_EMPLOYEE');
INSERT INTO roles (id, description, name) VALUES ('4', 'ROLE_CUSTOMER', 'ROLE_CUSTOMER');


INSERT INTO users (id, number_document, name, date_birth, phone, email, id_role)
VALUES (1, '9999999999', 'Miguel Feijoo', STR_TO_DATE('29-03-1988', '%d-%m-%Y'),'3142294644','Director@cinepacho.com', 1);
INSERT INTO members (id,number_document,code_employee,multiplex,salary,date_contract,password)
VALUES (1,'9999999999', 'D1',null,20000000,STR_TO_DATE('13-06-2023', '%d-%m-%Y'),'$2a$10$GlsGSNhkbVon6ZOSNMptOu5RikedRzlCAhMa7YpwvUSS0c88WT99S');

INSERT INTO users (id, number_document, name, date_birth, phone, email, id_role)
VALUES (2, '222', 'Pepito Juares', STR_TO_DATE('29-03-1998', '%d-%m-%Y'),'3142292644','AdminTitan@cinepacho.com', 2);
INSERT INTO members (id,number_document,code_employee,multiplex,salary,date_contract,password)
VALUES (2,'222', 'AT1','TITAN',10000000,STR_TO_DATE('15-06-2023', '%d-%m-%Y'),'$2a$10$GlsGSNhkbVon6ZOSNMptOu5RikedRzlCAhMa7YpwvUSS0c88WT99S');

INSERT INTO users (id, number_document, name, date_birth, phone, email, id_role)
VALUES (3, '333', 'Jorge Arias', STR_TO_DATE('10-12-2001', '%d-%m-%Y'),'3101234567','EmpleadoTitan@cinepacho.com', 3);
INSERT INTO members (id,number_document,code_employee,multiplex,salary,date_contract,password)
VALUES (3,'333', 'ET1','TITAN',1300000,STR_TO_DATE('20-06-2023', '%d-%m-%Y'),'$2a$10$GlsGSNhkbVon6ZOSNMptOu5RikedRzlCAhMa7YpwvUSS0c88WT99S');

INSERT INTO users (id, number_document, name, date_birth, phone, email, id_role)
VALUES (4, '444', 'Johan Gomez', STR_TO_DATE('10-02-2000', '%d-%m-%Y'),'3101264567','Cliente@cinepacho.com', 4);
INSERT INTO clients (id,number_document,rating_cinepacho)
VALUES (1,'444',null);