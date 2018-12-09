-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mar 27 Novembre 2018 à 16:14
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `proxibanquev2`
--

-- --------------------------------------------------------

--
-- Structure de la table `agence`
--

CREATE TABLE IF NOT EXISTS `agence` (
  `id_agence` bigint(20) NOT NULL AUTO_INCREMENT,
  `libelle_agence` varchar(255) DEFAULT NULL,
  `numero_identification` varchar(255) DEFAULT NULL,
  `date_creation` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id_agence`),
  UNIQUE KEY `id_agence` (`id_agence`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `agence`
--

INSERT INTO `agence` (`id_agence`, `libelle_agence`, `numero_identification`, `date_creation`) VALUES
(1, 'JOKKOLABS', 'A1JOK', '2016-11-07 00:00:00'),
(2, 'CTIC', 'A2CTI', '2016-11-07 00:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `carte`
--

CREATE TABLE IF NOT EXISTS `carte` (
  `id_carte` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_carte` varchar(255) NOT NULL,
  `solde_carte` double NOT NULL,
  `date_activation` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `date_desactivation` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `id_client` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_carte`),
  UNIQUE KEY `id_carte` (`id_carte`),
  KEY `FK_carte_client` (`id_client`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `id_client` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom_client` varchar(255) NOT NULL,
  `prenom_client` varchar(255) NOT NULL,
  `email_client` varchar(255) NOT NULL,
  `adresse_client` varchar(255) NOT NULL,
  `code_postal` varchar(255) NOT NULL,
  `ville_client` varchar(255) NOT NULL,
  `telephone_client` varchar(255) NOT NULL,
  `profession_client` varchar(255) NOT NULL,
  `id_conseiller` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_client`),
  UNIQUE KEY `id_client` (`id_client`),
  KEY `FK__employer` (`id_conseiller`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`id_client`, `nom_client`, `prenom_client`, `email_client`, `adresse_client`, `code_postal`, `ville_client`, `telephone_client`, `profession_client`, `id_conseiller`) VALUES
(1, 'SY', 'Birente', 'birentesy@objis.sn', 'DK-221', 'DK-221', 'Dakar', '773450917', 'Informaticien/Développeur', 3),
(2, 'DABO', 'Ibrahima', 'idabo@objis.sn', 'MB-221', 'MB-221', 'Mboro', '762093456', 'Informaticien/Développeur', 3),
(3, 'LAWSON', 'Fabrice', 'flawson@objis.sn', 'PIKINE', 'PK-221', 'PIKINE', '706391743', 'Informaticien/Développeur', 3),
(4, 'FALL', 'Fallou', 'ffall@objis.sn', 'KAOLACK', 'KK-221', 'KAOLACK', '779350284', 'Informaticien/Développeur', 4),
(5, 'DIAO', 'Adama', 'adiao@objis.sn', 'KL-221', 'KL-221', 'KOLDA', '709486381', 'Informaticien/Développeur', 4),
(6, 'LO', 'Farry', 'flo@objis.sn', 'SA-221', 'SE-221', 'SALOUM', '784832038', 'Commerçante', 4),
(7, 'DIOP', 'Aliou', 'adiop@objis.sn', 'THIES', 'TH-221', 'THIES', '789401274', 'Informaticien/Développeur', 4),
(8, 'NDIAYE', 'Abdou', 'andiaye@objis.sn', 'ST-LOUIS', 'STL-221', 'ST-LOUIS', '778402871', 'Informaticien/Développeur', 4),
(9, 'SARR', 'Salimata', 'ssarr@objis.sn', 'MBOUR', 'MBO-221', 'MBOUR', '779392748', 'Informaticien/Développeur', 4),
(10, 'MANE', 'Inna', 'imane@objis.sn', 'PA-221', 'PA-221', 'PA', '709371938', 'Informaticien/Développeur', 3),
(11, 'SALL', 'Satou', 'ssall@objis.sn', 'PA', 'PA', 'PA', '3456768', 'Informaticien/Développeur', 3),
(12, 'RAMATA', 'Demba', 'dramata@objis.sn', 'ST-221', 'ST-221', 'ST-LOUIS', '770923486', 'Informaticien/Développeur', 3),
(13, 'PAME', 'Racky', 'rpame@objis.sn', 'DAKAR', 'DK-221', 'DAKAR', '789230471', 'Informaticien/Développeur', 4),
(14, 'AMAR', 'Saliou', 'samar@objis.sn', 'KHELCOM', 'KH-221', 'TOUBA', '760284913', 'Commerçant', 3),
(15, 'SALL', 'Amadou', 'asall@objis.sn', 'THIES', 'TH-221', 'THIES', '709382930', 'Commerçant', 4),
(16, 'Diop', 'Moussa', 'mdiop10@yahoo.fr', 'Thiaroye', '94400', 'Vitry-sur-Seine', '01898980739', 'Économiste', 3),
(17, 'Ly', 'Mouhamed', 'mly@yahoo.fr', '11 ckjp', '11 ckjp', 'pikine', '899009887676', 'commercant', 4),
(18, 'Fall', 'Abdoulaye', 'afall23@yahoo.fr', 'Sicap sacré coeur 3 villa 456', '123', 'Dakar', '0774566789', 'Chauffeur', 3),
(19, 'Sidibé', 'Khady', 'khady@gmail.com', 'rue palmier villa 107', '3456', 'Thies', '770545545', 'Assistante de direction', 3);

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE IF NOT EXISTS `compte` (
  `id_compte` bigint(20) NOT NULL AUTO_INCREMENT,
  `numero_compte` varchar(255) NOT NULL,
  `solde_compte` double NOT NULL,
  `date_ouverture` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `type_compte` varchar(255) NOT NULL,
  `date_fermeture` timestamp NULL DEFAULT NULL,
  `taux_remuneration` double NOT NULL,
  `decouvert` double NOT NULL,
  `id_client` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_compte`),
  UNIQUE KEY `id_compte` (`id_compte`),
  KEY `FK__client` (`id_client`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=39 ;

--
-- Contenu de la table `compte`
--

INSERT INTO `compte` (`id_compte`, `numero_compte`, `solde_compte`, `date_ouverture`, `type_compte`, `date_fermeture`, `taux_remuneration`, `decouvert`, `id_client`) VALUES
(1, '0000001EPA', 30000, '2017-04-17 22:23:25', 'EPARGNE', NULL, 0.3, 0, 1),
(2, '0000002COU', 500000, '2018-03-11 17:07:18', 'COURANT', NULL, 0, 1000, 2),
(3, '0000003COU', 14500, '2017-04-13 16:10:57', 'COURANT', NULL, 0, 1000, 3),
(4, '0000004EPA', 5000, '2018-11-27 14:56:35', 'EPARGNE', NULL, 0.3, 0, 4),
(5, '0000005COU', 10500, '2017-04-13 16:10:57', 'COURANT', NULL, 0, 1000, 4),
(6, '0000006EPA', 14700, '2017-04-18 17:32:38', 'EPARGNE', NULL, 0.3, 0, 5),
(7, '0000007COU', 0, '2017-04-12 12:33:54', 'COURANT', NULL, 0, 1000, 6),
(8, '0000008EPA', 0, '2017-04-10 16:34:02', 'EPARGNE', NULL, 0.3, 0, 7),
(9, '0000009EPA', 0, '2017-04-05 20:39:20', 'EPARGNE', NULL, 0.3, 0, 8),
(10, '0000010COU', 0, '2017-04-10 16:34:02', 'COURANT', NULL, 0, 1000, 8),
(11, '0000011EPA', 0, '2017-04-05 21:13:34', 'EPARGNE', NULL, 0.3, 0, 9),
(12, '0000012COU', 0, '2017-04-06 07:10:29', 'COURANT', NULL, 0, 1000, 10),
(13, '0000013EPA', 0, '2017-04-07 07:33:09', 'EPARGNE', NULL, 0.3, 0, 11),
(14, '0000014COU', 0, '2017-04-07 07:39:08', 'COURANT', NULL, 0, 1000, 12),
(15, '0000015COU', 0, '2017-04-07 07:49:27', 'COURANT', NULL, 0, 1000, 13),
(16, '0000016EPA', 0, '2017-04-09 16:02:13', 'EPARGNE', NULL, 0.3, 0, 14),
(17, '0000017COU', 0, '2017-04-09 16:02:13', 'COURANT', NULL, 0, 1000, 14),
(18, '0000018COU', 498000, '2017-12-04 12:04:11', 'COURANT', NULL, 0, 1000, 1),
(19, '0000019EPA', 0, '2017-04-09 18:11:35', 'EPARGNE', NULL, 0.3, 0, 12),
(20, '0000020EPA', 5000, '2017-04-18 17:15:26', 'EPARGNE', NULL, 0.3, 0, 6),
(21, '0000021EPA', 0, '2017-04-09 18:13:59', 'EPARGNE', NULL, 0.3, 0, 13),
(22, '0000022COU', 1300, '2017-04-13 16:00:46', 'COURANT', NULL, 0, 1000, 5),
(23, '0000023COU', 0, '2017-04-10 13:43:37', 'COURANT', NULL, 0, 1000, 7),
(25, '0000024COU', 0, '2017-04-10 14:23:11', 'COURANT', NULL, 0, 1000, 15),
(26, '0000026EPA', 0, '2017-04-17 21:54:12', 'EPARGNE', NULL, 0.3, 0, 3),
(27, '0000027EPA', 0, '2017-04-18 15:55:09', 'EPARGNE', NULL, 0.3, 0, 16),
(28, '0000028COU', 0, '2017-04-18 15:57:15', 'COURANT', NULL, 0, 1000, 16),
(29, '0000029EPA', 0, '2017-04-18 16:35:41', 'EPARGNE', NULL, 0.3, 0, 10),
(30, '0000030COU', 0, '2017-04-18 16:36:54', 'COURANT', NULL, 0, 1000, 9),
(31, '0000031EPA', 0, '2017-04-18 16:42:16', 'EPARGNE', NULL, 0.3, 0, 15),
(32, '0000032EPA', 200000, '2017-12-04 12:04:11', 'EPARGNE', NULL, 0.3, 0, 2),
(33, '0000033EPA', 0, '2017-04-18 17:03:56', 'EPARGNE', NULL, 0.3, 0, 2),
(34, '0000034COU', 10000, '2017-04-18 17:15:26', 'COURANT', NULL, 0, 1000, 17),
(35, '0000035EPA', 0, '2017-04-18 17:10:30', 'EPARGNE', NULL, 0.3, 0, 17),
(36, '0000036EPA', 0, '2018-11-27 14:08:13', 'EPARGNE', NULL, 0.3, 0, 18),
(37, '0000037COU', 0, '2018-11-27 14:08:13', 'COURANT', NULL, 0, 1000, 18),
(38, '0000038COU', 0, '2018-11-27 15:05:41', 'COURANT', NULL, 0, 1000, 19);

-- --------------------------------------------------------

--
-- Structure de la table `compteutilisateur`
--

CREATE TABLE IF NOT EXISTS `compteutilisateur` (
  `id_compte_user` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `date_creation_user` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_compte_user`),
  UNIQUE KEY `id_compteUser` (`id_compte_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

--
-- Contenu de la table `compteutilisateur`
--

INSERT INTO `compteutilisateur` (`id_compte_user`, `login`, `password`, `date_creation_user`) VALUES
(1, 'baytam', 'admin1', '2017-03-27 17:10:50'),
(2, 'weuz', '1c142b2d01aa34e9a36bde480645a57fd69e14155dacfab5a3f9257b77fdc8d8', '2016-11-07 22:21:53'),
(3, 'fama', 'passer', '2017-03-27 17:08:34'),
(4, 'mawa', 'passer', '2017-04-03 15:00:26'),
(5, 'senabou', 'd9c7abd2f526dde65e7cf401a11fa19e17d1c45909cb13510693098e67c370f4', '2016-11-07 00:00:00'),
(6, 'douglas', 'd9c7abd2f526dde65e7cf401a11fa19e17d1c45909cb13510693098e67c370f4', '2016-11-07 00:00:00'),
(7, 'fall', 'd9c7abd2f526dde65e7cf401a11fa19e17d1c45909cb13510693098e67c370f4', '2016-11-08 18:16:13'),
(8, 'DETY', 'fb84010dd9c4efc51d2099b977093bbd71f814f33ef4c9d4d57ee4cef8ae8cf7', '2016-11-24 08:41:08'),
(9, 'DFG', '94dba585da358b9c7cabad5a7996a810c9869c4ee9133a1dd66ef34c5b2d40db', '2016-11-24 08:43:25'),
(10, 'ERYUUI', '88cc42c47ad637be65b6a81c106ea14df83b179e14da51c6d6081a1228e2d5fd', '2016-11-24 08:45:29'),
(11, 'TYUIU', '3daa687ebad543defb31817784e4798b5d5e5429e3e24ba80cda59eea8355118', '2016-11-24 08:45:55'),
(12, 'admin_db', 'admin_db', '2017-03-24 13:24:19'),
(13, 'test', 'd9c7abd2f526dde65e7cf401a11fa19e17d1c45909cb13510693098e67c370f4', '2017-03-27 18:53:24'),
(14, 'TEST2', 'd9c7abd2f526dde65e7cf401a11fa19e17d1c45909cb13510693098e67c370f4', '2017-03-28 07:01:29'),
(15, 'bsy', 'd9c7abd2f526dde65e7cf401a11fa19e17d1c45909cb13510693098e67c370f4', '2017-03-28 14:13:46'),
(16, 'rlo', 'd9c7abd2f526dde65e7cf401a11fa19e17d1c45909cb13510693098e67c370f4', '2017-03-28 14:19:09'),
(17, 'rlo', 'd9c7abd2f526dde65e7cf401a11fa19e17d1c45909cb13510693098e67c370f4', '2017-03-28 14:22:09'),
(18, 'idiop', 'd9c7abd2f526dde65e7cf401a11fa19e17d1c45909cb13510693098e67c370f4', '2017-03-28 14:25:25');

-- --------------------------------------------------------

--
-- Structure de la table `employer`
--

CREATE TABLE IF NOT EXISTS `employer` (
  `id_employer` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom_employer` varchar(255) NOT NULL,
  `prenom_employer` varchar(255) NOT NULL,
  `email_employer` varchar(255) NOT NULL,
  `adresse_employer` varchar(255) NOT NULL,
  `code_postal` varchar(255) NOT NULL,
  `ville_employer` varchar(255) NOT NULL,
  `telephone_employer` varchar(255) NOT NULL,
  `type_employer` varchar(255) NOT NULL,
  `id_compteUser` bigint(20) DEFAULT NULL,
  `idAgence` bigint(20) DEFAULT NULL,
  `id_gerant` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_employer`),
  UNIQUE KEY `id_employer` (`id_employer`),
  KEY `FK_employer_compteutilisateur` (`id_compteUser`),
  KEY `FK_employer_agence` (`idAgence`),
  KEY `FK_employer_employer` (`id_gerant`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Contenu de la table `employer`
--

INSERT INTO `employer` (`id_employer`, `nom_employer`, `prenom_employer`, `email_employer`, `adresse_employer`, `code_postal`, `ville_employer`, `telephone_employer`, `type_employer`, `id_compteUser`, `idAgence`, `id_gerant`) VALUES
(1, 'Tamsir', 'WADE', 'twade@objis.sn', 'Ouest Foire', '00221', 'Dakar', '772340956', 'GAG', 1, 1, NULL),
(2, 'SENE', 'Ousseynou', 'osene@objis.sn', 'Grand Dakar', '00221', 'Dakar', '775092834', 'GAG', 2, 2, NULL),
(3, 'Gueye', 'Fama', 'fama@objis.sn', 'Golf Cite Aliou sow', '1234', 'Guediawaye', '770102570', 'CCL', 3, NULL, 1),
(4, 'Diedhiou', 'Mawa', 'mawa@objis.sn', 'Parcelles Assainies', '00221', 'Dakar', '774568112', 'CCL', 4, NULL, 1),
(5, 'Badji', 'Senabou', 'badji@objis.sn', 'Yoff plage', '00221', 'Dakar', '776590876', 'CCL', 5, NULL, 2),
(6, 'Mbiandou', 'Douglas', 'douglas@objis.sn', 'Place Bellecour', '00336', 'Lyon', '003367890245', 'ADMIN', 6, NULL, 2),
(7, 'FALL', 'Fatima', 'ffall@yahoo.fr', 'Nord Foire', '00221', 'Dakar', '775021345', 'CCL', 7, NULL, 1),
(8, 'TALL', 'Racky', 'rtall@objis.sn', 'Pikne', '5790', 'Pikne', '467890', 'CCL', 8, NULL, 1),
(9, 'AERTY', 'ZERTY', 'RTRYU', 'ERTUY', '3568', 'DYUI', '2354679', 'CCL', 9, NULL, 1),
(10, 'ZRTYU', 'ERTYUY', 'EZRUI', 'REYUIO', '4578990', 'ERRTUI', '436789', 'CCL', 10, NULL, 1),
(11, 'SuperAdmin', 'SuperAdmin', 'SuperAdmin@gmail.com', 'DK_SuperAdmin', 'DK_221', 'DAKAR', '775432098', 'SuperAdmin', 12, NULL, NULL),
(12, 'TTYRY', 'RDRGR', 'ER', 'HTR', '345', 'ERTYRY', '355', 'CCL', NULL, NULL, NULL),
(13, 'ZR', 'DFGG', 'RTUY', 'TTYU', 'F67', 'TRYUI', '5678', 'CCL', NULL, NULL, NULL),
(14, 'SY', 'Birente', 'Birente@objis.sn', 'Dakar', 'ZE-32', 'Dakar', '54678', 'CCL', NULL, NULL, NULL),
(15, 'LO', 'Rama', 'rama@objis.sn', 'PA', 'AZ-45', 'Dakar', '346890', 'CCL', NULL, NULL, NULL),
(16, 'DIOP', 'Ibou', 'ibou@yahoo.fr', 'dk', 'ZE-43', 'dakar', '5678', 'CCL', 18, NULL, 1);

-- --------------------------------------------------------

--
-- Structure de la table `transaction`
--

CREATE TABLE IF NOT EXISTS `transaction` (
  `id_transact` bigint(20) NOT NULL AUTO_INCREMENT,
  `numero_transact` varchar(255) NOT NULL,
  `date_transact` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `montant_transact` double NOT NULL,
  `type_transact` varchar(255) NOT NULL,
  `solde_avant` bigint(20) DEFAULT NULL,
  `solde_apres` bigint(20) DEFAULT NULL,
  `solde_avant_cred` bigint(20) DEFAULT NULL,
  `solde_apres_cred` bigint(20) DEFAULT NULL,
  `id_employer` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_transact`),
  UNIQUE KEY `id_transact` (`id_transact`),
  KEY `FK_transaction_employer` (`id_employer`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=29 ;

--
-- Contenu de la table `transaction`
--

INSERT INTO `transaction` (`id_transact`, `numero_transact`, `date_transact`, `montant_transact`, `type_transact`, `solde_avant`, `solde_apres`, `solde_avant_cred`, `solde_apres_cred`, `id_employer`) VALUES
(1, '0000001DEP', '2017-04-12 22:13:31', 1000, 'DEPOT', 0, 1000, 0, 0, 4),
(2, '0000002VIR', '2017-04-12 22:14:00', 1000, 'VIREMENT', 1000, 0, 0, 1000, 4),
(3, '0000003DEP', '2017-04-12 22:16:48', 5000, 'DEPOT', 0, 5000, 0, 0, 4),
(4, '0000004DEP', '2017-04-12 22:22:50', 1000, 'DEPOT', 5000, 6000, 0, 0, 4),
(5, '0000005DEP', '2017-04-13 07:21:14', 10000, 'DEPOT', 0, 10000, 0, 0, 4),
(6, '0000006RET', '2017-04-13 07:21:26', 5000, 'RETRAIT', 10000, 5000, 0, 0, 4),
(7, '0000007VIR', '2017-04-13 07:22:07', 5500, 'VIREMENT', 5000, -500, 0, 5500, 4),
(8, '0000008DEP', '2017-04-13 15:54:00', 10000, 'DEPOT', 0, 10000, 0, 0, 4),
(9, '0000009RET', '2017-04-13 16:00:07', 200, 'RETRAIT', -500, -700, 0, 0, 4),
(10, '0000010DEP', '2017-04-13 16:00:46', 2000, 'DEPOT', -700, 1300, 0, 0, 4),
(11, '0000011DEP', '2017-04-13 16:08:47', 20000, 'DEPOT', 0, 20000, 0, 0, 3),
(12, '0000012RET', '2017-04-13 16:08:59', 500, 'RETRAIT', 20000, 19500, 0, 0, 3),
(13, '0000013VIR', '2017-04-13 16:10:57', 5000, 'VIREMENT', 19500, 14500, 5500, 10500, 3),
(14, '0000014DEP', '2017-04-13 16:53:30', 100, 'DEPOT', 6000, 6100, 0, 0, 4),
(15, '0000015RET', '2017-04-13 16:53:43', 200, 'RETRAIT', 6100, 5900, 0, 0, 4),
(16, '0000016RET', '2017-04-17 22:23:10', 1000, 'RETRAIT', 1000, 0, 0, 0, 3),
(17, '0000017DEP', '2017-04-17 22:23:25', 30000, 'DEPOT', 0, 30000, 0, 0, 3),
(18, '0000018DEP', '2017-04-18 17:13:44', 25000, 'DEPOT', 0, 25000, 0, 0, 4),
(19, '0000019RET', '2017-04-18 17:14:00', 10000, 'RETRAIT', 25000, 15000, 0, 0, 4),
(20, '0000020VIR', '2017-04-18 17:15:26', 5000, 'VIREMENT', 15000, 10000, 0, 5000, 4),
(21, '0000021DEP', '2017-04-18 17:32:26', 5000, 'DEPOT', 10000, 15000, 0, 0, 4),
(22, '0000022RET', '2017-04-18 17:32:38', 300, 'RETRAIT', 15000, 14700, 0, 0, 4),
(23, '0000023DEP', '2017-12-04 11:26:44', 500000, 'DEPOT', 0, 500000, 0, 0, 3),
(24, '0000024DEP', '2017-12-04 11:27:24', 200000, 'DEPOT', 500000, 700000, 0, 0, 3),
(25, '0000025RET', '2017-12-04 11:27:37', 2000, 'RETRAIT', 700000, 698000, 0, 0, 3),
(26, '0000026VIR', '2017-12-04 12:04:11', 200000, 'VIREMENT', 698000, 498000, 0, 200000, 3),
(27, '0000027DEP', '2018-03-11 17:07:18', 500000, 'DEPOT', 0, 500000, 0, 0, 3),
(28, '0000028RET', '2018-11-27 14:56:36', 900, 'RETRAIT', 5900, 5000, 0, 0, 4);

-- --------------------------------------------------------

--
-- Structure de la table `transact_compte`
--

CREATE TABLE IF NOT EXISTS `transact_compte` (
  `id_transact` bigint(20) NOT NULL,
  `id_compte_debiter` bigint(20) DEFAULT NULL,
  `id_compte_crediter` bigint(20) DEFAULT NULL,
  KEY `id_transact` (`id_transact`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `transact_compte`
--

INSERT INTO `transact_compte` (`id_transact`, `id_compte_debiter`, `id_compte_crediter`) VALUES
(1, NULL, 4),
(2, 4, 1),
(3, NULL, 4),
(4, NULL, 4),
(5, NULL, 22),
(6, 22, NULL),
(7, 22, 5),
(8, NULL, 6),
(9, 22, NULL),
(10, NULL, 22),
(11, NULL, 3),
(12, 3, NULL),
(13, 3, 5),
(14, NULL, 4),
(15, 4, NULL),
(16, 1, NULL),
(17, NULL, 1),
(18, NULL, 34),
(19, 34, NULL),
(20, 34, 20),
(21, NULL, 6),
(22, 6, NULL),
(23, NULL, 18),
(24, NULL, 18),
(25, 18, NULL),
(26, 18, 32),
(27, NULL, 2),
(28, 4, NULL);

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `user_roles_view`
--
CREATE TABLE IF NOT EXISTS `user_roles_view` (
`login` varchar(255)
,`password` varchar(255)
,`rolename` varchar(255)
);
-- --------------------------------------------------------

--
-- Structure de la vue `user_roles_view`
--
DROP TABLE IF EXISTS `user_roles_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `user_roles_view` AS select `u`.`login` AS `login`,`u`.`password` AS `password`,`r`.`type_employer` AS `rolename` from (`compteutilisateur` `u` join `employer` `r`) where (`r`.`id_compteUser` = `u`.`id_compte_user`);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `carte`
--
ALTER TABLE `carte`
  ADD CONSTRAINT `FK_carte_client` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`);

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FK__employer` FOREIGN KEY (`id_conseiller`) REFERENCES `employer` (`id_employer`);

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `FK__client` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
