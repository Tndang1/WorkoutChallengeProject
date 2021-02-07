-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema workoutdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `workoutdb` ;

-- -----------------------------------------------------
-- Schema workoutdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `workoutdb` DEFAULT CHARACTER SET utf8 ;
USE `workoutdb` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workout`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `workout` ;

CREATE TABLE IF NOT EXISTS `workout` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `requires_equipment` TINYINT NOT NULL,
  `estimated_time` VARCHAR(45) NULL,
  `rating` DECIMAL(2,1) NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_workout_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_workout_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `exercise`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exercise` ;

CREATE TABLE IF NOT EXISTS `exercise` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `repetitions` VARCHAR(45) NOT NULL,
  `duration` VARCHAR(45) NULL,
  `weight` DECIMAL(4,1) NULL,
  `equipment` VARCHAR(45) NULL,
  `workout_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_exercise_workout_idx` (`workout_id` ASC),
  CONSTRAINT `fk_exercise_workout`
    FOREIGN KEY (`workout_id`)
    REFERENCES `workout` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `workout_review`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `workout_review` ;

CREATE TABLE IF NOT EXISTS `workout_review` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rating` INT NOT NULL,
  `review` VARCHAR(45) NOT NULL,
  `workout_complete` VARCHAR(45) NOT NULL,
  `workout_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_workout_review_workout1_idx` (`workout_id` ASC),
  INDEX `fk_workout_review_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_workout_review_workout1`
    FOREIGN KEY (`workout_id`)
    REFERENCES `workout` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_workout_review_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `saved_workout`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `saved_workout` ;

CREATE TABLE IF NOT EXISTS `saved_workout` (
  `user_id` INT NOT NULL,
  `workout_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `workout_id`),
  INDEX `fk_user_has_workout_workout1_idx` (`workout_id` ASC),
  INDEX `fk_user_has_workout_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_workout_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_workout_workout1`
    FOREIGN KEY (`workout_id`)
    REFERENCES `workout` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `attempted_workout`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `attempted_workout` ;

CREATE TABLE IF NOT EXISTS `attempted_workout` (
  `id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `workout_id` INT NOT NULL,
  `completed` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `fk_user_has_workout1_workout1_idx` (`workout_id` ASC),
  INDEX `fk_user_has_workout1_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_workout1_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_workout1_workout1`
    FOREIGN KEY (`workout_id`)
    REFERENCES `workout` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS workoutuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'workoutuser'@'localhost' IDENTIFIED BY 'user';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'workoutuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `workoutdb`;
INSERT INTO `user` (`id`, `username`, `password`, `role`, `enabled`) VALUES (1, 'user', 'user', 'user', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `workout`
-- -----------------------------------------------------
START TRANSACTION;
USE `workoutdb`;
INSERT INTO `workout` (`id`, `title`, `category`, `requires_equipment`, `estimated_time`, `rating`, `user_id`) VALUES (1, 'The Short Card / No Equipment', 'General / Military', 0, NULL, 3, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `exercise`
-- -----------------------------------------------------
START TRANSACTION;
USE `workoutdb`;
INSERT INTO `exercise` (`id`, `name`, `repetitions`, `duration`, `weight`, `equipment`, `workout_id`) VALUES (1, 'Push-ups', '30', NULL, NULL, NULL, 1);
INSERT INTO `exercise` (`id`, `name`, `repetitions`, `duration`, `weight`, `equipment`, `workout_id`) VALUES (2, 'Squats', '30', NULL, NULL, NULL, 1);
INSERT INTO `exercise` (`id`, `name`, `repetitions`, `duration`, `weight`, `equipment`, `workout_id`) VALUES (3, 'Crunches', '30', NULL, NULL, NULL, 1);
INSERT INTO `exercise` (`id`, `name`, `repetitions`, `duration`, `weight`, `equipment`, `workout_id`) VALUES (4, 'Burpees', '10', NULL, NULL, NULL, 1);
INSERT INTO `exercise` (`id`, `name`, `repetitions`, `duration`, `weight`, `equipment`, `workout_id`) VALUES (5, 'Push-ups', '30', NULL, NULL, NULL, 1);
INSERT INTO `exercise` (`id`, `name`, `repetitions`, `duration`, `weight`, `equipment`, `workout_id`) VALUES (6, 'Mountain climbers', '30', NULL, NULL, NULL, 1);
INSERT INTO `exercise` (`id`, `name`, `repetitions`, `duration`, `weight`, `equipment`, `workout_id`) VALUES (7, 'Flutter Kicks', '30', NULL, NULL, NULL, 1);
INSERT INTO `exercise` (`id`, `name`, `repetitions`, `duration`, `weight`, `equipment`, `workout_id`) VALUES (8, 'Burpees', '10', NULL, NULL, NULL, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `workout_review`
-- -----------------------------------------------------
START TRANSACTION;
USE `workoutdb`;
INSERT INTO `workout_review` (`id`, `rating`, `review`, `workout_complete`, `workout_id`, `user_id`) VALUES (1, 3, 'This isn\'t the complete short card.', '1', 1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `saved_workout`
-- -----------------------------------------------------
START TRANSACTION;
USE `workoutdb`;
INSERT INTO `saved_workout` (`user_id`, `workout_id`) VALUES (1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `attempted_workout`
-- -----------------------------------------------------
START TRANSACTION;
USE `workoutdb`;
INSERT INTO `attempted_workout` (`id`, `user_id`, `workout_id`, `completed`) VALUES (1, 1, 1, 1);

COMMIT;

