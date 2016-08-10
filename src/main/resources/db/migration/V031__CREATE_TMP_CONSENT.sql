CREATE TABLE `TMP_CONSENT` (
	consentId INT AUTO_INCREMENT PRIMARY KEY,
	submitterId int,
	approvalStatusCode int,
	dateProcessed DATE,
	dateCreated DATE,
	dateUpdated DATE
);
