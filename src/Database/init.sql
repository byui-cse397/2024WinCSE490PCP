-- Database Connection Setup --
-- DROP DATABASE linkup_db;
-- Database Connection Setup --

CREATE DATABASE IF NOT EXISTS linkup_db;

USE linkup_db;
CREATE USER IF NOT EXISTS 'linkup-admin'@'localhost' IDENTIFIED BY 'nimda';
GRANT ALL PRIVILEGES ON linkup_db.* TO 'linkup-admin'@'localhost';

CREATE USER IF NOT EXISTS 'linkup-user'@'localhost' IDENTIFIED BY 'user';
GRANT SELECT, INSERT, UPDATE, DELETE ON linkup_db.* TO 'linkup-user'@'localhost';

CREATE USER IF NOT EXISTS 'linkup-tester'@'localhost' IDENTIFIED BY 'tester';
GRANT SELECT, INSERT, UPDATE, DELETE ON linkup_db.* TO 'linkup-user'@'localhost';

FLUSH PRIVILEGES;

-- Table Schema Setup --

CREATE TABLE IF NOT EXISTS Accounts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password_hash VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Community (
    id INT AUTO_INCREMENT PRIMARY KEY,
    community_name VARCHAR(255) NOT NULL
--    region VARCHAR(30) NOT NULL,
);

CREATE TABLE IF NOT EXISTS Post (
    id INT AUTO_INCREMENT PRIMARY KEY,
    content_text VARCHAR(800) NOT NULL,
    accounts_id INT NOT NULL, -- Alias, so I dont have to use id for primary and foreign key, which would cause issues
    post_time DATETIME NOT NULL,
    community_id int,
    CONSTRAINT fk_Post_Accounts FOREIGN KEY (accounts_id) REFERENCES Accounts(id),-- Create the actual foreign key relationship
    CONSTRAINT fk_Post_Community FOREIGN KEY (community_id) REFERENCES Community(id)
);

CREATE TABLE IF NOT EXISTS Departing (
    id INT AUTO_INCREMENT PRIMARY KEY,
    location_text VARCHAR(255) NOT NULL,
    post_id INT NOT NULL,
    CONSTRAINT fk_Departing_Post_Id FOREIGN KEY (post_id) REFERENCES Post(id)
);

CREATE TABLE IF NOT EXISTS Arriving (
    id INT AUTO_INCREMENT PRIMARY KEY,
    location_text VARCHAR(255) NOT NULL,
    post_id INT NOT NULL,
    CONSTRAINT fk_Arriving_Post_Id FOREIGN KEY (post_id) REFERENCES Post(id)
);

CREATE TABLE IF NOT EXISTS Forums (
    id INT AUTO_INCREMENT PRIMARY KEY,
    forum_name VARCHAR(255) NOT NULL,
    post_id INT NOT NULL,
    CONSTRAINT fk_Forum_Post_Id FOREIGN KEY (post_id) REFERENCES Post(id)
);

CREATE TABLE IF NOT EXISTS Comments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    comment_text VARCHAR(255) NOT NULL,
    post_id INT NOT NULL,
    CONSTRAINT fk_Comments_Post_Id FOREIGN KEY (post_id) REFERENCES Post(id)
);

CREATE TABLE IF NOT EXISTS Messages (
    id INT AUTO_INCREMENT PRIMARY KEY,
    message_content VARCHAR(300) NOT NULL,
    message_time DATETIME NOT NULL,
    sender_id INT NOT NULL,
    receiver_id INT NOT NULL,
    CONSTRAINT fk_Messages_sender_id FOREIGN KEY (sender_id) REFERENCES Accounts(id),
    CONSTRAINT fk_Messages_receiver_id FOREIGN KEY (receiver_id) REFERENCES Accounts(id)
);