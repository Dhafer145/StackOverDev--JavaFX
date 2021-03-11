-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 11 mars 2021 à 23:54
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
-- Structure de la table `affectation`
--

CREATE TABLE `affectation` (
  `id_affectation` int(10) NOT NULL,
  `id_etudiant` int(10) NOT NULL,
  `id_encadrant_academique` int(10) NOT NULL,
  `id_encadrant_entreprise` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `bilan`
--

CREATE TABLE `bilan` (
  `idBilan` int(11) NOT NULL,
  `titre` varchar(255) NOT NULL,
  `indexPeriode` int(11) NOT NULL,
  `periode` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `bilan`
--

INSERT INTO `bilan` (`idBilan`, `titre`, `indexPeriode`, `periode`) VALUES
(1, 'Bilan periodique de debut de stage', 1, '2021-03-24'),
(2, 'Bilan periodique de milieu de stage', 2, '2020-10-20'),
(3, 'Bilan periodique de fin de stage', 3, '2021-03-09');

-- --------------------------------------------------------

--
-- Structure de la table `compte_rendu`
--

CREATE TABLE `compte_rendu` (
  `id_cr` int(20) NOT NULL,
  `fichier` varchar(400) NOT NULL,
  `validation_cr` tinyint(1) DEFAULT NULL,
  `commentaire` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `compte_rendu`
--

INSERT INTO `compte_rendu` (`id_cr`, `fichier`, `validation_cr`, `commentaire`) VALUES
(22, 'C:\\Users\\ASUS\\Desktop\\hello.txt', NULL, 'aaaaaaaaaaaaaa');

-- --------------------------------------------------------

--
-- Structure de la table `evaluation`
--

CREATE TABLE `evaluation` (
  `id` int(11) NOT NULL,
  `id_enc` int(10) DEFAULT NULL,
  `id_etu` int(10) DEFAULT NULL,
  `date_r` date NOT NULL DEFAULT current_timestamp(),
  `ponctualite` tinyint(1) NOT NULL,
  `comm1` text NOT NULL,
  `integration` tinyint(1) NOT NULL,
  `comm2` text NOT NULL,
  `travail` tinyint(1) NOT NULL,
  `comm3` text NOT NULL,
  `competence` tinyint(1) NOT NULL,
  `comm4` text NOT NULL,
  `eg` tinyint(1) NOT NULL,
  `comm5` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `evaluation`
--

INSERT INTO `evaluation` (`id`, `id_enc`, `id_etu`, `date_r`, `ponctualite`, `comm1`, `integration`, `comm2`, `travail`, `comm3`, `competence`, `comm4`, `eg`, `comm5`) VALUES
(1, 1, 1, '2021-03-11', 1, 'test', 1, 's', 1, 's', 1, 's', 1, 's'),
(2, NULL, NULL, '2021-03-11', 1, 'test1', 1, 'test1', 1, 'test1', 1, 'test1', 1, 'test1'),
(10, NULL, NULL, '2021-03-11', 1, 'test', 1, 'test', 1, 'test', 1, 'test', 1, 'test'),
(11, NULL, NULL, '2021-03-11', 0, 'f', 0, 'f', 0, 'f', 0, 'f', 0, 'f');

-- --------------------------------------------------------

--
-- Structure de la table `journal_projet`
--

CREATE TABLE `journal_projet` (
  `id_jp` int(30) NOT NULL,
  `date` varchar(20) NOT NULL,
  `tache` varchar(200) NOT NULL,
  `avis` varchar(200) NOT NULL,
  `validation_jp` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `journal_projet`
--

INSERT INTO `journal_projet` (`id_jp`, `date`, `tache`, `avis`, `validation_jp`) VALUES
(1, '18-03-2021', 'sqdqs', 'sdqs', NULL),
(2, '19/03/2021', 'df', 'sd', NULL),
(3, '17/03/2021', 'DeEEdfsqf', 'sqdsqdq', NULL),
(4, '10/03/2021', 'dsfdsdsgsdfds', 'kjsqfdkldsf', NULL),
(5, '10/03/2021', 'sqfsdgfazt', 'zrzerze', NULL),
(6, '11/03/2021', 'dhafer', 'dhafer', NULL),
(7, '09/03/2021', 'dhafer', 'dgazeza', NULL);

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
-- Structure de la table `presentation`
--

CREATE TABLE `presentation` (
  `id_p` int(20) NOT NULL,
  `non_etudiant` varchar(20) NOT NULL,
  `non_president` varchar(20) NOT NULL,
  `non_encadrant` varchar(20) NOT NULL,
  `date_soutenance` varchar(20) NOT NULL,
  `salle` varchar(20) NOT NULL
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

-- --------------------------------------------------------

--
-- Structure de la table `question`
--

CREATE TABLE `question` (
  `idQuestion` int(11) NOT NULL,
  `quest` varchar(255) NOT NULL,
  `indexPeriode` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `question`
--

INSERT INTO `question` (`idQuestion`, `quest`, `indexPeriode`) VALUES
(8, 'Qu’est-ce qui vous plaît et vous motive dans votre stage?\r\n', 1),
(9, 'Décrivez une situation de travail marquante que vous avez vécu pendant votre stage.\r\n', 1),
(10, 'Avez-vous vécu pendant votre stage une situation difficile ou problématique? Si oui,\r\ncomment avez-vous réagi ?', 1),
(11, 'Que retirez-vous comme apprentissages depuis le début de votre stage ?', 1),
(12, 'Comment gérez-vous les délais dans votre travail?', 1),
(13, 'De quelle(s) manière(s) utilisez-vous vos capacités/talents dans votre stage? Donnez un exemple concret :\r\n', 1),
(14, 'Travailler en équipe ?', 0),
(15, 'Pourquoi vous êtes-vous attribué cette note? Donnez un exemple concret :', 0),
(16, 'Être autonome ?', 0),
(17, 'Être résilient ?', 0),
(18, 'Organiser votre travail dans les délais?', 0),
(19, 'Prendre des initiatives ?', 0),
(20, 'Réaliser un travail de qualité (rigueur professionnel, être appliqué…) ?', 0),
(21, 'Souhaitez-vous me contacter pour échanger sur le déroulement de votre stage?', 0),
(22, 'Par quel moyen (par téléphone, mail, rendez-vous...)?', 0),
(23, 'Vos missions ont-elles évolué depuis le début de votre stage? Si oui, quelles sont-elles ?', 2),
(24, 'Citez une de vos réalisations dont vous êtes fier/ère :\r\n', 2),
(25, 'Comment avez-vous procédé pour mener à bien cette mission?\r\n', 2),
(26, 'Quels ont été vos défis pendant votre stage?\r\n', 2),
(27, 'Comment avez-vous réussi à les surmonter? Ou avec le recul, comment auriez-vous pu le surmonter ?', 2),
(28, 'Comment votre stage confirme-t-il ou infirme-t-il votre projet professionnel ?\r\n', 2),
(29, 'De manière générale, comment vos missions ont-elles evolué?', 3),
(30, 'Quelles ont été vos meilleures réalisations pendant votre stage? Donnez des exemples concrets?', 3),
(31, 'Quels apprentissages pouvez-vous en tirer ? \r\n', 3),
(32, 'Quelles compétences avez-vous développé pour mener à bien vos missions? Comment les avez-vous utilisées ?', 3),
(33, 'Quel bilan faites-vous de votre projet professionnel à la fin de votre stage ?', 3);

-- --------------------------------------------------------

--
-- Structure de la table `rapport_final`
--

CREATE TABLE `rapport_final` (
  `id_rf` int(20) NOT NULL,
  `plagiat` float NOT NULL,
  `fichier` mediumtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `rapport_final`
--

INSERT INTO `rapport_final` (`id_rf`, `plagiat`, `fichier`) VALUES
(1, 35.3, 'C:\\Users\\usp\\Documents\\hhhhhh.txt');

-- --------------------------------------------------------

--
-- Structure de la table `rendezvous`
--

CREATE TABLE `rendezvous` (
  `id_rv` int(11) NOT NULL,
  `login` int(11) NOT NULL,
  `lieu` varchar(20) COLLATE utf8_bin NOT NULL,
  `date` date DEFAULT NULL,
  `raison` varchar(100) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `rendezvous`
--

INSERT INTO `rendezvous` (`id_rv`, `login`, `lieu`, `date`, `raison`) VALUES
(42, 999, 'tunis', '2021-03-25', 'rapport');

-- --------------------------------------------------------

--
-- Structure de la table `reponse`
--

CREATE TABLE `reponse` (
  `idReponse` int(11) NOT NULL,
  `rep` varchar(255) NOT NULL,
  `IdQuestion` int(11) NOT NULL,
  `idUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `tache`
--

CREATE TABLE `tache` (
  `id_tache` int(10) NOT NULL,
  `libelle` varchar(70) NOT NULL,
  `id_etudiant` int(10) NOT NULL,
  `id_encadrant_academique` int(10) NOT NULL,
  `id_encadrant_entreprise` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id_user` int(10) NOT NULL,
  `user_name` varchar(30) NOT NULL,
  `full_name` varchar(30) NOT NULL,
  `email` varchar(40) NOT NULL,
  `password` varchar(100) NOT NULL,
  `confirm_password` varchar(30) NOT NULL,
  `role` varchar(30) NOT NULL,
  `address` varchar(40) NOT NULL,
  `debut_stage` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id_user`, `user_name`, `full_name`, `email`, `password`, `confirm_password`, `role`, `address`, `debut_stage`) VALUES
(90, 'abc', 'lll', 'ramzi@esprit.tn', 'f6cfe289bbfa10e1fa917b9d1a8ef547f3373e0b8e23b16446500d7c157bb0ed', 'azertyui', 'Encadrant Professionnel', 'xxxx', NULL),
(91, 'mohamed', 'mohamedali', 'med@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', '12345678', 'responsable des stages', 'ben arous', NULL),
(117, 'ramzi', 'ramzikhefifi', 'ramzikhefifi.98@gmail.com', 'e38cabdb2344801e7534bd6a65719b841ded56b7210fd318e0de6cc560bd9c05', 'ramzuss12', 'etudiant', 'nabeul', NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `affectation`
--
ALTER TABLE `affectation`
  ADD PRIMARY KEY (`id_affectation`);

--
-- Index pour la table `bilan`
--
ALTER TABLE `bilan`
  ADD PRIMARY KEY (`idBilan`);

--
-- Index pour la table `compte_rendu`
--
ALTER TABLE `compte_rendu`
  ADD PRIMARY KEY (`id_cr`);

--
-- Index pour la table `evaluation`
--
ALTER TABLE `evaluation`
  ADD PRIMARY KEY (`id`);

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
-- Index pour la table `presentation`
--
ALTER TABLE `presentation`
  ADD PRIMARY KEY (`id_p`);

--
-- Index pour la table `proposition_projet`
--
ALTER TABLE `proposition_projet`
  ADD PRIMARY KEY (`id_sujet`);

--
-- Index pour la table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`idQuestion`);

--
-- Index pour la table `rapport_final`
--
ALTER TABLE `rapport_final`
  ADD PRIMARY KEY (`id_rf`);

--
-- Index pour la table `rendezvous`
--
ALTER TABLE `rendezvous`
  ADD PRIMARY KEY (`id_rv`);

--
-- Index pour la table `reponse`
--
ALTER TABLE `reponse`
  ADD PRIMARY KEY (`idReponse`);

--
-- Index pour la table `tache`
--
ALTER TABLE `tache`
  ADD PRIMARY KEY (`id_tache`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `affectation`
--
ALTER TABLE `affectation`
  MODIFY `id_affectation` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `bilan`
--
ALTER TABLE `bilan`
  MODIFY `idBilan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `compte_rendu`
--
ALTER TABLE `compte_rendu`
  MODIFY `id_cr` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT pour la table `evaluation`
--
ALTER TABLE `evaluation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `journal_projet`
--
ALTER TABLE `journal_projet`
  MODIFY `id_jp` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `plan_travail`
--
ALTER TABLE `plan_travail`
  MODIFY `id_pt` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `presentation`
--
ALTER TABLE `presentation`
  MODIFY `id_p` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `proposition_projet`
--
ALTER TABLE `proposition_projet`
  MODIFY `id_sujet` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `question`
--
ALTER TABLE `question`
  MODIFY `idQuestion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT pour la table `rapport_final`
--
ALTER TABLE `rapport_final`
  MODIFY `id_rf` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `rendezvous`
--
ALTER TABLE `rendezvous`
  MODIFY `id_rv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT pour la table `reponse`
--
ALTER TABLE `reponse`
  MODIFY `idReponse` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `tache`
--
ALTER TABLE `tache`
  MODIFY `id_tache` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=118;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
