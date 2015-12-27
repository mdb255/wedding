CREATE TABLE `weddingdb`.`rsvp` (
  `rsvp_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `attd_reception` TINYINT(1) NOT NULL,
  `attd_boat` TINYINT(1) NOT NULL,
  `attd_none` TINYINT(1) NOT NULL,
  `dinner` VARCHAR(45) NOT NULL,
  `dessert` VARCHAR(45) NOT NULL,
  `guest_type` VARCHAR(10) NOT NULL,
  `submitter_email` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`rsvp_id`));