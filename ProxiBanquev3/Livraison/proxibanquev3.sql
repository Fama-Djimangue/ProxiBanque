-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 03 Décembre 2018 à 22:11
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `proxibanquev3`
--

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

CREATE TABLE IF NOT EXISTS `clients` (
  `code_cli` bigint(20) NOT NULL AUTO_INCREMENT,
  `adresse_client` varchar(255) DEFAULT NULL,
  `email_client` varchar(255) DEFAULT NULL,
  `nom_client` varchar(255) DEFAULT NULL,
  `profession_client` varchar(255) DEFAULT NULL,
  `employe_code_employer` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`code_cli`),
  KEY `FK3knnljvb5blepki0440712quq` (`employe_code_employer`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Contenu de la table `clients`
--

INSERT INTO `clients` (`code_cli`, `adresse_client`, `email_client`, `nom_client`, `profession_client`, `employe_code_employer`) VALUES
(1, 'Sicap Sacré coeur rue 10', 'bamba@yahoo.fr', 'Bamba Kasse', 'Journaliste', 2),
(2, 'Pikine Tally bou mack', 'awadiop@hotmail.fr', 'Awa Mbaye Diop', 'Commercante', 2),
(3, 'Dieuppeul 2 villa 786', 'khady@yahoo.fr', 'Khady Kamara', 'Comptable', 2),
(4, 'Sicap Mbao', 'elimane@gmail.com', 'Elimane Ndiaye', 'Etudiant', 2),
(5, 'Cité millionnaire villa 508', 'idabo@yahoo.fr', 'Ibrahima Dabo', 'Formateur', 4),
(6, 'Colobane cité port villa 89', 'mkane@hotmail.fr', 'Amadou Kane', 'informaticien', 4),
(7, 'grand yoff rue 5', 'assdiop@gmail.com', 'Aissatou Dio', 'Assistante de direction', 4),
(8, 'Guédiaway sud', 'mouhamed12@yahoo.fr', 'Mouhamed Ly', 'Technicien mécanique', 4),
(9, 'Pikine icotaf villa 456', 'nabou@gmail.com', 'Seynabou ly', 'couturiére', 1),
(10, 'Guinaw raye', 'amsow@yahoo.fr', 'Amadou sow', 'Menusier', 1),
(11, 'Cité Diamalaye', 'nafy@hotmail.fr', 'Nafissatou Sidibé', 'Économiste', 1),
(12, 'Castor villa 309', 'mfaye@gmail.com', 'Mouhamadou Faye', 'Comptable', 1);

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE IF NOT EXISTS `compte` (
  `type_cpte` varchar(31) NOT NULL,
  `id_compte` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_creation` datetime DEFAULT NULL,
  `numero_compte` varchar(255) DEFAULT NULL,
  `solde` double NOT NULL,
  `decouvert` double DEFAULT NULL,
  `taux` double DEFAULT NULL,
  `client_code_cli` bigint(20) DEFAULT NULL,
  `employe_code_employer` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_compte`),
  KEY `FK4awmw4rmrhgse2qa63u0uxter` (`client_code_cli`),
  KEY `FKtmyn3y2sxno9ixttl73x28mg6` (`employe_code_employer`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Contenu de la table `compte`
--

INSERT INTO `compte` (`type_cpte`, `id_compte`, `date_creation`, `numero_compte`, `solde`, `decouvert`, `taux`, `client_code_cli`, `employe_code_employer`) VALUES
('EPARGNE', 1, '2018-12-03 16:36:51', '0000001Epa', 30000, NULL, 2.5, 1, 2),
('COURANT', 2, '2018-12-03 16:36:51', '0000002Cou', 10000, 1000, NULL, 1, 2),
('EPARGNE', 3, '2018-12-03 16:38:11', '0000003Epa', 65000, NULL, 2.5, 2, 2),
('COURANT', 4, '2018-12-03 16:39:25', '0000004Cou', 20000, 1000, NULL, 3, 2),
('EPARGNE', 5, '2018-12-03 16:40:29', '0000005Epa', 10000, NULL, 2.5, 4, 2),
('EPARGNE', 6, '2018-12-03 16:45:06', '0000006Epa', 110000, NULL, 2.5, 5, 4),
('COURANT', 7, '2018-12-03 16:45:06', '0000007Cou', 55000, 0, NULL, 5, 4),
('COURANT', 8, '2018-12-03 16:46:27', '0000008Cou', 10000, 1000, NULL, 6, 4),
('EPARGNE', 9, '2018-12-03 16:48:19', '0000009Epa', 10000, NULL, 2.5, 7, 4),
('EPARGNE', 10, '2018-12-03 16:49:40', '0000010Epa', 10000, NULL, 2.5, 8, 4),
('COURANT', 11, '2018-12-03 16:49:40', '0000011Cou', 10000, 1000, NULL, 8, 4),
('EPARGNE', 12, '2018-12-03 16:57:14', '0000012Epa', 40000, NULL, 2.5, 9, 1),
('EPARGNE', 13, '2018-12-03 16:59:07', '0000013Epa', 115000, NULL, 2.5, 10, 1),
('EPARGNE', 14, '2018-12-03 17:00:20', '0000014Epa', 10000, NULL, 2.5, 11, 1),
('COURANT', 15, '2018-12-03 17:00:20', '0000015Cou', 10000, 1000, NULL, 11, 1),
('EPARGNE', 16, '2018-12-03 17:01:08', '0000016Epa', 10000, NULL, 2.5, 12, 1),
('COURANT', 17, '2018-12-03 17:01:08', '0000017Cou', 10000, 1000, NULL, 12, 1);

-- --------------------------------------------------------

--
-- Structure de la table `compte_liste_operations`
--

CREATE TABLE IF NOT EXISTS `compte_liste_operations` (
  `compte_id_compte` bigint(20) NOT NULL,
  `liste_operations_id_operation` bigint(20) NOT NULL,
  KEY `FKr3ohyuijafuc5bfxih60h5155` (`liste_operations_id_operation`),
  KEY `FK8q4gbv8i5n7jvs5ia631eic1a` (`compte_id_compte`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `compte_liste_operations`
--

INSERT INTO `compte_liste_operations` (`compte_id_compte`, `liste_operations_id_operation`) VALUES
(4, 4),
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(3, 5),
(3, 6),
(3, 7),
(12, 8),
(12, 9),
(12, 10),
(13, 11),
(13, 12),
(13, 13),
(6, 14),
(6, 15),
(7, 16),
(7, 17),
(7, 18);

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

CREATE TABLE IF NOT EXISTS `employe` (
  `type_emp` varchar(31) NOT NULL,
  `code_employer` bigint(20) NOT NULL AUTO_INCREMENT,
  `adresse_employer` varchar(255) DEFAULT NULL,
  `email_employer` varchar(255) DEFAULT NULL,
  `nom_employer` varchar(255) DEFAULT NULL,
  `prenom_employer` varchar(255) DEFAULT NULL,
  `tel_employer` varchar(255) DEFAULT NULL,
  `code_gerent` bigint(20) DEFAULT NULL,
  `code_user` varchar(255) DEFAULT NULL,
  `code_admin` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`code_employer`),
  KEY `FKo0joq76d3ilnhqadb7b7o43d0` (`code_gerent`),
  KEY `FKb7e7vdsi1qg2eudb4bfy8o9q9` (`code_user`),
  KEY `FKt8y8764a3afgxra6d2ys07wy3` (`code_admin`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `employe`
--

INSERT INTO `employe` (`type_emp`, `code_employer`, `adresse_employer`, `email_employer`, `nom_employer`, `prenom_employer`, `tel_employer`, `code_gerent`, `code_user`, `code_admin`) VALUES
('Gérent', 1, 'Yoff Virage ville 203', 'ousseynou@objis.sn', 'Sene', 'Ousseynou', '775649087', NULL, 'admin', NULL),
('Conseiller', 2, 'Golf Cité Aliou sow', 'fama@gmail.com', 'Gueye', 'Fama', '77569087', 1, 'fama', NULL),
('Conseiller', 4, 'Parcelles assainies villa 178', 'mawa@yahoo.fr', 'Diedhiou', 'Ma Awa Djimangue', '772349087', 1, 'mawa', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `operations`
--

CREATE TABLE IF NOT EXISTS `operations` (
  `id_operation` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_operation` datetime DEFAULT NULL,
  `montant` double NOT NULL,
  `numero_operation` varchar(255) DEFAULT NULL,
  `type_operation` varchar(255) DEFAULT NULL,
  `code_emp` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_operation`),
  KEY `FK293goou09mrmn60vqtlxmj62` (`code_emp`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

--
-- Contenu de la table `operations`
--

INSERT INTO `operations` (`id_operation`, `date_operation`, `montant`, `numero_operation`, `type_operation`, `code_emp`) VALUES
(1, '2018-12-03 16:41:26', 50000, '0000002Ver', 'Versement', 2),
(2, '2018-12-03 16:41:43', 15000, '0000003Ret', 'Retrait', 2),
(3, '2018-12-03 16:42:11', 5000, '0000004Ret', 'Retrait', 2),
(4, '2018-12-03 16:43:27', 10000, '0000005Vir', 'Virement', 2),
(5, '2018-12-03 18:23:53', 45000, '0000006Ver', 'Versement', 2),
(6, '2018-12-03 18:24:06', 15000, '0000007Ver', 'Versement', 2),
(7, '2018-12-03 18:24:11', 5000, '0000008Ret', 'Retrait', 2),
(8, '2018-12-03 22:07:11', 25000, '0000009Ver', 'Versement', 1),
(9, '2018-12-03 22:07:28', 10000, '0000010Ver', 'Versement', 1),
(10, '2018-12-03 22:07:50', 5000, '0000011Ret', 'Retrait', 1),
(11, '2018-12-03 22:08:34', 100000, '0000012Ver', 'Versement', 1),
(12, '2018-12-03 22:08:43', 10000, '0000013Ver', 'Versement', 1),
(13, '2018-12-03 22:08:49', 5000, '0000014Ret', 'Retrait', 1),
(14, '2018-12-03 22:09:58', 5000, '0000015Ret', 'Retrait', 4),
(15, '2018-12-03 22:10:08', 105000, '0000016Ver', 'Versement', 4),
(16, '2018-12-03 22:10:39', 25000, '0000017Ver', 'Versement', 4),
(17, '2018-12-03 22:10:43', 30000, '0000018Ver', 'Versement', 4),
(18, '2018-12-03 22:10:48', 10000, '0000019Ret', 'Retrait', 4);

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `role` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `role`
--

INSERT INTO `role` (`role`, `description`) VALUES
('Conseiller', 'Conseiller'),
('Gerant', 'Gérant');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(255) NOT NULL,
  `actived` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`username`, `actived`, `password`) VALUES
('admin', b'1', 'admin'),
('fama', b'1', 'passer'),
('mawa', b'1', 'passer');

-- --------------------------------------------------------

--
-- Structure de la table `users_roles`
--

CREATE TABLE IF NOT EXISTS `users_roles` (
  `user_username` varchar(255) NOT NULL,
  `roles_role` varchar(255) NOT NULL,
  KEY `FK9bxfby7rpenikksf47nelxdbt` (`roles_role`),
  KEY `FK1y8kc6nr793297gijoc5t5qmx` (`user_username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `users_roles`
--

INSERT INTO `users_roles` (`user_username`, `roles_role`) VALUES
('fama', 'Conseiller'),
('admin', 'Gerant'),
('mawa', 'Conseiller');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `clients`
--
ALTER TABLE `clients`
  ADD CONSTRAINT `FK3knnljvb5blepki0440712quq` FOREIGN KEY (`employe_code_employer`) REFERENCES `employe` (`code_employer`);

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `FKtmyn3y2sxno9ixttl73x28mg6` FOREIGN KEY (`employe_code_employer`) REFERENCES `employe` (`code_employer`),
  ADD CONSTRAINT `FK4awmw4rmrhgse2qa63u0uxter` FOREIGN KEY (`client_code_cli`) REFERENCES `clients` (`code_cli`);

--
-- Contraintes pour la table `compte_liste_operations`
--
ALTER TABLE `compte_liste_operations`
  ADD CONSTRAINT `FK8q4gbv8i5n7jvs5ia631eic1a` FOREIGN KEY (`compte_id_compte`) REFERENCES `compte` (`id_compte`),
  ADD CONSTRAINT `FKr3ohyuijafuc5bfxih60h5155` FOREIGN KEY (`liste_operations_id_operation`) REFERENCES `operations` (`id_operation`);

--
-- Contraintes pour la table `employe`
--
ALTER TABLE `employe`
  ADD CONSTRAINT `FKt8y8764a3afgxra6d2ys07wy3` FOREIGN KEY (`code_admin`) REFERENCES `employe` (`code_employer`),
  ADD CONSTRAINT `FKb7e7vdsi1qg2eudb4bfy8o9q9` FOREIGN KEY (`code_user`) REFERENCES `users` (`username`),
  ADD CONSTRAINT `FKo0joq76d3ilnhqadb7b7o43d0` FOREIGN KEY (`code_gerent`) REFERENCES `employe` (`code_employer`);

--
-- Contraintes pour la table `operations`
--
ALTER TABLE `operations`
  ADD CONSTRAINT `FK293goou09mrmn60vqtlxmj62` FOREIGN KEY (`code_emp`) REFERENCES `employe` (`code_employer`);

--
-- Contraintes pour la table `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `FK1y8kc6nr793297gijoc5t5qmx` FOREIGN KEY (`user_username`) REFERENCES `users` (`username`),
  ADD CONSTRAINT `FK9bxfby7rpenikksf47nelxdbt` FOREIGN KEY (`roles_role`) REFERENCES `role` (`role`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
