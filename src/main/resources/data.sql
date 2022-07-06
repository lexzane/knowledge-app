--
-- Table structure for table `knowledge_pack`
--

DROP TABLE IF EXISTS `knowledge_pack`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `knowledge_pack` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `creation_date` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `knowledge_pack`
--

LOCK TABLES `knowledge_pack` WRITE;
/*!40000 ALTER TABLE `knowledge_pack` DISABLE KEYS */;
INSERT INTO `knowledge_pack` VALUES (1,'2022-07-06','Java K-Pack','Java'),(2,'2022-07-06','Ruby on Rails K-Pack','Ruby'),(3,'2022-07-06','Dart K-Pack','Dart'),(4,'2022-07-06','JavaScript K-Pack','JavaScript'),(5,'2022-07-06','TypeScript K-Pack','TypeScript'),(6,'2022-07-06','Objective-C K-Pack','Objective-C'),(7,'2022-07-06','Swift K-Pack','Swift');
/*!40000 ALTER TABLE `knowledge_pack` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `knowledge_pack_set`
--

DROP TABLE IF EXISTS `knowledge_pack_set`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `knowledge_pack_set` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `knowledge_pack_set`
--

LOCK TABLES `knowledge_pack_set` WRITE;
/*!40000 ALTER TABLE `knowledge_pack_set` DISABLE KEYS */;
INSERT INTO `knowledge_pack_set` VALUES (1,'Back-End Languages'),(2,'Front-End Languages'),(3,'Apple Languages');
/*!40000 ALTER TABLE `knowledge_pack_set` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `knowledge_pack_sets_knowledge_packs`
--

DROP TABLE IF EXISTS `knowledge_pack_sets_knowledge_packs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `knowledge_pack_sets_knowledge_packs` (
  `knowledge_pack_set_id` bigint NOT NULL,
  `knowledge_pack_id` bigint NOT NULL,
  PRIMARY KEY (`knowledge_pack_set_id`,`knowledge_pack_id`),
  KEY `FKndrga7tygu422raieyb0dlxa4` (`knowledge_pack_id`),
  CONSTRAINT `FKhwqqot7oomdh41t9kk5hat6jd` FOREIGN KEY (`knowledge_pack_set_id`) REFERENCES `knowledge_pack_set` (`id`),
  CONSTRAINT `FKndrga7tygu422raieyb0dlxa4` FOREIGN KEY (`knowledge_pack_id`) REFERENCES `knowledge_pack` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `knowledge_pack_sets_knowledge_packs`
--

LOCK TABLES `knowledge_pack_sets_knowledge_packs` WRITE;
/*!40000 ALTER TABLE `knowledge_pack_sets_knowledge_packs` DISABLE KEYS */;
INSERT INTO `knowledge_pack_sets_knowledge_packs` VALUES (1,1),(1,2),(1,3),(2,4),(2,5),(3,6),(3,7);
/*!40000 ALTER TABLE `knowledge_pack_sets_knowledge_packs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
