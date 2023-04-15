package Repository;

import Model.EmployeesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<EmployeesEntity, Integer> {

    @Query("SELECT e FROM EmployeesEntity e WHERE e.salary BETWEEN 9000 AND 17000")
    List<EmployeesEntity> findEmployeesBySalaryRange();

    @Query("SELECT e FROM EmployeesEntity e WHERE e.firstName LIKE '%a'")
    List<EmployeesEntity> findEmployeesByFirstNameEndsWithA();

    @Query("SELECT e FROM EmployeesEntity e JOIN e.department d WHERE d.departmentName = 'Accounting'")
    List<EmployeesEntity> findEmployeesInAccountingDepartment();

    @Query("SELECT e FROM EmployeesEntity e WHERE e.managerId = 108")
    List<EmployeesEntity> findEmployeesByManagerId();

    @Query("SELECT e.lastName, e.jobId, d.departmentId, d.departmentName FROM EmployeesEntity e JOIN e.department d JOIN d.location l WHERE l.city = 'Toronto'")
    List<Object[]> findEmployeesInToronto();

    @Query("SELECT d.departmentId, AVG(e.salary) as avgSalary FROM EmployeesEntity e JOIN e.department d GROUP BY d.departmentId ORDER BY d.departmentId")
    List<Object[]> findAvgSalaryByDepartment();

    @Query("SELECT m.firstName, m.lastName, d.departmentId, COUNT(e) as totalEmployees FROM EmployeesEntity e JOIN e.department d JOIN d.manager m GROUP BY m.employeeId, d.departmentId")
    List<Object[]> findManagerAndTotalEmployees();
}
