SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Database: `csci3130_group24`
--
CREATE DATABASE IF NOT EXISTS `csci3130_group24` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `csci3130_group24`;

-- --------------------------------------------------------

--
-- Table structure for table `trello_user_workspace`
--

DROP TABLE IF EXISTS `trello_user_workspace`;
CREATE TABLE `trello_user_workspace` (
  `trello_user_workspace_userid` int(11) NOT NULL,
  `trello_user_worskspace_workspaceid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `trello_user_workspace`
--

INSERT INTO `trello_user_workspace` (`trello_user_workspace_userid`, `trello_user_worskspace_workspaceid`) VALUES
(1, 1),
(1, 2),
(2, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `trello_task`
--

DROP TABLE IF EXISTS `trello_task`;
CREATE TABLE `trello_task` (
	`trello_task_taskid` int(11) NOT NULL,
    `trello_task_boardid` int(11) NOT NULL,
    `trello_task_userid` int(11),
	`trello_task_name` varchar(256) NOT NULL,
    `trello_task_description`text,
    `trello_task_status` int(11) COMMENT '0 is To-Do, 1 is Doing and 2 is Done.',
    `trello_task_creation_date` DATE,
    `trello_task_completion_date` DATE 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `trello_task`
--

INSERT INTO `trello_task` (`trello_task_taskid`, `trello_task_boardid`, `trello_task_userid`, `trello_task_name`, `trello_task_status`, `trello_task_creation_date`, `trello_task_completion_date`, `trello_task_description`) VALUES
(1, 1, 1, 'sample task', 2, 2022-11-01, 2022-11-01, 'sample description'),
(2, 2, 1, 'login form', 1, 2022-11-01, 2022-11-20, 'create a log in form that takes in user email and password'),
(3, 2, 2, 'home page', 1, 2022-11-01, 2022-11-20, 'create a home page with a welcoming message after the user is logged in and show all the workspaces the users are in'),
(4, 3, 1, 'API for email authentication', 0, 2022-11-01, 2022-11-12, 'create an API for check if an email exists in the database');

-- --------------------------------------------------------

--
-- Table structure for table `trello_board`
--

DROP TABLE IF EXISTS `trello_board`;
CREATE TABLE `trello_board` (
	`trello_board_boardid` int(11) NOT NULL,
    `trello_board_workspaceid` int(11) NOT NULL,
	`trello_board_name` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `gl_board`
--

INSERT INTO `trello_board` (`trello_board_boardid`, `trello_board_workspaceid`, `trello_board_name`) VALUES
(1, 1, 'Sample Board'),
(2, 2, 'Front End'),
(3, 2, 'Back End');

-- --------------------------------------------------------

--
-- Table structure for table `trello_workspace`
--

DROP TABLE IF EXISTS `trello_workspace`;
CREATE TABLE `trello_workspace` (
  `trello_workspace_workspaceid` int(11) NOT NULL,
  `trello_workspace_name` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `trello_workspace`
--

INSERT INTO `trello_workspace` (`trello_workspace_workspaceid`, `trello_workspace_name`) VALUES
(1, 'Sample Workspace'),
(2, 'CSCI 3130 Group 24');

-- --------------------------------------------------------

--
-- Table structure for table `trello_user`
--

DROP TABLE IF EXISTS `trello_user`;
CREATE TABLE `trello_user` (
  `trello_user_userid` int(11) NOT NULL,
  `trello_user_useremail` varchar(256) NOT NULL,
  `trello_user_firstname` varchar(256) NOT NULL,
  `trello_user_lastname` varchar(256),
  `trello_user_password` varchar(256) NOT NULL,
  `trello_user_type` int(11) NOT NULL COMMENT '0 is project manager and 1 is developer.'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `trello_user`
--

INSERT INTO `trello_user` (`trello_user_userid`, `trello_user_useremail`, `trello_user_firstname`, `trello_user_lastname`, `trello_user_password`, `trello_user_type`) VALUES
(1, 'fire@gmail.com', 'Fire', 'Trello', 123456, 0),
(2, 'moss@dal.ca', 'Moss', 'Trello', '654321', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `trello_user`
--
ALTER TABLE `trello_user`
  ADD PRIMARY KEY (`trello_user_userid`);

--
-- Indexes for table `trello_workspace`
--
ALTER TABLE `trello_workspace`
  ADD PRIMARY KEY (`trello_workspace_workspaceid`);

--
-- Indexes for table `trello_board`
--
ALTER TABLE `trello_board`
  ADD PRIMARY KEY (`trello_board_boardid`),
  ADD KEY `trello_board_workspaceid` (`trello_board_workspaceid`);
  
--
-- Indexes for table `trello_task`
--
ALTER TABLE `trello_task`
  ADD PRIMARY KEY (`trello_task_taskid`),
  ADD KEY `trello_task_boardid` (`trello_task_boardid`),
  ADD KEY `trello_task_userid` (`trello_task_userid`);
  
--
-- Indexes for table `trello_user_workspace`
--
ALTER TABLE `trello_user_workspace`
  ADD PRIMARY KEY (`trello_user_workspace_userid`, `trello_user_worskspace_workspaceid`),
  ADD KEY `trello_user_workspace_userid` (`trello_user_workspace_userid`),
  ADD KEY `trello_user_worskspace_workspaceid` (`trello_user_worskspace_workspaceid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `trello_user`
--
ALTER TABLE `trello_user`
  MODIFY `trello_user_userid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `trello_workspace`
--
ALTER TABLE `trello_workspace`
  MODIFY `trello_workspace_workspaceid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `trello_board`
--
ALTER TABLE `trello_board`
  MODIFY `trello_board_boardid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
  
--
-- AUTO_INCREMENT for table `trello_task`
--
ALTER TABLE `trello_task`
  MODIFY `trello_task_taskid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `trello_board`
--
ALTER TABLE `trello_board`
  ADD CONSTRAINT `trello_board_workspaceid` FOREIGN KEY (`trello_board_workspaceid`) REFERENCES `trello_workspace` (`trello_workspace_workspaceid`);

--
-- Constraints for table `trello_task`
--
ALTER TABLE `trello_task`
  ADD CONSTRAINT `trello_task_boardid` FOREIGN KEY (`trello_task_boardid`) REFERENCES `trello_board` (`trello_board_boardid`),
  ADD CONSTRAINT `trello_task_userid` FOREIGN KEY (`trello_task_userid`) REFERENCES `trello_user` (`trello_user_userid`);
  
  --
-- Constraints for table `trello_user_workspace`
--
ALTER TABLE `trello_user_workspace`
  ADD CONSTRAINT `trello_user_workspace_userid` FOREIGN KEY (`trello_user_workspace_userid`) REFERENCES `trello_user` (`trello_user_userid`),
  ADD CONSTRAINT `trello_user_worskspace_workspaceid` FOREIGN KEY (`trello_user_worskspace_workspaceid`) REFERENCES `trello_workspace` (`trello_workspace_workspaceid`);
COMMIT;
