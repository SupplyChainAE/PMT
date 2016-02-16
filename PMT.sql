-- Adminer 4.1.0 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

CREATE TABLE `Request_History` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment` varchar(200) DEFAULT NULL,
  `created` datetime NOT NULL,
  `requestid` bigint(20) NOT NULL,
  `requeststatus` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `Seller_Request` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` date NOT NULL,
  `updated` date NOT NULL,
  `SellerCode` varchar(100) NOT NULL,
  `comment` varchar(200) DEFAULT NULL,
  `para1` int(11) DEFAULT NULL,
  `para2` int(11) DEFAULT NULL,
  `para3` int(11) DEFAULT NULL,
  `para4` int(11) DEFAULT NULL,
  `para5` int(11) DEFAULT NULL,
  `para6` int(11) DEFAULT NULL,
  `para7` int(11) DEFAULT NULL,
  `para8` int(11) DEFAULT NULL,
  `requeststatus` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- 2014-08-12 10:12:15
