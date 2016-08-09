CREATE TABLE `TMP_CONSENT_ORGANIZATION` (
	consentCoCId INT AUTO_INCREMENT PRIMARY KEY,
	consentId INT,
	organizationId INT,
	dateCreated DATE,
	dateUpdated DATE
);
