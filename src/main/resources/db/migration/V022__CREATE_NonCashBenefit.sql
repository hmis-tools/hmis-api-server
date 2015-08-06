CREATE TABLE `TMP_NON_CASH_BENEFIT` (
	nonCashBenefitId INT AUTO_INCREMENT PRIMARY KEY,
	enrollmentId INT,
	informationDate DATE,
	benefitsFromAnySource INT,
	snap INT,
	wic INT,
	tanfChildCare INT,
	tanfTransportation INT,
	otherTanf INT,
	rentalAssistanceOngoing INT,
	otherBenefitsSource INT,
	rentalAssistanceTemp INT,
	otherBenefitsSourceIdentify VARCHAR(255)
);