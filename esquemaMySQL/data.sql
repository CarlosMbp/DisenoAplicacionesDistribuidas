-- MySQL dump 10.13  Distrib 8.0.14, for Win64 (x86_64)
--
-- Host: localhost    Database: posts
-- ------------------------------------------------------
-- Server version	8.0.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clases`
--

DROP TABLE IF EXISTS `clases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `clases` (
  `id` bigint(20) NOT NULL,
  `aforo` int(11) NOT NULL,
  `dia` int(11) NOT NULL,
  `hora` int(11) NOT NULL,
  `nombre_sala` varchar(255) DEFAULT NULL,
  `profesor` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `sala_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKctixuiveybh6m63d9okysmypx` (`sala_id`),
  CONSTRAINT `FKctixuiveybh6m63d9okysmypx` FOREIGN KEY (`sala_id`) REFERENCES `salas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clases`
--

LOCK TABLES `clases` WRITE;
/*!40000 ALTER TABLE `clases` DISABLE KEYS */;
INSERT INTO `clases` VALUES (4,2,3,17,'Piscina','Maria','AquaGYM',1),(5,2,5,12,'Piscina','Juan','NadoLibre',1),(6,50,1,18,'Zumba','Aitor','Zumba',3),(7,40,0,0,'Gym','-','gym',2);
/*!40000 ALTER TABLE `clases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cliente` (
  `id` bigint(20) NOT NULL,
  `edad` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password_hash` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (11,54,'paco@gmail.com','paco','$2a$10$PnVutkOKG8pASbGp5jYseufbebdMZlTP5H4TcnaY2WJLyYKagUsf2'),(12,54,'paco@gmail.com','admin','$2a$10$NsSubM2Kqlg2IPt1lsSgyeE5.3d6XH8f6ZimuqiYbm/M70xgvY8w2'),(13,11,'carloswep123@gmail.com','carlos','$2a$10$SbnYdqAiv4er1G3PaabsJugQYnH4AW8eO.HGzfKwqKpX9VjDaiiJu');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_clases`
--

DROP TABLE IF EXISTS `cliente_clases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cliente_clases` (
  `cliente_id` bigint(20) NOT NULL,
  `clases_id` bigint(20) NOT NULL,
  KEY `FKf9ki3gw8wunufhqb6hp2ototw` (`clases_id`),
  KEY `FKs28p2ykv7q0eeapa4o5m9fchc` (`cliente_id`),
  CONSTRAINT `FKf9ki3gw8wunufhqb6hp2ototw` FOREIGN KEY (`clases_id`) REFERENCES `clases` (`id`),
  CONSTRAINT `FKs28p2ykv7q0eeapa4o5m9fchc` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_clases`
--

LOCK TABLES `cliente_clases` WRITE;
/*!40000 ALTER TABLE `cliente_clases` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente_clases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_roles`
--

DROP TABLE IF EXISTS `cliente_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cliente_roles` (
  `cliente_id` bigint(20) NOT NULL,
  `roles` varchar(255) DEFAULT NULL,
  KEY `FKdrshtg7is7fbxhuehuamwyx57` (`cliente_id`),
  CONSTRAINT `FKdrshtg7is7fbxhuehuamwyx57` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_roles`
--

LOCK TABLES `cliente_roles` WRITE;
/*!40000 ALTER TABLE `cliente_roles` DISABLE KEYS */;
INSERT INTO `cliente_roles` VALUES (11,'ROLE_USER'),(12,'ROLE_USER'),(12,'ROLE_ADMIN'),(13,'ROLE_USER');
/*!40000 ALTER TABLE `cliente_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (14);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opinion`
--

DROP TABLE IF EXISTS `opinion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `opinion` (
  `id` bigint(20) NOT NULL,
  `comentario` varchar(255) DEFAULT NULL,
  `cliente_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjamvlisxs3khi7oukm456i8yg` (`cliente_id`),
  CONSTRAINT `FKjamvlisxs3khi7oukm456i8yg` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opinion`
--

LOCK TABLES `opinion` WRITE;
/*!40000 ALTER TABLE `opinion` DISABLE KEYS */;
/*!40000 ALTER TABLE `opinion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salas`
--

DROP TABLE IF EXISTS `salas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `salas` (
  `id` bigint(20) NOT NULL,
  `aforomax` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salas`
--

LOCK TABLES `salas` WRITE;
/*!40000 ALTER TABLE `salas` DISABLE KEYS */;
INSERT INTO `salas` VALUES (1,2,'Piscina'),(2,40,'Gym'),(3,50,'Zumba');
/*!40000 ALTER TABLE `salas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salas_clases`
--

DROP TABLE IF EXISTS `salas_clases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `salas_clases` (
  `salas_id` bigint(20) NOT NULL,
  `clases_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_ip9s0f6q11yak7mr2alhmk9nj` (`clases_id`),
  KEY `FK4y86mg4v7clk4e34ahnd2xppr` (`salas_id`),
  CONSTRAINT `FK4y86mg4v7clk4e34ahnd2xppr` FOREIGN KEY (`salas_id`) REFERENCES `salas` (`id`),
  CONSTRAINT `FKsdwne3wae8m4hxvh04f97c5wb` FOREIGN KEY (`clases_id`) REFERENCES `clases` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salas_clases`
--

LOCK TABLES `salas_clases` WRITE;
/*!40000 ALTER TABLE `salas_clases` DISABLE KEYS */;
/*!40000 ALTER TABLE `salas_clases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarifa`
--

DROP TABLE IF EXISTS `tarifa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tarifa` (
  `id` bigint(20) NOT NULL,
  `edad` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarifa`
--

LOCK TABLES `tarifa` WRITE;
/*!40000 ALTER TABLE `tarifa` DISABLE KEYS */;
INSERT INTO `tarifa` VALUES (8,64,15),(9,24,10),(10,65,5);
/*!40000 ALTER TABLE `tarifa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarifa_clientes`
--

DROP TABLE IF EXISTS `tarifa_clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tarifa_clientes` (
  `tarifa_id` bigint(20) NOT NULL,
  `clientes_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_ppip18wk5p7syu2xx2ejkuqgq` (`clientes_id`),
  KEY `FKk5tsmmx6mej553ee0awwnsi0w` (`tarifa_id`),
  CONSTRAINT `FK1s4xkqj7h64ntgld19535dg9e` FOREIGN KEY (`clientes_id`) REFERENCES `cliente` (`id`),
  CONSTRAINT `FKk5tsmmx6mej553ee0awwnsi0w` FOREIGN KEY (`tarifa_id`) REFERENCES `tarifa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarifa_clientes`
--

LOCK TABLES `tarifa_clientes` WRITE;
/*!40000 ALTER TABLE `tarifa_clientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `tarifa_clientes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-02 12:50:39
