create table `activities`(id bigint auto_increment, start_time timestamp, activity_desc varchar(255),
activity_type varchar(255), primary key(id));

CREATE TABLE `track_point`(id BIGINT AUTO_INCREMENT,
time DATE, lat DOUBLE, lon DOUBLE, activity_id BIGINT,
PRIMARY KEY(id),
FOREIGN KEY(`activity_id`) REFERENCES `activities`(`id`) );

insert into activities(start_time, activity_desc, activity_type) values ('2021-02-02 10:00:00', 'kosár', 'BASKETBALL');