package bd.ac.uiu.mscse.projects.service;

import bd.ac.uiu.mscse.projects.model.Movie;
import bd.ac.uiu.mscse.projects.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService extends AbstractService<Movie, MovieRepository> {

  MovieService(@Autowired MovieRepository movieRepository) {
    super(movieRepository);
  }

  public List<Movie> search(String query) {
    return repository.findByTitleIgnoreCase(query);
  }
}
