package Repository;

import Model.DepartmentsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<DepartmentsEntity, Integer> {

    @Query("SELECT d FROM DepartmentsEntity d WHERE d.locationId = 1700")
    List<DepartmentsEntity> findDepartmentsByLocationId();

    //Display the department name, city, and state province for each department.
    @Query("SELECT d.departmentName, l.city, l.stateProvince " +
            "FROM DepartmentsEntity d " +
            "JOIN LocationsEntity l ON d.locationId = l.locationId")
    List<Object[]> findDepartmentLocationInfo();
}
