/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 8.0.18 : Database - bd_ea
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bd_ea` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `bd_ea`;

/*Table structure for table `empleados` */

DROP TABLE IF EXISTS `empleados`;

CREATE TABLE `empleados` (
  `id_comision` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `nombre_trabajador` varchar(50) DEFAULT NULL,
  `nombre_cliente` varchar(50) DEFAULT NULL,
  `tiempo_trabajado` int(11) DEFAULT NULL,
  `comision_obtenida` int(11) DEFAULT NULL,
  `descuentos_realizados` int(11) DEFAULT NULL,
  `sueldototal` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_comision`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `empleados` */

insert  into `empleados`(`id_comision`,`fecha`,`nombre_trabajador`,`nombre_cliente`,`tiempo_trabajado`,`comision_obtenida`,`descuentos_realizados`,`sueldototal`) values 
(1,'2021-10-31','Andrea','Jesus',4,0,100,400),
(2,'2021-10-31','Carlos','Ivan',6,0,50,450),
(3,'2021-10-31','Mari','Sol',5,200,0,700),
(4,'2021-10-31','Andres','Juan',8,0,150,350),
(5,'2021-10-31','Perla','Ashley',6,0,50,450),
(6,'2021-10-31','Alberto','Eli',2,0,300,200),
(7,'2021-10-31','Luis','Enrique',3,0,200,300),
(8,'2021-10-31','Elias','Arisbeth',3,0,200,300),
(9,'2021-10-31','Jorge','Tania',2,0,300,200);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
