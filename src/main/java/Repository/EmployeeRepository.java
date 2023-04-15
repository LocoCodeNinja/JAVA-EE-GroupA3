package Repository;

import Model.EmployeesEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeesEntity, Integer> {
}
