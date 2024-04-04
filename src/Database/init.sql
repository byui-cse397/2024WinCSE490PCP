-- Database Connection Setup --
-- DROP DATABASE IF EXISTS linkup_db; 

CREATE DATABASE IF NOT EXISTS linkup_db;

USE linkup_db;

-- User Management --

CREATE USER IF NOT EXISTS 'linkup-admin'@'localhost' IDENTIFIED BY 'nimda';
GRANT ALL PRIVILEGES ON linkup_db.* TO 'linkup-admin'@'localhost';

CREATE USER IF NOT EXISTS 'linkup-user'@'localhost' IDENTIFIED BY 'user';
GRANT SELECT, INSERT, UPDATE, DELETE ON linkup_db.* TO 'linkup-user'@'localhost';

CREATE USER IF NOT EXISTS 'linkup-tester'@'localhost' IDENTIFIED BY 'tester';
GRANT SELECT, INSERT, UPDATE, DELETE ON linkup_db.* TO 'linkup-tester'@'localhost'; -- Corrected the user name here

FLUSH PRIVILEGES;

-- Table Schema Setup --

CREATE TABLE IF NOT EXISTS ACCOUNT (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    UNIQUE (username) 
);

CREATE TABLE IF NOT EXISTS COMMUNITY (
    id INT AUTO_INCREMENT PRIMARY KEY,
    community_name VARCHAR(255) NOT NULL,
    parent_account_id INT,
    FOREIGN KEY (parent_account_id) REFERENCES ACCOUNT(id) ON DELETE CASCADE,
    UNIQUE (community_name)
);

CREATE TABLE IF NOT EXISTS POST (
    id INT AUTO_INCREMENT PRIMARY KEY,
    content_text VARCHAR(800) NOT NULL,
    account_id INT NOT NULL,
    community_id INT NOT NULL,
    post_time DATETIME NOT NULL,
    CONSTRAINT fk_Post_Account FOREIGN KEY (account_id) REFERENCES ACCOUNT(id),
    CONSTRAINT fk_Post_Community FOREIGN KEY (community_id) REFERENCES COMMUNITY(id)
);

CREATE TABLE IF NOT EXISTS DEPARTING (
    id INT AUTO_INCREMENT PRIMARY KEY,
    location_text VARCHAR(255) NOT NULL,
    post_id INT NOT NULL,
    CONSTRAINT fk_Departing_Post_Id FOREIGN KEY (post_id) REFERENCES POST(id)
);

CREATE TABLE IF NOT EXISTS ARRIVING (
    id INT AUTO_INCREMENT PRIMARY KEY,
    location_text VARCHAR(255) NOT NULL,
    post_id INT NOT NULL,
    CONSTRAINT fk_Arriving_Post_Id FOREIGN KEY (post_id) REFERENCES POST(id)
);

CREATE TABLE IF NOT EXISTS FORUMS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    forum_name VARCHAR(255) NOT NULL,
    post_id INT NOT NULL,
    CONSTRAINT fk_Forum_Post_Id FOREIGN KEY (post_id) REFERENCES POST(id)
);

CREATE TABLE IF NOT EXISTS COMMENTS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    comment_text VARCHAR(255) NOT NULL,
    post_id INT NOT NULL,
    CONSTRAINT fk_Comments_Post_Id FOREIGN KEY (post_id) REFERENCES POST(id)
);

CREATE TABLE IF NOT EXISTS MESSAGES (
    id INT AUTO_INCREMENT PRIMARY KEY,
    message_content VARCHAR(300) NOT NULL,
    message_time DATETIME NOT NULL,
    sender_id INT NOT NULL,
    receiver_id INT NOT NULL
);
