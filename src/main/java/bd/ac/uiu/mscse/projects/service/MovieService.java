package bd.ac.uiu.mscse.projects.service;

import bd.ac.uiu.mscse.projects.model.Movie;
import bd.ac.uiu.mscse.projects.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

  @Autowired
  private MovieRepository movieRepository;

  public Movie get(final Integer id) {
    return movieRepository.getOne(id);
  }

  public Integer save(Movie movie) {
    return movieRepository.save(movie).getId();
  }

  public Integer update(Movie movie) {
    return movieRepository.save(movie).getId();
  }
}
