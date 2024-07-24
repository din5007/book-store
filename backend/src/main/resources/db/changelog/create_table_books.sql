#CREATE DATABASE if not exists onlinebookstore;
CREATE TABLE if not exists books
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    title     TEXT NOT NULL,
    author    VARCHAR(100) NOT NULL,
    price     INT,
    quantity  BIGINT
);