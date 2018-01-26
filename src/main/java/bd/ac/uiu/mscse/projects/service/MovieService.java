package bd.ac.uiu.mscse.projects.service;

import bd.ac.uiu.mscse.projects.model.Movie;
import bd.ac.uiu.mscse.projects.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieService extends AbstractService<Movie, MovieRepository> {

  MovieService(@Autowired MovieRepository movieRepository) {
    super(movieRepository);
  }

  public Map<String, Object> search(String query) {
    Map<String, Object> searchResults = new HashMap<>();
    List<Movie> items = repository.findByTitleContaining(query);
    searchResults.put("items", items);
    searchResults.put("total_count", items.size());
    return searchResults;
  }
}
