ALTER TABLE `weddingdb`.`purchase` 
ADD INDEX `fk_registry_item_idx` (`registry_item_id` ASC);
ALTER TABLE `weddingdb`.`purchase` 
ADD CONSTRAINT `fk_registry_item`
  FOREIGN KEY (`registry_item_id`)
  REFERENCES `weddingdb`.`registry_item` (`registry_item_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
