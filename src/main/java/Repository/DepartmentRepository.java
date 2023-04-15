package Repository;

import Model.DepartmentsEntity;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<DepartmentsEntity, Integer> {
}
