CREATE TABLE `TMP_CONSENT_FIELD` (
	consentFieldId INT AUTO_INCREMENT PRIMARY KEY,
	consentId INT,
	fieldName VARCHAR(255),
	requestType INT,
	dateCreated DATE,
	dateUpdated DATE
);
