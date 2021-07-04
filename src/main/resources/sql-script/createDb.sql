USE got-that-note-db
CREATE TABLE Users (
    Id integer(11) NOT NULL AUTO_INCREMENT,
    EMAIL varchar(50) NOT NULL,
    USER_PASSWORD varchar(50) NOT NULL,
    PRIMARY KEY (Id)
);
CREATE TABLE Notes (
	Id integer(11) NOT NULL AUTO_INCREMENT,
	USER_ID integer(11) NOT NULL,
	TITLE varchar(11),
	TEXT varchar(350) NOT NULL,
	PRIMARY KEY (Id),
	FOREIGN KEY (USER_ID) REFERENCES Users(Id)
);
