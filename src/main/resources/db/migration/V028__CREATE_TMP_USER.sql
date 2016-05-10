CREATE TABLE `TMP_USER` (
	userId INT AUTO_INCREMENT PRIMARY KEY,
	externalID VARCHAR(255) UNIQUE,
	canRead INT,
	canWrite INT,
	canAdmin INT,
	dateCreated DATE,
	dateUpdated DATE
);
