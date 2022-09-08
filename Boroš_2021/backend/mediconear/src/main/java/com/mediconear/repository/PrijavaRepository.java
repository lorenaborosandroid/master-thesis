package com.mediconear.repository;

import com.mediconear.domain.Prijava;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface PrijavaRepository extends JpaRepository<Prijava, Long> {
}
