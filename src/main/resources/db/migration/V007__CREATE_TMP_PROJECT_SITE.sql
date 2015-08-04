CREATE TABLE `TMP_PROJECT_SITE` (
	`siteId` INT PRIMARY KEY AUTO_INCREMENT, 
	`projectCoCId` INT,
	`principalSite` INT,
	`geocode` VARCHAR(255),
	`address` VARCHAR(255),
	`city` VARCHAR(255),
	`state` VARCHAR(255),
	`zip` VARCHAR(255),
	`dateCreated` DATE, 
	`dateUpdated` DATE
);