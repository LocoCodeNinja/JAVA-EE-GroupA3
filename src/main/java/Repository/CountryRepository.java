package Repository;

import Model.CountriesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends CrudRepository<CountriesEntity, String> {

    // counts number of locations associated with each country in the CountriesEntity and groups by countryId
    @Query("SELECT c.countryId, COUNT(l) as cityCount FROM CountriesEntity c " +
            "JOIN c.locations l GROUP BY c.countryId")
    List<Object[]> findCountryAndCityCount();
}
