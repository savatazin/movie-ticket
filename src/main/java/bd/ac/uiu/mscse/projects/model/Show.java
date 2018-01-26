package bd.ac.uiu.mscse.projects.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Date;

@Data
@Entity(name = "shows")
public class Show extends Base {

  @JsonProperty(value = "movie_id")
  @Column(name = "movie_id")
  private Integer movieId;

  @JsonProperty(value = "theater_id")
  @Column(name = "theater_id")
  private Integer theaterId;

  @JsonProperty(value = "show_date")
  @Column(name = "show_date")
  private Date showDate;

  @JsonProperty(value = "show_time_start")
  @Column(name = "show_time_start")
  private String showTimeStart;

  @JsonProperty(value = "show_time_end")
  @Column(name = "show_time_end")
  private String showTimeEnd;
}
