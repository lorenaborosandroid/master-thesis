package com.mediconear.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Specijalnost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long specijalnost_id;

    @NotNull
    @NotBlank
    private String tip;
}
