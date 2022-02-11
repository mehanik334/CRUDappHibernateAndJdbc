CREATE TABLE IF NOT EXISTS developer
(
    id         int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    first_name varchar(255),
    last_name  varchar(255),
    team_id    int,
    foreign key (team_id) references team (id)
        on delete cascade
);
