package com.mediconear.repository;

import com.mediconear.domain.Pacijent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public interface PacijentRepository extends JpaRepository<Pacijent, Long> {

    @Transactional
    @Query(value = "SELECT * FROM pacijent WHERE pacijent.korisnik_id = :x", nativeQuery = true)
    Pacijent getPatientById(@Param("x") Long pacijent_id);
}
