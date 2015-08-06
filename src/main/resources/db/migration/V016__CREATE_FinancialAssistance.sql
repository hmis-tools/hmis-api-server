CREATE TABLE `TMP_FINANCIAL_ASSISTANCE` (
	financialAssistanceId INT AUTO_INCREMENT PRIMARY KEY,
	enrollmentId INT,
	dateProvided DATE,
	hopwaTypeProvided INT,
	hopwaFaaAmount INT,
	ssvfTypeProvided INT,
	ssvfFaaAmount INT
);