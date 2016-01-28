CREATE TABLE `TMP_CHRONIC_HEALTH_CONDITION` (
	chronicHealthConditionId INT AUTO_INCREMENT PRIMARY KEY,
	enrollmentId INT,
	informationDate DATE,
	response INT,
	indefiniteAndImpairs INT,
	documentationOnFile INT,
	receivingServices INT,
	dateCreated DATE, 
	dateUpdated DATE
);