-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: exam
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `indexes` int NOT NULL,
  `index_bottom` int NOT NULL,
  `status` int NOT NULL,
  `creat_time` varchar(255) NOT NULL,
  `update_time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES (-515403775,'测试',9,9,0,'2022-08-31 09:46:51','2022-08-31 09:46:51'),(1,'华东',1,1,1,'2022-08-25 16:08:42','2022-08-25 16:08:44'),(2,'华中',2,2,1,'2022-08-25 16:08:45','2022-08-25 16:08:45'),(3,'华北',3,3,1,'2022-08-25 16:08:46','2022-08-25 16:08:47'),(4,'华南',4,4,1,'2022-08-25 16:08:51','2022-08-25 16:08:48'),(5,'西北',5,5,1,'2022-08-25 16:08:52','2022-08-25 16:08:48'),(6,'西南',6,6,1,'2022-08-25 16:08:52','2022-08-25 16:08:49'),(7,'东北',7,7,1,'2022-08-25 16:08:53','2022-08-25 16:08:49');
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `choice`
--

DROP TABLE IF EXISTS `choice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `choice` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `answer` varchar(255) NOT NULL,
  `option_a` varchar(255) NOT NULL,
  `option_b` varchar(255) NOT NULL,
  `option_c` varchar(255) NOT NULL,
  `option_d` varchar(255) NOT NULL,
  `fraction` int NOT NULL,
  `status` int NOT NULL,
  `operator` varchar(255) NOT NULL,
  `type` int NOT NULL,
  `creat_time` varchar(255) NOT NULL,
  `update_time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `choice`
--

LOCK TABLES `choice` WRITE;
/*!40000 ALTER TABLE `choice` DISABLE KEYS */;
INSERT INTO `choice` VALUES (1,'1+1=?','b','1','2','3','4',5,1,'丁岱达',1,'2022-09-10 11:33:06','2022-09-15 21:20:38'),(2,'什么动物被贴在墙上','d','梅花鹿','大象','熊猫','海豹',10,1,'丁岱达',1,'2022-09-10 11:34:36','2022-09-15 21:20:57'),(4,'1899年南通大生纱厂开业，其生产的机纱推动了周边农民家庭手工棉纺织业发展。棉纺织业发展对机纱的大量需求，又在大生纱厂濒临破产之际挽救了纱厂，并推动它走上迅速扩展之路。这一现象反映（ ）','d','机器大生产导致了小农经济破产','个体手工业阻碍机器大生产发展','“织”“耕”分离瓦解了自然经济','个体手工业可纳入新的经济体系',10,1,'丁岱达',1,'2022-09-03 17:04:58','2022-09-14 22:05:37'),(155697154,'以下能正确输出hello world的语句是？','c',':\"hello world\"','print(\"hello world\")','printf(\"hello world\")','printf(%d,\"hello world\")',10,1,'丁岱达',1,'2022-09-06 09:55:44','2022-09-06 09:55:44'),(365420545,'测试题目','b','1','2','3','4',10,0,'丁岱达',1,'2022-09-15 16:12:49','2022-09-15 16:13:37');
/*!40000 ALTER TABLE `choice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classes` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `indexes` int NOT NULL,
  `index_bottom` int NOT NULL,
  `status` int NOT NULL,
  `creat_time` varchar(255) NOT NULL,
  `update_time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` VALUES (1,'计算机213',1,1,1,'2022-08-25 16:12:48','2022-08-25 16:12:52'),(2,'计算机212',1,1,1,'2022-08-25 16:12:48','2022-08-25 16:12:53'),(3,'计算机211',1,1,1,'2022-08-25 16:12:48','2022-08-25 16:12:53'),(4,'医211',2,2,1,'2022-08-25 16:12:49','2022-08-25 16:12:53'),(5,'医212',2,2,1,'2022-08-25 16:12:49','2022-08-25 16:12:53'),(6,'医213',2,2,1,'2022-08-25 16:12:50','2022-08-25 16:12:54'),(7,'中文211',3,3,1,'2022-08-25 16:12:50','2022-08-25 16:12:54'),(8,'中文212',3,3,1,'2022-08-25 16:12:50','2022-08-25 16:12:54'),(797360130,'测试',2,2,1,'2022-09-15 21:18:55','2022-09-15 21:18:55'),(1128783873,'测试',1,1,0,'2022-09-15 16:10:55','2022-09-15 16:10:55'),(1401356289,'444',11,11,1,'2022-09-15 15:32:31','2022-09-15 15:32:31');
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `indexes` int NOT NULL,
  `index_bottom` int NOT NULL,
  `status` int NOT NULL,
  `creat_time` varchar(255) NOT NULL,
  `update_time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (-1220046846,'admin333',24,11,1,'2022-09-01 09:31:44','2022-09-01 09:31:44'),(-725098494,'admin',24,10,1,'2022-08-31 11:03:48','2022-08-31 11:03:48'),(1,'计算机系',1,1,1,'2022-08-25 16:12:33','2022-08-25 16:12:38'),(3,'医学系',1,2,1,'2022-08-25 16:12:34','2022-08-25 16:12:39'),(4,'中文系',1,3,1,'2022-08-25 16:12:34','2022-08-25 16:12:39'),(5,'数学系',2,4,1,'2022-08-25 16:12:34','2022-08-25 16:12:39'),(6,'中文系',2,5,1,'2022-08-25 16:12:35','2022-08-25 16:12:40'),(7,'中文系',3,6,1,'2022-08-25 16:12:35','2022-08-25 16:12:40'),(8,'数学系',3,7,1,'2022-08-25 16:12:36','2022-08-25 16:12:40'),(9,'医学系',4,8,1,'2022-08-25 16:12:36','2022-08-25 16:12:41'),(10,'中文系',4,9,1,'2022-08-25 16:12:37','2022-08-25 16:12:41');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `batch` varchar(255) NOT NULL,
  `info` varchar(255) NOT NULL,
  `start_time` varchar(255) NOT NULL,
  `end_time` varchar(255) NOT NULL,
  `point` int DEFAULT NULL,
  `operator` varchar(255) NOT NULL,
  `primary_organization` int NOT NULL,
  `secondary_organization` int NOT NULL,
  `tertiary_organization` int NOT NULL,
  `four_organization` int NOT NULL,
  `creat_time` varchar(255) NOT NULL,
  `update_time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
INSERT INTO `exam` VALUES (4812,'计算机系第二轮考试','1','第一轮测试','2022-09-15 21:22:13','2022-09-16 00:00:00',NULL,'丁岱达',1,1,1,1,'2022-09-15 21:22:18','2022-09-15 21:22:18'),(38248450,'admin333','2','第二轮测试','2022-09-15 15:58:37','2022-09-15 15:58:38',NULL,'丁岱达',1,1,1,1,'2022-09-14 22:05:07','2022-09-14 22:05:07'),(1451741185,'计算机系第一轮考试','1','第一轮测试','2022-09-08 10:40:16','2022-09-09 00:00:00',NULL,'丁岱达',1,1,1,1,'2022-09-08 10:40:20','2022-09-08 10:40:20'),(1497849857,'admin222','第一场','测试','2022-09-14 21:54:45','2022-09-14 21:54:46',NULL,'丁岱达',1,1,1,1,'2022-09-14 15:39:46','2022-09-14 15:39:46');
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_paper`
--

DROP TABLE IF EXISTS `exam_paper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam_paper` (
  `id` int NOT NULL,
  `exam_id` int NOT NULL,
  `sequence` int NOT NULL,
  `question_id` int NOT NULL,
  `type` int NOT NULL,
  `operator` varchar(255) NOT NULL,
  `creat_time` varchar(255) NOT NULL,
  `update_time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_paper`
--

LOCK TABLES `exam_paper` WRITE;
/*!40000 ALTER TABLE `exam_paper` DISABLE KEYS */;
INSERT INTO `exam_paper` VALUES (-2117615614,1451741185,5,-1006125055,3,'丁岱达','2022-09-10 19:35:15','2022-09-10 19:35:15'),(-1928871935,1451741185,4,1,3,'丁岱达','2022-09-10 19:34:42','2022-09-10 19:34:42'),(-1480089598,38248450,7,-1006125055,3,'丁岱达','2022-09-14 22:07:16','2022-09-14 22:07:16'),(-1220100095,4812,4,1158135810,2,'丁岱达','2022-09-15 21:22:43','2022-09-15 21:22:43'),(-905486334,1497849857,13,1,3,'丁岱达','2022-09-14 15:40:37','2022-09-14 15:40:37'),(-809017343,1497849857,5,2,1,'丁岱达','2022-09-14 15:40:27','2022-09-14 15:40:27'),(-712548350,1497849857,8,4,1,'丁岱达','2022-09-14 15:40:28','2022-09-14 15:40:28'),(-653869054,4812,8,4,1,'丁岱达','2022-09-15 21:22:50','2022-09-15 21:22:50'),(-586702846,38248450,1,2,1,'丁岱达','2022-09-14 22:07:09','2022-09-14 22:07:09'),(-498622462,38248450,3,4,1,'丁岱达','2022-09-14 22:07:10','2022-09-14 22:07:10'),(-423141375,1497849857,3,155697154,1,'丁岱达','2022-09-14 15:40:08','2022-09-14 15:40:08'),(-272121855,1451741185,1,1,1,'丁岱达','2022-09-10 19:27:39','2022-09-10 19:27:39'),(-251174911,1497849857,12,1158135810,2,'丁岱达','2022-09-14 15:40:33','2022-09-14 15:40:33'),(-192495615,4812,1,1,1,'丁岱达','2022-09-15 21:22:38','2022-09-15 21:22:38'),(-33046527,1451741185,3,1158135810,2,'丁岱达','2022-09-10 19:34:07','2022-09-10 19:34:07'),(591839233,4812,5,1,3,'丁岱达','2022-09-15 21:22:46','2022-09-15 21:22:46'),(919052290,38248450,6,1158135810,2,'丁岱达','2022-09-14 22:07:14','2022-09-14 22:07:14'),(1032282113,1497849857,10,1,2,'丁岱达','2022-09-14 15:40:32','2022-09-14 15:40:32'),(2114428929,38248450,4,1,2,'丁岱达','2022-09-14 22:07:13','2022-09-14 22:07:13');
/*!40000 ALTER TABLE `exam_paper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `judgment`
--

DROP TABLE IF EXISTS `judgment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `judgment` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `answer` varchar(255) NOT NULL,
  `option_a` varchar(255) NOT NULL,
  `option_b` varchar(255) NOT NULL,
  `fraction` int NOT NULL,
  `status` int NOT NULL,
  `operator` varchar(255) NOT NULL,
  `type` int NOT NULL,
  `creat_time` varchar(255) NOT NULL,
  `update_time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `judgment`
--

LOCK TABLES `judgment` WRITE;
/*!40000 ALTER TABLE `judgment` DISABLE KEYS */;
INSERT INTO `judgment` VALUES (1,'1+1=3','错','对','错',2,1,'丁岱达',2,'2022-09-03 16:48:34','2022-09-09 09:14:29'),(1158135810,'7878-78=78','错','对','错',10,1,'丁岱达',2,'2022-09-06 09:58:16','2022-09-09 09:14:48');
/*!40000 ALTER TABLE `judgment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `result` (
  `id` int NOT NULL,
  `exam_id` int NOT NULL,
  `nick_name` varchar(255) NOT NULL,
  `achievement` int NOT NULL,
  `creat_time` varchar(255) NOT NULL,
  `update_time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result`
--

LOCK TABLES `result` WRITE;
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
INSERT INTO `result` VALUES (-1907937279,38248450,'Melancholy-feel',99,'2022-09-14 22:30:51','2022-09-14 22:30:51'),(-1547182079,1497849857,'Melancholy-feel',56,'2022-09-14 21:08:47','2022-09-14 21:08:47'),(-838418430,4812,'Melancholy-feel',15,'2022-09-15 21:27:31','2022-09-15 21:27:31'),(868716545,1451741185,'Melancholy-feel',100,'2022-09-14 13:37:05','2022-09-14 13:37:05');
/*!40000 ALTER TABLE `result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `school`
--

DROP TABLE IF EXISTS `school`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `school` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `indexes` int NOT NULL,
  `index_bottom` int NOT NULL,
  `status` int NOT NULL,
  `creat_time` varchar(255) NOT NULL,
  `update_time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school`
--

LOCK TABLES `school` WRITE;
/*!40000 ALTER TABLE `school` DISABLE KEYS */;
INSERT INTO `school` VALUES (-427298814,'测试',9,24,1,'2022-08-31 10:10:47','2022-08-31 10:10:47'),(1,'丽水学院',1,1,1,'2022-08-25 16:10:43','2022-08-25 16:11:03'),(2,'复旦大学',1,2,1,'2022-08-25 16:10:43','2022-08-25 16:11:03'),(3,'上海交通大学',1,3,1,'2022-08-25 16:10:44','2022-08-25 16:11:04'),(4,'南京理工大学',1,4,1,'2022-08-25 16:10:44','2022-08-25 16:11:04'),(5,'华中科技大学',2,5,1,'2022-08-25 16:10:44','2022-08-25 16:11:04'),(6,'武汉大学',2,6,1,'2022-08-25 16:10:45','2022-08-25 16:11:05'),(7,'国防科技大学',2,7,1,'2022-08-25 16:10:45','2022-08-25 16:11:05'),(8,'首都医科大学',3,8,1,'2022-08-25 16:10:45','2022-08-25 16:11:06'),(9,'天津工业大学',3,9,1,'2022-08-25 16:10:46','2022-08-25 16:11:06'),(10,'北京语言大学',3,10,1,'2022-08-25 16:10:46','2022-08-25 16:11:06'),(11,'中山大学',4,11,1,'2022-08-25 16:10:46','2022-08-25 16:11:07'),(12,'华南理工大学',4,12,1,'2022-08-25 16:10:47','2022-08-25 16:11:07'),(13,'暨南大学',4,13,1,'2022-08-25 16:10:47','2022-08-25 16:11:08'),(14,'西北农林科技大学',5,14,1,'2022-08-25 16:10:48','2022-08-25 16:11:08'),(15,'西北大学',5,15,1,'2022-08-25 16:10:48','2022-08-25 16:11:09'),(16,'西北师范大学',5,16,1,'2022-08-25 16:10:48','2022-08-25 16:11:09'),(17,'四川大学',6,17,1,'2022-08-25 16:10:49','2022-08-25 16:11:10'),(18,'电子科技大学',6,18,1,'2022-08-25 16:10:49','2022-08-25 16:11:10'),(19,'成都理工大学',6,19,1,'2022-08-25 16:10:50','2022-08-25 16:11:11'),(20,'西南政法大学',6,20,1,'2022-08-25 16:10:50','2022-08-25 16:11:11'),(21,'哈尔滨工业大学',7,21,1,'2022-08-25 16:10:51','2022-08-25 16:11:12'),(22,'吉林大学',7,22,1,'2022-08-25 16:10:51','2022-08-25 16:11:12'),(23,'大连理工大学',7,23,1,'2022-08-25 16:10:51','2022-08-25 16:10:59'),(705159169,'admin222',9,89,1,'2022-08-31 10:58:57','2022-08-31 10:58:57');
/*!40000 ALTER TABLE `school` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solution`
--

DROP TABLE IF EXISTS `solution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `solution` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `answer` varchar(255) NOT NULL,
  `fraction` int NOT NULL,
  `status` int NOT NULL,
  `operator` varchar(255) NOT NULL,
  `type` int NOT NULL,
  `creat_time` varchar(255) NOT NULL,
  `update_time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solution`
--

LOCK TABLES `solution` WRITE;
/*!40000 ALTER TABLE `solution` DISABLE KEYS */;
INSERT INTO `solution` VALUES (-1006125055,'请写出键盘D键和G键之间的键的名字以及证明过程','F',10,1,'丁岱达',3,'2022-09-06 09:58:55','2022-09-06 09:58:55'),(1,'甲、乙两队共同修一条长400米的公路，甲队从东往西修4天，乙队从西往东修5天，正好修完，甲队比乙队每天多修10米。甲、乙两队每天共修多少米？','甲乙两队每天共修的米数：40×2+10=80+10=90（米）',20,1,'丁岱达',3,'2022-09-03 17:09:47','2022-09-08 17:23:01'),(2131165185,'光刻机怎么才能实现突破','略',10,1,'丁岱达',3,'2022-09-15 15:42:46','2022-09-15 15:43:36');
/*!40000 ALTER TABLE `solution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `nick_name` varchar(255) NOT NULL,
  `school` varchar(255) NOT NULL,
  `classes` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  `avatar_url` varchar(255) NOT NULL,
  `creat_time` varchar(255) NOT NULL,
  `update_time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1682374658,'邓荣松','Melancholy-feel','丽水学院','计算机213','0','https://thirdwx.qlogo.cn/mmopen/vi_32/PYa8oDrW84FKFeT1FkicRribeJG6MlxiaonprBZk3IlAjRYHREEUxNvtbrKLyW6XZObzzEfoESjMIjtutJ7WtNQvA/132','2022-09-15 15:54:39','2022-09-15 21:24:32');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_answer`
--

DROP TABLE IF EXISTS `student_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_answer` (
  `id` int NOT NULL,
  `exam_id` int NOT NULL,
  `sequence` int NOT NULL,
  `question_id` int NOT NULL,
  `type` int NOT NULL,
  `answer` varchar(255) NOT NULL,
  `nick_name` varchar(255) NOT NULL,
  `creat_time` varchar(255) NOT NULL,
  `update_time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_answer`
--

LOCK TABLES `student_answer` WRITE;
/*!40000 ALTER TABLE `student_answer` DISABLE KEYS */;
INSERT INTO `student_answer` VALUES (-1828245503,38248450,4,1,2,'对','Melancholy-feel','2022-09-14 22:26:26','2022-09-14 22:26:26'),(-1815650302,1497849857,8,4,1,'d','Melancholy-feel','2022-09-14 15:53:19','2022-09-14 15:53:19'),(-1752776703,4812,4,1158135810,2,'对','Melancholy-feel','2022-09-15 21:25:33','2022-09-15 21:25:33'),(-1505349630,1451741185,3,1158135810,2,'对','Melancholy-feel','2022-09-13 14:14:35','2022-09-13 14:14:35'),(-1345888254,1497849857,12,1158135810,2,'错','Melancholy-feel','2022-09-14 15:53:24','2022-09-14 15:53:24'),(-855195646,4812,5,1,3,'20m','Melancholy-feel','2022-09-15 21:25:38','2022-09-15 21:25:38'),(-851001342,4812,8,4,1,'d','Melancholy-feel','2022-09-15 21:25:42','2022-09-15 21:25:42'),(-305700863,1497849857,13,1,3,'20m','Melancholy-feel','2022-09-14 15:53:28','2022-09-14 15:53:28'),(-129540095,1497849857,5,2,1,'c','Melancholy-feel','2022-09-14 15:53:16','2022-09-14 15:53:16'),(-112840703,1451741185,4,1,3,'20m','Melancholy-feel','2022-09-13 14:15:06','2022-09-13 14:15:06'),(75980802,1497849857,10,1,2,'对','Melancholy-feel','2022-09-14 15:53:22','2022-09-14 15:53:22'),(356986882,38248450,1,2,1,'d','Melancholy-feel','2022-09-14 22:26:38','2022-09-14 22:26:38'),(814166018,38248450,3,4,1,'d','Melancholy-feel','2022-09-14 22:26:42','2022-09-14 22:26:42'),(1002844162,1451741185,1,1,1,'b','Melancholy-feel','2022-09-13 14:14:24','2022-09-13 14:14:24'),(1149722626,1497849857,3,155697154,1,'b','Melancholy-feel','2022-09-14 15:53:14','2022-09-14 15:53:14'),(1158070274,4812,1,1,1,'a','Melancholy-feel','2022-09-15 21:25:24','2022-09-15 21:25:24'),(1216819202,38248450,6,1158135810,2,'错','Melancholy-feel','2022-09-14 22:26:50','2022-09-14 22:26:50'),(1225207810,38248450,7,-1006125055,3,'f','Melancholy-feel','2022-09-14 22:26:54','2022-09-14 22:26:54'),(1531326466,1451741185,5,-1006125055,3,'f键，证明从略','Melancholy-feel','2022-09-13 14:14:58','2022-09-13 14:14:58'),(1741041666,1451741185,2,2,1,'d','Melancholy-feel','2022-09-13 14:14:29','2022-09-13 14:14:29');
/*!40000 ALTER TABLE `student_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  `age` int NOT NULL,
  `phone` varchar(255) NOT NULL,
  `type` int NOT NULL,
  `status` int NOT NULL,
  `creat_time` varchar(255) NOT NULL,
  `update_time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (-1052254206,'1+1=','5555','5','女',89,'11111',0,1,'2022-09-15 16:08:40','2022-09-15 16:08:54'),(-599326719,'111','7777','7','女',3,'33333',1,1,'2022-09-15 15:30:43','2022-09-15 16:07:43'),(-427397118,'admin222','12','12','男',23,'33333',1,1,'2022-08-24 16:31:24','2022-08-24 18:37:08'),(1,'邓荣松','123','123','男',20,'15183145500',0,1,'2022-08-04 17:39:38','2022-08-04 17:39:44'),(2,'丁岱达','1','1','女',19,'19865623526',1,0,'2022-08-22 16:22:47','2022-08-22 16:22:49'),(3,'admin333','2','56','男',56,'33333',0,1,'2022-08-23 17:10:10','2022-08-24 18:29:01'),(4,'聂凡娆','3','3','女',20,'16968594253',1,1,'2022-08-23 17:24:07','2022-08-23 17:24:33'),(42414082,'冯凡娆','89','89','男',23,'22222',1,1,'2022-08-24 18:29:56','2022-09-15 15:29:44'),(520536066,'777','8888','8','男',23,'33333',0,0,'2022-09-15 21:15:31','2022-09-15 21:15:31');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-28 19:07:39
