package br.com.rotadacerveja.API.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(schema = "beerroute", name = "brewery")
public class Brewery {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(length = 100)
  private String name;

  @Column(length = 45)
  private String brewmaster;

  @Column(columnDefinition = "TEXT")
  private String description;

  private Float latitude;
  private Float longitude;

  @OneToMany(mappedBy = "brewery", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Beer> beers;

}
