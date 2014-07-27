DROP TABLE IF EXISTS GameMatchPlayers;
DROP TABLE IF EXISTS BanList;
DROP TABLE IF EXISTS GameMatch;
DROP TABLE IF EXISTS Player;

CREATE TABLE Player           (pid        SERIAL,
                               email      CHAR(30),
                               latitude   REAL,
                               longitude  REAL,
                               status     INTEGER,
                               PRIMARY KEY (pid));

CREATE TABLE GameMatch        (gid        SERIAL,
                               startTime  INTEGER,
                               active     BOOLEAN,
                               PRIMARY KEY (gid));

CREATE TABLE BanList          (pid         INTEGER,
                               PRIMARY KEY (pid));

CREATE TABLE GameMatchPlayers (pid        INTEGER,
                               gid        INTEGER,
                               PRIMARY KEY (pid, gid),
                               FOREIGN KEY (pid) REFERENCES Player,
                               FOREIGN KEY (gid) REFERENCES GameMatch
                               ON DELETE CASCADE);
