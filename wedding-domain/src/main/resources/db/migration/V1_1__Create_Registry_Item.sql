CREATE TABLE `weddingdb`.`registry_item` (
  `registry_item_id` INT NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(30) NOT NULL,
  `is_purchasable` TINYINT(1) NOT NULL,
  `initial_stock` INT NOT NULL,
  `price_range` VARCHAR(45) NULL,
  PRIMARY KEY (`registry_item_id`));