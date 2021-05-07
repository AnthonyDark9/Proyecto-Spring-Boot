-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gestion_tareas_db
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumnos` (
  `id_alumno` int NOT NULL AUTO_INCREMENT,
  `nombre_alumno` varchar(50) NOT NULL,
  `apellido_paterno` varchar(50) NOT NULL,
  `apellido_materno` varchar(50) NOT NULL,
  `calificacion_alumno` float NOT NULL,
  PRIMARY KEY (`id_alumno`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES (1,'Marco','Vences','Pérez',8.2),(2,'Oscar','Serrano','Pozas',7.8),(3,'Andrea','Salcedo','Rocha',9.3);
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calificaciones`
--

DROP TABLE IF EXISTS `calificaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calificaciones` (
  `id_calificacion` int NOT NULL AUTO_INCREMENT,
  `promedio_alumno` float NOT NULL,
  `id_alumno_two_fk` int NOT NULL,
  PRIMARY KEY (`id_calificacion`),
  KEY `id_alumno_two_fk` (`id_alumno_two_fk`),
  CONSTRAINT `id_alumno_two_fk` FOREIGN KEY (`id_alumno_two_fk`) REFERENCES `alumnos` (`id_alumno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calificaciones`
--

LOCK TABLES `calificaciones` WRITE;
/*!40000 ALTER TABLE `calificaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `calificaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciudad` (
  `id_ciudad` int NOT NULL AUTO_INCREMENT,
  `ciudad` varchar(50) NOT NULL,
  PRIMARY KEY (`id_ciudad`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (1,'CDMX'),(2,'Monterrey'),(3,'CDMX'),(4,'CDMX'),(5,'CDMX');
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `contrasenia` varchar(50) DEFAULT NULL,
  `nombre_cliente` varchar(50) NOT NULL,
  `apellido_paterno_cliente` varchar(50) NOT NULL,
  `apellido_materno_cliente` varchar(50) NOT NULL,
  `numero_folio` varchar(40) NOT NULL,
  `id_empresa_externa_fk` int NOT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `id_empresa_externa_fk` (`id_empresa_externa_fk`),
  CONSTRAINT `id_empresa_externa_fk` FOREIGN KEY (`id_empresa_externa_fk`) REFERENCES `empresa_externa` (`id_empresa_externa`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (2,'CHR123','Catalina123','Catalina','Hernande','Rodriguez','CHR14241',2),(20,'Prueba123','12345','Oscar','Serrano','Pozos','Microsoft',2);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `clientes_externos_vw`
--

DROP TABLE IF EXISTS `clientes_externos_vw`;
/*!50001 DROP VIEW IF EXISTS `clientes_externos_vw`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `clientes_externos_vw` AS SELECT 
 1 AS `nombre_cliente`,
 1 AS `numero_folio`,
 1 AS `nombre_empresa_externa`,
 1 AS `folio_empresa`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `colonia`
--

DROP TABLE IF EXISTS `colonia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `colonia` (
  `id_colonia` int NOT NULL AUTO_INCREMENT,
  `colonia` varchar(60) NOT NULL,
  `id_ciudad` int NOT NULL,
  PRIMARY KEY (`id_colonia`),
  KEY `id_ciudad` (`id_ciudad`),
  CONSTRAINT `id_ciudad` FOREIGN KEY (`id_ciudad`) REFERENCES `ciudad` (`id_ciudad`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colonia`
--

LOCK TABLES `colonia` WRITE;
/*!40000 ALTER TABLE `colonia` DISABLE KEYS */;
INSERT INTO `colonia` VALUES (1,'San josé de los cedros',1),(2,'Obispado',2),(3,'La navidad',1),(4,'Santa fe',1),(5,'Lomas de chapultepec',1);
/*!40000 ALTER TABLE `colonia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conjunto_tarea`
--

DROP TABLE IF EXISTS `conjunto_tarea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conjunto_tarea` (
  `id_conjunto_tarea` int NOT NULL AUTO_INCREMENT,
  `nombre_tarea` varchar(80) NOT NULL,
  `nombre_tarea_pendiente` varchar(80) NOT NULL,
  `duracion_estimada` date NOT NULL,
  `id_tarea_fk` int NOT NULL,
  PRIMARY KEY (`id_conjunto_tarea`),
  KEY `id_tarea_fk` (`id_tarea_fk`),
  CONSTRAINT `id_tarea_fk` FOREIGN KEY (`id_tarea_fk`) REFERENCES `tarea` (`id_tarea`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conjunto_tarea`
--

LOCK TABLES `conjunto_tarea` WRITE;
/*!40000 ALTER TABLE `conjunto_tarea` DISABLE KEYS */;
INSERT INTO `conjunto_tarea` VALUES (1,'Revision libros','Checar libros en mal estado','2020-03-21',1),(2,'Revision documentos','Checar documentos de estudiantes egresados','2020-05-23',3),(3,'Revision redes','Checar antiguedad de los switch','2020-04-12',2),(4,'Revision equipos de computo','Checar que los equipos de compúto esten en buen estado','2020-03-27',4),(5,'Revision aulas','Checar que las aulas esten en buen estado y limpias','2020-04-22',5);
/*!40000 ALTER TABLE `conjunto_tarea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datos_infraestructura_estadisticas`
--

DROP TABLE IF EXISTS `datos_infraestructura_estadisticas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `datos_infraestructura_estadisticas` (
  `idRecurso` int NOT NULL AUTO_INCREMENT,
  `nombreRecurso` varchar(50) NOT NULL,
  `tiempoCompleto` int NOT NULL,
  `tiempoParcial` int NOT NULL,
  `unidadDisponible` int NOT NULL,
  PRIMARY KEY (`idRecurso`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_infraestructura_estadisticas`
--

LOCK TABLES `datos_infraestructura_estadisticas` WRITE;
/*!40000 ALTER TABLE `datos_infraestructura_estadisticas` DISABLE KEYS */;
INSERT INTO `datos_infraestructura_estadisticas` VALUES (1,'Recurso tecnológico',8,2,200),(2,'Recurso humano ',7,3,200),(3,'Recurso tecnológico',8,3,200),(4,'Recurso tecnológico',9,4,200),(5,'Recurso humano',7,5,200);
/*!40000 ALTER TABLE `datos_infraestructura_estadisticas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datos_proyecto_estadisticas`
--

DROP TABLE IF EXISTS `datos_proyecto_estadisticas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `datos_proyecto_estadisticas` (
  `id_proyecto` int NOT NULL AUTO_INCREMENT,
  `nombreProyecto` varchar(60) NOT NULL,
  `tituloRegistroProyecto` varchar(70) NOT NULL,
  `descripcionProyecto` varchar(250) NOT NULL,
  `duracionEstimadaProyecto` date NOT NULL,
  `fechaInicioPrevista` date NOT NULL,
  `fechaFinalizacionEstimada` date NOT NULL,
  `nombrePlantel` varchar(70) NOT NULL,
  `ubicacionPlantel` varchar(70) NOT NULL,
  PRIMARY KEY (`id_proyecto`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_proyecto_estadisticas`
--

LOCK TABLES `datos_proyecto_estadisticas` WRITE;
/*!40000 ALTER TABLE `datos_proyecto_estadisticas` DISABLE KEYS */;
INSERT INTO `datos_proyecto_estadisticas` VALUES (1,'Proyecto Inversion','PI','Se invertirá en sistemas de compúto de última generación ','2020-12-05','2020-09-20','2020-12-05','Ibero','CDMX'),(2,'Proyecto de supervisión','PS','Se supervisarán todas las instalaciones de la universidad','2021-01-02','2020-08-12','2021-01-02','IPN','CDMX'),(3,'Proyecto de becarios','PB','Se les dará una beca a los alumnos con mejor calificación','2020-06-03','2020-06-03','2020-06-03','UANL','Monterrey'),(4,'Proyecto de egresados','PE','Se les dará varias propuestas de empleo a los egresados','2020-04-09','2019-04-09','2019-09-12','UAM','CDMX'),(5,'Proyecto de Brightspace','PBS','Se les brindará una plataforma a los estudiantes para una educación óptima','2019-05-29','2018-01-15','2019-05-29','UNAM','CDMX');
/*!40000 ALTER TABLE `datos_proyecto_estadisticas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datos_tarea_estadisticas`
--

DROP TABLE IF EXISTS `datos_tarea_estadisticas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `datos_tarea_estadisticas` (
  `idTarea` int NOT NULL AUTO_INCREMENT,
  `nombreTarea` varchar(60) NOT NULL,
  `nombreTareaPendiente` varchar(70) NOT NULL,
  `duracionEstimada` date NOT NULL,
  `duracionEstimadaTotal` date NOT NULL,
  PRIMARY KEY (`idTarea`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_tarea_estadisticas`
--

LOCK TABLES `datos_tarea_estadisticas` WRITE;
/*!40000 ALTER TABLE `datos_tarea_estadisticas` DISABLE KEYS */;
INSERT INTO `datos_tarea_estadisticas` VALUES (1,'Revisión libros','Checar libros en mal estado','2020-03-21','2020-03-21'),(2,'Revisión documentos ','Checar documentos de estudiantes egresados','2020-05-23','2020-04-12'),(3,'Revisión redes','Checar antiguedad de los switch','2020-04-02','2020-05-23'),(4,'Revisión de equipos de comúto','Checar que los equipos de comúto esten en buen estado','2020-03-27','2020-03-27'),(5,'Revisión aulas','Checar que las aulas estén en buen estado y limpias','2020-04-22','2020-04-22');
/*!40000 ALTER TABLE `datos_tarea_estadisticas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamento` (
  `id_departamento` int NOT NULL AUTO_INCREMENT,
  `nombre_departamento` varchar(50) NOT NULL,
  `id_universidad_three_fk` int NOT NULL,
  PRIMARY KEY (`id_departamento`),
  KEY `id_universidad_three_fk` (`id_universidad_three_fk`),
  CONSTRAINT `id_universidad_three_fk` FOREIGN KEY (`id_universidad_three_fk`) REFERENCES `universidad` (`id_universidad`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'Finanzas',2),(2,'Contabilidad',3),(3,'Control de gestión',4),(8,'Recursos Humanos',1);
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direccion`
--

DROP TABLE IF EXISTS `direccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `direccion` (
  `id_direccion` int NOT NULL AUTO_INCREMENT,
  `calle` varchar(100) NOT NULL,
  `numero` int NOT NULL,
  `id_codigo_postal_fk` int NOT NULL,
  `id_ciudad_fk` int NOT NULL,
  PRIMARY KEY (`id_direccion`),
  KEY `id_codigo_postal_fk` (`id_codigo_postal_fk`),
  KEY `id_ciudad_fk` (`id_ciudad_fk`),
  CONSTRAINT `id_ciudad_fk` FOREIGN KEY (`id_ciudad_fk`) REFERENCES `ciudad` (`id_ciudad`),
  CONSTRAINT `id_codigo_postal_fk` FOREIGN KEY (`id_codigo_postal_fk`) REFERENCES `colonia` (`id_colonia`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direccion`
--

LOCK TABLES `direccion` WRITE;
/*!40000 ALTER TABLE `direccion` DISABLE KEYS */;
INSERT INTO `direccion` VALUES (1,'Nogal',14,1,1),(2,'Piñón',10,2,1),(3,'Granaderos',31,1,1),(4,'Jose maria morelos y pavón',102,2,2),(5,'Navidad',12,1,1);
/*!40000 ALTER TABLE `direccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direccion_administrativa`
--

DROP TABLE IF EXISTS `direccion_administrativa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `direccion_administrativa` (
  `id_unidad` int NOT NULL AUTO_INCREMENT,
  `nombre_unidad` varchar(50) NOT NULL,
  `id_universidad_two_fk` int NOT NULL,
  PRIMARY KEY (`id_unidad`),
  KEY `id_universidad_two_fk` (`id_universidad_two_fk`),
  CONSTRAINT `id_universidad_two_fk` FOREIGN KEY (`id_universidad_two_fk`) REFERENCES `universidad` (`id_universidad`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direccion_administrativa`
--

LOCK TABLES `direccion_administrativa` WRITE;
/*!40000 ALTER TABLE `direccion_administrativa` DISABLE KEYS */;
INSERT INTO `direccion_administrativa` VALUES (1,'Unidad administrativa',3),(2,'Unidad directiva',1),(3,'Unidad central',5),(4,'Unidad norte',2),(5,'Unidad administrativa',4);
/*!40000 ALTER TABLE `direccion_administrativa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `direccion_miembros_vw`
--

DROP TABLE IF EXISTS `direccion_miembros_vw`;
/*!50001 DROP VIEW IF EXISTS `direccion_miembros_vw`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `direccion_miembros_vw` AS SELECT 
 1 AS `nombre_miembro`,
 1 AS `apellido_paterno`,
 1 AS `apellido_materno`,
 1 AS `edad_miembro`,
 1 AS `calle`,
 1 AS `colonia`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `empleado_administrativo`
--

DROP TABLE IF EXISTS `empleado_administrativo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado_administrativo` (
  `id_empleado_administrativo` int NOT NULL AUTO_INCREMENT,
  `nivel_administrativo` int NOT NULL,
  `id_miembro_five_fk` int NOT NULL,
  PRIMARY KEY (`id_empleado_administrativo`),
  KEY `id_miembro_five_fk` (`id_miembro_five_fk`),
  CONSTRAINT `id_miembro_five_fk` FOREIGN KEY (`id_miembro_five_fk`) REFERENCES `miembro` (`id_miembro`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado_administrativo`
--

LOCK TABLES `empleado_administrativo` WRITE;
/*!40000 ALTER TABLE `empleado_administrativo` DISABLE KEYS */;
INSERT INTO `empleado_administrativo` VALUES (1,2,2),(2,3,1),(3,1,4),(4,2,5),(5,1,3);
/*!40000 ALTER TABLE `empleado_administrativo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado_direccion`
--

DROP TABLE IF EXISTS `empleado_direccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado_direccion` (
  `id_empleado_direccion` int NOT NULL AUTO_INCREMENT,
  `puesto_empleado_direccion` varchar(50) NOT NULL,
  `id_miembro_four_fk` int NOT NULL,
  PRIMARY KEY (`id_empleado_direccion`),
  KEY `id_miembro_four_fk` (`id_miembro_four_fk`),
  CONSTRAINT `id_miembro_four_fk` FOREIGN KEY (`id_miembro_four_fk`) REFERENCES `miembro` (`id_miembro`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado_direccion`
--

LOCK TABLES `empleado_direccion` WRITE;
/*!40000 ALTER TABLE `empleado_direccion` DISABLE KEYS */;
INSERT INTO `empleado_direccion` VALUES (1,'Directivo',5),(2,'Supervisión',3),(3,'Inspección',1),(4,'Fiscalización',2),(5,'Vigilancia',4);
/*!40000 ALTER TABLE `empleado_direccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado_empresa_externa`
--

DROP TABLE IF EXISTS `empleado_empresa_externa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado_empresa_externa` (
  `id_empleado_empresa_externa` int NOT NULL AUTO_INCREMENT,
  `puesto_empleado_empresa_externa` varchar(50) NOT NULL,
  `categoria_empleado` varchar(50) NOT NULL,
  `id_empresa_externa_two_fk` int NOT NULL,
  PRIMARY KEY (`id_empleado_empresa_externa`),
  KEY `id_empresa_externa_two_fk` (`id_empresa_externa_two_fk`),
  CONSTRAINT `id_empresa_externa_two_fk` FOREIGN KEY (`id_empresa_externa_two_fk`) REFERENCES `empresa_externa` (`id_empresa_externa`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado_empresa_externa`
--

LOCK TABLES `empleado_empresa_externa` WRITE;
/*!40000 ALTER TABLE `empleado_empresa_externa` DISABLE KEYS */;
INSERT INTO `empleado_empresa_externa` VALUES (1,'Gerente','A',1),(2,'Finanzas','D',3),(3,'Administración','C',4),(4,'Recursos humanos','B',2),(5,'Marketing','E',5);
/*!40000 ALTER TABLE `empleado_empresa_externa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado_profesor`
--

DROP TABLE IF EXISTS `empleado_profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado_profesor` (
  `id_empleado_profesor` int NOT NULL AUTO_INCREMENT,
  `dedicacion` int NOT NULL,
  `id_miembro_three_fk` int NOT NULL,
  PRIMARY KEY (`id_empleado_profesor`),
  KEY `id_miembro_three_fk` (`id_miembro_three_fk`),
  CONSTRAINT `id_miembro_three_fk` FOREIGN KEY (`id_miembro_three_fk`) REFERENCES `miembro` (`id_miembro`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado_profesor`
--

LOCK TABLES `empleado_profesor` WRITE;
/*!40000 ALTER TABLE `empleado_profesor` DISABLE KEYS */;
INSERT INTO `empleado_profesor` VALUES (1,3,3),(2,1,5),(3,2,1),(4,4,2),(5,1,4);
/*!40000 ALTER TABLE `empleado_profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado_tecnico`
--

DROP TABLE IF EXISTS `empleado_tecnico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado_tecnico` (
  `id_empleado_tecnico` int NOT NULL AUTO_INCREMENT,
  `nivel_tecnico` int NOT NULL,
  `id_miembro_two_fk` int NOT NULL,
  PRIMARY KEY (`id_empleado_tecnico`),
  KEY `id_miembro_two_fk` (`id_miembro_two_fk`),
  CONSTRAINT `id_miembro_two_fk` FOREIGN KEY (`id_miembro_two_fk`) REFERENCES `miembro` (`id_miembro`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado_tecnico`
--

LOCK TABLES `empleado_tecnico` WRITE;
/*!40000 ALTER TABLE `empleado_tecnico` DISABLE KEYS */;
INSERT INTO `empleado_tecnico` VALUES (1,3,2),(2,4,4),(3,1,1),(4,2,5),(5,3,3);
/*!40000 ALTER TABLE `empleado_tecnico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa_externa`
--

DROP TABLE IF EXISTS `empresa_externa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresa_externa` (
  `id_empresa_externa` int NOT NULL AUTO_INCREMENT,
  `nombre_empresa_externa` varchar(50) NOT NULL,
  `folio_empresa` varchar(60) NOT NULL,
  PRIMARY KEY (`id_empresa_externa`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa_externa`
--

LOCK TABLES `empresa_externa` WRITE;
/*!40000 ALTER TABLE `empresa_externa` DISABLE KEYS */;
INSERT INTO `empresa_externa` VALUES (1,'IBM','IB212342'),(2,'Microsoft','MIC1321'),(3,'Oracle','OR23454'),(4,'Dell','DE41242'),(5,'Apple','AP21341');
/*!40000 ALTER TABLE `empresa_externa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `informacion_recurso`
--

DROP TABLE IF EXISTS `informacion_recurso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `informacion_recurso` (
  `id_informacion_recurso` int NOT NULL AUTO_INCREMENT,
  `id_recurso_fk` int NOT NULL,
  PRIMARY KEY (`id_informacion_recurso`),
  KEY `id_recurso_fk` (`id_recurso_fk`),
  CONSTRAINT `id_recurso_fk` FOREIGN KEY (`id_recurso_fk`) REFERENCES `recurso` (`id_recurso`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `informacion_recurso`
--

LOCK TABLES `informacion_recurso` WRITE;
/*!40000 ALTER TABLE `informacion_recurso` DISABLE KEYS */;
INSERT INTO `informacion_recurso` VALUES (3,1),(4,2),(1,3),(2,4),(5,5);
/*!40000 ALTER TABLE `informacion_recurso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `infraestructura`
--

DROP TABLE IF EXISTS `infraestructura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `infraestructura` (
  `id_infraestructura` int NOT NULL AUTO_INCREMENT,
  `unidad_disponible` int NOT NULL,
  `id_informacion_recurso_two_fk` int NOT NULL,
  PRIMARY KEY (`id_infraestructura`),
  KEY `id_informacion_recurso_two_fk` (`id_informacion_recurso_two_fk`),
  CONSTRAINT `id_informacion_recurso_two_fk` FOREIGN KEY (`id_informacion_recurso_two_fk`) REFERENCES `informacion_recurso` (`id_informacion_recurso`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `infraestructura`
--

LOCK TABLES `infraestructura` WRITE;
/*!40000 ALTER TABLE `infraestructura` DISABLE KEYS */;
INSERT INTO `infraestructura` VALUES (1,200,1),(2,100,2),(3,200,3),(4,100,4),(5,200,5);
/*!40000 ALTER TABLE `infraestructura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jefe_proyecto`
--

DROP TABLE IF EXISTS `jefe_proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jefe_proyecto` (
  `id_jefe_proyecto` int NOT NULL AUTO_INCREMENT,
  `id_miembro_fk` int NOT NULL,
  PRIMARY KEY (`id_jefe_proyecto`),
  KEY `id_miembro_fk` (`id_miembro_fk`),
  CONSTRAINT `id_miembro_fk` FOREIGN KEY (`id_miembro_fk`) REFERENCES `miembro` (`id_miembro`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jefe_proyecto`
--

LOCK TABLES `jefe_proyecto` WRITE;
/*!40000 ALTER TABLE `jefe_proyecto` DISABLE KEYS */;
INSERT INTO `jefe_proyecto` VALUES (3,1),(1,2),(5,3),(4,4),(2,5);
/*!40000 ALTER TABLE `jefe_proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materias`
--

DROP TABLE IF EXISTS `materias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materias` (
  `id_materia` int NOT NULL AUTO_INCREMENT,
  `matematicas_A` varchar(50) NOT NULL,
  `español_A` varchar(60) NOT NULL,
  `historia_A` varchar(60) NOT NULL,
  `id_alumno_fk` int NOT NULL,
  PRIMARY KEY (`id_materia`),
  KEY `id_alumno_fk` (`id_alumno_fk`),
  CONSTRAINT `id_alumno_fk` FOREIGN KEY (`id_alumno_fk`) REFERENCES `alumnos` (`id_alumno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materias`
--

LOCK TABLES `materias` WRITE;
/*!40000 ALTER TABLE `materias` DISABLE KEYS */;
/*!40000 ALTER TABLE `materias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `miembro`
--

DROP TABLE IF EXISTS `miembro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `miembro` (
  `id_miembro` int NOT NULL AUTO_INCREMENT,
  `nombre_miembro` varchar(50) NOT NULL,
  `apellido_paterno` varchar(50) DEFAULT NULL,
  `apellido_materno` varchar(50) DEFAULT NULL,
  `peso_miembro` int NOT NULL,
  `edad_miembro` int NOT NULL,
  `correo_miembro` varchar(50) DEFAULT NULL,
  `contrasenia` varchar(50) DEFAULT NULL,
  `authority` varchar(50) NOT NULL,
  `telefono_miembro` int NOT NULL,
  `id_direccion_fk` int NOT NULL,
  `id_universidad_fk` int NOT NULL,
  PRIMARY KEY (`id_miembro`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `miembro`
--

LOCK TABLES `miembro` WRITE;
/*!40000 ALTER TABLE `miembro` DISABLE KEYS */;
INSERT INTO `miembro` VALUES (1,'Marco Antonio','Vences','loco',72,20,'marcovences@gmail.com','45484','sdad',551235523,1,2),(2,'Andrea','Salcedo','Rocha',66,20,'asalcedo@gmail.com','prueba12345','adad',554125662,1,3),(3,'Oscar','Serrano','Pozas',68,23,'fake3@gmail.com','O123','fafaf',552353521,5,1),(4,'Fernanda','Villanueva','Gonzaléz',57,20,'fake6@gmail.com','root','gfdg',557327778,3,5),(5,'Javier','Soria','Villalpando',77,21,'fake5@gmail.com','1515','fdg',552352124,4,4);
/*!40000 ALTER TABLE `miembro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `miembros_jefes_proyecto_vw`
--

DROP TABLE IF EXISTS `miembros_jefes_proyecto_vw`;
/*!50001 DROP VIEW IF EXISTS `miembros_jefes_proyecto_vw`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `miembros_jefes_proyecto_vw` AS SELECT 
 1 AS `nombre_miembro`,
 1 AS `apellido_paterno`,
 1 AS `apellido_materno`,
 1 AS `edad_miembro`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `personal_empresa_externa`
--

DROP TABLE IF EXISTS `personal_empresa_externa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personal_empresa_externa` (
  `id_personal_empresa_externa` int NOT NULL AUTO_INCREMENT,
  `puesto_personal` varchar(50) NOT NULL,
  `categoria_personal` varchar(50) NOT NULL,
  `id_empresa_externa_three_fk` int NOT NULL,
  PRIMARY KEY (`id_personal_empresa_externa`),
  KEY `id_empresa_externa_three_fk` (`id_empresa_externa_three_fk`),
  CONSTRAINT `id_empresa_externa_three_fk` FOREIGN KEY (`id_empresa_externa_three_fk`) REFERENCES `empresa_externa` (`id_empresa_externa`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal_empresa_externa`
--

LOCK TABLES `personal_empresa_externa` WRITE;
/*!40000 ALTER TABLE `personal_empresa_externa` DISABLE KEYS */;
INSERT INTO `personal_empresa_externa` VALUES (1,'Jefe de taller','A',2),(2,'Encargado sucursal','C',5),(3,'Gerente','E',1),(4,'Contabilidad','D',3),(5,'Mercadotecnía','B',4),(10,'Gerente','A',4);
/*!40000 ALTER TABLE `personal_empresa_externa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyecto` (
  `id_proyecto` int NOT NULL AUTO_INCREMENT,
  `nombre_proyecto` varchar(60) NOT NULL,
  `duracion_estimada_proyecto` date NOT NULL,
  `fecha_inicio_prevista` date NOT NULL,
  `id_registro_proyecto_fk` int NOT NULL,
  PRIMARY KEY (`id_proyecto`),
  KEY `id_registro_proyecto_fk` (`id_registro_proyecto_fk`),
  CONSTRAINT `id_registro_proyecto_fk` FOREIGN KEY (`id_registro_proyecto_fk`) REFERENCES `registro_proyecto` (`id_registro_proyecto`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto`
--

LOCK TABLES `proyecto` WRITE;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
INSERT INTO `proyecto` VALUES (1,'Prueba1','2021-02-27','2020-09-20',1),(2,'Proyecto de supervisión','2021-01-02','2020-08-12',2),(3,'Proyecto de becarios','2020-06-03','2020-06-03',3),(4,'Proyecto de egresados','2020-04-09','2019-09-12',4),(5,'Proyecto Brightspace','2019-05-29','2018-01-15',5);
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `proyectos_registrados_vw`
--

DROP TABLE IF EXISTS `proyectos_registrados_vw`;
/*!50001 DROP VIEW IF EXISTS `proyectos_registrados_vw`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `proyectos_registrados_vw` AS SELECT 
 1 AS `titulo_registro_proyecto`,
 1 AS `descripcion_registro_proyecto`,
 1 AS `nombre_proyecto`,
 1 AS `duracion_estimada`,
 1 AS `fecha_inicio_prevista`,
 1 AS `fecha_finalizacion_estimada`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `recurso`
--

DROP TABLE IF EXISTS `recurso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recurso` (
  `id_recurso` int NOT NULL AUTO_INCREMENT,
  `nombre_recurso` varchar(50) NOT NULL,
  `tiempo_completo` int NOT NULL,
  `tiempo_parcial` int NOT NULL,
  PRIMARY KEY (`id_recurso`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recurso`
--

LOCK TABLES `recurso` WRITE;
/*!40000 ALTER TABLE `recurso` DISABLE KEYS */;
INSERT INTO `recurso` VALUES (1,'Recurso tecnologico',8,2),(2,'Recurso humano',7,3),(3,'Recurso tecnologico',8,3),(4,'Recurso tecnologico ',9,4),(5,'Recurso humano',7,5);
/*!40000 ALTER TABLE `recurso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recurso_humano`
--

DROP TABLE IF EXISTS `recurso_humano`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recurso_humano` (
  `id_recurso_humano` int NOT NULL AUTO_INCREMENT,
  `unidad_disponible` varchar(10) NOT NULL,
  `numero_unidad_disponible` int NOT NULL,
  `id_informacion_recurso_fk` int NOT NULL,
  PRIMARY KEY (`id_recurso_humano`),
  KEY `id_informacion_recurso_fk` (`id_informacion_recurso_fk`),
  CONSTRAINT `id_informacion_recurso_fk` FOREIGN KEY (`id_informacion_recurso_fk`) REFERENCES `informacion_recurso` (`id_informacion_recurso`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recurso_humano`
--

LOCK TABLES `recurso_humano` WRITE;
/*!40000 ALTER TABLE `recurso_humano` DISABLE KEYS */;
INSERT INTO `recurso_humano` VALUES (1,'200%',2,1),(2,'100%',1,2),(3,'100%',1,3),(4,'200%',2,4),(5,'200%',2,5);
/*!40000 ALTER TABLE `recurso_humano` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro_proyecto`
--

DROP TABLE IF EXISTS `registro_proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registro_proyecto` (
  `id_registro_proyecto` int NOT NULL AUTO_INCREMENT,
  `titulo_registro_proyecto` varchar(50) NOT NULL,
  `descripcion_registro_proyecto` varchar(250) NOT NULL,
  `historial_version` date NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_finalizacion_estimada` date NOT NULL,
  `id_universidad_fk` int NOT NULL,
  PRIMARY KEY (`id_registro_proyecto`),
  KEY `id_universidad_fk` (`id_universidad_fk`),
  CONSTRAINT `id_universidad_fk` FOREIGN KEY (`id_universidad_fk`) REFERENCES `universidad` (`id_universidad`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_proyecto`
--

LOCK TABLES `registro_proyecto` WRITE;
/*!40000 ALTER TABLE `registro_proyecto` DISABLE KEYS */;
INSERT INTO `registro_proyecto` VALUES (1,'PI','Se invertira en sistemas de compúto de ultima genercación','2020-10-24','2020-09-20','2020-12-05',1),(2,'PS','Se supervisaran todas las instalaciones de la universidad','2020-10-22','2020-08-12','2021-01-02',4),(3,'PB','Se les dará una beca a los alumnos con mejor calificacioón de la institiución','2020-03-04','2020-01-03','2020-06-03',5),(4,'PE','Se les dará varias propuestas de empleo a los egresados','2020-01-03','2019-09-12','2020-04-09',2),(5,'PBS','Se les brindará una plataforma a los estudiantes para una educación más óptima y eficaz','2018-04-03','2018-01-15','2019-05-29',3),(7,'Proyecto TSU','Se creará una nueva TSU a partir del índice de crecimiento en el número de estudiantes','2022-01-04','2022-04-12','2022-03-02',3);
/*!40000 ALTER TABLE `registro_proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responsable`
--

DROP TABLE IF EXISTS `responsable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `responsable` (
  `id_responsable` int NOT NULL AUTO_INCREMENT,
  `id_personal_empresa_externa_fk` int NOT NULL,
  `id_empresa_externa_four_fk` int NOT NULL,
  PRIMARY KEY (`id_responsable`),
  KEY `id_personal_empresa_externa_fk` (`id_personal_empresa_externa_fk`),
  KEY `id_empresa_externa_four_fk` (`id_empresa_externa_four_fk`),
  CONSTRAINT `id_empresa_externa_four_fk` FOREIGN KEY (`id_empresa_externa_four_fk`) REFERENCES `empresa_externa` (`id_empresa_externa`),
  CONSTRAINT `id_personal_empresa_externa_fk` FOREIGN KEY (`id_personal_empresa_externa_fk`) REFERENCES `personal_empresa_externa` (`id_personal_empresa_externa`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responsable`
--

LOCK TABLES `responsable` WRITE;
/*!40000 ALTER TABLE `responsable` DISABLE KEYS */;
INSERT INTO `responsable` VALUES (1,2,1),(2,3,5),(3,1,1),(4,4,2),(5,5,3);
/*!40000 ALTER TABLE `responsable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `id_rol` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `id_usuario_fk` int NOT NULL,
  PRIMARY KEY (`id_rol`),
  KEY `id_usuario_fk` (`id_usuario_fk`),
  CONSTRAINT `id_usuario_fk` FOREIGN KEY (`id_usuario_fk`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'ROLE_ADMIN',1),(2,'ROLE_USER',1),(3,'ROLE_ADMIN',3),(4,'ROLE_USER',4),(5,'ROLE_USER',5),(6,'ROLE_USER',6),(7,'ROLE_USER',7);
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarea`
--

DROP TABLE IF EXISTS `tarea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tarea` (
  `id_tarea` int NOT NULL AUTO_INCREMENT,
  `nombre_tarea` varchar(40) NOT NULL,
  `duracion_estimada_total` date NOT NULL,
  `id_proyecto_fk` int NOT NULL,
  PRIMARY KEY (`id_tarea`),
  KEY `id_proyecto_fk` (`id_proyecto_fk`),
  CONSTRAINT `id_proyecto_fk` FOREIGN KEY (`id_proyecto_fk`) REFERENCES `proyecto` (`id_proyecto`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarea`
--

LOCK TABLES `tarea` WRITE;
/*!40000 ALTER TABLE `tarea` DISABLE KEYS */;
INSERT INTO `tarea` VALUES (1,'Revisión libros para la biblioteca','2020-03-21',1),(2,'Revisión documentos de recién ingresados','2020-05-23',3),(3,'Revisión redes','2020-04-12',2),(4,'Revisión equipos de compúto','2020-03-27',4),(5,'Revisión aulas','2020-04-22',5);
/*!40000 ALTER TABLE `tarea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `universidad`
--

DROP TABLE IF EXISTS `universidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `universidad` (
  `id_universidad` int NOT NULL AUTO_INCREMENT,
  `nombre_plantel` varchar(50) NOT NULL,
  `ubicacion_plantel` varchar(50) NOT NULL,
  PRIMARY KEY (`id_universidad`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `universidad`
--

LOCK TABLES `universidad` WRITE;
/*!40000 ALTER TABLE `universidad` DISABLE KEYS */;
INSERT INTO `universidad` VALUES (1,'Ibero','CDMX'),(2,'UAM','CDMX'),(3,'UNAM','CDMX'),(4,'IPN','CDMX'),(5,'UANL','Monterrey');
/*!40000 ALTER TABLE `universidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `universidad_miembro_vw`
--

DROP TABLE IF EXISTS `universidad_miembro_vw`;
/*!50001 DROP VIEW IF EXISTS `universidad_miembro_vw`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `universidad_miembro_vw` AS SELECT 
 1 AS `nombre_miembro`,
 1 AS `apellido_paterno`,
 1 AS `apellido_materno`,
 1 AS `edad_miembro`,
 1 AS `plantel`,
 1 AS `ubicacion_plantel`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `password` varchar(150) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin','$2a$10$oAJbl8OUbFbmBNz9QIltIOTifF400W4rLq0en2sQau28VnVnL08GO'),(2,'user','$2a$10$gN5y5gC.8UVstI5ujJRJAeLhnA6vOqyhmuQEPKLYHP8vpa9YBo55W'),(3,'marcovences9@gmail.com','$2a$04$Ni9wFQfHuQqWQOPhdrShFOAPzp61Z1MKWxM3g/ejMbS0iSKFkdQPe'),(4,'asalcedo@gmail.com','$2a$04$5yPmQAsdcR6yA7iPOB5SMOiMY2AT0dhrSHXzxSHJ8OL5ToYiZWqvy'),(5,'fake3@gmail.com','$2a$04$F66Aj4mT2qemPFEZ70rjj.xjNUg6.0Gbf5iLmtmGQMK6k8iMKsLCa'),(6,'fake6@gmail.com','$2a$04$HD28Un4C.8uy5Nz/iXcyVuD5bEwZwlNGHKqcoEUWf0TWGvhmsgDv2'),(7,'fake5@gmail.com','$2a$04$CUKa/JgjRz36K2.TX9AqpOu7Wj.HNWg0VjzSLx4xeuBpdhnQHWAbu'),(8,'DarkMoon9','$2a$04$wh1BXWFZSw5zKtnfiWpni.ugllmZuCa9RvBOOBTV1uLdxtvodohju');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `clientes_externos_vw`
--

/*!50001 DROP VIEW IF EXISTS `clientes_externos_vw`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `clientes_externos_vw` AS select concat(`t1`.`nombre_cliente`,' ',`t1`.`apellido_paterno_cliente`,' ',`t1`.`apellido_materno_cliente`) AS `nombre_cliente`,`t1`.`numero_folio` AS `numero_folio`,`t2`.`nombre_empresa_externa` AS `nombre_empresa_externa`,`t2`.`folio_empresa` AS `folio_empresa` from (`cliente` `t1` join `empresa_externa` `t2` on((`t1`.`id_empresa_externa_fk` = `t2`.`id_empresa_externa`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `direccion_miembros_vw`
--

/*!50001 DROP VIEW IF EXISTS `direccion_miembros_vw`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `direccion_miembros_vw` AS select `t1`.`nombre_miembro` AS `nombre_miembro`,`t1`.`apellido_paterno` AS `apellido_paterno`,`t1`.`apellido_materno` AS `apellido_materno`,`t1`.`edad_miembro` AS `edad_miembro`,`t2`.`calle` AS `calle`,`t3`.`colonia` AS `colonia` from (((`miembro` `t1` join `direccion` `t2` on((`t1`.`id_direccion_fk` = `t2`.`id_direccion`))) join `colonia` `t3` on((`t2`.`id_codigo_postal_fk` = `t3`.`id_colonia`))) join `ciudad` `t4` on((`t3`.`id_ciudad` = `t4`.`id_ciudad`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `miembros_jefes_proyecto_vw`
--

/*!50001 DROP VIEW IF EXISTS `miembros_jefes_proyecto_vw`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `miembros_jefes_proyecto_vw` AS select `t1`.`nombre_miembro` AS `nombre_miembro`,`t1`.`apellido_paterno` AS `apellido_paterno`,`t1`.`apellido_materno` AS `apellido_materno`,`t1`.`edad_miembro` AS `edad_miembro` from (`miembro` `t1` join `jefe_proyecto` `t2` on((`t1`.`id_miembro` = `t2`.`id_miembro_fk`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `proyectos_registrados_vw`
--

/*!50001 DROP VIEW IF EXISTS `proyectos_registrados_vw`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `proyectos_registrados_vw` AS select `t1`.`titulo_registro_proyecto` AS `titulo_registro_proyecto`,`t1`.`descripcion_registro_proyecto` AS `descripcion_registro_proyecto`,`t2`.`nombre_proyecto` AS `nombre_proyecto`,`t2`.`duracion_estimada_proyecto` AS `duracion_estimada`,`t2`.`fecha_inicio_prevista` AS `fecha_inicio_prevista`,`t1`.`fecha_finalizacion_estimada` AS `fecha_finalizacion_estimada` from (`registro_proyecto` `t1` join `proyecto` `t2` on((`t1`.`id_registro_proyecto` = `t2`.`id_proyecto`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `universidad_miembro_vw`
--

/*!50001 DROP VIEW IF EXISTS `universidad_miembro_vw`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `universidad_miembro_vw` AS select `t1`.`nombre_miembro` AS `nombre_miembro`,`t1`.`apellido_paterno` AS `apellido_paterno`,`t1`.`apellido_materno` AS `apellido_materno`,`t1`.`edad_miembro` AS `edad_miembro`,`t2`.`nombre_plantel` AS `plantel`,`t2`.`ubicacion_plantel` AS `ubicacion_plantel` from (`miembro` `t1` join `universidad` `t2` on((`t1`.`id_universidad_fk` = `t2`.`id_universidad`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-03 13:58:22
