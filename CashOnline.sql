CREATE DATABASE  IF NOT EXISTS `cashonline` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cashonline`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cashonline
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `loans`
--

DROP TABLE IF EXISTS `loans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loans` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `total` double NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT NULL,
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `FKloansuser` (`user_id`),
  CONSTRAINT `FKloansuser` FOREIGN KEY (`user_id`) REFERENCES `loans` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loans`
--

LOCK TABLES `loans` WRITE;
/*!40000 ALTER TABLE `loans` DISABLE KEYS */;
INSERT INTO `loans` VALUES (1,548655.5,1,0,'2021-06-20 23:21:53','2021-06-20 22:51:18'),(2,5689655.5,2,0,'2021-06-21 00:11:16','2021-06-20 23:01:16'),(3,568655.5,1,0,'2021-06-20 23:02:10','2021-06-20 23:02:09'),(4,568554865.5,1,0,'2021-06-20 23:20:02','2021-06-20 23:20:01'),(5,5854865.5,2,0,'2021-06-21 00:11:16','2021-06-20 23:20:11'),(6,556231685865.5,2,0,'2021-06-21 00:11:16','2021-06-20 23:21:31'),(7,12348486,2,0,'2021-06-21 17:12:45','2021-06-21 17:12:45'),(8,154834,2,0,'2021-06-21 17:12:54','2021-06-21 17:12:54'),(9,56848121,2,0,'2021-06-21 17:13:01','2021-06-21 17:13:00'),(10,6546845,2,0,'2021-06-21 17:13:08','2021-06-21 17:13:07'),(11,93254,2,0,'2021-06-21 17:14:05','2021-06-21 17:14:04'),(12,235468,2,0,'2021-06-21 17:14:11','2021-06-21 17:14:10'),(13,1254587,2,0,'2021-06-21 17:14:17','2021-06-21 17:14:17'),(14,26587,1,0,'2021-06-21 17:14:30','2021-06-21 17:14:30'),(15,6895.25,1,0,'2021-06-21 17:14:37','2021-06-21 17:14:36'),(16,89654.25,1,0,'2021-06-21 17:14:45','2021-06-21 17:14:45'),(17,45896,1,0,'2021-06-21 17:15:12','2021-06-21 17:15:11'),(18,89646,1,0,'2021-06-21 17:15:18','2021-06-21 17:15:18'),(19,78546,1,0,'2021-06-21 17:15:24','2021-06-21 17:15:24'),(20,78546,1,0,'2021-06-21 17:15:26','2021-06-21 17:15:25'),(21,876.5,3,0,'2021-06-21 17:17:21','2021-06-21 17:15:36'),(22,87568956.5,3,0,'2021-06-21 17:17:46','2021-06-21 17:17:45'),(23,878965.5,3,0,'2021-06-21 17:17:59','2021-06-21 17:17:58'),(24,459965.5,3,0,'2021-06-21 17:18:06','2021-06-21 17:18:05'),(25,5865.5,3,0,'2021-06-21 17:18:15','2021-06-21 17:18:15'),(26,89665.5,3,0,'2021-06-21 17:18:26','2021-06-21 17:18:25'),(27,32658,3,0,'2021-06-21 17:18:50','2021-06-21 17:18:49'),(28,32658.86,3,0,'2021-06-21 17:19:11','2021-06-21 17:19:10'),(29,32545,3,0,'2021-06-21 17:30:43','2021-06-21 17:30:42'),(30,98562.24548,3,0,'2021-06-21 17:30:50','2021-06-21 17:30:50');
/*!40000 ALTER TABLE `loans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT NULL,
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Ricardo.areiza.01@gmail.com','Ricardo','Areiza',0,'2021-06-20 01:36:13','2021-06-20 01:22:40'),(2,'dirielfran@gmail.com','Elvis','Areiza',0,'2021-06-21 00:11:40','2021-06-20 01:28:11'),(3,'antonio@gmail.com','Antonio','Piñango',0,'2021-06-20 01:34:58','2021-06-20 01:34:58'),(4,'diego@gmail.com','Diego','Areiza',0,'2021-06-20 18:55:44','2021-06-20 18:55:43'),(5,'Derek@gmail.com','Derek','Martinez',0,'2021-06-20 21:22:09','2021-06-20 21:22:09');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-23  7:44:55
