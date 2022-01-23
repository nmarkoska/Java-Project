-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 23, 2022 at 03:47 PM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `news_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `category_name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `category_name`) VALUES
(1, 'Sport'),
(2, 'Tech'),
(3, 'Film'),
(4, 'Political'),
(5, 'Education'),
(6, 'Music'),
(7, 'Science'),
(8, 'Sport'),
(9, 'Tech'),
(10, 'Film'),
(11, 'Political'),
(12, 'Education'),
(13, 'Music'),
(14, 'Science'),
(15, 'Sport'),
(16, 'Tech'),
(17, 'Film'),
(18, 'Political'),
(19, 'Education'),
(20, 'Music'),
(21, 'Science'),
(22, 'Sport'),
(23, 'Tech'),
(24, 'Film'),
(25, 'Political'),
(26, 'Education'),
(27, 'Music'),
(28, 'Science'),
(29, 'Sport'),
(30, 'Tech'),
(31, 'Film'),
(32, 'Political'),
(33, 'Education'),
(34, 'Music'),
(35, 'Science'),
(36, 'Sport'),
(37, 'Tech'),
(38, 'Film'),
(39, 'Political'),
(40, 'Education'),
(41, 'Music'),
(42, 'Science');

-- --------------------------------------------------------

--
-- Table structure for table `news`
--

CREATE TABLE `news` (
  `id` int(11) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `description` longtext,
  `title` varchar(255) DEFAULT NULL,
  `category_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `news`
--

INSERT INTO `news` (`id`, `date`, `description`, `title`, `category_id`) VALUES
(1, '2022-01-23', 'A man has been jailed for five years for robbing and blackmailing nine men he met for sex on dating app Grindr.After having consensual sex with his victims, 28-year-old Anouar Sabbar would claim he was actually an escort and demand payment for his visit.He stole £2,360 from his victims between April 2019 and June 2021, the Metropolitan Police said.Sabbar, from south London, had pleaded guilty at Snaresbrook Crown Court to robbery, theft, blackmail and fraud.', 'RussiaGrindr scammer jailed for blackmailing men', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKryugyuqj7jjkqd3byc5meoocy` (`category_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;
--
-- AUTO_INCREMENT for table `news`
--
ALTER TABLE `news`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
