package bd.ac.uiu.mscse.projects.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity(name = "movie")
public class Movie extends Base {

  @JsonProperty(value = "title")
  @Column(name = "title")
  private String title;

  @JsonProperty(value = "imdb_url")
  @Column(name = "imdb_url")
  private String imdbUrl;

  @JsonProperty(value = "poster_img_url")
  @Column(name = "poster_img_url")
  private String posterImgUrl;

  @JsonProperty(value = "banner_img_url")
  @Column(name = "banner_img_url")
  private String bannerImgUrl;
}
