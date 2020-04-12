DROP DATABASE IF EXISTS `scholarship`;
CREATE DATABASE `scholarship`;
USE `scholarship`;

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`
(
    `username` varchar(10)  NOT NULL COMMENT '用户名',
    `password` varchar(255) NOT NULL COMMENT '密码',
    PRIMARY KEY (`username`)
) COMMENT '学生资助中心管理员';

DROP TABLE IF EXISTS `counsellor`;
CREATE TABLE `counsellor`
(
    `staff_id`   char(6)      NOT NULL COMMENT '工号',
    `password`   varchar(255) NOT NULL COMMENT '密码',
    `name`       varchar(10)  NOT NULL COMMENT '姓名',
    `year`       char(4)      NOT NULL COMMENT '年级',
    `department` varchar(20)  NOT NULL COMMENT '学院',
    PRIMARY KEY (`staff_id`)
) COMMENT '辅导员';

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`
(
    `student_id` char(12)     NOT NULL COMMENT '学号',
    `password`   varchar(255) NOT NULL COMMENT '密码',
    `name`       varchar(10)  NOT NULL COMMENT '姓名',
    `specialty`  varchar(20)  NOT NULL COMMENT '专业',
    `m_class`    varchar(20)  NOT NULL COMMENT '班级',
    `staff_id`   char(6)      NOT NULL COMMENT '辅导员工号',
    PRIMARY KEY (`student_id`),
    CONSTRAINT FOREIGN KEY (`staff_id`) REFERENCES `counsellor` (`staff_id`)
) COMMENT '学生';