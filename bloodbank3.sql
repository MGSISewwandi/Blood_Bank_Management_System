-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bloodbank3
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `blood`
--

DROP TABLE IF EXISTS `blood`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blood` (
  `id` int NOT NULL AUTO_INCREMENT,
  `blood_bloodgroup` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blood`
--

LOCK TABLES `blood` WRITE;
/*!40000 ALTER TABLE `blood` DISABLE KEYS */;
INSERT INTO `blood` VALUES (1,'A+'),(2,'A-'),(3,'AB+');
/*!40000 ALTER TABLE `blood` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blood_requesthospital`
--

DROP TABLE IF EXISTS `blood_requesthospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blood_requesthospital` (
  `blood_id` int NOT NULL,
  `requesthospital_id` int NOT NULL,
  PRIMARY KEY (`requesthospital_id`,`blood_id`),
  KEY `FKte9yf8927ljpqw5jbe8824t3h` (`blood_id`),
  CONSTRAINT `FKgy86wdqt9ju1s8m4649c637qy` FOREIGN KEY (`requesthospital_id`) REFERENCES `requesthospital` (`id`),
  CONSTRAINT `FKte9yf8927ljpqw5jbe8824t3h` FOREIGN KEY (`blood_id`) REFERENCES `blood` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blood_requesthospital`
--

LOCK TABLES `blood_requesthospital` WRITE;
/*!40000 ALTER TABLE `blood_requesthospital` DISABLE KEYS */;
INSERT INTO `blood_requesthospital` VALUES (2,1),(3,1);
/*!40000 ALTER TABLE `blood_requesthospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bloodstock`
--

DROP TABLE IF EXISTS `bloodstock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bloodstock` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bloodstock_bloodgroup` varchar(255) DEFAULT NULL,
  `bloodstock_date` varchar(255) DEFAULT NULL,
  `bloodstock_units` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bloodstock`
--

LOCK TABLES `bloodstock` WRITE;
/*!40000 ALTER TABLE `bloodstock` DISABLE KEYS */;
/*!40000 ALTER TABLE `bloodstock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coordinator`
--

DROP TABLE IF EXISTS `coordinator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coordinator` (
  `id` int NOT NULL AUTO_INCREMENT,
  `contactno` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coordinator`
--

LOCK TABLES `coordinator` WRITE;
/*!40000 ALTER TABLE `coordinator` DISABLE KEYS */;
/*!40000 ALTER TABLE `coordinator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donateevent`
--

DROP TABLE IF EXISTS `donateevent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donateevent` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `coordinator_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnc60sslupfg52ao9vcorn213v` (`coordinator_id`),
  CONSTRAINT `FKnc60sslupfg52ao9vcorn213v` FOREIGN KEY (`coordinator_id`) REFERENCES `coordinator` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donateevent`
--

LOCK TABLES `donateevent` WRITE;
/*!40000 ALTER TABLE `donateevent` DISABLE KEYS */;
/*!40000 ALTER TABLE `donateevent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donor`
--

DROP TABLE IF EXISTS `donor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `donor_dob` varchar(255) DEFAULT NULL,
  `donor_gender` varchar(255) DEFAULT NULL,
  `donor_name` varchar(60) NOT NULL,
  `blood_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_pgsptlrvcr0xdxw2tttl36keq` (`donor_name`),
  KEY `FKf9t1yioajndae7m5x36fxbd3y` (`blood_id`),
  CONSTRAINT `FKf9t1yioajndae7m5x36fxbd3y` FOREIGN KEY (`blood_id`) REFERENCES `blood` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donor`
--

LOCK TABLES `donor` WRITE;
/*!40000 ALTER TABLE `donor` DISABLE KEYS */;
INSERT INTO `donor` VALUES (1,'1998-12-10','Female','Sachini Imasha',3);
/*!40000 ALTER TABLE `donor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requesthospital`
--

DROP TABLE IF EXISTS `requesthospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requesthospital` (
  `id` int NOT NULL AUTO_INCREMENT,
  `hospital_city` varchar(255) DEFAULT NULL,
  `hospital_contactno` varchar(255) DEFAULT NULL,
  `hospital_date` varchar(255) DEFAULT NULL,
  `hospital_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requesthospital`
--

LOCK TABLES `requesthospital` WRITE;
/*!40000 ALTER TABLE `requesthospital` DISABLE KEYS */;
INSERT INTO `requesthospital` VALUES (1,'Embilipitya','0473049089','2022-01-11','Embilipitya general district hospital');
/*!40000 ALTER TABLE `requesthospital` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-21 21:35:33
