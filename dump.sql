-- MySQL dump 10.13  Distrib 5.6.44, for Linux (x86_64)
--
-- Host: localhost    Database: ASA
-- ------------------------------------------------------
-- Server version	5.6.44

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
-- Table structure for table `test3`
--

DROP TABLE IF EXISTS `test3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test3` (
  `listno` bigint(20) NOT NULL AUTO_INCREMENT,
  `todoname` varchar(31) NOT NULL DEFAULT 'TODO',
  `untildate` varchar(10) NOT NULL DEFAULT '2018-01-01',
  `createdate` varchar(10) NOT NULL DEFAULT '2018-01-01',
  `complete` tinyint(1) NOT NULL DEFAULT '0',
  `color` varchar(10) NOT NULL DEFAULT 'red',
  PRIMARY KEY (`listno`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test3`
--

LOCK TABLES `test3` WRITE;
/*!40000 ALTER TABLE `test3` DISABLE KEYS */;
INSERT INTO `test3` VALUES (1,'ロボット設計演習レポート1','2019-05-01','2019-07-31',1,'blue'),(2,'ロボット設計演習レポート2','2019-06-01','2019-07-31',1,'blue'),(3,'ロボット設計演習レポート3','2019-07-01','2019-07-31',1,'blue'),(4,'アクチュエータ工学レポート','2019-05-25','2019-07-31',0,'red'),(5,'PID制御','2019-01-01','2019-07-31',1,'blue'),(6,'シンガポール','2019-01-01','2019-07-31',0,'red'),(7,'チームラボ課題','2019-08-04','2019-07-31',1,'blue'),(8,'運転の練習','2019-08-02','2019-07-31',1,'blue'),(9,'晩御飯予定','2019-08-01','2019-07-31',0,'red'),(10,'シャラポアとテニス','2019-01-01','2019-07-31',1,'blue'),(11,'井上氏とご飯','2019-01-01','2019-07-31',1,'blue'),(12,'近江舞子','2019-01-01','2019-07-31',1,'blue'),(13,'エラー解消','2019-08-02','2019-08-01',1,'blue'),(14,'エスケープ処理実装','2019-08-02','2019-08-02',1,'blue'),(15,'旅行の予定たてる','2019-08-07','2019-08-02',0,'red'),(16,'<>','2019-01-01','2019-08-02',0,'red'),(17,'あ','2019-01-01','2019-08-02',0,'red'),(18,'&<>\'','2019-01-01','2019-08-02',0,'red'),(19,'<strong>HTMLの特殊文字列</strong>','2019-01-01','2019-08-02',0,'red'),(20,'お','2019-01-01','2019-08-02',0,'red'),(21,'<>>>','2019-01-01','2019-08-02',0,'red'),(22,'<//','2019-01-01','2019-08-02',1,'blue'),(23,'//>','2019-01-01','2019-08-02',1,'blue'),(24,'<<','2019-01-01','2019-08-02',1,'blue'),(25,'<strong> aaa</strong>','2019-01-01','2019-08-02',1,'blue'),(26,'<>//','2019-01-01','2019-08-02',1,'blue');
/*!40000 ALTER TABLE `test3` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-02  5:39:54
