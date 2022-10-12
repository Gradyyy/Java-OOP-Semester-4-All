-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 11, 2022 at 10:52 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `facobell`
--

-- --------------------------------------------------------

--
-- Table structure for table `quesadilla`
--

CREATE TABLE `quesadilla` (
  `FoodId` int(11) NOT NULL,
  `FoodName` varchar(255) NOT NULL,
  `FoodType` varchar(255) NOT NULL,
  `FoodPrice` int(11) NOT NULL,
  `DippingSauce` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `quesadilla`
--

INSERT INTO `quesadilla` (`FoodId`, `FoodName`, `FoodType`, `FoodPrice`, `DippingSauce`) VALUES
(1, 'Steak Quesadilla', 'Quesadilla', 40000, 'Barbeque'),
(2, 'Chicken Quesadilla', 'Quesadilla', 35000, 'Barbeque'),
(3, 'Cheese Quesadilla', 'Quesadilla', 48000, 'Creamy Cheese'),
(4, 'Lamb Quesadilla', 'Quesadilla', 65000, 'Black Pepper'),
(5, 'Mixed Quesadilla', 'Quesadilla', 70000, 'Black Pepper');

-- --------------------------------------------------------

--
-- Table structure for table `taco`
--

CREATE TABLE `taco` (
  `FoodId` int(11) NOT NULL,
  `FoodName` varchar(255) NOT NULL,
  `FoodType` varchar(255) NOT NULL,
  `FoodPrice` int(11) NOT NULL,
  `ShellType` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `taco`
--

INSERT INTO `taco` (`FoodId`, `FoodName`, `FoodType`, `FoodPrice`, `ShellType`) VALUES
(6, 'Super Supreme', 'Taco', 28000, 'Crunchy'),
(7, 'Locos Tacos', 'Taco', 19000, 'Crunchy'),
(8, 'Beefy Potato', 'Taco', 32000, 'Soft'),
(9, 'Spicy Potato', 'Taco', 26000, 'Soft'),
(10, 'Black Bean', 'Taco', 23000, 'Soft');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `TransactionId` varchar(255) NOT NULL,
  `FoodId` int(11) NOT NULL,
  `Qty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


--
-- Indexes for dumped tables
--

--
-- Indexes for table `quesadilla`
--
ALTER TABLE `quesadilla`
  ADD PRIMARY KEY (`FoodId`);

--
-- Indexes for table `taco`
--
ALTER TABLE `taco`
  ADD PRIMARY KEY (`FoodId`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`TransactionId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `quesadilla`
--
ALTER TABLE `quesadilla`
  MODIFY `FoodId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `taco`
--
ALTER TABLE `taco`
  MODIFY `FoodId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
