package com.mediconear.repository;

import com.mediconear.domain.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Component
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    Optional<Korisnik> findByEmail(String email);

    Boolean existsByEmail(String email);

    @Modifying
    @Transactional
    @Query(value = "UPDATE korisnik SET ime = :x, prezime = :y, kontakt_broj = :z, email = :j, " +
            "oib = :a, datum_rodjenja = :b WHERE korisnik.korisnik_id = :m", nativeQuery = true)
    void updateKorisnik(@Param("x") String ime,@Param("y") String prezime, @Param("z") String kontaktni_broj,
                    @Param("j") String email, @Param("a") String oib
                        , @Param("b") String datum_rodjenja, @Param("m") Long korisnik_id);
}