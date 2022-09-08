package com.mediconear.repository;

import com.mediconear.domain.Lijecnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public interface LijecnikRepository extends JpaRepository<Lijecnik, Long> {

    @Transactional
    @Query(value = "SELECT * FROM lijecnik WHERE lijecnik.specijalnost_id = :x", nativeQuery = true)
    List<Lijecnik> getDoctorsForSpeciality(@Param("x") Long specijalizacijaId);

    @Transactional
    @Query(value = "SELECT * FROM lijecnik WHERE lijecnik.korisnik_id = :x", nativeQuery = true)
    Lijecnik getDoctorById(@Param("x") Long lijecnikId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE lijecnik SET adresa = :b, naziv_ordinacije = :c, radno_vrijeme = :d, " +
            "specijalnost_id = :e WHERE lijecnik_id = :a", nativeQuery = true)
    void updateDoctor(@Param("a") Long lijecnikId, @Param("b") String adresa, @Param("c") String nazivOrdinacije,
                          @Param("d") String radnoVrijeme, @Param("e") Long specijalnostId);


}
