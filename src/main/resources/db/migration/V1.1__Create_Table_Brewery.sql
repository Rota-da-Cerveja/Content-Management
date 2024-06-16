CREATE TABLE IF NOT EXISTS brewery (
    id bigint not null auto_increment,
    name varchar(100),
    brewmaster varchar(45),
    description TEXT,
    latitude DECIMAL(10, 7),
    longitude DECIMAL(10, 7),
    primary key (id)
) engine = InnoDB 

CREATE TABLE IF NOT EXISTS beer (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    minimum_temperature DECIMAL(10, 0) NOT NULL,
    maximum_temperature DECIMAL(10, 0) NOT NULL,
    ibu TINYINT NOT NULL,
    alcohol_content TINYINT NOT NULL,
    description VARCHAR(150) NOT NULL,
    type VARCHAR(50) NOT NULL,
    volume DECIMAL(10, 0) NOT NULL,
    brewery_id bigint NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_brewery FOREIGN KEY (brewery_id) REFERENCES brewery(id)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci