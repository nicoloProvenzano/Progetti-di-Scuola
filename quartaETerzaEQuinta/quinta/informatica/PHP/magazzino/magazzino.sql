-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Feb 06, 2021 alle 13:15
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
-- Database: `magazzino`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `articolo`
--

CREATE TABLE `articolo` (
  `codA` int(11) NOT NULL,
  `descrizione` char(20) DEFAULT NULL,
  `prezzo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `cliente`
--

CREATE TABLE `cliente` (
  `codC` int(11) NOT NULL,
  `nome` char(15) DEFAULT NULL,
  `cognome` char(15) DEFAULT NULL,
  `sex` char(15) DEFAULT NULL,
  `data_nascita` char(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `ic`
--

CREATE TABLE `ic` (
  `codI` int(11) DEFAULT NULL,
  `codC` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `indirizzo`
--

CREATE TABLE `indirizzo` (
  `codI` int(11) NOT NULL,
  `via` char(20) DEFAULT NULL,
  `cap` int(11) DEFAULT NULL,
  `citta` char(15) NOT NULL,
  `provincia` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `oa`
--

CREATE TABLE `oa` (
  `codO` int(11) DEFAULT NULL,
  `codA` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `ordine`
--

CREATE TABLE `ordine` (
  `codO` int(11) NOT NULL,
  `codC` int(5) NOT NULL,
  `data_ordine` char(10) DEFAULT NULL,
  `quantità` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `reclamo`
--

CREATE TABLE `reclamo` (
  `codR` int(5) NOT NULL,
  `codO` int(5) NOT NULL,
  `tipologia` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `tc`
--

CREATE TABLE `tc` (
  `numero` int(11) DEFAULT NULL,
  `codC` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `telefono`
--

CREATE TABLE `telefono` (
  `numero` int(11) NOT NULL,
  `tipo` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `articolo`
--
ALTER TABLE `articolo`
  ADD PRIMARY KEY (`codA`);

--
-- Indici per le tabelle `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`codC`);

--
-- Indici per le tabelle `ic`
--
ALTER TABLE `ic`
  ADD KEY `codI` (`codI`),
  ADD KEY `codC` (`codC`);

--
-- Indici per le tabelle `indirizzo`
--
ALTER TABLE `indirizzo`
  ADD PRIMARY KEY (`codI`);

--
-- Indici per le tabelle `oa`
--
ALTER TABLE `oa`
  ADD KEY `codO` (`codO`),
  ADD KEY `codA` (`codA`);

--
-- Indici per le tabelle `ordine`
--
ALTER TABLE `ordine`
  ADD PRIMARY KEY (`codO`),
  ADD KEY `codC` (`codC`);

--
-- Indici per le tabelle `reclamo`
--
ALTER TABLE `reclamo`
  ADD PRIMARY KEY (`codR`),
  ADD KEY `codO` (`codO`);

--
-- Indici per le tabelle `tc`
--
ALTER TABLE `tc`
  ADD KEY `numero` (`numero`),
  ADD KEY `codC` (`codC`);

--
-- Indici per le tabelle `telefono`
--
ALTER TABLE `telefono`
  ADD PRIMARY KEY (`numero`);

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `ic`
--
ALTER TABLE `ic`
  ADD CONSTRAINT `ic_ibfk_1` FOREIGN KEY (`codI`) REFERENCES `indirizzo` (`codI`),
  ADD CONSTRAINT `ic_ibfk_2` FOREIGN KEY (`codC`) REFERENCES `cliente` (`codC`);

--
-- Limiti per la tabella `oa`
--
ALTER TABLE `oa`
  ADD CONSTRAINT `oa_ibfk_1` FOREIGN KEY (`codO`) REFERENCES `ordine` (`codO`),
  ADD CONSTRAINT `oa_ibfk_2` FOREIGN KEY (`codA`) REFERENCES `articolo` (`codA`);

--
-- Limiti per la tabella `ordine`
--
ALTER TABLE `ordine`
  ADD CONSTRAINT `codC` FOREIGN KEY (`codC`) REFERENCES `cliente` (`codC`);

--
-- Limiti per la tabella `reclamo`
--
ALTER TABLE `reclamo`
  ADD CONSTRAINT `codO` FOREIGN KEY (`codO`) REFERENCES `ordine` (`codO`);

--
-- Limiti per la tabella `tc`
--
ALTER TABLE `tc`
  ADD CONSTRAINT `tc_ibfk_1` FOREIGN KEY (`numero`) REFERENCES `telefono` (`numero`),
  ADD CONSTRAINT `tc_ibfk_2` FOREIGN KEY (`codC`) REFERENCES `cliente` (`codC`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
