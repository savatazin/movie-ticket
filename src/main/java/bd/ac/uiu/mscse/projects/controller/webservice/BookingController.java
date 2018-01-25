package bd.ac.uiu.mscse.projects.controller.webservice;

import bd.ac.uiu.mscse.projects.model.Booking;
import bd.ac.uiu.mscse.projects.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/webservice/booking")
public class BookingController {

  @Autowired
  private BookingService bookingService;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Booking> get(@PathVariable(value = "id") Integer id) {
    return ResponseEntity.ok(bookingService.get(id));
  }

  @RequestMapping(value = {"", "/"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> post(@RequestBody Booking booking) {
    System.out.println(bookingService.save(booking));
    return ResponseEntity.ok().build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> put(@RequestBody Booking booking, @PathVariable(value = "id") Integer id) {
    booking.setId(id);
    System.out.println(bookingService.update(booking));
    return ResponseEntity.ok().build();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> put(@PathVariable(value = "id") Integer id) {
    bookingService.delete(id);
    return ResponseEntity.ok().build();
  }
}
