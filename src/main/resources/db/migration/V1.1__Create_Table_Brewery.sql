CREATE TABLE IF NOT EXISTS brewery (
        id bigint not null auto_increment,
        name varchar(100),
        brewmaster varchar(45),
        description TEXT,
        location varchar(255),
        primary key (id)
    ) engine=InnoDB