-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mar. 29 déc. 2020 à 13:05
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
  `userOwner` int(10) NOT NULL,
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
  `idBoard` int(10) NOT NULL,
  `idColumn` int(10) NOT NULL,
  `idItemCollection` int(10) NOT NULL,
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
  `idBoard` int(10) NOT NULL,
  `columnName` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `item`
--

CREATE TABLE `item` (
  `idItem` int(10) NOT NULL,
  `idBoard` int(10) NOT NULL,
  `idItemCollection` int(10) NOT NULL,
  `itemName` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `itemcollection`
--

CREATE TABLE `itemcollection` (
  `idItemCollection` int(10) NOT NULL,
  `idBoard` int(10) NOT NULL,
  `itemCollectionName` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `item_collection_item`
--

CREATE TABLE `item_collection_item` (
  `idItemCollection` int(10) NOT NULL,
  `idItem` int(10) NOT NULL
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
  `idUserOwner` int(10) NOT NULL,
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
  ADD KEY `FOREIGN_PARENT_WORKSPACE` (`parentWorkspace`),
  ADD KEY `FOREIGN_USER_OWNER` (`userOwner`);

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
  ADD KEY `FOREIGN_CELL_TYPE` (`idCellType`),
  ADD KEY `FOREIGN_CELL_BOARD` (`idBoard`),
  ADD KEY `FOREIGN_COLUMN_CELL` (`idColumn`),
  ADD KEY `FOREIGN_ITEM_COLLECTION_CELL` (`idItemCollection`);

--
-- Index pour la table `celltype`
--
ALTER TABLE `celltype`
  ADD PRIMARY KEY (`idCellType`);

--
-- Index pour la table `column`
--
ALTER TABLE `column`
  ADD PRIMARY KEY (`idColumn`),
  ADD KEY `FOREIGN_COLUMN_BOARD_KEY` (`idBoard`);

--
-- Index pour la table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`idItem`),
  ADD KEY `FOREIGN_BOARD_ITEM_KEY` (`idBoard`),
  ADD KEY `FOREIGN_ITEM_COLLECTION_ITEM_KEY` (`idItemCollection`);

--
-- Index pour la table `itemcollection`
--
ALTER TABLE `itemcollection`
  ADD PRIMARY KEY (`idItemCollection`),
  ADD KEY `FOREIGN_BOARD_ITEM_COLLECTION_KEY` (`idBoard`);

--
-- Index pour la table `item_collection_item`
--
ALTER TABLE `item_collection_item`
  ADD KEY `FOREIGN_ITEM__ITEM_COLLECTION` (`idItem`),
  ADD KEY `FOREIGN_ITEM_COLLECTION_ITEM` (`idItemCollection`);

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
  ADD PRIMARY KEY (`idWorskpace`),
  ADD KEY `FOREIGN_ADMIN_OWNER_WORKSPACE` (`idUserOwner`);

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
  ADD CONSTRAINT `FOREIGN_PARENT_WORKSPACE` FOREIGN KEY (`parentWorkspace`) REFERENCES `workspace` (`idWorskpace`),
  ADD CONSTRAINT `FOREIGN_USER_OWNER` FOREIGN KEY (`userOwner`) REFERENCES `user` (`idUser`);

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
  ADD CONSTRAINT `FOREIGN_CELL_BOARD` FOREIGN KEY (`idBoard`) REFERENCES `board` (`idBoard`),
  ADD CONSTRAINT `FOREIGN_CELL_TYPE` FOREIGN KEY (`idCellType`) REFERENCES `celltype` (`idCellType`),
  ADD CONSTRAINT `FOREIGN_COLUMN_CELL` FOREIGN KEY (`idColumn`) REFERENCES `column` (`idColumn`),
  ADD CONSTRAINT `FOREIGN_ITEM_COLLECTION_CELL` FOREIGN KEY (`idItemCollection`) REFERENCES `itemcollection` (`idItemCollection`);

--
-- Contraintes pour la table `column`
--
ALTER TABLE `column`
  ADD CONSTRAINT `FOREIGN_COLUMN_BOARD_KEY` FOREIGN KEY (`idBoard`) REFERENCES `board` (`idBoard`);

--
-- Contraintes pour la table `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `FOREIGN_BOARD_ITEM` FOREIGN KEY (`idBoard`) REFERENCES `board` (`idBoard`),
  ADD CONSTRAINT `FOREIGN_BOARD_ITEM_KEY` FOREIGN KEY (`idBoard`) REFERENCES `board` (`idBoard`),
  ADD CONSTRAINT `FOREIGN_ITEM_COLLECTION_ITEM_KEY` FOREIGN KEY (`idItemCollection`) REFERENCES `itemcollection` (`idItemCollection`);

--
-- Contraintes pour la table `itemcollection`
--
ALTER TABLE `itemcollection`
  ADD CONSTRAINT `FOREIGN_BOARD_ITEM_COLLECTION_KEY` FOREIGN KEY (`idBoard`) REFERENCES `board` (`idBoard`);

--
-- Contraintes pour la table `item_collection_item`
--
ALTER TABLE `item_collection_item`
  ADD CONSTRAINT `FOREIGN_ITEM_COLLECTION_ITEM` FOREIGN KEY (`idItemCollection`) REFERENCES `itemcollection` (`idItemCollection`),
  ADD CONSTRAINT `FOREIGN_ITEM__ITEM_COLLECTION` FOREIGN KEY (`idItem`) REFERENCES `item` (`idItem`);

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

--
-- Contraintes pour la table `workspace`
--
ALTER TABLE `workspace`
  ADD CONSTRAINT `FOREIGN_ADMIN_OWNER_WORKSPACE` FOREIGN KEY (`idUserOwner`) REFERENCES `user` (`idUser`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
