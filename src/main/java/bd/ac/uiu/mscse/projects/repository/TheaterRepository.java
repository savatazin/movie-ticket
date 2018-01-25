package bd.ac.uiu.mscse.projects.repository;

import bd.ac.uiu.mscse.projects.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Integer> {
}
