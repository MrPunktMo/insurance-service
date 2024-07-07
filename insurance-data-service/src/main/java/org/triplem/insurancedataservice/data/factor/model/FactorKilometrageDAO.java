package org.triplem.insurancedataservice.data.factor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "factor_kilometrage")
@Getter
@Setter
public class FactorKilometrageDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kilometrage_id")
    private Integer kilometerID;

    @Column(name = "kilometre_from", nullable = false)
    private Integer from;

    @Column(name = "kilometre_to", nullable = false)
    private Integer to;

    @Column(name = "valid_from", nullable = false)
    private LocalDate validFrom;

    @Column(name = "valid_to", nullable = false)
    private LocalDate validTo;

    @Column(name = "factor", nullable = false)
    private float factor;

}
