/* MySQL CREATE SCHEMA */
CREATE DATABASE `knowledge_db` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;

/* MySQL CREATE TABLES */
CREATE TABLE `knowledge_pack` (
                                  `id` bigint NOT NULL AUTO_INCREMENT,
                                  `creation_date` date DEFAULT NULL,
                                  `description` varchar(255) DEFAULT NULL,
                                  `title` varchar(255) DEFAULT NULL,
                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `knowledge_pack_set` (
                                      `id` bigint NOT NULL AUTO_INCREMENT,
                                      `title` varchar(255) DEFAULT NULL,
                                      PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `knowledge_pack_sets_knowledge_packs` (
                                                       `knowledge_pack_set_id` bigint NOT NULL,
                                                       `knowledge_pack_id` bigint NOT NULL,
                                                       PRIMARY KEY (`knowledge_pack_set_id`,`knowledge_pack_id`),
                                                       KEY `FKndrga7tygu422raieyb0dlxa4` (`knowledge_pack_id`),
                                                       CONSTRAINT `FKhwqqot7oomdh41t9kk5hat6jd` FOREIGN KEY (`knowledge_pack_set_id`) REFERENCES `knowledge_pack_set` (`id`),
                                                       CONSTRAINT `FKndrga7tygu422raieyb0dlxa4` FOREIGN KEY (`knowledge_pack_id`) REFERENCES `knowledge_pack` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
