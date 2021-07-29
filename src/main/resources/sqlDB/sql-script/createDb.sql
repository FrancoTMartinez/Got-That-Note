USE got-that-note-db-MySql
CREATE TABLE Users (
    Id integer(11) NOT NULL AUTO_INCREMENT,
    EMAIL varchar(50) NOT NULL,
    USER_PASSWORD varchar(50) NOT NULL,
    PRIMARY KEY (Id)
);
