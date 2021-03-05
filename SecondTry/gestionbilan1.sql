-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 05 mars 2021 à 03:34
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 7.4.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestionbilan1`
--

-- --------------------------------------------------------

--
-- Structure de la table `debutstage`
--

CREATE TABLE `debutstage` (
  `Id_Debut` int(11) NOT NULL,
  `Motivation` varchar(255) NOT NULL,
  `Situation` varchar(255) NOT NULL,
  `Problematique` varchar(255) NOT NULL,
  `apprentissages` varchar(255) NOT NULL,
  `Deadline` varchar(255) NOT NULL,
  `Talents` varchar(255) NOT NULL,
  `Ex1` varchar(255) NOT NULL,
  `Equipe` varchar(255) NOT NULL,
  `Ex2` varchar(255) NOT NULL,
  `Autonomie` varchar(255) NOT NULL,
  `Ex3` varchar(255) NOT NULL,
  `Resistance` varchar(255) NOT NULL,
  `Ex4` varchar(255) NOT NULL,
  `Organisation` varchar(255) NOT NULL,
  `Ex5` varchar(255) NOT NULL,
  `Initiative` varchar(255) NOT NULL,
  `Ex6` varchar(255) NOT NULL,
  `Qualite` varchar(255) NOT NULL,
  `Ex7` varchar(255) NOT NULL,
  `Contact` varchar(255) NOT NULL,
  `Moyen` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `debutstage`
--
ALTER TABLE `debutstage`
  ADD PRIMARY KEY (`Id_Debut`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `debutstage`
--
ALTER TABLE `debutstage`
  MODIFY `Id_Debut` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
