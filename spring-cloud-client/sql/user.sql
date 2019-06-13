CREATE TABLE `user` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `username` varchar(255) DEFAULT NULL COMMENT '姓名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` VALUES ('1','admin','admin');
INSERT INTO `user` VALUES ('2','陈荣刚','123456');