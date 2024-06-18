package br.com.rotadacerveja.API.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.rotadacerveja.API.entity.Beer;

public interface BeerRepository extends JpaRepository<Beer, Long> {
  Optional<Beer> findByName(String name);

  @Query("SELECT b FROM Beer b ORDER BY RAND() LIMIT 2")
  List<Beer> findRandomBeers();
}
