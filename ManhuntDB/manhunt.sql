DROP TABLE IF EXISTS GameMatchPlayers;
DROP TABLE IF EXISTS BanList;
DROP TABLE IF EXISTS GameMatch;
DROP TABLE IF EXISTS Player;

CREATE TABLE Player           (pid        SERIAL NOT NULL,
                               email      CHAR(30),
                               latitude   REAL,
                               longitude  REAL,
                               type     INTEGER,
                               PRIMARY KEY (pid));

CREATE TABLE GameMatch        (gid        SERIAL NOT NULL,
                               startTime  INTEGER,
                               active     BOOLEAN,
                               PRIMARY KEY (gid));

CREATE TABLE BanList          (pid         INTEGER NOT NULL,
                               PRIMARY KEY (pid));

CREATE TABLE GameMatchPlayers (pid        INTEGER NOT NULL,
                               gid        INTEGER NOT NULL,
                               PRIMARY KEY (pid, gid),
                               FOREIGN KEY (pid) REFERENCES Player
                               ON DELETE CASCADE,
                               FOREIGN KEY (gid) REFERENCES GameMatch
                               ON DELETE CASCADE);
