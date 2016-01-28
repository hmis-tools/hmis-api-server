CREATE TABLE `TMP_MEDICAL_ASSISTANCE` (
	medicalAssistanceId INT AUTO_INCREMENT PRIMARY KEY,
	enrollmentId INT,
	informationDate DATE,
	hivAidsAssistance INT,
	noHivAidsAssistanceReason INT,
	adap INT,
	noAdapReason INT,
	dateCreated DATE, 
	dateUpdated DATE
);