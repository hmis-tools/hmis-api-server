CREATE TABLE `TMP_TOKEN_CACHE` (
        tokenCacheId INT AUTO_INCREMENT PRIMARY KEY,
	userId INT,
	idToken VARCHAR(255) UNIQUE,
	dateCreated DATE,
	dateUpdated DATE
);
