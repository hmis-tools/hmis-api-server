CREATE TABLE `TMP_PROJECT` (
	`projectId` INT PRIMARY KEY AUTO_INCREMENT, 
	`projectName` VARCHAR(255), 
	`continuumProject` INT, 
	`projectType` INT, 
	`residentialAffiliation` INT, 
	`resProjectId` INT, 
	`trackingMethod` INT, 
	`targetPopulation` INT, 
	`dateCreated` DATE, 
	`dateUpdated` DATE
);
