package org.triplem.insurancedataservice.data.region.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "region")
@IdClass(RegionPK.class)
@RequiredArgsConstructor
@Getter
@Setter
public class RegionDAO {

    @Id
    @Column(name = "ort", nullable = false)
    private String ort;

    @Id
    @Column(name = "postleitzahl", nullable = false)
    private String postleitzahl;

    @Column(name = "region1", nullable = false)
    private String bundesLand;

    @Column(name = "region3", nullable = false)
    private String land;

    @Column(name = "region4", nullable = false)
    private String stadt;

}
