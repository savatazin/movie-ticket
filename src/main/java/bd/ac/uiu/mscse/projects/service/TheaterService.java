package bd.ac.uiu.mscse.projects.service;

import bd.ac.uiu.mscse.projects.model.Theater;
import bd.ac.uiu.mscse.projects.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TheaterService extends AbstractService<Theater, TheaterRepository> {

  public TheaterService(@Autowired TheaterRepository theaterRepository) {
    super(theaterRepository);
  }

  public Map<String, Object> search(String query) {
    Map<String, Object> searchResults = new HashMap<>();
    List<Theater> items = repository.findByTitleContaining(query);
    searchResults.put("items", items);
    searchResults.put("total_count", items.size());
    return searchResults;
  }
}
