-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Dic 17, 2020 alle 09:08
-- Versione del server: 10.4.14-MariaDB
-- Versione PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `provenzanonicolo`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `stili`
--

CREATE TABLE `stili` (
  `id_style` int(11) NOT NULL,
  `background` char(20) DEFAULT NULL,
  `color` char(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `stili`
--

INSERT INTO `stili` (`id_style`, `background`, `color`) VALUES
(1, 'blue', 'yellow'),
(2, 'orange', 'black'),
(3, 'green', 'purple');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `stili`
--
ALTER TABLE `stili`
  ADD PRIMARY KEY (`id_style`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
