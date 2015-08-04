CREATE TABLE `TMP_PROJECT_FUNDER` (
	`funderId` INT PRIMARY KEY AUTO_INCREMENT, 
	`projectId` INT,
	`funder` INT,
	`grantId` VARCHAR(255),
	`startDate` DATE,
	`endDate` DATE,
	`dateCreated` DATE, 
	`dateUpdated` DATE
);