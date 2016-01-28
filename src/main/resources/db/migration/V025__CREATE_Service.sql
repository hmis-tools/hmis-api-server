CREATE TABLE `TMP_SERVICE` (
	serviceId INT AUTO_INCREMENT PRIMARY KEY,
	enrollmentId INT,
	dateProvided DATE,
	pathTypeProvided INT,
	rhyTypeProvided INT,
	hopwaTypeProvided INT,
	ssvfTypeProvided INT,
	ssvfVaSubTypeProvided INT,
	ssvfCoordinatingSubTypeProvided INT,
	ssvfDirectSubTypeProvided INT,
	ssvfOtherService VARCHAR(255),
	dateCreated DATE, 
	dateUpdated DATE
);