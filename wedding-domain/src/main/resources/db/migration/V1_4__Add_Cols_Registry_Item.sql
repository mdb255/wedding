ALTER TABLE `weddingdb`.`registry_item` 
ADD COLUMN `description` VARCHAR(60) NOT NULL AFTER `price_range`,
ADD COLUMN `image_url` VARCHAR(100) NULL AFTER `description`;