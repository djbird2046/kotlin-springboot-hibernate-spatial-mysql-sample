CREATE TABLE `tb_location` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `location` point NOT NULL,
  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;