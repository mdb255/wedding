-- category: Sub-section of the Registry; Items are browsable on a page per category
-- description: Description of the item to appear when browsing the Registry
-- price_range: Comma delimited list of prices selectable from dropdown
-- initial_stock: Quantity of the item that is initially available for purchase
-- is_purchasable: Value of 1 indicates limited stock (can sell out); Value of 0 indicates that the item is a user suggestion with unlimited stock

INSERT INTO registry_item (category,description,price_range,initial_stock,is_purchasable) VALUES ('Transportation','Flight from A to B','50,75,100','1','1');
INSERT INTO registry_item (category,description,price_range,initial_stock,is_purchasable) VALUES ('Transportation','Train ride from B to C','50,75,100','1','1');
INSERT INTO registry_item (category,description,price_range,initial_stock,is_purchasable) VALUES ('Accommodations','Hotel in A','100,150,200','3','1');
INSERT INTO registry_item (category,description,price_range,initial_stock,is_purchasable) VALUES ('Accommodations','Bed and Breakfast in B','100,150,200','3','1');
INSERT INTO registry_item (category,description,price_range,initial_stock,is_purchasable) VALUES ('Accommodations','','','1','0');
INSERT INTO registry_item (category,description,price_range,initial_stock,is_purchasable) VALUES ('Wining and Dining','Winery near A','50,75,100','1','1');
INSERT INTO registry_item (category,description,price_range,initial_stock,is_purchasable) VALUES ('Wining and Dining','Dinner in B','75,100,125','3','1');
INSERT INTO registry_item (category,description,price_range,initial_stock,is_purchasable) VALUES ('Wining and Dining','Breakfast in C','25,50,75','3','1');
INSERT INTO registry_item (category,description,price_range,initial_stock,is_purchasable) VALUES ('Wining and Dining','','','1','0');
INSERT INTO registry_item (category,description,price_range,initial_stock,is_purchasable) VALUES ('Explorations','Visit the A','100','1','1');
INSERT INTO registry_item (category,description,price_range,initial_stock,is_purchasable) VALUES ('Explorations','Walking tour of B','50,100','1','1');
INSERT INTO registry_item (category,description,price_range,initial_stock,is_purchasable) VALUES ('Explorations','Shopping in C','50,75,100','1','1');
INSERT INTO registry_item (category,description,price_range,initial_stock,is_purchasable) VALUES ('Explorations','','','1','0');
INSERT INTO registry_item (category,description,price_range,initial_stock,is_purchasable) VALUES ('Relaxation','Day on the beach in A','25,50,75','1','1');
INSERT INTO registry_item (category,description,price_range,initial_stock,is_purchasable) VALUES ('Relaxation','Visit a spa in B','50,75,100','2','1');
INSERT INTO registry_item (category,description,price_range,initial_stock,is_purchasable) VALUES ('Relaxation','','','1','0');
COMMIT;
