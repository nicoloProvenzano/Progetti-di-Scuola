-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Nov 19, 2020 alle 12:56
-- Versione del server: 10.4.14-MariaDB
-- Versione PHP: 7.4.11
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */
;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */
;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */
;
/*!40101 SET NAMES utf8mb4 */
;
--
-- Database: `scuola`
--
-- --------------------------------------------------------
--
-- Struttura della tabella `studente`
--
CREATE TABLE `studente` (
  `codS` int(11) NOT NULL,
  `cognome` char(20) NOT NULL,
  `nome` char(20) NOT NULL,
  `classe` char(5) DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;
--
-- Dump dei dati per la tabella `studente`
--
INSERT INTO `studente` (`codS`, `cognome`, `nome`, `classe`)
VALUES (1, 'Russo', 'Francesco', '5IA'),
  (2, 'Veggo', 'Nicolò', '4IA'),
  (3, 'Perpignan', 'Mattia', ''),
  (4, 'Marchesini', 'Leonardo', NULL),
  (5, 'Zanella', 'Samuele', '5IA');
--
-- Indici per le tabelle scaricate
--
--
-- Indici per le tabelle `studente`
--
ALTER TABLE `studente`
ADD PRIMARY KEY (`codS`);
--
-- AUTO_INCREMENT per le tabelle scaricate
--
--
-- AUTO_INCREMENT per la tabella `studente`
--
ALTER TABLE `studente`
MODIFY `codS` int(11) NOT NULL AUTO_INCREMENT,
  AUTO_INCREMENT = 6;
COMMIT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */
;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */
;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */
;