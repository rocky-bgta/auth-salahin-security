INSERT INTO `user`(id, name, password) VALUES (1, 'john','$2a$10$uKYHKWB20gIUnSsEg.ArDOOCJtsTyx3SIRiIRt5fQ.5tjBpU5ykAy');
INSERT INTO `user`(id, name, password) VALUES (2, 'anish','$2a$10$uKYHKWB20gIUnSsEg.ArDOOCJtsTyx3SIRiIRt5fQ.5tjBpU5ykAy');
                                                           --password
INSERT INTO role(id, name) VALUES(1, 'ROLE_USER');
INSERT INTO role(id, name) VALUES(2, 'ROLE_ADMIN');

INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,2);


CREATE TABLE oauth_access_token (
                                    authentication_id varchar(255) NOT NULL PRIMARY KEY,
                                    token_id varchar(255) NOT NULL,
                                    token blob NOT NULL,
                                    user_name varchar(255) NOT NULL,
                                    client_id varchar(255) NOT NULL,
                                    authentication blob NOT NULL,
                                    refresh_token varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE oauth_refresh_token (
                                     token_id varchar(255) NOT NULL,
                                     token blob NOT NULL,
                                     authentication blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



