CREATE TABLE `TMP_PROJECT_CONTINUUM` (
	`project_coc_id` INT PRIMARY KEY AUTO_INCREMENT, 
	`project_id` INT,
	`coc_code` VARCHAR(255),
	`date_created` DATE, 
	`date_updated` DATE
);