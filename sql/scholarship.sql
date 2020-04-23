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

DROP TABLE IF EXISTS `unit`;
CREATE TABLE `unit`
(
    `id`   int         NOT NULL AUTO_INCREMENT COMMENT 'id',
    `pid`  int COMMENT '父级单位id',
    `name` varchar(20) NOT NULL COMMENT '单位名称',
    PRIMARY KEY (`id`),
    CONSTRAINT FOREIGN KEY (`pid`) REFERENCES `unit` (`id`)
) COMMENT '组织单位';

DROP TABLE IF EXISTS `counsellor`;
CREATE TABLE `counsellor`
(
    `staff_id` char(6)      NOT NULL COMMENT '工号',
    `password` varchar(255) NOT NULL COMMENT '密码',
    `name`     varchar(10)  NOT NULL COMMENT '姓名',
    `unit_id`  int          NOT NULL COMMENT '所属单位',
    PRIMARY KEY (`staff_id`),
    CONSTRAINT FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`)
) COMMENT '辅导员';

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`
(
    `student_id` char(12)     NOT NULL COMMENT '学号',
    `name`       varchar(10)  NOT NULL COMMENT '姓名',
    `sex`        char(1)      NOT NULL COMMENT '性别',
    `unit_id`    int          NOT NULL COMMENT '所属单位',
    `password`   varchar(255) NOT NULL COMMENT '密码',
    PRIMARY KEY (`student_id`),
    CONSTRAINT FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`)
) COMMENT '学生';

DROP TABLE IF EXISTS `scholarship`;
CREATE TABLE `scholarship`
(
    `id`          int          NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`        varchar(10)  NOT NULL COMMENT '奖学金名称',
    `description` varchar(255)  NOT NULL COMMENT '奖学金介绍',
    `requirement` varchar(255) NOT NULL COMMENT '申请要求',
    `year`        char(9)      NOT NULL COMMENT '学年',
    PRIMARY KEY (`id`)
) COMMENT '奖学金';

DROP TABLE IF EXISTS `distribution`;
CREATE TABLE `distribution`
(
    `unit_id`        int NOT NULL COMMENT '单位id',
    `scholarship_id` int NOT NULL COMMENT '奖学金id',
    `num`            int NOT NULL COMMENT '分配名额',
    PRIMARY KEY (`unit_id`, `scholarship_id`),
    CONSTRAINT FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`),
    CONSTRAINT FOREIGN KEY (`scholarship_id`) REFERENCES `scholarship` (`id`)
) COMMENT '名额分配';

DROP TABLE IF EXISTS `application`;
CREATE TABLE `application`
(
    `student_id`     char(12)  NOT NULL COMMENT '学号',
    `scholarship_id` int       NOT NULL COMMENT '奖学金id',
    `level`          char(3) COMMENT '奖学金等级',
    `state`          tinyint   NOT NULL DEFAULT '0' COMMENT '申请状态',
    `create_time`    timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '申请时间',
    PRIMARY KEY (`student_id`, `scholarship_id`),
    CONSTRAINT FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
    CONSTRAINT FOREIGN KEY (`scholarship_id`) REFERENCES `scholarship` (`id`)
) COMMENT '申请';

DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`
(
    `student_id` char(12) NOT NULL COMMENT '学号',
    `year`       char(9)  NOT NULL COMMENT '学年',
    `score`      float    COMMENT '考试分',
    `quality`    float    COMMENT '素质分',
    `fail`       boolean DEFAULT '0' COMMENT '挂科标记',
    PRIMARY KEY (`student_id`, `year`),
    CONSTRAINT FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`)
) COMMENT '成绩平均分';


