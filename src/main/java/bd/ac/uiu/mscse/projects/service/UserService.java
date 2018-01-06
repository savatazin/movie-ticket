package bd.ac.uiu.mscse.projects.service;

import bd.ac.uiu.mscse.projects.model.User;

public interface UserService {
  public User findUserByEmail(String email);

  public void saveUser(User user);
}
