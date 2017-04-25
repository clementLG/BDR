-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2017 at 03:21 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cetudiants`
--

-- --------------------------------------------------------

--
-- Table structure for table `administration`
--

CREATE TABLE IF NOT EXISTS `administration` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `identifiant` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `administration`
--

INSERT INTO `administration` (`id`, `identifiant`, `password`) VALUES
(1, 'admin', 'a94a8fe5ccb19ba61c4c0873d391e987982fbbd3');

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE IF NOT EXISTS `contact` (
  `idcontact` int(255) NOT NULL AUTO_INCREMENT,
  `titre` text NOT NULL,
  `contenu` longtext NOT NULL,
  `userid` int(255) NOT NULL,
  `datetime` date NOT NULL,
  `lue` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idcontact`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `contact`
--

INSERT INTO `contact` (`idcontact`, `titre`, `contenu`, `userid`, `datetime`, `lue`) VALUES
(1, 'test', 'test', 2, '2015-06-19', 1);

-- --------------------------------------------------------

--
-- Table structure for table `devoirs`
--

CREATE TABLE IF NOT EXISTS `devoirs` (
  `iddevoir` int(11) NOT NULL AUTO_INCREMENT,
  `devoir` varchar(20) COLLATE utf8_bin NOT NULL,
  `idmatiere` int(11) NOT NULL,
  `idsection` int(11) NOT NULL,
  `idsemestre` int(11) NOT NULL,
  `coef` int(11) NOT NULL,
  PRIMARY KEY (`iddevoir`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=8 ;

--
-- Dumping data for table `devoirs`
--

INSERT INTO `devoirs` (`iddevoir`, `devoir`, `idmatiere`, `idsection`, `idsemestre`, `coef`) VALUES
(1, 'Devoir1', 16, 1, 1, 2),
(2, 'Devoir2', 6, 1, 1, 2),
(3, 'Devoir3', 6, 1, 2, 2),
(4, 'Devoir4', 7, 1, 1, 2),
(5, 'Devoir Test', 16, 1, 2, 2),
(6, 'BTS Blanc', 16, 1, 1, 7),
(7, 'Devoir de test', 16, 1, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `fanswer`
--

CREATE TABLE IF NOT EXISTS `fanswer` (
  `question_id` int(4) NOT NULL DEFAULT '0',
  `a_id` int(4) NOT NULL DEFAULT '0',
  `a_name` varchar(65) NOT NULL DEFAULT '',
  `a_answer` longtext NOT NULL,
  `a_datetime` varchar(25) NOT NULL DEFAULT '',
  KEY `a_id` (`a_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fanswer`
--

INSERT INTO `fanswer` (`question_id`, `a_id`, `a_name`, `a_answer`, `a_datetime`) VALUES
(20, 2, 'pesteves', 'salut!', '10/04/15 10:46:35'),
(22, 1, 'clegal', 'Ceci est une réponse !!!!!!!!', '11/04/15 21:48:57'),
(22, 2, 'mlebras', 'répondre', '12/04/15 01:39:54'),
(22, 3, 'jdupont', 'Je n''ai absolument aucun problème', '13/04/15 01:03:49'),
(23, 1, 'mlebras', 'Il faut avancer dans tes projets et finir tes documentations', '13/04/15 01:06:35'),
(22, 4, 'clegal', 'Tant mieux!', '13/04/15 01:09:38'),
(20, 3, 'clegal', 'Bonjour Mickaël et Patrick', '13/04/15 01:10:00');

-- --------------------------------------------------------

--
-- Table structure for table `fquestions`
--

CREATE TABLE IF NOT EXISTS `fquestions` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `topic` varchar(255) NOT NULL DEFAULT '',
  `detail` longtext NOT NULL,
  `name` varchar(65) NOT NULL DEFAULT '',
  `datetime` varchar(25) NOT NULL DEFAULT '',
  `view` int(4) NOT NULL DEFAULT '0',
  `reply` int(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Dumping data for table `fquestions`
--

INSERT INTO `fquestions` (`id`, `topic`, `detail`, `name`, `datetime`, `view`, `reply`) VALUES
(20, 'Première Discussion', 'Voici la première discussion du coin étudiants''', 'mlebras', '10/04/15 12:59:28', 40, 3),
(22, 'Demande d''aide', 'Bonjour à tous,\r\n\r\nCe sujet est mis à votre disposition en complément des tickets d''assistances que vous pouvez retrouver dans le pied de page en cliquant sur "Contacter un Administrateur".\r\n\r\nSi vous souhaitez poser une question aux autres étudiants, vous êtes au bon endroit.', 'mlebras', '11/04/15 08:54:19', 37, 4),
(23, 'Au sujet du devoirs pour lundi', 'Bonjour, quelqu''un a les devoirs pour demain?', 'jdupont', '13/04/15 01:04:20', 9, 2);

-- --------------------------------------------------------

--
-- Table structure for table `matieres`
--

CREATE TABLE IF NOT EXISTS `matieres` (
  `idmatiere` int(11) NOT NULL AUTO_INCREMENT,
  `matiere` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_mysql500_ci NOT NULL,
  `coeffmatiere` int(255) NOT NULL,
  `idsection` int(10) NOT NULL,
  `idprof` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idmatiere`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

--
-- Dumping data for table `matieres`
--

INSERT INTO `matieres` (`idmatiere`, `matiere`, `coeffmatiere`, `idsection`, `idprof`) VALUES
(6, 'Mathématiques', 3, 1, 5),
(7, 'Français', 3, 1, 16),
(9, 'Eco/Droit', 2, 0, 0),
(10, 'DÃ©veloppement', 5, 0, 0),
(11, 'MathÃ©matiques', 2, 0, 0),
(12, 'MathÃ©matiques', 2, 0, 0),
(13, 'FranÃ§ais', 1, 0, 0),
(14, 'Anglais', 2, 0, 0),
(15, 'Maths', 1, 0, 0),
(16, 'Développement', 4, 1, 1),
(17, 'Commerce', 4, 5, 0),
(18, 'Management', 2, 5, 0),
(19, 'Comptabilité', 4, 3, 0),
(20, 'Finance', 2, 3, 0),
(21, 'Anglais', 2, 1, 0),
(22, 'Réseau', 4, 1, 0),
(23, 'test', 2, 1, 1),
(24, 'test2', 2, 1, 4);

-- --------------------------------------------------------

--
-- Table structure for table `newsletter`
--

CREATE TABLE IF NOT EXISTS `newsletter` (
  `idnews` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(255) NOT NULL,
  `contenu` longtext NOT NULL,
  `userid` int(11) NOT NULL,
  `newsletter` tinyint(1) NOT NULL,
  `datetime` date NOT NULL,
  PRIMARY KEY (`idnews`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `newsletter`
--

INSERT INTO `newsletter` (`idnews`, `titre`, `contenu`, `userid`, `newsletter`, `datetime`) VALUES
(13, 'Bienvenue sur le Coin Etudiants', '<center><b>Bienvenue à Tous sur le Coin des Etudiants!</b></center>\n\nJ''espère que vous vous plairez parmis nous, et que vous trouverez votre bonheur parmis les fonctionnalités de ce site qui est désormais ouvert!\n\n<b>Vous pourrez ainsi retrouver:</b>\n\n- Un bulletin en temps réel\n- Un forum afin de trouver de l''entraide et de discuter avec d''autres étudiants\n- Un espace membre personnalisable\n- Une newsletter pour être toujours informé des nouveautés du site\n- Une boîte de réception pour gérer vos messages privés\n- Un administrateur à l''écoute de vos questions dans l''onglet "Contact"\n\nA très vite sur le Coin des Etudiants!						', 2, 0, '2014-11-27');

-- --------------------------------------------------------

--
-- Table structure for table `notes`
--

CREATE TABLE IF NOT EXISTS `notes` (
  `idnote` int(11) NOT NULL AUTO_INCREMENT,
  `note` float(65,2) NOT NULL,
  `coef` int(255) NOT NULL,
  `idetudiant` int(255) NOT NULL,
  `idmatiere` int(255) NOT NULL,
  `commentaire` varchar(100) NOT NULL,
  `iddevoir` int(11) NOT NULL,
  `idsemestre` int(11) NOT NULL,
  PRIMARY KEY (`idnote`),
  UNIQUE KEY `idnote` (`idnote`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=68 ;

--
-- Dumping data for table `notes`
--

INSERT INTO `notes` (`idnote`, `note`, `coef`, `idetudiant`, `idmatiere`, `commentaire`, `iddevoir`, `idsemestre`) VALUES
(42, 15.00, 2, 2, 16, 'bien', 1, 1),
(54, 6.00, 2, 13, 22, 'Très mauvais élève', 0, 1),
(55, 19.00, 2, 13, 6, 'swagg', 0, 1),
(56, 20.00, 2, 14, 22, 'Exeptionnel', 0, 2),
(57, 12.00, 2, 2, 6, 'Passable', 0, 1),
(58, 14.00, 2, 2, 7, 'bien', 4, 1),
(59, 12.00, 2, 2, 21, '', 0, 1),
(60, 12.00, 2, 2, 16, 'test', 7, 2),
(62, 15.00, 2, 2, 21, '', 0, 2),
(63, 12.00, 1, 2, 6, '', 0, 1),
(64, 12.00, 1, 10, 6, '', 0, 1),
(65, 12.00, 2, 9, 6, '', 2, 1),
(66, 12.00, 2, 9, 6, '', 2, 1),
(67, 12.00, 2, 2, 6, '', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `pm`
--

CREATE TABLE IF NOT EXISTS `pm` (
  `id` bigint(20) NOT NULL,
  `id2` int(11) NOT NULL,
  `title` varchar(256) NOT NULL,
  `user1` bigint(20) NOT NULL,
  `user2` bigint(20) NOT NULL,
  `message` text NOT NULL,
  `timestamp` int(10) NOT NULL,
  `user1read` varchar(3) NOT NULL,
  `user2read` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pm`
--

INSERT INTO `pm` (`id`, `id2`, `title`, `user1`, `user2`, `message`, `timestamp`, `user1read`, `user2read`) VALUES
(1, 1, 'Discussion privée', 2, 3, 'Bonjour Clément, ceci est une discussion privée entre toi et moi.', 1428788581, 'yes', 'yes'),
(1, 2, '', 3, 2, 'J''ai correctement reçu ce message', 1428788823, 'yes', 'no'),
(4, 1, 'Test', 15, 2, 'bonjour mlebras', 1428879883, 'yes', 'yes'),
(4, 2, '', 2, 15, 'bonjour jdupont', 1428879910, 'yes', 'no'),
(4, 3, '', 2, 15, 'ça '' va '' bien?', 1428879932, 'yes', 'no');

-- --------------------------------------------------------

--
-- Table structure for table `professeurs`
--

CREATE TABLE IF NOT EXISTS `professeurs` (
  `idprof` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  PRIMARY KEY (`idprof`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Dumping data for table `professeurs`
--

INSERT INTO `professeurs` (`idprof`, `nom`, `prenom`) VALUES
(1, 'Edme', 'Jeans'),
(4, 'Benisti', 'Cédric'),
(5, 'Jonnot', 'Marcel'),
(12, 'Guerfi', 'Souhila'),
(16, 'Patrick', 'Richard');

-- --------------------------------------------------------

--
-- Table structure for table `sections`
--

CREATE TABLE IF NOT EXISTS `sections` (
  `idsections` int(11) NOT NULL AUTO_INCREMENT,
  `section` varchar(50) NOT NULL,
  `niveau` varchar(10) NOT NULL,
  PRIMARY KEY (`idsections`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `sections`
--

INSERT INTO `sections` (`idsections`, `section`, `niveau`) VALUES
(1, 'SIO', '2'),
(2, 'MUC', '2'),
(3, 'CGO', '2'),
(5, 'NRC', '2');

-- --------------------------------------------------------

--
-- Table structure for table `semestre`
--

CREATE TABLE IF NOT EXISTS `semestre` (
  `idsemestre` int(11) NOT NULL AUTO_INCREMENT,
  `semestre` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`idsemestre`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3 ;

--
-- Dumping data for table `semestre`
--

INSERT INTO `semestre` (`idsemestre`, `semestre`) VALUES
(1, 'Premier Semestre'),
(2, 'Second Semestre');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `userid` int(255) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `pseudo` varchar(255) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `defaultpass` varchar(50) NOT NULL,
  `datenaiss` date NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `description` text,
  `signature` text,
  `newsok` tinyint(1) DEFAULT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT '0',
  `idsection` int(255) DEFAULT NULL,
  `email` varchar(50) NOT NULL DEFAULT 'email@host.com',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userid`, `nom`, `pseudo`, `prenom`, `password`, `defaultpass`, `datenaiss`, `avatar`, `description`, `signature`, `newsok`, `admin`, `idsection`, `email`) VALUES
(2, 'Le Bras', 'mlebras', 'Mickaël', 'ee9e3307d98c01699b4aa24e429a3725d79e19e1', 'lebrasmickael30', '1992-03-09', 'upload/210042015000609.jpg', 'En deuxième année de BTS SIO, le Coin Etudiants est un projet que j''ai réalisé afin de le présenter lors de mon examen.\r\n\r\n(Je l''ai eu maggle)\r\n', 'Shqnks - Webmaster du Coin Etudiants. =)', 1, 1, 1, 'mick.lebras@yahoo.fr'),
(3, 'Legal', 'clegal', 'Clément', '4d5eeba8bc615642cd70de50d9b9f1e35bba6072', 'legalclement8', '1993-04-08', 'images/avatardebase.gif', '', 'signature de clément', NULL, 0, 1, 'clegal@gmail.com'),
(4, 'Esteves', 'pesteves', 'Patrick', '24ef92bcf4d6ff2e3747a3ee41e5867332ce0710', 'estevespatrick50', '1992-10-14', 'upload/410042015104605.png', 'Bonjour! Je suis patrick Esteves!', '', NULL, 0, 1, 'email@host.com'),
(8, 'Bonsoir', 'hbonsoir', 'Hercey', 'cdddfe13fdc0892c6dd630996096753df1bc745e', 'bonsoirhercey19', '1985-01-02', NULL, NULL, NULL, NULL, 0, 6, 'email@host.com'),
(9, 'Reyal', 'kreyal', 'Kévin', '48b576e713070114815da7abea24441183cb4b52', 'reyalkévin55', '1989-04-26', 'upload/904052015153008.jpg', NULL, NULL, NULL, 0, 1, 'email@host.com'),
(10, 'Chevet', 'bchevet', 'Benoit', 'fdb463d54de81b8677260a9ddff778fcd8433835', 'chevetbenoit27', '1986-10-27', NULL, NULL, NULL, NULL, 0, 1, 'email@host.com'),
(12, 'Mangelle', 'tmangelle', 'Timothée', 'b6b1b8b432e171712325cfee14eb670368f6c3c1', 'mangelletimothée41', '1992-11-14', NULL, NULL, NULL, NULL, 0, 1, 'email@host.com'),
(13, 'Sojane', 'csojane', 'Charles', '1091f8ab1e39e7f3c50cdf299a6ed4411a5d7fcb', 'sojanecharles24', '1993-06-16', 'images/avatardebase.gif', NULL, NULL, NULL, 0, 1, 'email@host.com'),
(14, 'Tarik', 'atarik', 'Abdel Ali', '43bc1ca38dc487549f23a477c259abdaa7c1d65a', 'tarikabdelali34', '1994-06-24', NULL, NULL, NULL, NULL, 0, 1, 'email@host.com'),
(15, 'Dupont', 'jdupont', 'Jean', '417e9efc94fb3f1b1712c87e2bff1ae3861f564f', 'dupontjean8', '1990-06-05', 'images/avatardebase.gif', NULL, NULL, 1, 0, 1, 'email@host.com'),
(16, 'Lanchas', 'vlanchas', 'Victor', 'adc3dc8c17241e183c0968cf4a731798eb777bb6', 'lanchasvictor56', '1993-03-26', NULL, NULL, NULL, NULL, 1, 1, 'email@host.com');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
