-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 05, 2015 at 10:48 PM
-- Server version: 5.5.40-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dépenses_familiales`
--

-- --------------------------------------------------------

--
-- Table structure for table `Expensive`
--

CREATE TABLE IF NOT EXISTS `Expensive` (
  `Exp_ID` int(11) NOT NULL,
  `Exp_Desc` varchar(50) NOT NULL,
  PRIMARY KEY (`Exp_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Income_Trans`
--

CREATE TABLE IF NOT EXISTS `Income_Trans` (
  `ID_Trans` int(11) NOT NULL,
  `ID_User` int(11) NOT NULL,
  `Amount` int(11) NOT NULL,
  `Date` date NOT NULL,
  `ID_Income_Type` int(11) NOT NULL,
  PRIMARY KEY (`ID_Trans`),
  KEY `ID_User` (`ID_User`),
  KEY `ID_Income_Type` (`ID_Income_Type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Income_Type`
--

CREATE TABLE IF NOT EXISTS `Income_Type` (
  `ID_Income` int(11) NOT NULL,
  `Income_Desc` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_Income`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Role`
--

CREATE TABLE IF NOT EXISTS `Role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Desc` varchar(25) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Transaction`
--

CREATE TABLE IF NOT EXISTS `Transaction` (
  `ID_Trans` int(11) NOT NULL AUTO_INCREMENT,
  `ID_user` int(11) NOT NULL,
  `Amount` int(11) NOT NULL,
  `ID_Expens` int(11) NOT NULL,
  `Date` date NOT NULL,
  PRIMARY KEY (`ID_Trans`),
  KEY `ID_user` (`ID_user`),
  KEY `ID_Expens` (`ID_Expens`),
  KEY `ID_user_2` (`ID_user`),
  KEY `ID_Expens_2` (`ID_Expens`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE IF NOT EXISTS `User` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `User_Name` varchar(15) NOT NULL,
  `Password` varchar(15) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Role_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Role_ID` (`Role_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Income_Trans`
--
ALTER TABLE `Income_Trans`
  ADD CONSTRAINT `Income_Trans_ibfk_1` FOREIGN KEY (`ID_User`) REFERENCES `User` (`ID`),
  ADD CONSTRAINT `Income_Trans_ibfk_2` FOREIGN KEY (`ID_Income_Type`) REFERENCES `Income_Trans` (`ID_User`);

--
-- Constraints for table `Transaction`
--
ALTER TABLE `Transaction`
  ADD CONSTRAINT `Transaction_ibfk_1` FOREIGN KEY (`ID_user`) REFERENCES `User` (`ID`),
  ADD CONSTRAINT `Transaction_ibfk_2` FOREIGN KEY (`ID_Expens`) REFERENCES `Expensive` (`Exp_ID`);

--
-- Constraints for table `User`
--
ALTER TABLE `User`
  ADD CONSTRAINT `User_ibfk_1` FOREIGN KEY (`Role_ID`) REFERENCES `Role` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
