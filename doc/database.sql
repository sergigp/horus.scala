CREATE TABLE `users` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(36) NOT NULL DEFAULT '',
  `name` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `u_name` (`name`),
  KEY `i_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
