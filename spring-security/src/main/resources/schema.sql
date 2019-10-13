--
-- Database: `spring_security`
--

-- --------------------------------------------------------

--
-- Table structure for table `jpausers`
--

CREATE TABLE `jpausers` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `jpausers`
--

INSERT INTO `jpausers` (`id`, `username`, `password`, `authority`) VALUES
(1, 'ridait', '123456', 'USER'),
(2, 'admin', 'nimda', 'ADMIN');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jpausers`
--
ALTER TABLE `jpausers`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jpausers`
--
ALTER TABLE `jpausers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;