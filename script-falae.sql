CREATE DATABASE falae;

CREATE TABLE users
(
 "id"    serial NOT NULL,
 email varchar(50) NOT NULL,
 senha varchar(200) NOT NULL,
 nickName varchar(45) NOT NULL ,
 picture varchar(450),
 status varchar(150) NOT NULL,
 CONSTRAINT PK_user PRIMARY KEY ( "id" )
);
CREATE TABLE posts
(
 "id"    serial NOT NULL,
 dt_post timestamp,
 post varchar(500) NOT NULL,
 fk_user_id int NOT NULL,
 CONSTRAINT PK_post PRIMARY KEY ( "id" ),
CONSTRAINT FK_1 FOREIGN KEY ( fk_user_id ) REFERENCES users ( "id" )
);
CREATE INDEX FK_1 ON posts
(
 fk_user_id
);
CREATE TABLE reactions
(
 "id"    serial NOT NULL,
 dt_reactions timestamp,
 tipo_reaction int,
 fk_user_id int NOT NULL,
 fk_post_id int NOT NULL,
 CONSTRAINT PK_reaction PRIMARY KEY ( "id" ),
 CONSTRAINT FK_2 FOREIGN KEY ( fk_user_id ) REFERENCES users ( "id" ),
 CONSTRAINT FK_3 FOREIGN KEY ( fk_post_id ) REFERENCES posts ( "id" )
);
CREATE INDEX FK_2 ON reactions
(
 fk_user_id
);
CREATE INDEX FK_3 ON reactions
(
 fk_post_id
);
