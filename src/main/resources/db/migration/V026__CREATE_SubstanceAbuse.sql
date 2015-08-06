CREATE TABLE `TMP_SUBSTANCE_ABUSE` (
	substanceAbuseId INT AUTO_INCREMENT PRIMARY KEY,
	enrollmentId INT,
	informationDate DATE,
	response INT,
	indefiniteAndImpairs INT,
	documentationOnFile INT,
	receivingServices INT,
	pathHowConfirmed INT
);