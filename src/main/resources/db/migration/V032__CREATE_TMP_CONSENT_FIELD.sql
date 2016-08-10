CREATE TABLE `TMP_CONSENT_FIELD` (
	consentFieldId INT AUTO_INCREMENT PRIMARY KEY,
	consentId INT,
	fieldCode INT,
	requestTypeCode INT,
	dateCreated DATE,
	dateUpdated DATE
);
