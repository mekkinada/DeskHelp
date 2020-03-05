-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 31 juil. 2019 à 09:50
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `deskhelp`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `ID_CLIENT` int(11) NOT NULL,
  `ID_TYPE_CLIENT` int(11) DEFAULT NULL,
  `PWD_USER` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NOM` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PRENOM` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ADDRESS` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TELF` int(11) DEFAULT NULL,
  `EMAIL1_USED` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID_CLIENT`),
   KEY `FK_CLIENT_ROLE_CLIE_TYPE_CLI` (`ID_TYPE_CLIENT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`ID_CLIENT`, `ID_TYPE_CLIENT`, `PWD_USER`, `NOM`, `PRENOM`, `ADDRESS`, `TELF`, `EMAIL1_USED`) VALUES
(0, 0, '9999', 'client1NADANADA', 'perclient1', '555addclient1', 555, '@11C');

-- --------------------------------------------------------

--
-- Structure de la table `client_decbug`
--

DROP TABLE IF EXISTS `client_decbug`;
CREATE TABLE IF NOT EXISTS `client_decbug` (
  `ID_CLIENT_DECBUG` int(11) NOT NULL AUTO_INCREMENT,
  `ID_CLIENT` int(11) DEFAULT NULL,
  `ID_DECBUG` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_CLIENT_DECBUG`),
  KEY `ID_CLIENT` (`ID_CLIENT`),
  KEY `ID_DECBUG` (`ID_DECBUG`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `client_decbug`
--

INSERT INTO `client_decbug` (`ID_CLIENT_DECBUG`, `ID_CLIENT`, `ID_DECBUG`) VALUES
(0, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `decbug`
--

DROP TABLE IF EXISTS `decbug`;
CREATE TABLE IF NOT EXISTS `decbug` (
  `ID_DECBUG` int(11) NOT NULL,
  `ID_USER` int(11) DEFAULT NULL,
  `ID_TICKET` int(11) DEFAULT NULL,
  `DATEDEBUT` datetime DEFAULT NULL,
  `DATEFIN` datetime DEFAULT NULL,
  `TITRE` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DESCRIPTION` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ACTIVE_DECBUG` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID_DECBUG`),
  KEY `FK_DECBUG_FAIRE_USER` (`ID_USER`),
  KEY `FK_DECBUG_TRANSFERE_TICKET` (`ID_TICKET`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `decbug`
--

INSERT INTO `decbug` (`ID_DECBUG`, `ID_USER`, `ID_TICKET`, `DATEDEBUT`, `DATEFIN`, `TITRE`, `DESCRIPTION`, `ACTIVE_DECBUG`) VALUES
(0, 0, 0, '2019-01-01 00:00:00', '2019-02-02 00:00:00', 'BUGNEW', 'DES 0202', 1);

-- --------------------------------------------------------

--
-- Structure de la table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
CREATE TABLE IF NOT EXISTS `ticket` (
  `ID_TICKET` int(11) NOT NULL,
  `CODE` int(11) DEFAULT NULL,
  `DATE_DEBUT_TICKET` datetime DEFAULT NULL,
  `DATE_DUBET_TICKET` datetime DEFAULT NULL,
  `DESCRIPTION` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ACTIVE_TICKET` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID_TICKET`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `ticket`
--

INSERT INTO `ticket` (`ID_TICKET`, `CODE`, `DATE_DEBUT_TICKET`, `DATE_DUBET_TICKET`, `DESCRIPTION`, `ACTIVE_TICKET`) VALUES
(0, 0, '2019-01-01 00:00:00', '2019-02-01 00:00:00', ' ticket 1', 0);

-- --------------------------------------------------------

--
-- Structure de la table `type_client`
--

DROP TABLE IF EXISTS `type_client`;
CREATE TABLE IF NOT EXISTS `type_client` (
  `ID_TYPE_CLIENT` int(11) NOT NULL,
  `LIB_TYPE_CLIENT` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID_TYPE_CLIENT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
--
-- Déchargement des données de la table `type_client`
--

INSERT INTO `type_client` (`ID_TYPE_CLIENT`, `LIB_TYPE_CLIENT`) VALUES
(0, 'Originaire');

-- --------------------------------------------------------

--
-- Structure de la table `type_user`
--

DROP TABLE IF EXISTS `type_user`;
CREATE TABLE IF NOT EXISTS `type_user` (
 `ID_TYPE_USER` int(11) NOT NULL,
 `LIB_TYPE_USER` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID_TYPE_USER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
--
-- Déchargement des données de la table `type_user`
--

INSERT INTO `type_user` (`ID_TYPE_USER`, `LIB_TYPE_USER`) VALUES
(0, 'Admin'),
(1, 'Developer'),
(2, 'Support-client');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `ID_USER` int(11) NOT NULL,
  `ID_TYPE_USER` int(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PWD_USER` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NAME_USED_AR` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `FIRST_NAME_USED_AR` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TELF_USED_PERS` int(11) DEFAULT NULL,
  `SEX_USED` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `EMAIL1_USED` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ADDRESS1_USED` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID_USER`),
   KEY `FK_USER_FK_TYPE_TYPE_USE` (`ID_TYPE_USER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`ID_USER`, `ID_TYPE_USER`, `PWD_USER`, `NAME_USED_AR`, `FIRST_NAME_USED_AR`, `TELF_USED_PERS`, `SEX_USED`, `EMAIL1_USED`, `ADDRESS1_USED`) VALUES
(0, 0, 'AA00', 'MEKKI00', 'NADA00', 0, 'Male', '@AA00NADA', 'ADD'),
(1, 1, '1111', 'nada', 'mekki', 54208189, 'Male', '@11A', 'add1'),
(2, 2, '2222', 'nom2', 'per2', 2222, 'Female', '@22D', 'ADDTITO');


--
-- Contraintes pour les tables déchargées
--


--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FK_CLIENT_ROLE_CLIE_TYPE_CLI` FOREIGN KEY (`ID_TYPE_CLIENT`) REFERENCES `type_client` (`ID_TYPE_CLIENT`) on delete restrict on update restrict;


--
-- Contraintes pour la table `client_decbug`
--
ALTER TABLE `client_decbug`
  ADD CONSTRAINT `FK_CLIENT_DECBUG` FOREIGN KEY (`ID_CLIENT`) REFERENCES `client` (`ID_CLIENT`),
  ADD CONSTRAINT `FK_DECBUG_CLIENT` FOREIGN KEY (`ID_DECBUG`) REFERENCES `decbug` (`ID_DECBUG`);

--
-- Contraintes pour la table `decbug`
--
ALTER TABLE `decbug`
  ADD CONSTRAINT `FK_DECBUG_FAIRE_USER` FOREIGN KEY (`ID_USER`) REFERENCES `user` (`ID_USER`),
  ADD CONSTRAINT `FK_DECBUG_TRANSFERE_TICKET` FOREIGN KEY (`ID_TICKET`) REFERENCES `ticket` (`ID_TICKET`);
  

--
-- Contraintes pour la table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK_USER_FK_TYPE_TYPE_USE` FOREIGN KEY (`ID_TYPE_USER`) REFERENCES `type_user` (`ID_TYPE_USER`);
COMMIT;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
