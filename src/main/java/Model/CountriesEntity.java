package Model;

import jakarta.persistence.Entity;

@Entity
@jakarta.persistence.Table(name = "countries", schema = "hr", catalog = "")
public class CountriesEntity {
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @jakarta.persistence.Column(name = "country_id", nullable = false, length = 2)
    private String countryId;

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @jakarta.persistence.Basic
    @jakarta.persistence.Column(name = "country_name", nullable = true, length = 40)
    private String countryName;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @jakarta.persistence.Basic
    @jakarta.persistence.Column(name = "region_id", nullable = false)
    private int regionId;

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }
}