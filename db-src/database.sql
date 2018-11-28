CREATE DATABASE IF NOT EXISTS `softproj`
    DEFAULT CHARACTER SET UTF8MB4
    DEFAULT COLLATE utf8mb4_general_ci;
    
USE `softproj`;

SET NAMES utf8mb4;

DROP TABLE IF EXISTS Team;

CREATE TABLE Team (
    
    teamID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    isApproved BOOLEAN NOT NULL DEFAULT FALSE  
)
ENGINE=InnoDB;


DROP TABLE IF EXISTS `User`;

CREATE TABLE `User` (
  userID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  isApproved BOOLEAN NOT NULL DEFAULT FALSE,
  email varchar(50) UNIQUE NOT NULL,
  teamID INT UNSIGNED DEFAULT NULL,
  
  FOREIGN KEY (teamID) REFERENCES Team (teamID)
)
ENGINE=InnoDB;

DROP TABLE IF EXISTS Submission;

CREATE TABLE Submission (
    
    submissionID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    teamID INT UNSIGNED NOT NULL,
    submitterID INT UNSIGNED NOT NULL,
    dateSubmitted DATETIME NOT NULL,
  
    FOREIGN KEY (teamID) REFERENCES Team (teamID),
    FOREIGN KEY (submitterID) REFERENCES `User` (userID)
)
ENGINE=InnoDB;


DROP TABLE IF EXISTS Artifact;

CREATE TABLE Artifact (
    name varchar(50) NOT NULL,
    phase varchar(45) NOT NULL,
    type varchar(45) NOT NULL,
    directory varchar(150) NOT NULL,
    submissionID INT UNSIGNED NOT NULL,
    
    FOREIGN KEY (submissionID) REFERENCES Submission (submissionID)
)
ENGINE=InnoDB;


