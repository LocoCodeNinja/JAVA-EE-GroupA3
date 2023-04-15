package Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@jakarta.persistence.Table(name = "countries", schema = "hr")
public class CountriesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false, length = 2)
    private String countryId;

    @Basic
    @Column(name = "country_name", nullable = true, length = 40)
    private String countryName;

    @Basic
    @Column(name = "region_id", nullable = false)
    private int regionId;

    @OneToMany(mappedBy = "country")
    private List<LocationsEntity> locations;

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public List<LocationsEntity> getLocations() {
        return locations;
    }

    public void setLocations(List<LocationsEntity> locations) {
        this.locations = locations;
    }
}
