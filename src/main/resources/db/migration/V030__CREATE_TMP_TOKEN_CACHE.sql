CREATE TABLE `TMP_TOKEN_CACHE` (
        tokenCacheId INT AUTO_INCREMENT PRIMARY KEY,
	externalId TEXT,
	idToken TEXT,
	dateCreated DATE,
	dateUpdated DATE
);
