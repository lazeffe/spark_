create Table member(
EMAIL 		varchar2(20) primary key,
PASSWORD	varchar2(20) not null,
NAME		varchar2(20),
AGE			varchar2(20),
GENDER		varchar2(20)
);

create Table BOOKMARK(
BOOKMARK_EMAIL	varchar2(20),
BOOKMARK_NAME 	varchar2(50),
BOOKMARK_ADDR		varchar2(50),
BOOKMARK_TEL		varchar2(20)
);

create table SPark(
	PARKING_CODE	 	varchar2(50),
	PARKING_NAME	 	varchar2(50),
	ADDR		 	varchar2(50),
	PARKING_TYPE	 	varchar2(50),
	PARKING_TYPE_NM 	varchar2(50),
	OPERATION_RULE	 	varchar2(50),
	OPERATION_RULE_NM 	varchar2(50),
	TEL		 	varchar2(50),
	CAPACITY	 	varchar2(50),
	CUR_PARKING	 	varchar2(50),
	PAY_YN	 		varchar2(50),
	PAY_NM	 		varchar2(50),
	NIGHT_FREE_OPEN	 	varchar2(50),
	NIGHT_FREE_OPEN_NM 	varchar2(50),
	WEEKDAY_BEGIN_TIME 	varchar2(50),
	WEEKDAY_END_TIME 	varchar2(50),
	WEEKEND_BEGIN_TIME 	varchar2(50),
	WEEKEND_END_TIME 	varchar2(50),
	HOLIDAY_BEGIN_TIME 	varchar2(50),
	HOLIDAY_END_TIME 	varchar2(50),
	SATURDAY_PAY_YN 	varchar2(50),
	SATURDAY_PAY_NM 	varchar2(50),
	HOLIDAY_PAY_YN	 	varchar2(50),
	HOLIDAY_PAY_NM	 	varchar2(50),
	FULLTIME_MONTHLY 	varchar2(50),
	RATES		 	varchar2(50),
	TIME_RATE	 	varchar2(50),
	ADD_RATES	 	varchar2(50),
	ADD_TIME_RATE	 	varchar2(50),
	DAY_MAXIMUM	 	varchar2(50),
	LAT		 	varchar2(50),
	LNG		 	varchar2(50)
);


select *from member;

select *from SPark;

select count(*) from member;

insert into MEMBER values('asdf@asdf.com', 'asdf', 'username', '18','none');

insert into BOOKMARK values('asdf@asdf.com', '아카데미 노상공영(구)', '강북구 수유동 535-76', '02-111-1111');
insert into BOOKMARK values('asdf@asdf.com', '가오천 노상공영(구)', '강북구 수유동 181-40', '02-111-1111');
insert into BOOKMARK values('asdf@asdf.com', '훈련원공원주차장(시)', '중구 을지로5가 40-3', '02-111-1111');

select * from bookmark;

commit;

delete from BOOKMARK where BOOKMARK_NAME=null;

drop table BOOKMARK;

select PARKING_NAME, ADDR, TEL FROM Spark where PARKING_CODE = '1540479';

select * from SPark where PARKING_CODE = 140652