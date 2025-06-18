-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Cze 10, 2025 at 10:44 PM
-- Wersja serwera: 10.4.32-MariaDB
-- Wersja PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `harmonogramjava`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `cele`
--

CREATE TABLE `cele` (
  `id` int(10) UNSIGNED NOT NULL,
  `id_uzytkownika` int(10) UNSIGNED NOT NULL,
  `nazwa` varchar(50) NOT NULL,
  `kategoria` varchar(50) NOT NULL,
  `opis` text NOT NULL,
  `zdjecie` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_polish_ci;

--
-- Dumping data for table `cele`
--

INSERT INTO `cele` (`id`, `id_uzytkownika`, `nazwa`, `kategoria`, `opis`, `zdjecie`) VALUES
(1, 1, 'Wakacje na Malediwach', 'wakacje', 'zorganizowanie oraz wykupienie wakacji', 'malediwy.webp'),
(4, 1, 'Zakup samochodu', 'Samochód', 'kupić samochód z roku 2020', 'mercedes.webp'),
(6, 1, 'Komunia brata', 'okazja rodzinna', 'kupić prezent oraz zaplanować obiad rodzinny', ''),
(7, 5, 'test1', 'test1', 'test1', 'test1');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `szczegoly_celu`
--

CREATE TABLE `szczegoly_celu` (
  `id_celu` int(10) UNSIGNED NOT NULL,
  `koszty` int(11) NOT NULL,
  `uzbierana_kwota` int(11) NOT NULL,
  `data_rozpoczecia` date NOT NULL,
  `data_zakonczenia` date NOT NULL,
  `status` enum('nie rozpoczęto planowania','w trakcie planowania','w trakcie wykonywania','ukończony cel') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_polish_ci;

--
-- Dumping data for table `szczegoly_celu`
--

INSERT INTO `szczegoly_celu` (`id_celu`, `koszty`, `uzbierana_kwota`, `data_rozpoczecia`, `data_zakonczenia`, `status`) VALUES
(1, 5500, 3000, '2025-07-08', '2025-09-06', 'w trakcie planowania'),
(4, 70000, 10000, '2025-05-31', '2026-01-22', 'nie rozpoczęto planowania'),
(6, 7000, 2000, '2025-04-09', '2025-05-26', 'w trakcie wykonywania');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `szczegoly_zad`
--

CREATE TABLE `szczegoly_zad` (
  `id_zadania` int(10) UNSIGNED NOT NULL,
  `data` date NOT NULL,
  `godzina` time NOT NULL,
  `stan_realizacji` enum('nie rozpoczęto zadania','w trakcie realizacji','zakończenie zadania','') NOT NULL,
  `szczegoly` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_polish_ci;

--
-- Dumping data for table `szczegoly_zad`
--

INSERT INTO `szczegoly_zad` (`id_zadania`, `data`, `godzina`, `stan_realizacji`, `szczegoly`) VALUES
(1, '2025-05-20', '14:45:00', 'zakończenie zadania', 'kontynuacja pracy z strony www'),
(4, '2025-05-21', '16:36:00', 'nie rozpoczęto zadania', 'pojechać z babcią na pole'),
(6, '2025-05-22', '08:15:00', 'nie rozpoczęto zadania', 'kolokwium z matematyki3'),
(8, '2025-05-23', '18:10:00', 'nie rozpoczęto zadania', 'pojechać do wiktori na paznokcie'),
(11, '2025-06-04', '15:57:00', 'zakończenie zadania', 'pokazać pracę oraz sprawozdanie'),
(12, '2025-06-05', '10:58:00', 'w trakcie realizacji', 'jechać na wieś oraz zrobić zakupy'),
(13, '2025-06-05', '13:58:00', 'nie rozpoczęto zadania', 'jechać do kwiaiarni'),
(14, '2025-06-10', '14:50:00', 'w trakcie realizacji', 'dokończyć pracę ( zacząć tworzyć style oraz dołoży'),
(15, '2025-06-10', '19:15:00', 'nie rozpoczęto zadania', 'iść na zajęcia ze zdrowego kregosłupa');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `uzytkownik`
--

CREATE TABLE `uzytkownik` (
  `id` int(10) UNSIGNED NOT NULL,
  `imie` varchar(50) NOT NULL,
  `nazwisko` varchar(50) NOT NULL,
  `nick` varchar(50) NOT NULL,
  `haslo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_polish_ci;

--
-- Dumping data for table `uzytkownik`
--

INSERT INTO `uzytkownik` (`id`, `imie`, `nazwisko`, `nick`, `haslo`) VALUES
(1, 'Natalia', 'Góras', 'nati', '$2y$10$uqS5zKt8aE7avTMM3nMqCexjD8UyrkIgxdkUSavZOynFTE.vjzcne'),
(2, 'Robert', 'Perzanowski', 'roki', '222'),
(4, 'Marta', 'Grudzień', 'soltys', '333'),
(5, 'a', 'a', 'a', '$2a$10$7ZuaaaQWuNmmrhogDAboGej14LrHTPWdFysb8JOuTtQsU1PC1FEw.');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `zadania`
--

CREATE TABLE `zadania` (
  `id` int(10) UNSIGNED NOT NULL,
  `id_uzytkownika` int(10) UNSIGNED NOT NULL,
  `nazwa` varchar(50) NOT NULL,
  `piorytet` int(11) NOT NULL,
  `kategoria` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_polish_ci;

--
-- Dumping data for table `zadania`
--

INSERT INTO `zadania` (`id`, `id_uzytkownika`, `nazwa`, `piorytet`, `kategoria`) VALUES
(1, 1, 'zadanie WWW', 7, 'studia'),
(4, 1, 'pomoc babci', 6, 'Rodzina'),
(6, 1, 'Egzamin Matematyka', 7, 'Studia'),
(8, 1, 'paznokcie', 8, 'uroda'),
(11, 1, 'Oddać pracę WWW', 1, 'studia'),
(12, 1, 'Pomoc babci', 6, 'rodzina'),
(13, 1, 'praca wiacainia', 7, 'praca'),
(14, 1, 'Praca z programowania obiektowego', 7, 'Studia'),
(15, 1, 'Siłownia', 6, 'Sport'),
(16, 5, 'test', 1, 'test'),
(17, 5, 'a', 1, 'a'),
(18, 5, 'test2', 2, 'test2');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `cele`
--
ALTER TABLE `cele`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cele_ibfk_1` (`id_uzytkownika`);

--
-- Indeksy dla tabeli `szczegoly_celu`
--
ALTER TABLE `szczegoly_celu`
  ADD UNIQUE KEY `id_celu` (`id_celu`);

--
-- Indeksy dla tabeli `szczegoly_zad`
--
ALTER TABLE `szczegoly_zad`
  ADD UNIQUE KEY `id_zadania` (`id_zadania`);

--
-- Indeksy dla tabeli `uzytkownik`
--
ALTER TABLE `uzytkownik`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `zadania`
--
ALTER TABLE `zadania`
  ADD PRIMARY KEY (`id`),
  ADD KEY `zadania_ibfk_1` (`id_uzytkownika`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cele`
--
ALTER TABLE `cele`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `uzytkownik`
--
ALTER TABLE `uzytkownik`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `zadania`
--
ALTER TABLE `zadania`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cele`
--
ALTER TABLE `cele`
  ADD CONSTRAINT `cele_ibfk_1` FOREIGN KEY (`id_uzytkownika`) REFERENCES `uzytkownik` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `szczegoly_celu`
--
ALTER TABLE `szczegoly_celu`
  ADD CONSTRAINT `szczegoly_celu_ibfk_1` FOREIGN KEY (`id_celu`) REFERENCES `cele` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `szczegoly_zad`
--
ALTER TABLE `szczegoly_zad`
  ADD CONSTRAINT `szczegoly_zad_ibfk_1` FOREIGN KEY (`id_zadania`) REFERENCES `zadania` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `zadania`
--
ALTER TABLE `zadania`
  ADD CONSTRAINT `zadania_ibfk_1` FOREIGN KEY (`id_uzytkownika`) REFERENCES `uzytkownik` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
