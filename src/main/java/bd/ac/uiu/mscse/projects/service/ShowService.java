package bd.ac.uiu.mscse.projects.service;

import bd.ac.uiu.mscse.projects.model.Show;
import bd.ac.uiu.mscse.projects.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService extends AbstractService<Show, ShowRepository> {
  public ShowService(@Autowired ShowRepository showRepository) {
    super(showRepository);
  }
}
