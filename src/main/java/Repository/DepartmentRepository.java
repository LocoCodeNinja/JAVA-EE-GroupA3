package Repository;

import Model.DepartmentsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<DepartmentsEntity, Integer> {

    @Query("SELECT d FROM DepartmentsEntity d WHERE d.locationId = 1700")
    List<DepartmentsEntity> findDepartmentsByLocationId();

    @Query("SELECT d.departmentName, l.city, l.stateProvince FROM DepartmentsEntity d JOIN d.location l")
    List<Object[]> findDepartmentInfo();
}
