package bd.ac.uiu.mscse.projects.repository;

import bd.ac.uiu.mscse.projects.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("movieRepository")
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
