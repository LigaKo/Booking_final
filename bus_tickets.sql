-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 02, 2021 at 01:56 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bus_tickets`
--

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `cid` int(11) NOT NULL,
  `name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`cid`, `name`) VALUES
(1, 'Jelgava'),
(2, 'Liepaja'),
(3, 'Ventspils'),
(4, 'Valmiera'),
(5, 'Rēzekne');

-- --------------------------------------------------------

--
-- Table structure for table `destin`
--

CREATE TABLE `destin` (
  `cityID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `destinations`
--

CREATE TABLE `destinations` (
  `busID` int(11) NOT NULL,
  `destination` varchar(100) NOT NULL,
  `journeyDate` varchar(100) NOT NULL,
  `journeyTime` varchar(255) DEFAULT NULL,
  `travelTime` varchar(255) DEFAULT NULL,
  `MaximumNumberOfSeats` int(5) NOT NULL,
  `price` varchar(255) DEFAULT NULL,
  `cityID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `destinations`
--

INSERT INTO `destinations` (`busID`, `destination`, `journeyDate`, `journeyTime`, `travelTime`, `MaximumNumberOfSeats`, `price`, `cityID`) VALUES
(1, 'Jelgava', '05-10-2021', '4:00', '55 minutes', 20, '2,40', 1),
(2, 'Jelgava', '05-10-2021', '8:00', '55 minutes', 20, '2,40', 1),
(3, 'Jelgava', '06-10-2021', '11:00', '55 minutes', 20, '2,40', 1),
(4, 'Jelgava', '07-10-2021', '14:00', '55 minutes', 20, '2,40', 1),
(5, 'Jelgava', '08-10-2021', '8:00', '55 minutes', 20, '2,40', 1),
(6, 'Jelgava', '09-10-2021', '8:00', '55 minutes', 20, '2,40', 1),
(7, 'Liepaja', '06-10-2021', '05:00', '3 hours 30 minutes', 20, '8,65', 2),
(8, 'Liepaja', '08-10-2021', '14:00', '3 hours 20 minutes', 20, '8,60', 2),
(9, 'Liepaja', '09-10-2021', '16:00', '3 hours 20 minutes', 20, '8,60', 2),
(10, 'Liepaja', '10-10-2021', '20:00', '3 hours 20 minutes', 20, '8,60', 2),
(11, 'Liepaja', '09-10-2021', '16:00', '3 hours 20 minutes', 20, '8,60', 2),
(12, 'Liepaaja', '09-10-2021', '16:00', '3 hours 20 minutes', 20, '8,60', 2),
(13, 'Ventspils', '06-10-2021', '10:00', '3 hours', 20, '7,65', 3),
(14, 'Ventspils', '06-10-2021', '01:00', '3 hours', 20, '7,65', 3),
(15, 'Ventspils', '06-10-2021', '18:00', '3 hours', 20, '7,65', 3),
(16, 'Ventspils', '07-10-2021', '11:00', '3 hours', 20, '7,65', 3),
(17, 'Ventspils', '08-10-2021', '17:00', '3 hours', 20, '7,65', 3),
(18, 'Valmiera', '06-10-2021', '21:00', '3 hours 10 minutes', 20, '4,85', 4),
(19, 'Valmiera', '09-10-2021', '22:00', '3 hours 10 minutes', 20, '4,85', 4),
(20, 'Valmiera', '09-10-2021', '08:00', '3 hours 10 minutes', 20, '4,85', 4),
(21, 'Valmiera', '11-10-2021', '06:00', '3 hours 10 minutes', 20, '4,85', 4),
(22, 'Valmiera', '09-10-2021', '10:00', '3 hours 10 minutes', 20, '4,85', 24),
(23, 'Rēzekne', '09-10-2021', '04:00', '4 hours 5 minutes', 20, '9,85', 5),
(24, 'Rēzekne', '09-10-2021', '09:00', '4 hours 5 minutes', 20, '9,85', 5),
(25, 'Rēzekne', '09-10-2021', '10:00', '4 hours 5 minutes', 20, '9,85', 5),
(26, 'Rēzekne', '09-10-2021', '14:00', '4 hours 5 minutes', 20, '9,85', 5),
(27, 'Rēzekne', '09-10-2021', '18:00', '4 hours 5 minutes', 20, '9,85', 5),
(28, 'Rēzekne', '10-10-2021', '01:00', '4 hours 5 minutes', 20, '9,85', 5),
(29, 'Rēzekne', '10-10-2021', '13:00', '4 hours 5 minutes', 20, '9,85', 5),
(30, 'Rēzekne', '11-10-2021', '10:00', '4 hours 5 minutes', 20, '9,85', 5);

-- --------------------------------------------------------

--
-- Table structure for table `ticket_info`
--

CREATE TABLE `ticket_info` (
  `passengerID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `surname` varchar(200) NOT NULL,
  `phoneNumber` int(11) NOT NULL,
  `email` varchar(200) NOT NULL,
  `destination` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL,
  `time` varchar(45) NOT NULL,
  `ticketType` varchar(255) NOT NULL,
  `discountAmount` int(11) NOT NULL,
  `ticketPrice` double NOT NULL,
  `busID` int(11) NOT NULL,
  `seatNumber` int NOT NULL,
  PRIMARY KEY (`passengerID`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP  TABLE ticket_info;
SELECT * FROM ticket_info;
DELETE FROM ticket_info WHERE passengerID=8;


--
-- Dumping data for table `ticket_info`
--

INSERT INTO `ticket_info` (`name`, `surname`, `phoneNumber`, `email`, `destination`, `date`, `time`, `ticketType`, `discountAmount`, `ticketPrice`) VALUES
('test', 'test', 123456789, 'test@gmial.com', 'Liepaja', '06-10-2021', '05:00', '2. Student', 90, '0.87');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`cid`);

--
-- Indexes for table `destin`
--
ALTER TABLE `destin`
  ADD PRIMARY KEY (`cityID`);

--
-- Indexes for table `destinations`
--
ALTER TABLE `destinations`
  ADD PRIMARY KEY (`busID`);

--
-- Indexes for table `ticket_info`
--
ALTER TABLE `ticket_info`
  ADD PRIMARY KEY (`passengerID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ticket_info`
--
ALTER TABLE `ticket_info`
  MODIFY `passengerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
