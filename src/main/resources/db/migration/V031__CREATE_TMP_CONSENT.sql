CREATE TABLE `TMP_CONSENT` (
	consentId INT AUTO_INCREMENT PRIMARY KEY,
	submitterId int,
	clientId INT, 
	approvalStatusCode int,
	dateProcessed DATE,
	dateCreated DATE,
	dateUpdated DATE
);
