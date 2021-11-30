CREATE TABLE `CONFIG`  (
  `ID` int NOT NULL COMMENT 'ID ',
  `KEY` varchar(255) NULL COMMENT '特殊参数KEY(黑名单退出时间|超过签到时间自动加入黑名单界限)',
  `VALUE` varchar(255) NULL COMMENT '特殊参数VALUE',
  PRIMARY KEY (`ID`)
);

CREATE TABLE `FIELD`  (
  `ID` int NOT NULL COMMENT 'ID',
  `TYPE` varchar(255) NOT NULL COMMENT '场地类型(羽毛球|篮球|排球|乒乓球|田径场地)',
  `GROUND_ID` int NULL COMMENT '运动场地ID',
  `ADDRESS` varchar(255) NULL COMMENT '地点',
  `STATUS` varchar(255) NULL COMMENT '状态(可用|不可用)',
  `FIELD_NAME` varchar(255) NULL COMMENT '场地名称',
  PRIMARY KEY (`ID`)
);

CREATE TABLE `ORDER`  (
  `ID` int NOT NULL,
  `ORDER_TIME` datetime NULL COMMENT '预约时间',
  `START_TIME` datetime NULL COMMENT '预约开始时间(小时)',
  `END_TIME` datetime NOT NULL COMMENT '预约结束时间(小时)',
  `STATUS` varchar(255) NULL COMMENT '预约状态(空闲|预约|使用)',
  `USER_ID` int NULL COMMENT '用户ID',
  `FIELD_ID` int NULL COMMENT '运动场ID',
  PRIMARY KEY (`ID`)
);

CREATE TABLE `PLAYGROUND`  (
  `ID` int NOT NULL COMMENT 'ID',
  `GROUND_NAME` varchar(255) NULL COMMENT '场地名称',
  `ADDRESS` varchar(255) NULL COMMENT '地址',
  `ADMIN_NAME` varchar(255) NULL COMMENT '管理员名称',
  `CONTACT` varchar(255) NULL COMMENT '联系方式',
  `OPEN_TIME` datetime NULL COMMENT '开馆时间',
  `CLOSE_TIME` datetime NULL COMMENT '闭馆时间',
  PRIMARY KEY (`ID`)
);

CREATE TABLE `USER`  (
  ` ID` int NOT NULL COMMENT 'ID',
  `USERNAME` varchar(255) NULL COMMENT '用户名',
  `PASSWORD` varchar(255) NULL COMMENT '密码',
  `NICKNAME` varchar(255) NULL COMMENT '昵称',
  `STATUS` varchar(255) NULL COMMENT '是否加入黑名单',
  PRIMARY KEY (` ID`)
);

