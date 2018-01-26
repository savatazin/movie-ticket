INSERT INTO `role` VALUES (1, 'ADMIN');
INSERT INTO `role` VALUES (2, 'USER');

INSERT INTO `user` VALUES
  (1, 1, 'tazin.sava@gmail.com', 'Tazin', 'Sava',
   '$2a$10$y0o0QOTaKN8qb1xxzHjINuAQQ2gd44KcJDhjHt190MxXHmr4CSmL6');

INSERT INTO `user_role` VALUES (1, 1)