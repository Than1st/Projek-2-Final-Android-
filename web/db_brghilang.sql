-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 11, 2020 at 02:05 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_brghilang`
--

-- --------------------------------------------------------

--
-- Table structure for table `brghilang`
--

CREATE TABLE `brghilang` (
  `id_brghilang` varchar(3) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `kategori` varchar(20) NOT NULL,
  `detail` varchar(30) NOT NULL,
  `waktu_ditemukan` datetime NOT NULL,
  `waktu_dikembalikan` datetime NOT NULL,
  `status` enum('0','1') NOT NULL,
  `src` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `brghilang`
--

INSERT INTO `brghilang` (`id_brghilang`, `nama`, `kategori`, `detail`, `waktu_ditemukan`, `waktu_dikembalikan`, `status`, `src`) VALUES
('1', 'Flashdisk HP', 'Electronic', 'stainless steel', '2020-03-07 11:32:37', '0000-00-00 00:00:00', '0', '1.jpg'),
('2', 'Laptop Macbook', 'Electronic', 'Tipis, putih', '2020-03-07 11:34:02', '0000-00-00 00:00:00', '0', '2.jpg\r\n'),
('3', 'Topi Hitam', 'Pakaian', 'warna Hitam', '2020-03-07 13:51:52', '2020-03-07 13:51:52', '0', '3.jpg'),
('4', 'Adapter Xiaomi', 'Electronic', 'Warna Putih', '2020-03-11 17:37:02', '0000-00-00 00:00:00', '0', '4.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `brghilang`
--
ALTER TABLE `brghilang`
  ADD PRIMARY KEY (`id_brghilang`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
