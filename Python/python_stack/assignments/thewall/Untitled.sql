-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: thewall
-- ------------------------------------------------------
-- Server version	5.6.35

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
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` text,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `messages_id` int(11) NOT NULL,
  `users_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_comments_messages_idx` (`messages_id`),
  KEY `fk_comments_users1_idx` (`users_id`),
  CONSTRAINT `fk_comments_messages` FOREIGN KEY (`messages_id`) REFERENCES `messages` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comments_users1` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,'no wayyy!','2017-06-15 18:00:59','2017-06-15 18:00:59',1,3),(2,'omg!','2017-06-15 18:00:59','2017-06-15 18:00:59',2,4),(3,'totally!','2017-06-15 18:00:59','2017-06-15 18:00:59',2,2),(4,'totally!','2017-06-15 18:00:59','2017-06-15 18:00:59',2,5),(9,'wait really?','2017-06-16 01:47:27','2017-06-16 01:47:27',15,15),(10,'oka i agree','2017-06-16 01:51:25','2017-06-16 01:51:25',3,15),(11,'yep that\'s me','2017-06-16 02:40:22','2017-06-16 02:40:22',18,15);
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `messages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` text,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `users_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_messages_users1_idx` (`users_id`),
  CONSTRAINT `fk_messages_users1` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES (1,'this is cool!','2017-06-15 16:27:16','2017-06-15 16:27:16',2),(2,'workworkwork','2017-06-15 16:28:21','2017-06-15 16:28:21',2),(3,'what up','2017-06-15 16:31:02','2017-06-15 16:31:02',2),(11,'whoa!','2017-06-16 00:06:47','2017-06-16 00:06:47',3),(14,'this is new balloon','2017-06-16 00:37:41','2017-06-16 00:37:41',3),(15,'wew','2017-06-16 00:46:20','2017-06-16 00:46:20',3),(16,'okay, this sounds really cool!','2017-06-16 01:46:34','2017-06-16 01:46:34',15),(18,'gossip gurl','2017-06-16 02:40:14','2017-06-16 02:40:14',15);
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Sushma','Mangalapally','sushma.m812@gmail.com','5743645e04f61b7f53b26f2f780da125','2017-06-15 15:05:11','2017-06-15 15:05:11'),(2,'George','Washington','gwash@mail.com','0ed2b406efc231be1270e405e86ca14a','2017-06-15 15:38:59','2017-06-15 15:38:59'),(3,'Nikki','Mangalapally','nikvm@gmail.com','66b8f8a0cd00484d077b5c4f77099345','2017-06-15 17:42:38','2017-06-15 17:42:38'),(4,'Kassandra','Crawley','craw@mail.com','0b9b37dd1dc7809e9482c73929515ee8','2017-06-15 17:44:54','2017-06-15 17:44:54'),(5,'Stephanie','Lin','slin@mail.com','59f29878f0ca6fffa2485e3c5e3b5443','2017-06-15 17:46:49','2017-06-15 17:46:49'),(6,'Betty','Huang','bhuang@gmail.com','9351ad116df9ac810aa00d244f2a9d9f','2017-06-16 01:04:41','2017-06-16 01:04:41'),(7,'Mary','Zamoski','mzam@scu.edu','505ca5ca08bc70ab1364447e15330dd3','2017-06-16 01:11:17','2017-06-16 01:11:17'),(8,'Sandhya','Sandha','sandhyasandha@gmail.com','ebde191d39afca85b6a95d4ffa3d34ea','2017-06-16 01:12:14','2017-06-16 01:12:14'),(9,'Sandhya','Sandha','sandhyasandha@gmail.com','ebde191d39afca85b6a95d4ffa3d34ea','2017-06-16 01:14:01','2017-06-16 01:14:01'),(10,'Sandhya','Sandha','sandhyasandha@gmail.com','ebde191d39afca85b6a95d4ffa3d34ea','2017-06-16 01:14:33','2017-06-16 01:14:33'),(11,'Sandhya','Sandha','sandhyasandha@gmail.com','ebde191d39afca85b6a95d4ffa3d34ea','2017-06-16 01:15:00','2017-06-16 01:15:00'),(12,'Sandhya','Sandha','sandhyasandha@gmail.com','ebde191d39afca85b6a95d4ffa3d34ea','2017-06-16 01:15:11','2017-06-16 01:15:11'),(13,'Kashyap','Mang','kmangala@gmail.com','0b73ea7df5d84df5808c3ca19dc1a214','2017-06-16 01:16:29','2017-06-16 01:16:29'),(14,'Kashyap','Mang','kmangala@gmail.com','0b73ea7df5d84df5808c3ca19dc1a214','2017-06-16 01:17:39','2017-06-16 01:17:39'),(15,'Blair','Waldorf','bwald@mail.com','28689ca9d8971a020598658f6b6efb46','2017-06-16 01:18:29','2017-06-16 01:18:29');
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

-- Dump completed on 2017-06-16  2:44:36
