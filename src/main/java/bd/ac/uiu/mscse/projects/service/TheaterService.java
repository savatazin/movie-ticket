package bd.ac.uiu.mscse.projects.service;

import bd.ac.uiu.mscse.projects.model.Theater;
import bd.ac.uiu.mscse.projects.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService extends AbstractService<Theater, TheaterRepository> {

  public TheaterService(@Autowired TheaterRepository theaterRepository) {
    super(theaterRepository);
  }
}
