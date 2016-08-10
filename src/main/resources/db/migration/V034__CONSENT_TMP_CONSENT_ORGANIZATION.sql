CREATE TABLE `TMP_CONSENT_ORGANIZATION` (
	consentOrganizationId INT AUTO_INCREMENT PRIMARY KEY,
	consentId INT,
	organizationId INT,
	dateCreated DATE,
	dateUpdated DATE
);
