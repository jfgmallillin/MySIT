-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 08, 2015 at 02:25 PM
-- Server version: 5.6.26
-- PHP Version: 5.5.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mysit`
--

-- --------------------------------------------------------

--
-- Table structure for table `bible_study_tbl`
--

CREATE TABLE IF NOT EXISTS `bible_study_tbl` (
  `ID` int(11) NOT NULL,
  `SUBJECT_ID` int(11) NOT NULL,
  `DISCIPLER_ID` int(11) NOT NULL,
  `DISCIPLE_ID` int(11) NOT NULL,
  `DATE` date NOT NULL,
  `ACTIVITY_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `curriculum_content`
--

CREATE TABLE IF NOT EXISTS `curriculum_content` (
  `CURRICULUM_ID` int(11) NOT NULL,
  `SUBJECT_ID` int(11) NOT NULL,
  `SEQ_NO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `curriculum_tbl`
--

CREATE TABLE IF NOT EXISTS `curriculum_tbl` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `DESCRIPTION` varchar(250) NOT NULL,
  `KEYWORD` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `evangelism_tbl`
--

CREATE TABLE IF NOT EXISTS `evangelism_tbl` (
  `ACTIVITY_ID` int(11) NOT NULL,
  `TYPE` int(11) NOT NULL,
  `DATE_START` date NOT NULL,
  `DATE_END` date NOT NULL,
  `PRC` int(11) NOT NULL,
  `AC` int(11) NOT NULL,
  `NI` int(11) NOT NULL,
  `TOTAL` int(11) NOT NULL,
  `DATA` blob NOT NULL,
  `KEYWORD` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `evangelism_type`
--

CREATE TABLE IF NOT EXISTS `evangelism_type` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `member_profile`
--

CREATE TABLE IF NOT EXISTS `member_profile` (
  `PROFILE_ID` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `FIRSTNAME` varchar(50) NOT NULL,
  `LASTNAME` varchar(50) NOT NULL,
  `MIDDLENAME` varchar(25) NOT NULL,
  `GENDER` char(1) NOT NULL,
  `B_BIRTHDAY` date NOT NULL,
  `S_BIRTHDAY` date NOT NULL,
  `STATUS` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `org_activities_hierarchy`
--

CREATE TABLE IF NOT EXISTS `org_activities_hierarchy` (
  `ACTIVITY_ID` int(11) NOT NULL,
  `LFT` int(11) NOT NULL,
  `RGT` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `org_activities_tbl`
--

CREATE TABLE IF NOT EXISTS `org_activities_tbl` (
  `ACTIVITY_ID` int(11) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `DESCRIPTION` varchar(500) NOT NULL,
  `DATE_START` date NOT NULL,
  `DATE_END` date NOT NULL,
  `KEYWORD` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `org_group`
--

CREATE TABLE IF NOT EXISTS `org_group` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(25) NOT NULL,
  `DESCRIPTION` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `org_member_group`
--

CREATE TABLE IF NOT EXISTS `org_member_group` (
  `ORG_GROUP_ID` int(11) NOT NULL,
  `MEMBER_PROFILE_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `org_member_hierarchy`
--

CREATE TABLE IF NOT EXISTS `org_member_hierarchy` (
  `PROFILE_ID` int(11) NOT NULL,
  `LFT` int(11) NOT NULL,
  `RGT` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`ID`, `NAME`) VALUES
(1, 'System Admin'),
(2, 'Activity Admin'),
(3, 'Disciple');

-- --------------------------------------------------------

--
-- Table structure for table `subject_tbl`
--

CREATE TABLE IF NOT EXISTS `subject_tbl` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(25) NOT NULL,
  `DESCRIPTION` varchar(200) NOT NULL,
  `KEYWORD` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `text_messages`
--

CREATE TABLE IF NOT EXISTS `text_messages` (
  `ID` int(11) NOT NULL,
  `MESSAGE` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `userlogin`
--

CREATE TABLE IF NOT EXISTS `userlogin` (
  `ID` int(11) NOT NULL,
  `USERNAME` varchar(30) NOT NULL,
  `PASSWORD` varchar(64) NOT NULL,
  `MOBILE_NO` varchar(11) NOT NULL,
  `STATUS` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userlogin`
--

INSERT INTO `userlogin` (`ID`, `USERNAME`, `PASSWORD`, `MOBILE_NO`, `STATUS`) VALUES
(1, 'nimoaa', 'c775e7b757ede630cd0aa1113bd102661ab38829ca52a6422ab782862f268646', '1', 1),
(2, 'mallillinjg', 'mallillinjg', '09175265740', 1);

-- --------------------------------------------------------

--
-- Table structure for table `userroles`
--

CREATE TABLE IF NOT EXISTS `userroles` (
  `USER_ID` int(11) NOT NULL,
  `ROLE_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userroles`
--

INSERT INTO `userroles` (`USER_ID`, `ROLE_ID`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 2),
(2, 3);

-- --------------------------------------------------------

--
-- Stand-in structure for view `userroles_view`
--
CREATE TABLE IF NOT EXISTS `userroles_view` (
`USERNAME` varchar(30)
,`PASSWORD` varchar(64)
,`ROLENAME` varchar(30)
);

-- --------------------------------------------------------

--
-- Structure for view `userroles_view`
--
DROP TABLE IF EXISTS `userroles_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `userroles_view` AS select `userlogin`.`USERNAME` AS `USERNAME`,`userlogin`.`PASSWORD` AS `PASSWORD`,`role`.`NAME` AS `ROLENAME` from ((`userroles` join `userlogin` on((`userroles`.`USER_ID` = `userlogin`.`ID`))) join `role` on((`userroles`.`ROLE_ID` = `role`.`ID`)));

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bible_study_tbl`
--
ALTER TABLE `bible_study_tbl`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `SUBJECT_ID` (`SUBJECT_ID`),
  ADD KEY `DISCIPLER_ID` (`DISCIPLER_ID`),
  ADD KEY `DISCIPLE_ID` (`DISCIPLE_ID`),
  ADD KEY `ACTIVITY_ID` (`ACTIVITY_ID`);

--
-- Indexes for table `curriculum_content`
--
ALTER TABLE `curriculum_content`
  ADD PRIMARY KEY (`CURRICULUM_ID`,`SUBJECT_ID`),
  ADD KEY `SUBJECT_ID` (`SUBJECT_ID`);

--
-- Indexes for table `curriculum_tbl`
--
ALTER TABLE `curriculum_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `evangelism_tbl`
--
ALTER TABLE `evangelism_tbl`
  ADD PRIMARY KEY (`ACTIVITY_ID`,`TYPE`,`DATE_START`),
  ADD KEY `TYPE` (`TYPE`);

--
-- Indexes for table `evangelism_type`
--
ALTER TABLE `evangelism_type`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `member_profile`
--
ALTER TABLE `member_profile`
  ADD PRIMARY KEY (`PROFILE_ID`),
  ADD KEY `USER_ID` (`USER_ID`);

--
-- Indexes for table `org_activities_hierarchy`
--
ALTER TABLE `org_activities_hierarchy`
  ADD PRIMARY KEY (`ACTIVITY_ID`);

--
-- Indexes for table `org_activities_tbl`
--
ALTER TABLE `org_activities_tbl`
  ADD PRIMARY KEY (`ACTIVITY_ID`);

--
-- Indexes for table `org_group`
--
ALTER TABLE `org_group`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `org_member_group`
--
ALTER TABLE `org_member_group`
  ADD PRIMARY KEY (`ORG_GROUP_ID`,`MEMBER_PROFILE_ID`),
  ADD KEY `MEMBER_PROFILE_ID` (`MEMBER_PROFILE_ID`);

--
-- Indexes for table `org_member_hierarchy`
--
ALTER TABLE `org_member_hierarchy`
  ADD PRIMARY KEY (`PROFILE_ID`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `subject_tbl`
--
ALTER TABLE `subject_tbl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `text_messages`
--
ALTER TABLE `text_messages`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `userlogin`
--
ALTER TABLE `userlogin`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `userroles`
--
ALTER TABLE `userroles`
  ADD PRIMARY KEY (`USER_ID`,`ROLE_ID`),
  ADD KEY `USER_ID` (`USER_ID`),
  ADD KEY `ROLE_ID` (`ROLE_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bible_study_tbl`
--
ALTER TABLE `bible_study_tbl`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `bible_study_tbl`
--
ALTER TABLE `bible_study_tbl`
  ADD CONSTRAINT `bible_study_tbl_ibfk_1` FOREIGN KEY (`SUBJECT_ID`) REFERENCES `subject_tbl` (`ID`) ON UPDATE NO ACTION,
  ADD CONSTRAINT `bible_study_tbl_ibfk_2` FOREIGN KEY (`DISCIPLER_ID`) REFERENCES `member_profile` (`PROFILE_ID`) ON UPDATE NO ACTION,
  ADD CONSTRAINT `bible_study_tbl_ibfk_3` FOREIGN KEY (`DISCIPLE_ID`) REFERENCES `member_profile` (`PROFILE_ID`) ON UPDATE NO ACTION,
  ADD CONSTRAINT `bible_study_tbl_ibfk_4` FOREIGN KEY (`ACTIVITY_ID`) REFERENCES `org_activities_tbl` (`ACTIVITY_ID`) ON UPDATE NO ACTION;

--
-- Constraints for table `curriculum_content`
--
ALTER TABLE `curriculum_content`
  ADD CONSTRAINT `curriculum_content_ibfk_1` FOREIGN KEY (`CURRICULUM_ID`) REFERENCES `curriculum_tbl` (`ID`) ON UPDATE NO ACTION,
  ADD CONSTRAINT `curriculum_content_ibfk_2` FOREIGN KEY (`SUBJECT_ID`) REFERENCES `subject_tbl` (`ID`) ON UPDATE NO ACTION;

--
-- Constraints for table `evangelism_tbl`
--
ALTER TABLE `evangelism_tbl`
  ADD CONSTRAINT `evangelism_tbl_ibfk_1` FOREIGN KEY (`ACTIVITY_ID`) REFERENCES `org_activities_tbl` (`ACTIVITY_ID`) ON UPDATE NO ACTION,
  ADD CONSTRAINT `evangelism_tbl_ibfk_2` FOREIGN KEY (`TYPE`) REFERENCES `evangelism_type` (`ID`) ON UPDATE NO ACTION;

--
-- Constraints for table `member_profile`
--
ALTER TABLE `member_profile`
  ADD CONSTRAINT `USERID_FK` FOREIGN KEY (`USER_ID`) REFERENCES `userlogin` (`ID`) ON UPDATE NO ACTION;

--
-- Constraints for table `org_activities_hierarchy`
--
ALTER TABLE `org_activities_hierarchy`
  ADD CONSTRAINT `org_activities_hierarchy_ibfk_1` FOREIGN KEY (`ACTIVITY_ID`) REFERENCES `org_activities_tbl` (`ACTIVITY_ID`) ON UPDATE NO ACTION;

--
-- Constraints for table `org_member_group`
--
ALTER TABLE `org_member_group`
  ADD CONSTRAINT `org_member_group_ibfk_1` FOREIGN KEY (`ORG_GROUP_ID`) REFERENCES `org_group` (`ID`) ON UPDATE NO ACTION,
  ADD CONSTRAINT `org_member_group_ibfk_2` FOREIGN KEY (`MEMBER_PROFILE_ID`) REFERENCES `member_profile` (`PROFILE_ID`) ON UPDATE NO ACTION;

--
-- Constraints for table `org_member_hierarchy`
--
ALTER TABLE `org_member_hierarchy`
  ADD CONSTRAINT `org_member_hierarchy_ibfk_1` FOREIGN KEY (`PROFILE_ID`) REFERENCES `member_profile` (`PROFILE_ID`) ON UPDATE NO ACTION;

--
-- Constraints for table `userroles`
--
ALTER TABLE `userroles`
  ADD CONSTRAINT `userroles_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `userlogin` (`ID`) ON UPDATE NO ACTION,
  ADD CONSTRAINT `userroles_ibfk_2` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ID`) ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
