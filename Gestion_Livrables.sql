-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 04 mars 2021 à 21:59
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 7.4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bd_pfe`
--

-- --------------------------------------------------------

--
-- Structure de la table `compte_rendu`
--

CREATE TABLE `compte_rendu` (
  `id_cr` int(20) NOT NULL,
  `fichier` mediumblob DEFAULT NULL,
  `validation_cr` tinyint(1) DEFAULT NULL,
  `commentaire` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `compte_rendu`
--

INSERT INTO `compte_rendu` (`id_cr`, `fichier`, `validation_cr`, `commentaire`) VALUES
(1, NULL, NULL, 'bonjour'),
(2, NULL, NULL, 'bonjour'),
(4, NULL, NULL, 'bonjour');

-- --------------------------------------------------------

--
-- Structure de la table `journal_projet`
--

CREATE TABLE `journal_projet` (
  `id_jp` int(30) NOT NULL,
  `date` date NOT NULL,
  `tache` varchar(200) NOT NULL,
  `avis` varchar(200) NOT NULL,
  `validation_jp` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `plan_travail`
--

CREATE TABLE `plan_travail` (
  `id_pt` int(20) NOT NULL,
  `backlog` varchar(1000) NOT NULL,
  `sprints` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `proposition_projet`
--

CREATE TABLE `proposition_projet` (
  `id_sujet` int(20) NOT NULL,
  `nom_sujet` varchar(255) NOT NULL,
  `cahier_charge` mediumblob NOT NULL,
  `validation_pp` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `compte_rendu`
--
ALTER TABLE `compte_rendu`
  ADD PRIMARY KEY (`id_cr`);

--
-- Index pour la table `journal_projet`
--
ALTER TABLE `journal_projet`
  ADD PRIMARY KEY (`id_jp`);

--
-- Index pour la table `plan_travail`
--
ALTER TABLE `plan_travail`
  ADD PRIMARY KEY (`id_pt`);

--
-- Index pour la table `proposition_projet`
--
ALTER TABLE `proposition_projet`
  ADD PRIMARY KEY (`id_sujet`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `compte_rendu`
--
ALTER TABLE `compte_rendu`
  MODIFY `id_cr` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `journal_projet`
--
ALTER TABLE `journal_projet`
  MODIFY `id_jp` int(30) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `plan_travail`
--
ALTER TABLE `plan_travail`
  MODIFY `id_pt` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `proposition_projet`
--
ALTER TABLE `proposition_projet`
  MODIFY `id_sujet` int(20) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
