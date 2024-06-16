package br.com.rotadacerveja.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.rotadacerveja.API.entity.Beer;

public interface BeerRepository extends JpaRepository<Beer, Long> {}
