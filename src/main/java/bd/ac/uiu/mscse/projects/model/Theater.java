package bd.ac.uiu.mscse.projects.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity(name = "theater")
public class Theater extends Base {

  @JsonProperty(value = "title")
  @Column(name = "title")
  private String title;

  @JsonProperty(value = "capacity")
  @Column(name = "capacity")
  private Integer capacity;
}
