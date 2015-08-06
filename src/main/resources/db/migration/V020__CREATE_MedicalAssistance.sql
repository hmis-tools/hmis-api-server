CREATE TABLE `MEDICAL_ASSISTANCE` (
	medicalAssistanceId INT AUTO_INCREMENT PRIMARY KEY,
	enrollmentId INT,
	informationDate DATE,
	hivAidsAssistance INT,
	noHivAidsAssistanceReason INT,
	adap INT,
	noAdapReason INT
);