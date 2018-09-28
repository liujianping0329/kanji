create table kanji.yys_kami
(
	id int auto_increment
		primary key,
	name varchar(16) not null,
	level int not null comment '等级',
	type int default '0' null comment '1N 2R 3SR 4SSR',
	remark varchar(64) not null comment '备注',
	create_at timestamp default CURRENT_TIMESTAMP null,
	update_at timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
)
comment '阴阳师式神' engine=InnoDB
;

create table kanji.yys_kami_skill
(
	id int auto_increment
		primary key,
	value int not null,
	level int not null comment '等级 1D 2C 3B 4A 5S',
	type int default '0' null comment '1攻击2生命3防御4速度5暴击6暴伤7命中8抵抗',
	kami_id int not null comment '式神id',
	remark varchar(64) not null comment '备注',
	create_at timestamp default CURRENT_TIMESTAMP null,
	update_at timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
)
comment '阴阳师式神属性' engine=InnoDB
;

create index yys_kami_skill_kami_id_index
	on kanji.yys_kami_skill (kami_id)
;



CREATE TABLE `yys_pass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL DEFAULT '',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yys_pass_part` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kami_id` int(11) NOT NULL DEFAULT '0',
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yys_pass_part_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kami_id` int(11) NOT NULL DEFAULT '0',
  `amount` int(11) NOT NULL DEFAULT '1',
  `pass_part_id` int(11) NOT NULL DEFAULT '0',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL DEFAULT '',
  `password` varchar(16) NOT NULL DEFAULT '',
  `remark` varchar(16) NOT NULL DEFAULT '',
  `icon` varchar(128) NOT NULL DEFAULT '',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `user_geo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lng` decimal(11,11) NOT NULL DEFAULT '0.00000000000',
  `lat` decimal(11,11) NOT NULL DEFAULT '0.00000000000',
  `user_id` int(11) NOT NULL DEFAULT '0',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_geo_article` (
  `id` int(11) NOT NULL,
  `geo_id` int(11) NOT NULL,
  `pics` varchar(1024) NOT NULL DEFAULT '',
  `remark` varchar(255) NOT NULL DEFAULT '',
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




