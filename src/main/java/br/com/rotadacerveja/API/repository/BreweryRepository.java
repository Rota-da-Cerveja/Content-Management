package br.com.rotadacerveja.API.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.com.rotadacerveja.API.entity.Brewery;

public interface BreweryRepository extends JpaRepository<Brewery, Long> {
    
    @Query("SELECT b.name FROM Brewery b ORDER BY RAND() LIMIT :limit")
    List<String> findRandomBreweryNames(@Param("limit") int limit);

    Optional<Brewery> findByName(String name);
}
