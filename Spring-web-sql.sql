CREATE DATABASE  IF NOT EXISTS `java3` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `java3`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: java3
-- ------------------------------------------------------
-- Server version	5.5.37

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
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authorities` (
  `username` varchar(30) NOT NULL,
  `authority` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES ('rufat','admin'),('rufat','list:cars'),('rufat','list:students'),('rufat','show-save-page:students'),('rufat','save:students'),('rufat','edit:students'),('rufat','delete:students'),('elbrus','admin'),('elbrus','list:cars'),('elbrus','list:students'),('elbrus','show-save-page:students'),('elbrus','save:students'),('nihad','admin'),('nihad','list:students'),('nihad','delete:students'),('resad','admin'),('resad','list:students'),('resad','edit:students'),('resad','save:students'),('rufat','admin'),('rufat','list:cars'),('rufat','list:students'),('rufat','show-save-page:students'),('rufat','save:students'),('rufat','edit:students'),('rufat','delete:students'),('elbrus','admin'),('elbrus','list:cars'),('elbrus','list:students'),('elbrus','show-save-page:students'),('elbrus','save:students'),('nihad','admin'),('nihad','list:students'),('nihad','delete:students'),('resad','admin'),('resad','list:students'),('resad','edit:students'),('resad','save:students'),('rufat','admin'),('rufat','list:cars'),('rufat','list:students'),('rufat','show-save-page:students'),('rufat','save:students'),('rufat','edit:students'),('rufat','delete:students'),('elbrus','admin'),('elbrus','list:cars'),('elbrus','list:students'),('elbrus','show-save-page:students'),('elbrus','save:students'),('nihad','admin'),('nihad','list:students'),('nihad','delete:students'),('resad','admin'),('resad','list:students'),('resad','edit:students'),('resad','save:students'),('rufat','admin'),('rufat','list:cars'),('rufat','list:students'),('rufat','show-save-page:students'),('rufat','save:students'),('rufat','edit:students'),('rufat','delete:students'),('elbrus','admin'),('elbrus','list:cars'),('elbrus','list:students'),('elbrus','show-save-page:students'),('elbrus','save:students'),('nihad','admin'),('nihad','list:students'),('nihad','delete:students'),('resad','admin'),('resad','list:students'),('resad','edit:students'),('resad','save:students'),('amin','admin'),('amin','list:cars'),('akber','admin'),('akber','list:cars'),('xeyal','admin'),('xeyal','list:cars'),('leyla','admin'),('leyla','list:cars'),('rufat','list:book'),('rufat','save:book'),('rufat','open:edit:book'),('rufat','open:save:books'),('rufat','list:book'),('rufat','save:book'),('rufat','open:edit:book'),('rufat','open:save:books'),('rufat','list:book'),('rufat','save:book'),('rufat','open:edit:book'),('rufat','open:save:books'),('rufat','list:book'),('rufat','save:book'),('rufat','open:edit:book'),('rufat','open:save:books'),('rufat','list:books'),('rufat','save:books'),('rufat','open:edit:books'),('rufat','open:save:books'),('rufat','list:books'),('rufat','save:books'),('rufat','open:edit:books'),('rufat','open:save:books'),('rufat','list:books'),('rufat','save:book'),('rufat','open:edit:book'),('rufat','open:save:book'),('rufat','list:books'),('rufat','save:book'),('rufat','open:edit:book'),('rufat','open:save:book'),('rufat','delete:book'),('rufat','edit:book'),('rufat','delete:book'),('rufat','edit:book'),('rufat','delete:book'),('rufat','edit:book'),('akberrr','admin'),('akberrr','list:cars'),('fatime','admin'),('fatime','list:cars'),('Leyla','admin'),('Leyla','list:cars');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authors`
--

LOCK TABLES `authors` WRITE;
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors` VALUES (1,'Rufat'),(2,'Anar'),(3,'Vusal'),(4,'Orxan'),(5,'Nicat'),(6,'Akber');
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `outhor` varchar(45) DEFAULT NULL,
  `page_conut` int(11) DEFAULT NULL,
  `publish_date` date DEFAULT NULL,
  `counter` int(11) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `page_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (4,'html',300.00,'jems',500,'2012-08-20',NULL,NULL,NULL),(5,'css',300.00,'jems',500,'2007-08-20',NULL,NULL,NULL),(6,'python',300.00,'jems',500,'1991-08-20',NULL,NULL,NULL),(7,'spring',300.00,'jems',500,'1999-08-20',NULL,NULL,NULL),(8,'react',300.00,'jems',500,'1996-08-20',NULL,NULL,NULL),(9,'angular',300.00,'jems',500,'2002-08-20',NULL,NULL,NULL),(10,'sql',300.00,'jems',500,'2021-08-20',NULL,NULL,NULL),(11,'html',300.00,'jems',500,'2015-08-20',NULL,NULL,NULL),(20,'',NULL,NULL,NULL,'2022-08-24',NULL,'Ingilis',NULL),(21,'',NULL,NULL,NULL,'2022-08-25',NULL,'Ingilis',NULL);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books_authors`
--

DROP TABLE IF EXISTS `books_authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books_authors` (
  `book_id` int(11) NOT NULL,
  `authors_id` int(11) NOT NULL,
  KEY `FK20menrngp9wi9at1dsu5cbb8o` (`authors_id`),
  KEY `FK1b933slgixbjdslgwu888m34v` (`book_id`),
  CONSTRAINT `FK1b933slgixbjdslgwu888m34v` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`),
  CONSTRAINT `FK20menrngp9wi9at1dsu5cbb8o` FOREIGN KEY (`authors_id`) REFERENCES `authors` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books_authors`
--

LOCK TABLES `books_authors` WRITE;
/*!40000 ALTER TABLE `books_authors` DISABLE KEYS */;
INSERT INTO `books_authors` VALUES (20,2),(20,4),(20,6),(21,1),(21,2),(21,3);
/*!40000 ALTER TABLE `books_authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cars`
--

DROP TABLE IF EXISTS `cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cars` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(30) DEFAULT NULL,
  `speed` int(11) DEFAULT NULL,
  `color` varchar(30) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `made_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars`
--

LOCK TABLES `cars` WRITE;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
INSERT INTO `cars` VALUES (4,'Ford123',200,'Blue',13500,'2018-05-07'),(5,'Nissan',240,'Yellow',37000,'2021-03-09'),(6,'Tesla',320,'Green',102000,'2013-07-06'),(7,'Honda',300,'Black',23000,'2007-12-12'),(8,'Tayota',310,'White',36500,'2018-10-04'),(9,'Kia',240,'Red',52000,'2018-05-05'),(10,'Bmw',260,'Black',45000,'2019-05-06'),(11,'Mercedes',220,'White',75000,'2016-07-03'),(12,'Ford',200,'Blue',13500,'2018-05-07'),(13,'Nissan',240,'Yellow',37000,'2021-03-09'),(14,'Tesla',320,'Green',102000,'2013-07-06'),(15,'Honda',300,'Black',23000,'2007-12-12'),(16,'Tayota',310,'White',36500,'2018-10-04'),(17,'Kia',240,'Red',52000,'2018-05-05'),(18,'Bmw',260,'Black',45000,'2019-05-06'),(19,'Mercedes',220,'White',75000,'2016-07-03'),(20,'Ford',200,'Blue',13500,'2018-05-07'),(21,'Nissan',240,'Yellow',37000,'2021-03-09'),(22,'Tesla',320,'Green',102000,'2013-07-06'),(23,'Honda',300,'Black',23000,'2007-12-12'),(24,'Tayota',310,'White',36500,'2018-10-04'),(25,'Kia',240,'Red',52000,'2018-05-05'),(26,'Bmw',260,'Black',45000,'2019-05-06'),(27,'Mercedes',220,'White',75000,'2016-07-03'),(28,'Ford',200,'Blue',13500,'2018-05-07'),(29,'Nissan',240,'Yellow',37000,'2021-03-09'),(30,'Tesla',320,'Green',102000,'2013-07-06'),(31,'Honda',300,'Black',23000,'2007-12-12'),(32,'Tayota',310,'White',36500,'2018-10-04'),(33,'Hundai',290,'goy',15350,'2021-06-29'),(34,'Hundai',250,'Tund yasil',450005,'2022-08-02');
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `surname` varchar(30) DEFAULT NULL,
  `brithday` date DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `phone` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'Rufat','Qarayev','1989-04-18','qarayev.rufat@gmail.com','+994-51-996-3116'),(2,'Huseyin','Humabtov','2010-02-15','Huseyin.Humabtov@gmail.com','+994-51-996-3116'),(3,'Xeyal','Xellov','2010-09-26','Xellov.Xeyal@gmail.com','+994-51-996-3116'),(4,'Uqur','Humabtov','2012-03-15','Uqur.Humabtov@gmail.com','+994-51-996-3116'),(5,'Leyla','Qarayeva','2018-10-04','qarayeva.leyla@gmail.com','+994-51-996-3116'),(6,'Rufat','Qarayev','1989-04-18','qarayev.rufat@gmail.com','+994-51-996-3116'),(7,'Huseyin','Humabtov','2010-02-15','Huseyin.Humabtov@gmail.com','+994-51-996-3116'),(8,'Xeyal','Xellov','2010-09-26','Xellov.Xeyal@gmail.com','+994-51-996-3116'),(9,'Uqur','Humabtov','2012-03-15','Uqur.Humabtov@gmail.com','+994-51-996-3116'),(10,'Leyla','Qarayeva','2018-10-04','qarayeva.leyla@gmail.com','+994-51-996-3116'),(11,'Rufat','Qarayev','1989-04-18','qarayev.rufat@gmail.com','+994-51-996-3116'),(12,'Huseyin','Humabtov','2010-02-15','Huseyin.Humabtov@gmail.com','+994-51-996-3116'),(13,'Xeyal','Xellov','2010-09-26','Xellov.Xeyal@gmail.com','+994-51-996-3116'),(14,'Uqur','Humabtov','2012-03-15','Uqur.Humabtov@gmail.com','+994-51-996-3116'),(15,'Leyla','Qarayeva','2018-10-04','qarayeva.leyla@gmail.com','+994-51-996-3116'),(16,'Rufat','Qarayev','1989-04-18','qarayev.rufat@gmail.com','+994-51-996-3116'),(17,'Huseyin','Humabtov','2010-02-15','Huseyin.Humabtov@gmail.com','+994-51-996-3116'),(18,'Xeyal','Xellov','2010-09-26','Xellov.Xeyal@gmail.com','+994-51-996-3116'),(19,'Uqur','Humabtov','2012-03-15','Uqur.Humabtov@gmail.com','+994-51-996-3116'),(20,'Leyla','Qarayeva','2018-10-04','qarayeva.leyla@gmail.com','+994-51-996-3116');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('Leyla','{bcrypt}$2a$10$OM5LIElc9TPUq4QwVteEJOG2iNLeIq55yMeMHh8s3OVe1U5wy1YKG',1),('rufat','{noop}1',1);
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

-- Dump completed on 2023-03-05 16:03:25
