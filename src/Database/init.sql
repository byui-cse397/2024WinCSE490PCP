CREATE DATABASE IF NOT EXISTS linkup_db;

USE linkup_db;
CREATE USER IF NOT EXISTS 'linkup-admin'@'localhost' IDENTIFIED BY 'nimda';
GRANT ALL PRIVILEGES ON linkup_db.* TO 'linkup-admin'@'localhost';

CREATE USER IF NOT EXISTS 'linkup-user'@'localhost' IDENTIFIED BY 'user';
GRANT SELECT, INSERT, UPDATE, DELETE ON linkup_db.* TO 'linkup-user'@'localhost';

FLUSH PRIVILEGES;
