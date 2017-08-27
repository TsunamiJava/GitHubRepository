/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.5.11 : Database - test_demo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test_demo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test_demo`;

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `stu_name` varchar(25) DEFAULT NULL COMMENT '学生姓名',
  `stu_age` int(11) DEFAULT NULL COMMENT '学生年龄',
  `stu_sex` int(2) DEFAULT NULL COMMENT '学生性别',
  `stu_num` varchar(25) DEFAULT NULL COMMENT '学生学号',
  `stu_class` varchar(50) DEFAULT NULL COMMENT '学生班级',
  `stu_createtime` date DEFAULT NULL COMMENT '创建时间',
  `stu_updatetime` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
