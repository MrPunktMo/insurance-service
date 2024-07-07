package org.triplem.insurancedataservice.data.factor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "fee")
@Getter
@Setter
public class FeeDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fee_id")
    private Integer feeId;

    @Column(name = "amount", nullable = false)
    private float amount;

    @Column(name = "vehicle_type", nullable = false)
    private String vehicleType;

    @Column(name = "kilometrage", nullable = false)
    private Integer kilometrage;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "created_on", nullable = false)
    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    private LocalDate createdOn;

}
