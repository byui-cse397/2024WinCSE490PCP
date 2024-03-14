---Database Connection Setup---

CREATE DATABASE IF NOT EXISTS linkup_db;

USE linkup_db;
CREATE USER IF NOT EXISTS 'linkup-admin'@'localhost' IDENTIFIED BY 'nimda';
GRANT ALL PRIVILEGES ON linkup_db.* TO 'linkup-admin'@'localhost';

CREATE USER IF NOT EXISTS 'linkup-user'@'localhost' IDENTIFIED BY 'user';
GRANT SELECT, INSERT, UPDATE, DELETE ON linkup_db.* TO 'linkup-user'@'localhost';

CREATE USER IF NOT EXISTS 'linkup-tester'@'localhost' IDENTIFIED BY 'tester';
GRANT SELECT, INSERT, UPDATE, DELETE ON linkup_db.* TO 'linkup-user'@'localhost';

FLUSH PRIVILEGES;

---Table Schema Setup---

CREATE TABLE IF NOT EXISTS Account (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password_hash VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Post (
    id INT AUTO_INCREMENT PRIMARY KEY,
    content_text VARCHAR(800) NOT NULL,
    account_id INT NOT NULL, -- Alias, so I dont have to use id for primary and foreign key, which would cause issues
    post_time time NOT NULL,
    CONSTRAINT fk_Post_Account FOREIGN KEY (account_id) REFERENCES Account(id)-- Create the actual foreign key relationship
);

CREATE TABLE IF NOT EXISTS Departing (
    id INT AUTO_INCREMENT PRIMARY KEY,
    location VARCHAR(255) NOT NULL,
    post_id INT NOT NULL,
    CONSTRAINT fk_Departing_Post_Id FOREIGN KEY (post_id) REFERENCES Departing(id)
);

CREATE TABLE IF NOT EXISTS Arriving (
    id INT AUTO_INCREMENT PRIMARY KEY,
    location VARCHAR(255) NOT NULL,
    post_id INT NOT NULL,
    CONSTRAINT fk_Arriving_Post_Id FOREIGN KEY (post_id) REFERENCES Arriving(id)
);