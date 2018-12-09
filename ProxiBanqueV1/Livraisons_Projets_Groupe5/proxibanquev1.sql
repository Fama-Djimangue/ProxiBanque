-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mar 08 Novembre 2016 à 21:19
-- Version du serveur :  10.1.10-MariaDB
-- Version de PHP :  7.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `proxibanquev1`
--

-- --------------------------------------------------------

--
-- Structure de la table `agence`
--

CREATE TABLE `agence` (
  `id_agence` bigint(20) NOT NULL,
  `libelle_agence` varchar(255) DEFAULT NULL,
  `numero_identification` varchar(255) DEFAULT NULL,
  `date_creation` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

CREATE TABLE `carte` (
  `id_carte` bigint(20) NOT NULL,
  `type_carte` varchar(255) NOT NULL,
  `solde_carte` double NOT NULL,
  `date_activation` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `date_desactivation` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `id_client` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id_client` bigint(20) NOT NULL,
  `nom_client` varchar(255) NOT NULL,
  `prenom_client` varchar(255) NOT NULL,
  `email_client` varchar(255) NOT NULL,
  `adresse_client` varchar(255) NOT NULL,
  `code_postal` varchar(255) NOT NULL,
  `ville_client` varchar(255) NOT NULL,
  `telephone_client` varchar(255) NOT NULL,
  `profession_client` varchar(255) NOT NULL,
  `id_conseiller` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`id_client`, `nom_client`, `prenom_client`, `email_client`, `adresse_client`, `code_postal`, `ville_client`, `telephone_client`, `profession_client`, `id_conseiller`) VALUES
(83, 'Dabo', 'Ibrahima', 'dabo@yahoo.fr', 'HLM Grd Yoff', '123', 'Dakar', '098714678', 'Informaticien', 3),
(84, 'Ndiaye', 'Waly', 'waly@gmail.com', 'allé mansour sy', '3456', 'rufisque', '0930747436', 'Manager', 3),
(85, 'Diedhiou', 'Mouhamed', 'mdied@yahoo.fr', 'cité gorgui', '234', 'Keur Massar', '0937837987932', 'Economiste', 3),
(86, 'Kane', 'Maguette', 'kanem@gmail.com', 'cité mamelle', '3567', 'Dakar', '08932077398', 'Informaticienne', 4),
(87, 'Edem', 'Julien', 'julien@yahoo.fr', 'khar yalla', '33424', 'Grand Yoff', '90329000932', 'Docteur', 4);

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `id_compte` bigint(20) NOT NULL,
  `numero_compte` varchar(255) NOT NULL,
  `solde_compte` double NOT NULL,
  `date_ouverture` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `type_compte` varchar(255) NOT NULL,
  `date_fermeture` timestamp NULL DEFAULT NULL,
  `taux_remuneration` double NOT NULL,
  `decouvert` double NOT NULL,
  `id_client` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `compte`
--

INSERT INTO `compte` (`id_compte`, `numero_compte`, `solde_compte`, `date_ouverture`, `type_compte`, `date_fermeture`, `taux_remuneration`, `decouvert`, `id_client`) VALUES
(37, '1', 0, '2016-11-08 18:12:35', 'COURANT', NULL, 0, 1000, 83),
(38, '34', 0, '2016-11-08 18:10:16', 'EPARGNE', NULL, 0.03, 0, 84),
(39, '21', 485000, '2016-11-08 18:51:50', 'COURANT', NULL, 0, 1000, 85),
(40, '5467', 10000, '2016-11-08 18:51:50', 'EPARGNE', NULL, 0.03, 0, 86),
(41, '4323', 0, '2016-11-08 18:12:07', 'COURANT', NULL, 0, 1000, 87);

-- --------------------------------------------------------

--
-- Structure de la table `compteutilisateur`
--

CREATE TABLE `compteutilisateur` (
  `id_compte_user` bigint(20) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `date_creation_user` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `compteutilisateur`
--

INSERT INTO `compteutilisateur` (`id_compte_user`, `login`, `password`, `date_creation_user`) VALUES
(1, 'baytam', '25f43b1486ad95a1398e3eeb3d83bc4010015fcc9bedb35b432e00298d5021f7', '2016-11-07 22:20:43'),
(2, 'weuz', '1c142b2d01aa34e9a36bde480645a57fd69e14155dacfab5a3f9257b77fdc8d8', '2016-11-07 22:21:53'),
(3, 'fama', 'd9c7abd2f526dde65e7cf401a11fa19e17d1c45909cb13510693098e67c370f4', '2016-11-07 00:00:00'),
(4, 'mawa', 'd9c7abd2f526dde65e7cf401a11fa19e17d1c45909cb13510693098e67c370f4', '2016-11-07 00:00:00'),
(5, 'senabou', 'd9c7abd2f526dde65e7cf401a11fa19e17d1c45909cb13510693098e67c370f4', '2016-11-07 00:00:00'),
(6, 'douglas', 'd9c7abd2f526dde65e7cf401a11fa19e17d1c45909cb13510693098e67c370f4', '2016-11-07 00:00:00'),
(7, 'fall', 'd9c7abd2f526dde65e7cf401a11fa19e17d1c45909cb13510693098e67c370f4', '2016-11-08 18:16:13');

-- --------------------------------------------------------

--
-- Structure de la table `employer`
--

CREATE TABLE `employer` (
  `id_employer` bigint(20) NOT NULL,
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
  `id_gerant` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `employer`
--

INSERT INTO `employer` (`id_employer`, `nom_employer`, `prenom_employer`, `email_employer`, `adresse_employer`, `code_postal`, `ville_employer`, `telephone_employer`, `type_employer`, `id_compteUser`, `idAgence`, `id_gerant`) VALUES
(1, 'Tamsir', 'WADE', 'twade@objis.sn', 'Ouest Foire', '00221', 'Dakar', '772340956', 'GAG', 1, 1, NULL),
(2, 'SENE', 'Ousseynou', 'osene@objis.sn', 'Grand Dakar', '00221', 'Dakar', '775092834', 'GAG', 2, 2, NULL),
(3, 'Gueye', 'Fama', 'fama@objis.sn', 'Golf Cite Aliou sow', '1234', 'Guediawaye', '770102570', 'CCL', 3, NULL, 1),
(4, 'Diedhiou', 'Mawa', 'mawa@objis.sn', 'parcelles assainies unite 24', '00221', 'Dakar', '774568112', 'CCL', 4, NULL, 1),
(5, 'Badji', 'Senabou', 'badji@objis.sn', 'Yoff plage', '00221', 'Dakar', '776590876', 'CCL', 5, NULL, 2),
(6, 'Mbiandou', 'Douglas', 'douglas@objis.sn', 'Place Bellecour', '00336', 'Lyon', '003367890245', 'CCL', 6, NULL, 2),
(7, 'FALL', 'Fatima', 'ffall@yahoo.fr', 'Foire', '00221', 'Dakar', '775021345', 'CCL', 7, NULL, 1);

-- --------------------------------------------------------

--
-- Structure de la table `transaction`
--

CREATE TABLE `transaction` (
  `id_transact` bigint(20) NOT NULL,
  `numero_transact` varchar(255) NOT NULL,
  `date_transact` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `montant_transact` double NOT NULL,
  `type_transact` varchar(255) NOT NULL,
  `id_employer` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `transaction`
--

INSERT INTO `transaction` (`id_transact`, `numero_transact`, `date_transact`, `montant_transact`, `type_transact`, `id_employer`) VALUES
(1, '3EDF1', '2016-11-08 18:50:44', 500000, 'DEPOT', NULL),
(2, '4AZR9', '2016-11-08 18:51:12', 5000, 'RETRAIT', NULL),
(3, '5POI3', '2016-11-08 18:51:50', 10000, 'VIREMENT', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `transact_compte`
--

CREATE TABLE `transact_compte` (
  `id_transact` bigint(20) NOT NULL,
  `id_compte` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `transact_compte`
--

INSERT INTO `transact_compte` (`id_transact`, `id_compte`) VALUES
(1, 39),
(2, 39),
(3, 39);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `agence`
--
ALTER TABLE `agence`
  ADD PRIMARY KEY (`id_agence`),
  ADD UNIQUE KEY `id_agence` (`id_agence`);

--
-- Index pour la table `carte`
--
ALTER TABLE `carte`
  ADD PRIMARY KEY (`id_carte`),
  ADD UNIQUE KEY `id_carte` (`id_carte`),
  ADD KEY `FK_carte_client` (`id_client`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`),
  ADD UNIQUE KEY `id_client` (`id_client`),
  ADD KEY `FK__employer` (`id_conseiller`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`id_compte`),
  ADD UNIQUE KEY `id_compte` (`id_compte`),
  ADD KEY `FK__client` (`id_client`);

--
-- Index pour la table `compteutilisateur`
--
ALTER TABLE `compteutilisateur`
  ADD PRIMARY KEY (`id_compte_user`),
  ADD UNIQUE KEY `id_compteUser` (`id_compte_user`);

--
-- Index pour la table `employer`
--
ALTER TABLE `employer`
  ADD PRIMARY KEY (`id_employer`),
  ADD UNIQUE KEY `id_employer` (`id_employer`),
  ADD KEY `FK_employer_compteutilisateur` (`id_compteUser`),
  ADD KEY `FK_employer_agence` (`idAgence`),
  ADD KEY `FK_employer_employer` (`id_gerant`);

--
-- Index pour la table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id_transact`),
  ADD UNIQUE KEY `id_transact` (`id_transact`),
  ADD KEY `FK_transaction_employer` (`id_employer`);

--
-- Index pour la table `transact_compte`
--
ALTER TABLE `transact_compte`
  ADD PRIMARY KEY (`id_transact`,`id_compte`),
  ADD KEY `FK__compte` (`id_compte`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `agence`
--
ALTER TABLE `agence`
  MODIFY `id_agence` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `carte`
--
ALTER TABLE `carte`
  MODIFY `id_carte` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id_client` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=88;
--
-- AUTO_INCREMENT pour la table `compte`
--
ALTER TABLE `compte`
  MODIFY `id_compte` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
--
-- AUTO_INCREMENT pour la table `compteutilisateur`
--
ALTER TABLE `compteutilisateur`
  MODIFY `id_compte_user` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `employer`
--
ALTER TABLE `employer`
  MODIFY `id_employer` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id_transact` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
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

--
-- Contraintes pour la table `employer`
--
ALTER TABLE `employer`
  ADD CONSTRAINT `FK_employer_agence` FOREIGN KEY (`idAgence`) REFERENCES `agence` (`id_agence`),
  ADD CONSTRAINT `FK_employer_compteutilisateur` FOREIGN KEY (`id_compteUser`) REFERENCES `compteutilisateur` (`id_compte_user`),
  ADD CONSTRAINT `FK_employer_employer` FOREIGN KEY (`id_gerant`) REFERENCES `employer` (`id_employer`);

--
-- Contraintes pour la table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `FK_transaction_employer` FOREIGN KEY (`id_employer`) REFERENCES `employer` (`id_employer`);

--
-- Contraintes pour la table `transact_compte`
--
ALTER TABLE `transact_compte`
  ADD CONSTRAINT `FK__compte` FOREIGN KEY (`id_compte`) REFERENCES `compte` (`id_compte`),
  ADD CONSTRAINT `FK__transaction` FOREIGN KEY (`id_transact`) REFERENCES `transaction` (`id_transact`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
