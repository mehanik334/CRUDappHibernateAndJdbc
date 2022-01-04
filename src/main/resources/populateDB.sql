INSERT INTO developer(id,first_name,last_name) VALUES (1,'Alex','Denisenko');
INSERT INTO developer(id,first_name,last_name) VALUES (2,'Alena','Chernenko');
INSERT INTO developer(id,first_name,last_name) VALUES (3,'Dima','Ivanov');

INSERT INTO skill(skill_id,name) VALUES (1,'Java');
INSERT INTO skill(skill_id,name) VALUES (2,'Spring');
INSERT INTO skill(skill_id,name) VALUES (3,'Hibernate');
INSERT INTO skill(skill_id,name) VALUES (4,'C++');

INSERT INTO developer_skill(developer_id,skill_id) VALUES (1,1);
INSERT INTO developer_skill(developer_id,skill_id) VALUES (1,2);
INSERT INTO developer_skill(developer_id,skill_id) VALUES (2,4);
INSERT INTO developer_skill(developer_id,skill_id) VALUES (3,1);
INSERT INTO developer_skill(developer_id,skill_id) VALUES (3,2);
INSERT INTO developer_skill(developer_id,skill_id) VALUES (3,3);

INSERT INTO team(id,name,developer_id) VALUES (1,'Java team',1);
INSERT INTO team(id,name,developer_id) VALUES (2,'Java team',3);
INSERT INTO team(id,name,developer_id) VALUES (3,'C++ team',2);