INSERT INTO `user`(id, name, password) VALUES (1, 'john','$2a$10$uKYHKWB20gIUnSsEg.ArDOOCJtsTyx3SIRiIRt5fQ.5tjBpU5ykAy');
INSERT INTO `user`(id, name, password) VALUES (2, 'anish','$2a$10$uKYHKWB20gIUnSsEg.ArDOOCJtsTyx3SIRiIRt5fQ.5tjBpU5ykAy');

INSERT INTO role(id, name) VALUES(1, 'ROLE_USER');
INSERT INTO role(id, name) VALUES(2, 'ROLE_ADMIN');

INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,2);



