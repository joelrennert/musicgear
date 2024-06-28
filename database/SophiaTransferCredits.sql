-- **********************************************************
-- ***** Sophia Transfer Credits for WGU - Joel Rennert *****
-- **********************************************************

-- A very basic database to store information about transfer credits to WGU

-- ***** DROP TABLES
DROP TABLE IF EXISTS classes;

-- *****  CREATE TABLES
CREATE TABLE classes (
    id serial NOT NULL,
	class_id varchar(100) NULL,
	name varchar(100) NOT NULL,
	credit_hours int NOT NULL,
    completed BOOLEAN
);

-- ***** INSERT DATA

-- General Education Courses
INSERT INTO classes(name, class_id, credit_hours, completed) VALUES
('Composition: Writing with a strategy', 'ENG1001 (SOPH-0015)', 3, FALSE),
('Composition: Successful Self-Expression', 'ENG1002 (SOPH-0030)', 3, FALSE),
('Introduction to Communication: Connecting with Others', 'COMM1002 (SOPH-0024)', 3, FALSE),
('Introduction to Communication: Connecting with Others', 'COMM1002 (SOPH-0024)', 3, FALSE),
('Critical Thinking: Reason and Evidence', 'PHIL1005 (SOPH-0065)', 3, FALSE),
('Technical Communication', '', 3, FALSE),
('American Politics and the US Constitution', 'HIST1020 (SOPH-0071)', 3, FALSE),
('Global Arts and Humanities', 'ArtHist1001 (SOPH-0006)', 3, FALSE),
('Introduction to Physical and Human Geography', 'ECON1001 (SOPH-0012)', 3, FALSE),
('Ethics in Technology', '', 3, FALSE),
('Applied Algebra', 'CA1001 (SOPH-0001)', 3, FALSE),
('Finite Mathematics', '', 4, FALSE),
('Applied Probability and Statistics', 'STAT1001 (SOPH-0005)', 3, FALSE),
('Integrated Physical Sciences', 'ENVS1001 (SOPH-0016)', 3, FALSE),
('Natural Science Lab', 'SCIE1021 (SOPH-0067)', 2, FALSE),

-- WGU Core Courses
('Intro to IT', 'CS1001 (SOPH-0023)', 4, TRUE),
('Data Management - Foundations', 'CS1011 (SOPH-0047)', 3, FALSE),
('Network and Security - Foundations', 'CS1015 (SOPH-0068)', 3, FALSE),
('Scripting and Programming - Foundations', 'CS1101 (SOPH-0062)', 3, FALSE),
('Web Development Foundations', 'CS1005 (SOPH-0043)', 3, TRUE),
('Business of IT - Applications', '', 4, FALSE),

-- WGU Additional Courses
('Data Management - Applications', '', 4, FALSE),
('Web Development - Applications', '', 6, FALSE),
('Linux Foundations', '', 3, FALSE),
('Business of IT - Project Management', 'PM1001 (SOPH-0013)', 4, FALSE),
('Cloud Foundations', '', 3, FALSE),
('Spreadsheets', '', 3, FALSE),
('Organizational Behavior and Leadership', '', 3, FALSE),
('Principles of Management', 'BUSI1013 (SOPH-0054)', 3, FALSE),
('Information Systems Management', '', 4, FALSE),
('User Interface Design', '', 4, FALSE),
('Emerging Technologies', '', 2, FALSE),
('Networks', '', 4, FALSE),
('Network and Security - Applications', '', 4, FALSE),
('IT Foundations', '', 4, FALSE),
('IT Applications', '', 4, FALSE);
