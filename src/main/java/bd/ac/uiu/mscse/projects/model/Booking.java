package bd.ac.uiu.mscse.projects.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity(name = "booking")
public class Booking extends Base {

  @JsonProperty(value = "show_id")
  @Column(name = "show_id")
  private Integer showId;

  @JsonProperty(value = "user_id")
  @Column(name = "user_id")
  private Integer userId;

  @JsonProperty(value = "seat_no")
  @Column(name = "seat_no")
  private Integer seatNo;

}
