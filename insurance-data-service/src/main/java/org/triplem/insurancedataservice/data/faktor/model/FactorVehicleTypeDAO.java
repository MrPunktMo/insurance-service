package org.triplem.insurancedataservice.data.faktor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(schema = "insurance_data", name = "factor_vehicle_type")
@Getter
@Setter
public class FactorVehicleTypeDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "vehicle_type", nullable = false)
    private String type;

    @Column(name = "valid_from", nullable = false)
    private LocalDate validFrom;

    @Column(name = "valid_to", nullable = false)
    private LocalDate validTo;

    @Column(name = "factor", nullable = false)
    private float factor;

}
