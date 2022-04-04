-- liquibase formatted sql
-- changeset Sylvain:create-db-1
-- comment Create initiale database

CREATE TABLE IF NOT EXISTS `Park` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
   `name` VARCHAR(100) COLLATE utf8_bin NOT NULL,
   `type` VARCHAR(5) COLLATE utf8_bin NOT NULL,
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `Offer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `day` DATETIME NOT NULL,
  `market` VARCHAR(10) COLLATE utf8_bin NOT NULL,
  `quantity` double(20,6) NOT NULL,
  `bottomPrice` double(20,6) NOT NULL,
  `chunk` VARCHAR(10) COLLATE utf8_bin NOT NULL,
  `parkId` bigint(20) NOT NULL,
  FOREIGN KEY (`parkId`) REFERENCES `Park` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
