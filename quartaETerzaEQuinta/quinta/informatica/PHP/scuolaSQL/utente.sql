-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Nov 17, 2020 alle 08:55
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
-- Database: `esempio`
--
-- --------------------------------------------------------
--
-- Struttura della tabella `utente`
--
CREATE TABLE `utente` (
  `id` int(5) NOT NULL,
  `nome` varchar(40) NOT NULL,
  `cognome` varchar(64) NOT NULL,
  `note` text DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
--
-- Dump dei dati per la tabella `utente`
--
INSERT INTO `utente` (`id`, `nome`, `cognome`, `note`)
VALUES (1, 'Mario', 'Rossi', NULL),
  (
    2,
    'Paolo',
    'Verdi',
    'prova inserimento testo dentro della nota'
  ),
  (
    3,
    'Luigi',
    'Bianchi',
    'utilizzatore esperto linux'
  ),
  (4, 'Giulio', 'Gialli', 'esaminatore CISCO'),
  (5, 'Paolo', 'Rossi', 'Sistemista ');
--
-- Indici per le tabelle scaricate
--
--
-- Indici per le tabelle `utente`
--
ALTER TABLE `utente`
ADD PRIMARY KEY (`id`);
--
-- AUTO_INCREMENT per le tabelle scaricate
--
--
-- AUTO_INCREMENT per la tabella `utente`
--
ALTER TABLE `utente`
MODIFY `id` int(5) NOT NULL AUTO_INCREMENT,
  AUTO_INCREMENT = 15;
COMMIT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */
;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */
;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */
;