
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
  `ID_TYPE_CLIENT` varchar(255)  DEFAULT NULL,
  `PWD_USER` varchar(100) DEFAULT NULL,
  `NOM` varchar(100) DEFAULT NULL,
  `PRENOM` varchar(100)  DEFAULT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `TELF` int(11) DEFAULT NULL,
  `EMAIL1_USED` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_CLIENT`)
) ENGINE=InnoDB;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`ID_CLIENT`, `ID_TYPE_CLIENT`, `PWD_USER`, `NOM`, `PRENOM`, `ADDRESS`, `TELF`, `EMAIL1_USED`) VALUES
(0, 'Originaire', '9999', 'client1NADANADA', 'perclient1', '555addclient1', 555, '@11C'),
(1, 'Originaire', '8888', 'client2', 'per2', 'addclient2', 2222, '@22C');

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
(0, 0, 0),
(1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `decbug`
--

DROP TABLE IF EXISTS `decbug`;
CREATE TABLE IF NOT EXISTS `decbug` (
  `ID_DECBUG` int(11) NOT NULL,
  `ID_USER` int(11) DEFAULT NULL,
  `ID_TICKET` int(11) DEFAULT NULL,
  `DATEDEBUT` date DEFAULT NULL,
  `DATEFIN` date DEFAULT NULL,
  `TITRE` varchar(100)  DEFAULT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  `ACTIVE_DECBUG` varchar(100) DEFAULT NULL,
  `RQ_ACTIVE_DECBUG` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_DECBUG`),
  KEY `FK_DECBUG_FAIRE_USER` (`ID_USER`),
  KEY `FK_DECBUG_TRANSFERE_TICKET` (`ID_TICKET`)
) ENGINE=InnoDB ;

--
-- Déchargement des données de la table `decbug`
--

INSERT INTO `decbug` (`ID_DECBUG`, `ID_USER`, `ID_TICKET`, `DATEDEBUT`, `DATEFIN`, `TITRE`, `DESCRIPTION`, `ACTIVE_DECBUG`, `RQ_ACTIVE_DECBUG`) VALUES
(0, 0, 0, '2019-10-03', '2019-11-15', 'new08', 'new08 2019', 'valide', 'RQ valide'),
(1, 1, 1, '2019-03-01', '2019-04-01', 'decbug 1', 'rq 1 decbug 1', 'valide', 'RQ valide');

-- --------------------------------------------------------

--
-- Structure de la table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
CREATE TABLE IF NOT EXISTS `ticket` (
  `ID_TICKET` int(11) NOT NULL,
  `CODE` int(11) DEFAULT NULL,
  `DATE_DEBUT_TICKET` date DEFAULT NULL,
  `DATE_DUBET_TICKET` date DEFAULT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  `ACTIVE_TICKET` varchar(100)  DEFAULT NULL,
  `RQ_ACTIVE_TICKET` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_TICKET`)
) ENGINE=InnoDB ;

--
-- Déchargement des données de la table `ticket`
--

INSERT INTO `ticket` (`ID_TICKET`, `CODE`, `DATE_DEBUT_TICKET`, `DATE_DUBET_TICKET`, `DESCRIPTION`, `ACTIVE_TICKET`, `RQ_ACTIVE_TICKET`) VALUES
(0, 0, '2019-01-01', '2019-02-01', ' ticket 1', 'valide', 'RQ valide'),
(1, 1, '2019-02-01', '2019-03-01', ' ticket 2', 'valide', 'RQ valide');

-- --------------------------------------------------------

--
-- Structure de la table `type_client`
--

DROP TABLE IF EXISTS `type_client`;
CREATE TABLE IF NOT EXISTS `type_client` (
  `ID_TYPE_CLIENT` varchar(255)  NOT NULL,
  PRIMARY KEY (`ID_TYPE_CLIENT`)
) ENGINE=InnoDB ;

--
-- Déchargement des données de la table `type_client`
--

INSERT INTO `type_client` (`ID_TYPE_CLIENT`) VALUES
('Originaire');

-- --------------------------------------------------------

--
-- Structure de la table `type_user`
--

DROP TABLE IF EXISTS `type_user`;
CREATE TABLE IF NOT EXISTS `type_user` (
  `ID_TYPE_USER` varchar(255)  NOT NULL,
  PRIMARY KEY (`ID_TYPE_USER`)
) ENGINE=InnoDB ;

--
-- Déchargement des données de la table `type_user`
--

INSERT INTO `type_user` (`ID_TYPE_USER`) VALUES
('Administrateur'),
('Developer'),
('Support-client');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `ID_USER` int(11) NOT NULL,
  `ID_TYPE_USER` varchar(255)  DEFAULT NULL,
  `PWD_USER` varchar(255)  DEFAULT NULL,
  `NAME_USED_AR` varchar(255)  DEFAULT NULL,
  `FIRST_NAME_USED_AR` varchar(255)  DEFAULT NULL,
  `TELF_USED_PERS` int(11) DEFAULT NULL,
  `SEX_USED` varchar(255)  DEFAULT NULL,
  `EMAIL1_USED` varchar(255)  DEFAULT NULL,
  `ADDRESS1_USED` varchar(255)  DEFAULT NULL,
  PRIMARY KEY (`ID_USER`)
) ENGINE=InnoDB ;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`ID_USER`, `ID_TYPE_USER`, `PWD_USER`, `NAME_USED_AR`, `FIRST_NAME_USED_AR`, `TELF_USED_PERS`, `SEX_USED`, `EMAIL1_USED`, `ADDRESS1_USED`) VALUES
(0, 'Admin', '9090', 'NEWNOM', 'PRENEW', 547878, 'Mâle', '@NEW', 'AFEH'),
(1, 'Admin', '0000', 'nada', 'mekki', 54208189, 'Male', 'nada.mekki@gmail.com', 'add1'),
(2, 'Developer', '2222', 'nom2', 'per2', 2222, 'Female', '@22D', 'ADDTITO'),
(3, 'Support-client', '3333', 'NOM33', 'PRE33', 3333, 'Male', '@33S', 'ADD TOTO');

--
-- Contraintes pour les tables déchargées
--

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
COMMIT;
