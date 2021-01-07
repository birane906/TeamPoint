-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 07 jan. 2021 à 03:55
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
  `idPermission` int(10) NOT NULL,
  `boardName` varchar(25) NOT NULL,
  `parentWorkspace` int(10) NOT NULL,
  `boardCreationDate` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `board`
--

INSERT INTO `board` (`idBoard`, `userOwner`, `idPermission`, `boardName`, `parentWorkspace`, `boardCreationDate`) VALUES
(75, 1, 0, 'TestBoard', 0, '2021-01-06'),
(76, 1, 0, 'Boarddaas', 0, '2021-01-06');

-- --------------------------------------------------------

--
-- Structure de la table `cell`
--

CREATE TABLE `cell` (
  `idCell` int(10) NOT NULL,
  `idBoard` int(10) NOT NULL,
  `idColumn` int(10) NOT NULL,
  `idItem` int(10) NOT NULL,
  `idType` int(10) NOT NULL,
  `idItemCollection` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `cell`
--

INSERT INTO `cell` (`idCell`, `idBoard`, `idColumn`, `idItem`, `idType`, `idItemCollection`) VALUES
(1, 75, 2, 59, 5, 59),
(2, 75, 3, 59, 6, 59),
(3, 75, 4, 59, 4, 59),
(4, 75, 5, 59, 2, 59),
(5, 75, 6, 59, 0, 59),
(6, 75, 54, 59, 1, 59),
(79, 75, 1, 1, 3, 59);

-- --------------------------------------------------------

--
-- Structure de la table `column`
--

CREATE TABLE `column` (
  `idColumn` int(10) NOT NULL,
  `idColumnType` int(10) NOT NULL,
  `idBoard` int(10) NOT NULL,
  `columnName` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `column`
--

INSERT INTO `column` (`idColumn`, `idColumnType`, `idBoard`, `columnName`) VALUES
(1, 3, 75, 'Number'),
(2, 5, 75, 'Date'),
(3, 6, 75, 'Depend'),
(4, 4, 75, 'Person'),
(5, 2, 75, 'Status'),
(6, 0, 75, 'Timeline'),
(54, 1, 75, 'Text');

-- --------------------------------------------------------

--
-- Structure de la table `datetype`
--

CREATE TABLE `datetype` (
  `idDateType` int(10) NOT NULL,
  `idCell` int(10) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `datetype`
--

INSERT INTO `datetype` (`idDateType`, `idCell`, `date`) VALUES
(1, 1, '2021-01-05');

-- --------------------------------------------------------

--
-- Structure de la table `dependencytype`
--

CREATE TABLE `dependencytype` (
  `idDependancyType` int(10) NOT NULL,
  `idCell` int(10) NOT NULL,
  `idItem` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `dependencytype`
--

INSERT INTO `dependencytype` (`idDependancyType`, `idCell`, `idItem`) VALUES
(1, 2, 59);

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

--
-- Déchargement des données de la table `item`
--

INSERT INTO `item` (`idItem`, `idBoard`, `idItemCollection`, `itemName`) VALUES
(1, 75, 59, 'Task2'),
(3, 75, 1, 'Task3'),
(59, 75, 1, 'Task1');

-- --------------------------------------------------------

--
-- Structure de la table `itemcollection`
--

CREATE TABLE `itemcollection` (
  `idItemCollection` int(10) NOT NULL,
  `idBoard` int(10) NOT NULL,
  `itemCollectionName` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `itemcollection`
--

INSERT INTO `itemcollection` (`idItemCollection`, `idBoard`, `itemCollectionName`) VALUES
(1, 75, 'Phase 2'),
(59, 75, 'Phase1');

-- --------------------------------------------------------

--
-- Structure de la table `numbertype`
--

CREATE TABLE `numbertype` (
  `idNumberType` int(10) NOT NULL,
  `idCell` int(10) NOT NULL,
  `unit` varchar(5) NOT NULL,
  `number` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `numbertype`
--

INSERT INTO `numbertype` (`idNumberType`, `idCell`, `unit`, `number`) VALUES
(1, 79, 'Dolla', 1);

-- --------------------------------------------------------

--
-- Structure de la table `persontype`
--

CREATE TABLE `persontype` (
  `idPersonType` int(10) NOT NULL,
  `idCell` int(10) NOT NULL,
  `idUser` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `persontype`
--

INSERT INTO `persontype` (`idPersonType`, `idCell`, `idUser`) VALUES
(2, 3, 1);

-- --------------------------------------------------------

--
-- Structure de la table `statuslabel`
--

CREATE TABLE `statuslabel` (
  `idStatusLabel` int(10) NOT NULL,
  `idColumn` int(10) NOT NULL,
  `label` varchar(25) NOT NULL,
  `colorStatus` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `statuslabel`
--

INSERT INTO `statuslabel` (`idStatusLabel`, `idColumn`, `label`, `colorStatus`) VALUES
(0, 5, 'Done', 'Rouge');

-- --------------------------------------------------------

--
-- Structure de la table `statustype`
--

CREATE TABLE `statustype` (
  `idStatusType` int(10) NOT NULL,
  `idCell` int(10) NOT NULL,
  `statusLabelId` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `statustype`
--

INSERT INTO `statustype` (`idStatusType`, `idCell`, `statusLabelId`) VALUES
(2, 4, 0);

-- --------------------------------------------------------

--
-- Structure de la table `texttype`
--

CREATE TABLE `texttype` (
  `idTextType` int(10) NOT NULL,
  `idCell` int(10) NOT NULL,
  `text` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `texttype`
--

INSERT INTO `texttype` (`idTextType`, `idCell`, `text`) VALUES
(10, 6, 'SAlut');

-- --------------------------------------------------------

--
-- Structure de la table `timelinetype`
--

CREATE TABLE `timelinetype` (
  `idTimelineType` int(10) NOT NULL,
  `idCell` int(10) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `timelinetype`
--

INSERT INTO `timelinetype` (`idTimelineType`, `idCell`, `startDate`, `endDate`) VALUES
(1, 5, '2021-01-19', '2021-01-14');

-- --------------------------------------------------------

--
-- Structure de la table `type`
--

CREATE TABLE `type` (
  `idType` int(10) NOT NULL,
  `nameType` varchar(25) NOT NULL,
  `descriptionType` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `type`
--

INSERT INTO `type` (`idType`, `nameType`, `descriptionType`) VALUES
(0, 'TimelineType', 'two date'),
(1, 'TextType', 'field of text'),
(2, 'StatusType', 'Status: done, current etc'),
(3, 'NumberType', 'number unit'),
(4, 'PersonType', 'User'),
(5, 'DateType', 'Date'),
(6, 'DependencyType', 'items');

-- --------------------------------------------------------

--
-- Structure de la table `typepermission`
--

CREATE TABLE `typepermission` (
  `idTypePermission` int(10) NOT NULL,
  `labelPermission` varchar(25) NOT NULL,
  `description` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `typepermission`
--

INSERT INTO `typepermission` (`idTypePermission`, `labelPermission`, `description`) VALUES
(0, 'EditEverything', 'member of a board can edit every row and column');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `idUser` int(10) NOT NULL,
  `name` varchar(25) DEFAULT NULL,
  `firstName` varchar(25) DEFAULT NULL,
  `email` varchar(25) NOT NULL,
  `password` varchar(500) NOT NULL,
  `phoneNumber` varchar(10) DEFAULT NULL,
  `profileDescription` varchar(500) DEFAULT NULL,
  `birthday` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`idUser`, `name`, `firstName`, `email`, `password`, `phoneNumber`, `profileDescription`, `birthday`) VALUES
(1, 'Nicolas', 'Galois', 'galoisnicolas@gmail.com', '$2a$10$BcCrQI./VvJa3V61g8pv1uEHOOWNG95s6WhZxCHDTPR0ZpmICN.ny', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `user_workspace`
--

CREATE TABLE `user_workspace` (
  `idUser` int(10) NOT NULL,
  `idWorkspace` int(10) NOT NULL,
  `userRole` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user_workspace`
--

INSERT INTO `user_workspace` (`idUser`, `idWorkspace`, `userRole`) VALUES
(1, 0, 'WorkspaceAdmin');

-- --------------------------------------------------------

--
-- Structure de la table `workspace`
--

CREATE TABLE `workspace` (
  `idWorkspace` int(10) NOT NULL,
  `idUserOwner` int(10) NOT NULL,
  `workspaceName` varchar(25) NOT NULL,
  `workspaceCreationDate` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `workspace`
--

INSERT INTO `workspace` (`idWorkspace`, `idUserOwner`, `workspaceName`, `workspaceCreationDate`) VALUES
(0, 1, 'Test', '0000-00-00');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `board`
--
ALTER TABLE `board`
  ADD PRIMARY KEY (`idBoard`),
  ADD KEY `FOREIGN_PARENT_WORKSPACE` (`parentWorkspace`),
  ADD KEY `FOREIGN_USER_OWNER` (`userOwner`),
  ADD KEY `FOREIGN_PERMISSION` (`idPermission`);

--
-- Index pour la table `cell`
--
ALTER TABLE `cell`
  ADD PRIMARY KEY (`idCell`),
  ADD KEY `FOREIGN_CELL_BOARD` (`idBoard`),
  ADD KEY `FOREIGN_COLUMN_CELL` (`idColumn`),
  ADD KEY `FOREIGN_ITEM_COLLECTION_CELL` (`idItemCollection`),
  ADD KEY `FOREIGN_ITEM_ROW` (`idItem`),
  ADD KEY `FOREIGN_CELL_TYPE` (`idType`);

--
-- Index pour la table `column`
--
ALTER TABLE `column`
  ADD PRIMARY KEY (`idColumn`),
  ADD KEY `FOREIGN_COLUMN_BOARD_KEY` (`idBoard`),
  ADD KEY `FOREIGN_COLUMN_TYPE` (`idColumnType`);

--
-- Index pour la table `datetype`
--
ALTER TABLE `datetype`
  ADD PRIMARY KEY (`idDateType`),
  ADD KEY `FOREIGN_CELL_DATETYPE` (`idCell`);

--
-- Index pour la table `dependencytype`
--
ALTER TABLE `dependencytype`
  ADD PRIMARY KEY (`idDependancyType`),
  ADD KEY `FOREIGN_CELL_DEP_TYPE` (`idCell`),
  ADD KEY `FOREIGN_ITEM_CELL_VALUE` (`idItem`);

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
-- Index pour la table `numbertype`
--
ALTER TABLE `numbertype`
  ADD PRIMARY KEY (`idNumberType`),
  ADD KEY `FOREIGN_CELL_NUMBER_TYPE` (`idCell`);

--
-- Index pour la table `persontype`
--
ALTER TABLE `persontype`
  ADD PRIMARY KEY (`idPersonType`),
  ADD KEY `FOREIGN_CELL_PERSONTYPE` (`idCell`),
  ADD KEY `FOREIGN_USER_TYPE_KEY` (`idUser`);

--
-- Index pour la table `statuslabel`
--
ALTER TABLE `statuslabel`
  ADD PRIMARY KEY (`idStatusLabel`),
  ADD KEY `FOREIGN_COLUMN_TYPE_KEY` (`idColumn`);

--
-- Index pour la table `statustype`
--
ALTER TABLE `statustype`
  ADD PRIMARY KEY (`idStatusType`),
  ADD KEY `FOREIGN_CELL_STATUS` (`idCell`),
  ADD KEY `FOREIGN_STATUS_LABEL_ID` (`statusLabelId`);

--
-- Index pour la table `texttype`
--
ALTER TABLE `texttype`
  ADD PRIMARY KEY (`idTextType`),
  ADD KEY `FOREIGN_CELL_TEXT_TYPE` (`idCell`);

--
-- Index pour la table `timelinetype`
--
ALTER TABLE `timelinetype`
  ADD PRIMARY KEY (`idTimelineType`),
  ADD KEY `FOREIGN_CELL_TIMELINE` (`idCell`);

--
-- Index pour la table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`idType`);

--
-- Index pour la table `typepermission`
--
ALTER TABLE `typepermission`
  ADD PRIMARY KEY (`idTypePermission`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`);

--
-- Index pour la table `user_workspace`
--
ALTER TABLE `user_workspace`
  ADD KEY `FOREIGN_USER_WORKSPACE_USER` (`idUser`),
  ADD KEY `FOREIGN_WORKSPACE_USER_WORKSPACE` (`idWorkspace`);

--
-- Index pour la table `workspace`
--
ALTER TABLE `workspace`
  ADD PRIMARY KEY (`idWorkspace`),
  ADD KEY `FOREIGN_ADMIN_OWNER_WORKSPACE` (`idUserOwner`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `board`
--
ALTER TABLE `board`
  MODIFY `idBoard` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=77;

--
-- AUTO_INCREMENT pour la table `cell`
--
ALTER TABLE `cell`
  MODIFY `idCell` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=80;

--
-- AUTO_INCREMENT pour la table `column`
--
ALTER TABLE `column`
  MODIFY `idColumn` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT pour la table `datetype`
--
ALTER TABLE `datetype`
  MODIFY `idDateType` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `dependencytype`
--
ALTER TABLE `dependencytype`
  MODIFY `idDependancyType` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `item`
--
ALTER TABLE `item`
  MODIFY `idItem` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

--
-- AUTO_INCREMENT pour la table `itemcollection`
--
ALTER TABLE `itemcollection`
  MODIFY `idItemCollection` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT pour la table `numbertype`
--
ALTER TABLE `numbertype`
  MODIFY `idNumberType` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `persontype`
--
ALTER TABLE `persontype`
  MODIFY `idPersonType` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `statustype`
--
ALTER TABLE `statustype`
  MODIFY `idStatusType` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `texttype`
--
ALTER TABLE `texttype`
  MODIFY `idTextType` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `timelinetype`
--
ALTER TABLE `timelinetype`
  MODIFY `idTimelineType` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT pour la table `workspace`
--
ALTER TABLE `workspace`
  MODIFY `idWorkspace` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `board`
--
ALTER TABLE `board`
  ADD CONSTRAINT `FOREIGN_PARENT_WORKSPACE` FOREIGN KEY (`parentWorkspace`) REFERENCES `workspace` (`idWorkspace`),
  ADD CONSTRAINT `FOREIGN_PERMISSION` FOREIGN KEY (`idPermission`) REFERENCES `typepermission` (`idTypePermission`),
  ADD CONSTRAINT `FOREIGN_USER_OWNER` FOREIGN KEY (`userOwner`) REFERENCES `user` (`idUser`);

--
-- Contraintes pour la table `cell`
--
ALTER TABLE `cell`
  ADD CONSTRAINT `FOREIGN_CELL_BOARD` FOREIGN KEY (`idBoard`) REFERENCES `board` (`idBoard`),
  ADD CONSTRAINT `FOREIGN_CELL_TYPE` FOREIGN KEY (`idType`) REFERENCES `type` (`idType`),
  ADD CONSTRAINT `FOREIGN_COLUMN_CELL` FOREIGN KEY (`idColumn`) REFERENCES `column` (`idColumn`),
  ADD CONSTRAINT `FOREIGN_ITEM_COLLECTION_CELL` FOREIGN KEY (`idItemCollection`) REFERENCES `itemcollection` (`idItemCollection`),
  ADD CONSTRAINT `FOREIGN_ITEM_ROW` FOREIGN KEY (`idItem`) REFERENCES `item` (`idItem`);

--
-- Contraintes pour la table `column`
--
ALTER TABLE `column`
  ADD CONSTRAINT `FOREIGN_COLUMN_BOARD_KEY` FOREIGN KEY (`idBoard`) REFERENCES `board` (`idBoard`),
  ADD CONSTRAINT `FOREIGN_COLUMN_TYPE` FOREIGN KEY (`idColumnType`) REFERENCES `type` (`idType`);

--
-- Contraintes pour la table `datetype`
--
ALTER TABLE `datetype`
  ADD CONSTRAINT `FOREIGN_CELL_DATETYPE` FOREIGN KEY (`idCell`) REFERENCES `cell` (`idCell`);

--
-- Contraintes pour la table `dependencytype`
--
ALTER TABLE `dependencytype`
  ADD CONSTRAINT `FOREIGN_CELL_DEP_TYPE` FOREIGN KEY (`idCell`) REFERENCES `cell` (`idCell`),
  ADD CONSTRAINT `FOREIGN_ITEM_CELL_VALUE` FOREIGN KEY (`idItem`) REFERENCES `item` (`idItem`);

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
-- Contraintes pour la table `numbertype`
--
ALTER TABLE `numbertype`
  ADD CONSTRAINT `FOREIGN_CELL_NUMBER_TYPE` FOREIGN KEY (`idCell`) REFERENCES `cell` (`idCell`);

--
-- Contraintes pour la table `persontype`
--
ALTER TABLE `persontype`
  ADD CONSTRAINT `FOREIGN_CELL_PERSONTYPE` FOREIGN KEY (`idCell`) REFERENCES `cell` (`idCell`),
  ADD CONSTRAINT `FOREIGN_USER_TYPE_KEY` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`);

--
-- Contraintes pour la table `statuslabel`
--
ALTER TABLE `statuslabel`
  ADD CONSTRAINT `FOREIGN_COLUMN_TYPE_KEY` FOREIGN KEY (`idColumn`) REFERENCES `column` (`idColumn`);

--
-- Contraintes pour la table `statustype`
--
ALTER TABLE `statustype`
  ADD CONSTRAINT `FOREIGN_CELL_STATUS` FOREIGN KEY (`idCell`) REFERENCES `cell` (`idCell`),
  ADD CONSTRAINT `FOREIGN_STATUS_LABEL_ID` FOREIGN KEY (`statusLabelId`) REFERENCES `statuslabel` (`idStatusLabel`);

--
-- Contraintes pour la table `texttype`
--
ALTER TABLE `texttype`
  ADD CONSTRAINT `FOREIGN_CELL_TEXT_TYPE` FOREIGN KEY (`idCell`) REFERENCES `cell` (`idCell`);

--
-- Contraintes pour la table `timelinetype`
--
ALTER TABLE `timelinetype`
  ADD CONSTRAINT `FOREIGN_CELL_TIMELINE` FOREIGN KEY (`idCell`) REFERENCES `cell` (`idCell`);

--
-- Contraintes pour la table `user_workspace`
--
ALTER TABLE `user_workspace`
  ADD CONSTRAINT `FOREIGN_USER_WORKSPACE_USER` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`),
  ADD CONSTRAINT `FOREIGN_WORKSPACE_USER_WORKSPACE` FOREIGN KEY (`idWorkspace`) REFERENCES `workspace` (`idWorkspace`);

--
-- Contraintes pour la table `workspace`
--
ALTER TABLE `workspace`
  ADD CONSTRAINT `FOREIGN_ADMIN_OWNER_WORKSPACE` FOREIGN KEY (`idUserOwner`) REFERENCES `user` (`idUser`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
