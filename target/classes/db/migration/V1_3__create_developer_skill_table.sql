CREATE TABLE IF NOT EXISTS developer_skill
(
    developer_id int NOT NULL ,
    skill_id     int NOT NULL ,
    foreign key (developer_id) references developer(id)
        on delete cascade,
    foreign key (skill_id) references skill (skill_id)
        on delete cascade
);

