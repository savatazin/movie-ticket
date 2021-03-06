package bd.ac.uiu.mscse.projects.service;

import bd.ac.uiu.mscse.projects.model.Role;
import bd.ac.uiu.mscse.projects.model.User;
import bd.ac.uiu.mscse.projects.repository.RoleRepository;
import bd.ac.uiu.mscse.projects.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RoleRepository roleRepository;
  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  public User findUserByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  @Override
  public void saveUser(User user) {
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    user.setActive(true);
    Role userRole = roleRepository.findByRole("USER");
    if (user.getRoles() != null && user.getRoles().size() > 0) {
      Iterator<Role> iterator = user.getRoles().iterator();
      userRole = roleRepository.findByRole(iterator.next().getRole());
    }
    user.setRoles(new HashSet<Role>(Collections.singletonList(userRole)));
    userRepository.save(user);
  }

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(userName);
    List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
    return buildUserForAuthentication(user, authorities);
  }

  private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
    Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
    for (Role role : userRoles) {
      roles.add(new SimpleGrantedAuthority(role.getRole()));
    }

    List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(roles);
    return grantedAuthorities;
  }

  private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
    return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.isActive(), true, true, true, authorities);
  }
}
