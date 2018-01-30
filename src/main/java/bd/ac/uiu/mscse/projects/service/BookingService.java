package bd.ac.uiu.mscse.projects.service;

import bd.ac.uiu.mscse.projects.model.Booking;
import bd.ac.uiu.mscse.projects.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService extends AbstractService<Booking, BookingRepository> {
  public BookingService(@Autowired BookingRepository bookingRepository) {
    super(bookingRepository);
  }

  public List<Booking> getUserBookings(int id) {
    return repository.findByUserId(id);
  }
}
