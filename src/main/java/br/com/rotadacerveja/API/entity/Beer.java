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
@Table(schema = "beerroute", name = "beer")
public class Beer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;

  @Column(name = "minimum_temperature")
  private Double minimumTemperature;

  @Column(name = "maximum_temperature")
  private Double maximumTemperature;
  
  @Column(name = "ibu")
  private Integer ibu;
  
  @Column(name = "alcohol_content")
  private Integer alcoholContent;

  @Column(length = 150)
  private String description;

  private String type;
  private Double volume;

  @ManyToOne
  @JoinColumn(name = "brewery_id")
  private Brewery brewery;
}
