CREATE TABLE `TMP_PROJECT_COC` (
	`projectCoCId` INT PRIMARY KEY AUTO_INCREMENT, 
	`projectId` INT,
	`coCCode` VARCHAR(255),
	`dateCreated` DATE, 
	`dateUpdated` DATE
);