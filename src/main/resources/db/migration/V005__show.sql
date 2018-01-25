CREATE TABLE shows (
  id         INT(11)   NOT NULL AUTO_INCREMENT,
  movie_id   INT(11)   NOT NULL,
  theater_id INT(11)   NOT NULL,
  show_time  TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
);
