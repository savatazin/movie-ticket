CREATE TABLE booking (
  id      INT(11) NOT NULL AUTO_INCREMENT,
  show_id INT(11) NOT NULL,
  user_id INT(11) NOT NULL,
  seat_no INT(11) NOT NULL,
  PRIMARY KEY (id)
);
