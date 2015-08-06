CREATE TABLE `TMP_PHYSICAL_DISABILITY` (
	physicalDisabilityId INT AUTO_INCREMENT PRIMARY KEY,
	enrollmentId INT,
	informationDate DATE,
	response INT,
	indefiniteAndImpairs INT,
	documentationOnFile INT,
	receivingServices INT,
	dateCreated DATE, 
	dateUpdated DATE
);