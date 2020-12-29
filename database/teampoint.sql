-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mar. 29 déc. 2020 à 12:20
-- Version du serveur :  10.4.8-MariaDB
-- Version de PHP :  7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `teampoint`
--

-- --------------------------------------------------------

--
-- Structure de la table `board`
--

CREATE TABLE `board` (
  `idBoard` int(10) NOT NULL,
  `boardName` varchar(25) NOT NULL,
  `parentWorkspace` int(10) NOT NULL,
  `boardCreationDate` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `board_contains`
--

CREATE TABLE `board_contains` (
  `idBoard` int(10) NOT NULL,
  `idItemCollection` int(10) NOT NULL,
  `idColumn` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `cell`
--

CREATE TABLE `cell` (
  `idCell` int(10) NOT NULL,
  `cellValue` varchar(25) NOT NULL,
  `idCellType` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `celltype`
--

CREATE TABLE `celltype` (
  `idCellType` int(10) NOT NULL,
  `nameType` varchar(25) NOT NULL,
  `descriptionType` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `column`
--

CREATE TABLE `column` (
  `idColumn` int(10) NOT NULL,
  `columnName` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `item`
--

CREATE TABLE `item` (
  `idItem` int(10) NOT NULL,
  `itemName` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `itemcollection`
--

CREATE TABLE `itemcollection` (
  `idItemCollection` int(10) NOT NULL,
  `itemCollectionName` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `itemcollection_contains_items`
--

CREATE TABLE `itemcollection_contains_items` (
  `idItemCollection` int(10) NOT NULL,
  `idItem` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `item_column_crossed_cell`
--

CREATE TABLE `item_column_crossed_cell` (
  `idColumn` int(10) NOT NULL,
  `idItem` int(10) NOT NULL,
  `idCell` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `idUser` int(10) NOT NULL,
  `name` varchar(25) DEFAULT NULL,
  `firstName` varchar(25) DEFAULT NULL,
  `email` varchar(25) NOT NULL,
  `password` varchar(50) NOT NULL,
  `phoneNumber` varchar(10) DEFAULT NULL,
  `profileDescription` varchar(500) DEFAULT NULL,
  `birthday` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`idUser`, `name`, `firstName`, `email`, `password`, `phoneNumber`, `profileDescription`, `birthday`) VALUES
(1, 'Nicolas', 'Galois', 'galoisnicolas@gmail.com', 'toto', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `user_as_member_of_workspace`
--

CREATE TABLE `user_as_member_of_workspace` (
  `idUser` int(10) NOT NULL,
  `idWorkspace` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `user_attendance`
--

CREATE TABLE `user_attendance` (
  `idUser` int(10) NOT NULL,
  `roleLabel` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `workspace`
--

CREATE TABLE `workspace` (
  `idWorskpace` int(10) NOT NULL,
  `workspaceName` varchar(25) NOT NULL,
  `workspaceCreationDate` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `board`
--
ALTER TABLE `board`
  ADD PRIMARY KEY (`idBoard`),
  ADD KEY `FOREIGN_PARENT_WORKSPACE` (`parentWorkspace`);

--
-- Index pour la table `board_contains`
--
ALTER TABLE `board_contains`
  ADD KEY `FOREIGN_BOARD` (`idBoard`),
  ADD KEY `FOREIGN_ITEM_BOARD` (`idItemCollection`),
  ADD KEY `FOREIGN_COLUMN_BOARD` (`idColumn`);

--
-- Index pour la table `cell`
--
ALTER TABLE `cell`
  ADD PRIMARY KEY (`idCell`),
  ADD KEY `FOREIGN_CELL_TYPE` (`idCellType`);

--
-- Index pour la table `celltype`
--
ALTER TABLE `celltype`
  ADD PRIMARY KEY (`idCellType`);

--
-- Index pour la table `column`
--
ALTER TABLE `column`
  ADD PRIMARY KEY (`idColumn`);

--
-- Index pour la table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`idItem`);

--
-- Index pour la table `itemcollection`
--
ALTER TABLE `itemcollection`
  ADD PRIMARY KEY (`idItemCollection`);

--
-- Index pour la table `itemcollection_contains_items`
--
ALTER TABLE `itemcollection_contains_items`
  ADD KEY `FOREIGN_ITEM_COLLECTION` (`idItemCollection`),
  ADD KEY `FOREIGN_ITEM_BELONGS_TO` (`idItem`);

--
-- Index pour la table `item_column_crossed_cell`
--
ALTER TABLE `item_column_crossed_cell`
  ADD KEY `FOREIGN_CELL` (`idCell`),
  ADD KEY `FOREIGN_COLUMN` (`idColumn`),
  ADD KEY `FOREIGN_ITEM` (`idItem`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`);

--
-- Index pour la table `user_as_member_of_workspace`
--
ALTER TABLE `user_as_member_of_workspace`
  ADD KEY `FOREIGN_USER` (`idUser`),
  ADD KEY `FOREIGN_WORKSPACE` (`idWorkspace`);

--
-- Index pour la table `user_attendance`
--
ALTER TABLE `user_attendance`
  ADD KEY `FOREIGN_USER_ATTENDANCE` (`idUser`);

--
-- Index pour la table `workspace`
--
ALTER TABLE `workspace`
  ADD PRIMARY KEY (`idWorskpace`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `board`
--
ALTER TABLE `board`
  ADD CONSTRAINT `FOREIGN_PARENT_WORKSPACE` FOREIGN KEY (`parentWorkspace`) REFERENCES `workspace` (`idWorskpace`);

--
-- Contraintes pour la table `board_contains`
--
ALTER TABLE `board_contains`
  ADD CONSTRAINT `FOREIGN_BOARD` FOREIGN KEY (`idBoard`) REFERENCES `board` (`idBoard`),
  ADD CONSTRAINT `FOREIGN_COLUMN_BOARD` FOREIGN KEY (`idColumn`) REFERENCES `column` (`idColumn`),
  ADD CONSTRAINT `FOREIGN_ITEM_BOARD` FOREIGN KEY (`idItemCollection`) REFERENCES `itemcollection` (`idItemCollection`);

--
-- Contraintes pour la table `cell`
--
ALTER TABLE `cell`
  ADD CONSTRAINT `FOREIGN_CELL_TYPE` FOREIGN KEY (`idCellType`) REFERENCES `celltype` (`idCellType`);

--
-- Contraintes pour la table `itemcollection_contains_items`
--
ALTER TABLE `itemcollection_contains_items`
  ADD CONSTRAINT `FOREIGN_ITEM_BELONGS_TO` FOREIGN KEY (`idItem`) REFERENCES `item` (`idItem`),
  ADD CONSTRAINT `FOREIGN_ITEM_COLLECTION` FOREIGN KEY (`idItemCollection`) REFERENCES `itemcollection` (`idItemCollection`);

--
-- Contraintes pour la table `item_column_crossed_cell`
--
ALTER TABLE `item_column_crossed_cell`
  ADD CONSTRAINT `FOREIGN_CELL` FOREIGN KEY (`idCell`) REFERENCES `cell` (`idCell`),
  ADD CONSTRAINT `FOREIGN_COLUMN` FOREIGN KEY (`idColumn`) REFERENCES `column` (`idColumn`),
  ADD CONSTRAINT `FOREIGN_ITEM` FOREIGN KEY (`idItem`) REFERENCES `item` (`idItem`);

--
-- Contraintes pour la table `user_as_member_of_workspace`
--
ALTER TABLE `user_as_member_of_workspace`
  ADD CONSTRAINT `FOREIGN_USER` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`),
  ADD CONSTRAINT `FOREIGN_WORKSPACE` FOREIGN KEY (`idWorkspace`) REFERENCES `workspace` (`idWorskpace`);

--
-- Contraintes pour la table `user_attendance`
--
ALTER TABLE `user_attendance`
  ADD CONSTRAINT `FOREIGN_USER_ATTENDANCE` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
