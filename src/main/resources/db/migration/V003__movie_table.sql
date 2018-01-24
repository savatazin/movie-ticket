CREATE TABLE movie(
  id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(255) NOT NULL,
  imdb_url varchar(255) NOT NULL,
  rotten_tomatoes_url varchar(255) NOT NULL,
  poster_img_url varchar(255) NOT NULL,
  banner_img_url varchar(255) NOT NULL,
  PRIMARY KEY (id)
);
