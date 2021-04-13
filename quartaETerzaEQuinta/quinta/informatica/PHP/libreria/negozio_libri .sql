-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mar 12, 2021 alle 16:24
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
-- Database: `negozio_libri`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `acquisti`
--

CREATE TABLE `acquisti` (
  `codAC` int(11) NOT NULL,
  `costo` int(11) NOT NULL,
  `data` char(20) NOT NULL,
  `CF` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `acquisti`
--

INSERT INTO `acquisti` (`codAC`, `costo`, `data`, `CF`) VALUES
(1, 11, '12/03/2021', 'DFRLRD01M11F241Z'),
(2, 10, '5/03/2021', 'TNTDRA01T23L407K');

-- --------------------------------------------------------

--
-- Struttura della tabella `al`
--

CREATE TABLE `al` (
  `codA` int(11) NOT NULL,
  `ISBN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `al`
--

INSERT INTO `al` (`codA`, `ISBN`) VALUES
(1, 1),
(1, 2),
(2, 3),
(3, 4);

-- --------------------------------------------------------

--
-- Struttura della tabella `autore`
--

CREATE TABLE `autore` (
  `codA` int(11) NOT NULL,
  `nome` char(20) NOT NULL,
  `cognome` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `autore`
--

INSERT INTO `autore` (`codA`, `nome`, `cognome`) VALUES
(1, 'Joanne Kathleen', 'Rowling'),
(2, 'Walter', 'Isaacson'),
(3, 'John Ronald Reuel', 'Tolkien');

-- --------------------------------------------------------

--
-- Struttura della tabella `categoria`
--

CREATE TABLE `categoria` (
  `codC` int(11) NOT NULL,
  `denominazione` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `categoria`
--

INSERT INTO `categoria` (`codC`, `denominazione`) VALUES
(1, 'Fantasy'),
(2, 'biografico');

-- --------------------------------------------------------

--
-- Struttura della tabella `cliente`
--

CREATE TABLE `cliente` (
  `CF` char(20) NOT NULL,
  `indirizzo` char(20) NOT NULL,
  `nome` char(20) NOT NULL,
  `cognome` char(20) DEFAULT NULL,
  `codL` int(11) DEFAULT NULL,
  `email` char(50) DEFAULT NULL,
  `password` char(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `cliente`
--

INSERT INTO `cliente` (`CF`, `indirizzo`, `nome`, `cognome`, `codL`, `email`, `password`) VALUES
('DFRLRD01M11F241Z', 'J. Da Ponte 7', 'Leonardo', 'Di Francesco', 1, 'smaskedif@gmail.com', 'smaske2001'),
('TNTDRA01T23L407K', 'Tonetti 5', 'Dario', 'Tonetti', 2, 'tonetti.d@gmail.com', 'dario2001');

-- --------------------------------------------------------

--
-- Struttura della tabella `editore`
--

CREATE TABLE `editore` (
  `codE` int(11) NOT NULL,
  `nome` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `editore`
--

INSERT INTO `editore` (`codE`, `nome`) VALUES
(1, 'Bompiani'),
(2, 'Mondadori'),
(3, 'Salani');

-- --------------------------------------------------------

--
-- Struttura della tabella `el`
--

CREATE TABLE `el` (
  `ISBN` int(11) NOT NULL,
  `codE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `el`
--

INSERT INTO `el` (`ISBN`, `codE`) VALUES
(1, 3),
(2, 3),
(3, 2),
(4, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `la`
--

CREATE TABLE `la` (
  `ISBN` int(11) NOT NULL,
  `codAC` int(11) NOT NULL,
  `Quantità` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `la`
--

INSERT INTO `la` (`ISBN`, `codAC`, `Quantità`) VALUES
(1, 1, 1),
(2, 2, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `lc`
--

CREATE TABLE `lc` (
  `codC` int(11) NOT NULL,
  `ISBN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `lc`
--

INSERT INTO `lc` (`codC`, `ISBN`) VALUES
(1, 1),
(1, 2),
(2, 3),
(1, 4);

-- --------------------------------------------------------

--
-- Struttura della tabella `libreria`
--

CREATE TABLE `libreria` (
  `codL` int(11) NOT NULL,
  `nome` char(20) NOT NULL,
  `indirizzo` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `libreria`
--

INSERT INTO `libreria` (`codL`, `nome`, `indirizzo`) VALUES
(1, 'feltrinelli', 'Don Tosatto'),
(2, 'mondadori', 'dei matti');

-- --------------------------------------------------------

--
-- Struttura della tabella `libro`
--

CREATE TABLE `libro` (
  `ISBN` int(11) NOT NULL,
  `prezzo` int(11) NOT NULL,
  `titolo` char(20) NOT NULL,
  `dataPub` char(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `libro`
--

INSERT INTO `libro` (`ISBN`, `prezzo`, `titolo`, `dataPub`) VALUES
(1, 11, 'Harry Potter e la ca', '23/01/2020'),
(2, 10, 'Harry Potter e la pi', '23/01/2020'),
(3, 15, 'Steve Jobs', '25/05/2017'),
(4, 47, 'il signore degli ane', '28/10/2020');

-- --------------------------------------------------------

--
-- Struttura della tabella `ll`
--

CREATE TABLE `ll` (
  `ISBN` int(11) NOT NULL,
  `codL` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `ll`
--

INSERT INTO `ll` (`ISBN`, `codL`) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 2);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `acquisti`
--
ALTER TABLE `acquisti`
  ADD PRIMARY KEY (`codAC`),
  ADD KEY `CF` (`CF`);

--
-- Indici per le tabelle `al`
--
ALTER TABLE `al`
  ADD PRIMARY KEY (`ISBN`,`codA`),
  ADD KEY `codA` (`codA`),
  ADD KEY `ISBN` (`ISBN`);

--
-- Indici per le tabelle `autore`
--
ALTER TABLE `autore`
  ADD PRIMARY KEY (`codA`);

--
-- Indici per le tabelle `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`codC`);

--
-- Indici per le tabelle `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`CF`),
  ADD KEY `codL` (`codL`);

--
-- Indici per le tabelle `editore`
--
ALTER TABLE `editore`
  ADD PRIMARY KEY (`codE`);

--
-- Indici per le tabelle `el`
--
ALTER TABLE `el`
  ADD PRIMARY KEY (`ISBN`,`codE`),
  ADD KEY `codE` (`codE`),
  ADD KEY `ISBN` (`ISBN`);

--
-- Indici per le tabelle `la`
--
ALTER TABLE `la`
  ADD PRIMARY KEY (`ISBN`,`codAC`),
  ADD KEY `codAC` (`codAC`),
  ADD KEY `ISBN` (`ISBN`);

--
-- Indici per le tabelle `lc`
--
ALTER TABLE `lc`
  ADD PRIMARY KEY (`ISBN`,`codC`),
  ADD KEY `codC` (`codC`),
  ADD KEY `ISBN` (`ISBN`);

--
-- Indici per le tabelle `libreria`
--
ALTER TABLE `libreria`
  ADD PRIMARY KEY (`codL`);

--
-- Indici per le tabelle `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`ISBN`);

--
-- Indici per le tabelle `ll`
--
ALTER TABLE `ll`
  ADD PRIMARY KEY (`ISBN`,`codL`),
  ADD KEY `ISBN` (`ISBN`),
  ADD KEY `codL` (`codL`);

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `acquisti`
--
ALTER TABLE `acquisti`
  ADD CONSTRAINT `acquisti_ibfk_1` FOREIGN KEY (`CF`) REFERENCES `cliente` (`CF`);

--
-- Limiti per la tabella `al`
--
ALTER TABLE `al`
  ADD CONSTRAINT `al_ibfk_1` FOREIGN KEY (`codA`) REFERENCES `autore` (`codA`),
  ADD CONSTRAINT `al_ibfk_2` FOREIGN KEY (`codA`) REFERENCES `autore` (`codA`),
  ADD CONSTRAINT `al_ibfk_3` FOREIGN KEY (`ISBN`) REFERENCES `libro` (`ISBN`);

--
-- Limiti per la tabella `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`codL`) REFERENCES `libreria` (`codL`);

--
-- Limiti per la tabella `el`
--
ALTER TABLE `el`
  ADD CONSTRAINT `el_ibfk_1` FOREIGN KEY (`codE`) REFERENCES `editore` (`codE`),
  ADD CONSTRAINT `el_ibfk_2` FOREIGN KEY (`ISBN`) REFERENCES `libro` (`ISBN`);

--
-- Limiti per la tabella `la`
--
ALTER TABLE `la`
  ADD CONSTRAINT `la_ibfk_1` FOREIGN KEY (`codAC`) REFERENCES `acquisti` (`codAC`),
  ADD CONSTRAINT `la_ibfk_2` FOREIGN KEY (`codAC`) REFERENCES `acquisti` (`codAC`),
  ADD CONSTRAINT `la_ibfk_3` FOREIGN KEY (`ISBN`) REFERENCES `libro` (`ISBN`);

--
-- Limiti per la tabella `lc`
--
ALTER TABLE `lc`
  ADD CONSTRAINT `lc_ibfk_1` FOREIGN KEY (`codC`) REFERENCES `categoria` (`codC`),
  ADD CONSTRAINT `lc_ibfk_2` FOREIGN KEY (`ISBN`) REFERENCES `libro` (`ISBN`);

--
-- Limiti per la tabella `ll`
--
ALTER TABLE `ll`
  ADD CONSTRAINT `ll_ibfk_1` FOREIGN KEY (`ISBN`) REFERENCES `libro` (`ISBN`),
  ADD CONSTRAINT `ll_ibfk_2` FOREIGN KEY (`codL`) REFERENCES `libreria` (`codL`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
