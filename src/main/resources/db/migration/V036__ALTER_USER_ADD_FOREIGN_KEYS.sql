/*
 * Rename columns and link to new tables.
*/


ALTER TABLE TMP_USER CHANGE coC coCId INT;
ALTER TABLE TMP_USER CHANGE organization organizationId INT;


ALTER TABLE TMP_USER MODIFY COLUMN coCId INT,
 ADD CONSTRAINT coCId_fk
 FOREIGN KEY(coCId)
 REFERENCES TMP_COC (coCId);

ALTER TABLE TMP_USER MODIFY COLUMN organizationId INT,
 ADD CONSTRAINT organizationId_fk
 FOREIGN KEY(organizationId)
 REFERENCES TMP_ORGANIZATION (organizationId);
 
