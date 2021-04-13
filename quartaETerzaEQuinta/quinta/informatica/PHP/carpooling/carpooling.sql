-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mar 23, 2021 alle 11:20
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
-- Database: `carpooling`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `ap`
--

CREATE TABLE `ap` (
  `giudizio_autista` char(20) DEFAULT NULL,
  `CF_autista` char(20) NOT NULL,
  `CF_passeggero` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `ap`
--

INSERT INTO `ap` (`giudizio_autista`, `CF_autista`, `CF_passeggero`) VALUES
('non buono', 'LJYNDN02A01F158Z', 'SCVSMI90R11L736O'),
('buono', 'LJYNDN02A01F158Z', 'ZNZZRA01T23L407Y'),
('ottimo', 'ZNLNCL01P13G273D', 'ZNTSMA04R11L736Q');

-- --------------------------------------------------------

--
-- Struttura della tabella `autista`
--

CREATE TABLE `autista` (
  `CF_autista` char(20) NOT NULL,
  `nome` char(30) NOT NULL,
  `cognome` char(30) NOT NULL,
  `scadenza_patente` char(10) NOT NULL,
  `telefono` int(11) NOT NULL,
  `email` char(30) NOT NULL,
  `password` char(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `autista`
--

INSERT INTO `autista` (`CF_autista`, `nome`, `cognome`, `scadenza_patente`, `telefono`, `email`, `password`) VALUES
('LJYNDN02A01F158Z', 'Andonio', 'Aliajey', '27/6/2026', 324271456, 'aliajey.andonio@gmail.com', 'aliajey2002'),
('ZNLNCL01P13G273D', 'Nicolò', 'Zanal', '5/02/2031', 324873456, 'zanal.nicolo@gmail.com', 'zanal2001');

-- --------------------------------------------------------

--
-- Struttura della tabella `macchina`
--

CREATE TABLE `macchina` (
  `n_targa` char(20) NOT NULL,
  `marca` char(30) NOT NULL,
  `cilindrata` int(11) NOT NULL,
  `colore` char(20) NOT NULL,
  `modello` char(30) NOT NULL,
  `fotografia` int(11) NOT NULL,
  `CF_autista` char(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `macchina`
--

INSERT INTO `macchina` (`n_targa`, `marca`, `cilindrata`, `colore`, `modello`, `fotografia`, `CF_autista`) VALUES
('AB456CD', 'AUDI', 1800, 'BIANCO', 'Q3', 2, 'LJYNDN02A01F158Z'),
('WF378CV', 'Mercedes', 1600, 'Grigio', 'AMGT', 1, 'ZNLNCL01P13G273D');

-- --------------------------------------------------------

--
-- Struttura della tabella `passeggero`
--

CREATE TABLE `passeggero` (
  `CF_passeggero` char(20) NOT NULL,
  `password` char(30) NOT NULL,
  `email` char(30) NOT NULL,
  `telefono` int(11) NOT NULL,
  `documento_id` int(11) NOT NULL,
  `cognome` char(30) NOT NULL,
  `nome` char(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `passeggero`
--

INSERT INTO `passeggero` (`CF_passeggero`, `password`, `email`, `telefono`, `documento_id`, `cognome`, `nome`) VALUES
('SCVSMI90R11L736O', 'scavezzones', 'scavezzones.simo@gmail.com', 345638311, 2, 'Scavezzones', 'Simo'),
('ZNTSMA04R11L736Q', 'zanetta2001', 'zanetta.samu@gmail.com', 34567890, 3, 'Zanetta', 'Samu'),
('ZNZZRA01T23L407Y', 'zonezzi2001', 'zonezzi.zario@gmail.com', 345678321, 1, 'Zonezzi', 'Zario');

-- --------------------------------------------------------

--
-- Struttura della tabella `pxv`
--

CREATE TABLE `pxv` (
  `n_passeggeri` int(11) DEFAULT NULL,
  `CF_passeggero` char(20) NOT NULL,
  `codV` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `pxv`
--

INSERT INTO `pxv` (`n_passeggeri`, `CF_passeggero`, `codV`) VALUES
(2, 'SCVSMI90R11L736O', 1),
(2, 'ZNTSMA04R11L736Q', 1),
(1, 'ZNZZRA01T23L407Y', 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `viaggio`
--

CREATE TABLE `viaggio` (
  `codV` int(11) NOT NULL,
  `città_partenza` char(50) NOT NULL,
  `città_destinazione` char(50) NOT NULL,
  `data_partenza` char(10) NOT NULL,
  `ora_partenza` char(10) NOT NULL,
  `costo` int(11) NOT NULL,
  `data_destinazione` char(11) NOT NULL,
  `CF_autista` char(20) DEFAULT NULL,
  `ora_fine` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `viaggio`
--

INSERT INTO `viaggio` (`codV`, `città_partenza`, `città_destinazione`, `data_partenza`, `ora_partenza`, `costo`, `data_destinazione`, `CF_autista`, `ora_fine`) VALUES
(1, 'Milano', 'Palermo', '5/09/2020', '15:00', 300, '6/09/2020', 'LJYNDN02A01F158Z', '11:00'),
(2, 'Venezia', 'Padova', '15/12/2020', '16:00', 20, '15/12/2020', 'ZNLNCL01P13G273D', '18:00');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `ap`
--
ALTER TABLE `ap`
  ADD PRIMARY KEY (`CF_autista`,`CF_passeggero`),
  ADD KEY `CF_passeggiero` (`CF_passeggero`),
  ADD KEY `CF_passeggero` (`CF_passeggero`),
  ADD KEY `CF_autista` (`CF_autista`);

--
-- Indici per le tabelle `autista`
--
ALTER TABLE `autista`
  ADD PRIMARY KEY (`CF_autista`);

--
-- Indici per le tabelle `macchina`
--
ALTER TABLE `macchina`
  ADD PRIMARY KEY (`n_targa`),
  ADD KEY `CF_autista` (`CF_autista`);

--
-- Indici per le tabelle `passeggero`
--
ALTER TABLE `passeggero`
  ADD PRIMARY KEY (`CF_passeggero`);

--
-- Indici per le tabelle `pxv`
--
ALTER TABLE `pxv`
  ADD PRIMARY KEY (`CF_passeggero`,`codV`),
  ADD KEY `CF_passeggiero` (`CF_passeggero`),
  ADD KEY `codV` (`codV`);

--
-- Indici per le tabelle `viaggio`
--
ALTER TABLE `viaggio`
  ADD PRIMARY KEY (`codV`),
  ADD KEY `CF_autista` (`CF_autista`);

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `ap`
--
ALTER TABLE `ap`
  ADD CONSTRAINT `ap_ibfk_1` FOREIGN KEY (`CF_passeggero`) REFERENCES `passeggero` (`CF_passeggero`),
  ADD CONSTRAINT `ap_ibfk_2` FOREIGN KEY (`CF_autista`) REFERENCES `autista` (`CF_autista`);

--
-- Limiti per la tabella `macchina`
--
ALTER TABLE `macchina`
  ADD CONSTRAINT `macchina_ibfk_1` FOREIGN KEY (`CF_autista`) REFERENCES `autista` (`CF_autista`);

--
-- Limiti per la tabella `pxv`
--
ALTER TABLE `pxv`
  ADD CONSTRAINT `pxv_ibfk_1` FOREIGN KEY (`CF_passeggero`) REFERENCES `passeggero` (`CF_passeggero`),
  ADD CONSTRAINT `pxv_ibfk_2` FOREIGN KEY (`codV`) REFERENCES `viaggio` (`codV`);

--
-- Limiti per la tabella `viaggio`
--
ALTER TABLE `viaggio`
  ADD CONSTRAINT `viaggio_ibfk_1` FOREIGN KEY (`CF_autista`) REFERENCES `autista` (`CF_autista`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
