package com.mediconear.repository;

import com.mediconear.domain.Lijecnik;
import com.mediconear.domain.Specijalnost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface SpecijalizacijaRepository extends JpaRepository<Specijalnost, Long> {
}
