CREATE TABLE shows (
  id              INT(11)      NOT NULL AUTO_INCREMENT,
  movie_id        INT(11)      NOT NULL,
  theater_id      INT(11)      NOT NULL,
  show_date       DATE         NOT NULL,
  show_time_start VARCHAR(255) NOT NULL,
  show_time_end   VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);
