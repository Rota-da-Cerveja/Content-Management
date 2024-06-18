package br.com.rotadacerveja.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.rotadacerveja.API.entity.Harmonization;

public interface HarmonizationRepository extends JpaRepository<Harmonization, Long> {
}
