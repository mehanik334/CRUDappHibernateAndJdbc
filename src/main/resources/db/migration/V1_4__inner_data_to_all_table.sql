INSERT INTO team(team_name)
VALUES ('Java team');
INSERT INTO team(team_name)
VALUES ('C++ team');

INSERT INTO skill( name)
VALUES ('Java');
INSERT INTO skill( name)
VALUES ('Spring');
INSERT INTO skill( name)
VALUES ('Hibernate');
INSERT INTO skill( name)
VALUES ('C++');

INSERT INTO developer( first_name, last_name, team_id)
VALUES ('Alex', 'Denisenko', 1);
INSERT INTO developer(first_name, last_name, team_id)
VALUES ('Alena', 'Denisenko', 2);
INSERT INTO developer(first_name, last_name, team_id)
VALUES ('Dima', 'Ivanov', 1);

INSERT INTO developer_skill(developer_id, skill_id)
VALUES (1, 1);
INSERT INTO developer_skill(developer_id, skill_id)
VALUES (1, 2);
INSERT INTO developer_skill(developer_id, skill_id)
VALUES (2, 4);
INSERT INTO developer_skill(developer_id, skill_id)
VALUES (3, 1);
INSERT INTO developer_skill(developer_id, skill_id)
VALUES (3, 2);
INSERT INTO developer_skill(developer_id, skill_id)
VALUES (3, 3);


