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
-- Base de données : `bdpfe`
--

-- --------------------------------------------------------

--
-- Structure de la table `evaluation_miparcour`
--

CREATE TABLE `evaluation_miparcour` (
  `id_ev_mi` int(6) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `ponctualite1` tinyint(1) NOT NULL,
  `ponctualite2` tinyint(1) NOT NULL,
  `commentaire1` text DEFAULT NULL,
  `integration1` tinyint(1) NOT NULL,
  `integration2` tinyint(1) NOT NULL,
  `integration3` tinyint(1) NOT NULL,
  `commentaire2` text DEFAULT NULL,
  `travail1` tinyint(1) NOT NULL,
  `travail2` tinyint(1) NOT NULL,
  `travail3` tinyint(1) NOT NULL,
  `travail4` tinyint(1) NOT NULL,
  `commentaire3` text DEFAULT NULL,
  `competence1` tinyint(1) NOT NULL,
  `competence2` tinyint(1) NOT NULL,
  `competence3` tinyint(1) NOT NULL,
  `competence4` tinyint(1) NOT NULL,
  `competence5` tinyint(1) NOT NULL,
  `competence6` tinyint(1) NOT NULL,
  `commentaire4` text DEFAULT NULL,
  `evaluation_globale` tinyint(1) NOT NULL,
  `commentaire5` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `evaluation_miparcour`
--

INSERT INTO `evaluation_miparcour` (`id_ev_mi`, `id_user`, `ponctualite1`, `ponctualite2`, `commentaire1`, `integration1`, `integration2`, `integration3`, `commentaire2`, `travail1`, `travail2`, `travail3`, `travail4`, `commentaire3`, `competence1`, `competence2`, `competence3`, `competence4`, `competence5`, `competence6`, `commentaire4`, `evaluation_globale`, `commentaire5`) VALUES
(1, NULL, 1, 0, 'test', 0, 1, 0, 's', 1, 1, 1, 1, 's', 0, 1, 1, 1, 0, 0, 's', 1, 's'),
(2, NULL, 1, 0, 'test', 0, 1, 0, 's', 1, 1, 1, 1, 's', 0, 1, 1, 1, 0, 0, 's', 1, 's'),
(3, NULL, 1, 0, 'f', 1, 0, 0, 'f', 1, 1, 0, 0, 'f', 1, 1, 1, 1, 0, 0, 'f', 1, 'd');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `evaluation_miparcour`
--
ALTER TABLE `evaluation_miparcour`
  ADD PRIMARY KEY (`id_ev_mi`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `evaluation_miparcour`
--
ALTER TABLE `evaluation_miparcour`
  MODIFY `id_ev_mi` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
