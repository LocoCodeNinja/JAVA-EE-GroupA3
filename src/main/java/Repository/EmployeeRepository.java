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

    @Query("SELECT e.lastName, e.jobId, d.departmentId, d.departmentName " +
            "FROM EmployeesEntity e " +
            "JOIN DepartmentsEntity d ON e.departmentId = d.departmentId " +
            "JOIN LocationsEntity l ON d.locationId = l.locationId " +
            "WHERE l.city = 'Toronto'")
    List<Object[]> findEmployeesInToronto();

    @Query("SELECT d.departmentId, AVG(e.salary) as avgSalary FROM EmployeesEntity e JOIN e.department d GROUP BY d.departmentId ORDER BY d.departmentId")
    List<Object[]> findAvgSalaryByDepartment();

    // DISPLAY MANAGER NAME, DEPARTMENT ID OF MANAGER, EMPLOYEE COUNT as Total_Employees
    // Dependent on Jobs, Employee, Departments
    // get job_id where job_title CONTAINS "Manager", in EMPLOYEES find job_id matches job_id of those with Manager,
    // concat first and last name, get department_id, get count of all employees under that department_id  as Total_Employees
    @Query("SELECT CONCAT(e.firstName, ' ', e.lastName) as managerName, e.departmentId, (SELECT COUNT(*) FROM EmployeesEntity WHERE departmentId = e.departmentId) as totalEmployees FROM EmployeesEntity e JOIN JobsEntity j ON e.jobId = j.jobId WHERE j.jobTitle LIKE '%Manager%'")
    List<Object[]> findManagerAndTotalEmployees();

}
