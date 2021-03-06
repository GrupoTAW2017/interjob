-- MySQL Script generated by MySQL Workbench
-- 04/17/17 18:42:10
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema dbinterjob
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `dbinterjob` ;

-- -----------------------------------------------------
-- Schema dbinterjob
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbinterjob` DEFAULT CHARACTER SET utf8 ;
USE `dbinterjob` ;

-- -----------------------------------------------------
-- Table `dbinterjob`.`USER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbinterjob`.`USER` (
  `USERNAME` VARCHAR(20) NOT NULL,
  `PASSWORD` VARCHAR(50) NOT NULL,
  `NAME` VARCHAR(50) NOT NULL,
  `LAST_NAME` VARCHAR(50) NOT NULL,
  `TWITTER` VARCHAR(50) NULL,
  `INSTAGRAM` VARCHAR(50) NULL,
  `WEBPAGE` VARCHAR(100) NULL,
  `FOTO` VARCHAR(100) NULL,
  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  UNIQUE INDEX `USERNAME_UNIQUE` (`USERNAME` ASC),
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbinterjob`.`HOBBY`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbinterjob`.`HOBBY` (
  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(100) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbinterjob`.`STUDIES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbinterjob`.`STUDIES` (
  `START_DATE` DATE NULL,
  `END_DATE` DATE NULL,
  `DESCRIPTION` TEXT(200) NULL,
  `LOCATION` VARCHAR(100) NULL,
  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `USER_ID` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_STUDIES_USER1_idx` (`USER_ID` ASC),
  CONSTRAINT `fk_STUDIES_USER1`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `dbinterjob`.`USER` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbinterjob`.`WORK_EXPERIENCE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbinterjob`.`WORK_EXPERIENCE` (
  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `START_DATE` DATE NULL,
  `END_DATE` DATE NULL,
  `BUSINESS` VARCHAR(100) NULL,
  `JOB` VARCHAR(100) NULL,
  `WEBPAGE` VARCHAR(100) NULL,
  `USER_ID` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_WORK_EXPERIENCE_USER1_idx` (`USER_ID` ASC),
  CONSTRAINT `fk_WORK_EXPERIENCE_USER1`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `dbinterjob`.`USER` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbinterjob`.`MESSAGE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbinterjob`.`MESSAGE` (
  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `DATE` DATETIME NULL,
  `CONTENT` TEXT(400) NULL,
  `READ` TINYINT NOT NULL,
  `USER_FROM` INT UNSIGNED NOT NULL,
  `USER_TO` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_MESSAGE_USER_idx` (`USER_FROM` ASC),
  INDEX `fk_MESSAGE_USER1_idx` (`USER_TO` ASC),
  CONSTRAINT `fk_MESSAGE_USER`
    FOREIGN KEY (`USER_FROM`)
    REFERENCES `dbinterjob`.`USER` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MESSAGE_USER1`
    FOREIGN KEY (`USER_TO`)
    REFERENCES `dbinterjob`.`USER` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbinterjob`.`FRIENDSHIP`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbinterjob`.`FRIENDSHIP` (
  `CONFIRMED` TINYINT NULL,
  `USER_ID` INT UNSIGNED NOT NULL,
  `USER_ID1` INT UNSIGNED NOT NULL,
  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  INDEX `fk_FRIENDSHIP_USER1_idx` (`USER_ID` ASC),
  INDEX `fk_FRIENDSHIP_USER2_idx` (`USER_ID1` ASC),
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_FRIENDSHIP_USER1`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `dbinterjob`.`USER` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FRIENDSHIP_USER2`
    FOREIGN KEY (`USER_ID1`)
    REFERENCES `dbinterjob`.`USER` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbinterjob`.`USER_HAS_HOBBY`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbinterjob`.`USER_HAS_HOBBY` (
  `USER_ID` INT UNSIGNED NOT NULL,
  `HOBBY_ID` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`USER_ID`, `HOBBY_ID`),
  INDEX `fk_USER_has_HOBBY_HOBBY1_idx` (`HOBBY_ID` ASC),
  INDEX `fk_USER_has_HOBBY_USER1_idx` (`USER_ID` ASC),
  CONSTRAINT `fk_USER_has_HOBBY_USER1`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `dbinterjob`.`USER` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_USER_has_HOBBY_HOBBY1`
    FOREIGN KEY (`HOBBY_ID`)
    REFERENCES `dbinterjob`.`HOBBY` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
