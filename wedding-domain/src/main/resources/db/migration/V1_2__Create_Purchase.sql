CREATE TABLE `weddingdb`.`purchase` (
  `purchase_id` INT NOT NULL AUTO_INCREMENT,
  `registry_item_id` INT NOT NULL,
  `purchased_by_names` VARCHAR(75) NOT NULL,
  `purchased_by_email` VARCHAR(60) NOT NULL,
  `custom_description` VARCHAR(60) NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  `delivery_method` VARCHAR(10) NOT NULL,
  `create_dt` TIMESTAMP(2) NOT NULL,
  PRIMARY KEY (`purchase_id`));