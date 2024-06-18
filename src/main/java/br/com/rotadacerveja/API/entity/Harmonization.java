package br.com.rotadacerveja.API.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(schema = "beerroute", name = "harmonization")
public class Harmonization {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "harmonization_id")
  private long id;

  @Column(length = 100)
  private String food;

  @ManyToOne
  @JoinColumn(name = "beer_id")
  private Beer beer;

}
