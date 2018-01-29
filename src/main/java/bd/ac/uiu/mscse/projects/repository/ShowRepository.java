package bd.ac.uiu.mscse.projects.repository;

import bd.ac.uiu.mscse.projects.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
  List<Show> findByShowDateGreaterThanEqual(Date date);
}

