CREATE TABLE movie (
  id             INT(11)      NOT NULL AUTO_INCREMENT,
  title          VARCHAR(255) NOT NULL,
  imdb_url       VARCHAR(255) NOT NULL,
  poster_img_url VARCHAR(255) NOT NULL,
  banner_img_url VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);