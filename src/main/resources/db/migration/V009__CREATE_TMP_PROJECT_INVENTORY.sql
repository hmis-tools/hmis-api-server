CREATE TABLE `TMP_PROJECT_INVENTORY` (
	`inventoryId` INT PRIMARY KEY AUTO_INCREMENT, 
	`projectCoCId` INT,
	`informationDate` DATE,
	`householdType` INT,
	`bedType` INT,
	`availability` INT,
	`unitInventory` INT,
	`bedInventory` INT,
	`chBedInventory` INT,
	`vetBedInventory` INT,
	`youthBedInventory` INT,
	`youthAgeGroup` INT,
	`inventoryStartDate` DATE,
	`inventoryEndDate` DATE,
	`participatingBeds` INT,
	`dateCreated` DATE, 
	`dateUpdated` DATE
);