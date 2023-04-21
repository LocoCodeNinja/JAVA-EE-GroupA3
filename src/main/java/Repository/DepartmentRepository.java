package Repository;

import Model.DepartmentsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<DepartmentsEntity, Integer> {

    // selects data from DepartmentsEntity where locationId is 1700
    @Query("SELECT d FROM DepartmentsEntity d WHERE d.locationId = 1700")
    List<DepartmentsEntity> findDepartmentsByLocationId();

    // selects data from DepartmentsEntity where ID is locationId
    List<DepartmentsEntity> findByLocationId(Integer locationId);

    // display the department name, city, and state province for each department.
    @Query("SELECT d.departmentName, l.city, l.stateProvince " +
            "FROM DepartmentsEntity d " +
            "JOIN LocationsEntity l ON d.locationId = l.locationId")
    List<Object[]> findDepartmentLocationInfo();
}
