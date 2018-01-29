package bd.ac.uiu.mscse.projects.service;

import bd.ac.uiu.mscse.projects.model.Show;
import bd.ac.uiu.mscse.projects.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShowService extends AbstractService<Show, ShowRepository> {
  public ShowService(@Autowired ShowRepository showRepository) {
    super(showRepository);
  }

  public List<Show> getUpcomingShows() {
    return repository.findByShowDateGreaterThanEqual(new Date());
  }

  public List<Show> getAllCurrentShowsOf(Integer movieId) {
    return repository.findByMovieIdAndShowDateGreaterThanEqual(movieId, new Date());
  }
}
