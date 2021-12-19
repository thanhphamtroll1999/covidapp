-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: covid
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `age` int DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `date_discovered` date DEFAULT NULL,
  `area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (49,'Chử Việt Hoàng','1999-10-02','Nam',22,'Hai Bà Trưng','F1','2021-11-10','Cộng đồng','C:\\Users\\Admin\\Desktop\\CovidWebSpring\\2021-03-06.json'),(48,'Chử Quỳnh Hoa','1999-04-17','Nữ',22,'Đống Đa','F2','2021-11-15','Cộng đồng','C:\\Users\\Admin\\Desktop\\CovidWebSpring\\2021-03-06.json'),(44,'Phạm Minh Quang','1999-06-15','Nam',22,'Cầu Giấy','F0','2021-11-15','Cách ly','C:\\Users\\Admin\\Desktop\\CovidWebSpring\\2021-03-06.json'),(38,'Trần Thúy Mai','1999-05-21','Nữ',22,'Hà Đông','F2','2021-10-30','Cách ly','C:\\Users\\Admin\\Desktop\\CovidWebSpring\\2021-03-06.json'),(45,'Phạm Chí Công','2004-09-11','Nam',18,'Cầu Giấy','F1','2021-11-08','Cộng đồng','C:\\Users\\Admin\\Desktop\\CovidWebSpring\\2021-03-06.json'),(43,'Nguyễn Phương Trang','2002-05-17','Nữ',20,'Đống Đa','F1','2021-11-09','Cộng đồng','C:\\Users\\Admin\\Desktop\\CovidWebSpring\\2021-03-06.json'),(46,'Ngô Khắc Toản','1999-04-05','Nam',22,'Hà Đông','F2','2021-11-16','Cách ly','C:\\Users\\Admin\\Desktop\\CovidWebSpring\\2021-03-06.json'),(40,'Phạm Nhật Vượng','2021-11-01','Nam',22,'Cầu Giấy','F1','2021-11-08','Cach ly','C:\\Users\\Admin\\Desktop\\CovidWebSpring\\2021-03-06.json'),(39,'Nguyễn Phương Hằng','1989-02-20','Nữ',30,'Hà Đông','F1','2021-11-01','Cách ly','C:\\Users\\Admin\\Desktop\\CovidWebSpring\\2021-03-06.json'),(51,'Nguyễn Thanh TÙng','1999-09-19','Nam',22,'Hà Đông','F2','2021-11-16','Cộng đồng','C:\\Users\\Admin\\Desktop\\CovidWebSpring\\2021-03-06.json');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travel_schedule`
--

DROP TABLE IF EXISTS `travel_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `travel_schedule` (
  `id` bigint NOT NULL,
  `moving_schedule` varchar(255) DEFAULT NULL,
  `time_moving` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travel_schedule`
--

LOCK TABLES `travel_schedule` WRITE;
/*!40000 ALTER TABLE `travel_schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `travel_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'covid'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-07  1:44:11
