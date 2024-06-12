CREATE TABLE IF NOT EXISTS brewery (
        id bigint not null auto_increment,
        brewmaster varchar(45),
        name varchar(100),
        primary key (id)
    ) engine=InnoDB