package bd.ac.uiu.mscse.projects.repository;

import bd.ac.uiu.mscse.projects.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
  List<Booking> findByUserId(int id);
}
