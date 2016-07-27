CREATE TABLE `TMP_TOKEN_CACHE` (
        tokenCacheId INT AUTO_INCREMENT PRIMARY KEY,
	userId INT,
	idToken TEXT,
	dateCreated DATE,
	dateUpdated DATE
);
