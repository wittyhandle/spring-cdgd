CREATE TABLE IF NOT EXISTS `foo` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;