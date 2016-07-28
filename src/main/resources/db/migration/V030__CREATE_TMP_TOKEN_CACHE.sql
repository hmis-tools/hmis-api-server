CREATE TABLE `TMP_TOKEN_CACHE` (
        tokenCacheId INT AUTO_INCREMENT PRIMARY KEY,
	externalId VARCHAR(255),
	idToken TEXT,
	dateCreated DATE,
	dateUpdated DATE
);
