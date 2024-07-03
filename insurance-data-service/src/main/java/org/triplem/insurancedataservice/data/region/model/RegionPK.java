package org.triplem.insurancedataservice.data.region.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
public class RegionPK implements Serializable {

    private String ort;
    private String postleitzahl;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegionPK regionPK = (RegionPK) o;
        return Objects.equals(ort, regionPK.ort) && Objects.equals(postleitzahl, regionPK.postleitzahl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ort, postleitzahl);
    }

}
