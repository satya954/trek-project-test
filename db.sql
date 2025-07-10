CREATE DATABASE IF NOT EXISTS trekkingdb;

USE trekkingdb;

CREATE TABLE registrations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    mobile VARCHAR(15),
    start_date DATE
);

