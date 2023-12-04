create database school;
use school;
create table stu(id int,name varchar(20));

insert into stu(id,name) values (1,'prabal'),(9,'kuinkel');

select * from stu;

create table login(user_name varchar(20),password varchar(20));

insert into login (user_name,password) values ('prabal','kuinkel');
 insert into login (user_name,password) values ('hello','world');
 
Delete from school.login where user_name ='hello';
DELETE FROM login ;
select * from login;

select * from stu;
insert into stu(id,name) values (1,'aaaaaa');

#to create table for user login and signup

create table userlogin(username varchar(20),password varchar(20)) ;
select * from userlogin;
-------------------------------------------------------------------------------------------------------------------------------------------------------


-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 29, 2022 at 01:41 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
 create Database votingsystem;
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_login`
--
use votingsystem;
CREATE TABLE `admin_login` (
  `Id` int(11) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin_login`
--

INSERT INTO `admin_login` (`Id`, `Username`, `Password`) VALUES
(1, 'admin', '123');

-- --------------------------------------------------------

--
-- Table structure for table `personal_info`
--

CREATE TABLE `personal_info` (
  `Id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `F_Name` varchar(50) NOT NULL,
  `CNIC` int(11) NOT NULL,
  `Gender` varchar(20) NOT NULL,
  `Birth_Year` int(11) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `Vote` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `personal_info`
--

INSERT INTO `personal_info` (`Id`, `Name`, `F_Name`, `CNIC`, `Gender`, `Birth_Year`, `Address`, `City`, `Vote`) VALUES
(1, 'Shahrukh Ahmed', 'Irshad Ahmed', 1234567890, 'MALE', 2000, 'North Nazimabad ', 'karachi', 'YES'),
(2, 'Shahzad Ahmed', 'Irshad Ahmed', 123456789, 'MALE', 2002, 'North Nazimabad ', 'karachi', 'YES'),
(5, 'Farhan Ali', 'Wahid Ali', 123466789, 'MALE', 1999, 'Mehmoodabad', 'karachi', 'YES'),
(6, 'Zain', 'Younus', 123466788, 'MALE', 2000, 'Bufferzone', 'karachi', 'YES'),
(7, 'Fatima', 'khan', 223466788, 'FEMALE', 2000, 'Bufferzone', 'karachi', 'YES'),
(8, 'Zahid', 'Ahmed', 224466788, 'MALE', 1996, 'liyari', 'karachi', 'YES'),
(9, 'Zeeshan', 'Ahmed khan', 224466688, 'MALE', 1997, 'liyari', 'karachi', 'YES'),
(10, 'Alina', 'Mutaza', 224476688, 'FEMALE', 1998, 'DHA', 'karachi', 'YES');

-- --------------------------------------------------------

--
-- Table structure for table `voting`
--

CREATE TABLE `voting` (
  `Id` int(11) NOT NULL,
  `CNIC` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `F_Name` varchar(50) NOT NULL,
  `DBO` int(11) NOT NULL,
  `City` varchar(50) NOT NULL,
  `Date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `Party_Vote` varchar(50) NOT NULL,
  `Done` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `voting`
--

INSERT INTO `voting` (`Id`, `CNIC`, `Name`, `F_Name`, `DBO`, `City`, `Date`, `Party_Vote`, `Done`) VALUES
(1, 1234567890, 'Shahrukh Ahmed', 'Irshad Ahmed', 2000, 'karachi', '2022-06-29 11:32:30', 'PTI', 'done'),
(2, 123456789, 'Shahzad Ahmed', 'Irshad Ahmed', 2002, 'karachi', '2022-06-29 11:34:51', 'PTI', 'done'),
(3, 123466789, 'Farhan Ali', 'Wahid Ali', 1999, 'karachi', '2022-06-29 11:35:40', 'PTI', 'done'),
(4, 123466788, 'Zain', 'Younus', 2000, 'karachi', '2022-06-29 11:37:17', 'PPPP', 'done'),
(5, 223466788, 'Fatima', 'khan', 2000, 'karachi', '2022-06-29 11:37:49', 'PPPP', 'done'),
(6, 224466788, 'Zahid', 'Ahmed', 1996, 'karachi', '2022-06-29 11:38:13', 'MQM', 'done'),
(7, 224466688, 'Zeeshan', 'Ahmed khan', 1997, 'karachi', '2022-06-29 11:39:02', 'ANP', 'done');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_login`
--
ALTER TABLE `admin_login`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `personal_info`
--
ALTER TABLE `personal_info`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `voting`
--
ALTER TABLE `voting`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `CNIC` (`CNIC`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin_login`
--
ALTER TABLE `admin_login`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `personal_info`
--
ALTER TABLE `personal_info`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `voting`
--
ALTER TABLE `voting`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;



