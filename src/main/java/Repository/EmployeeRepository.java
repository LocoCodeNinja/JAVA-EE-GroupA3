package Repository;

import Model.EmployeesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<EmployeesEntity, Integer> {

    // selects data from EmployeesEntity where salary is between 9000 and 17000
    @Query("SELECT e FROM EmployeesEntity e WHERE e.salary BETWEEN 9000 AND 17000")
    List<EmployeesEntity> findEmployeesBySalaryRange();

    // selects data from EmployeesEntity where firstName ends with a
    @Query("SELECT e FROM EmployeesEntity e WHERE e.firstName LIKE '%a'")
    List<EmployeesEntity> findEmployeesByFirstNameEndsWithA();

    // selects data from EmployeesEntity where departmentName from department is Accounting
    // basically matching employees from two tables where departmentName is "Accounting"
    @Query("SELECT e FROM EmployeesEntity e JOIN e.department d WHERE d.departmentName = 'Accounting'")
    List<EmployeesEntity> findEmployeesInAccountingDepartment();

    // selects data from EmployeesEntity where managerId is 108
    @Query("SELECT e FROM EmployeesEntity e WHERE e.managerId = 108")
    List<EmployeesEntity> findEmployeesByManagerId();

    // select data from EmployeesEntity and match with DepartmentsEntity and LocationsEntity where city is "Toronto"
    @Query("SELECT e.lastName, j.jobTitle, d.departmentId, d.departmentName " +
            "FROM EmployeesEntity e " +
            "JOIN DepartmentsEntity d ON e.departmentId = d.departmentId " +
            "JOIN JobsEntity j ON e.jobId = j.jobId " +
            "JOIN LocationsEntity l ON d.locationId = l.locationId " +
            "WHERE l.city = 'Toronto'")
    List<Object[]> findEmployeesInToronto();

    // select departmentId and round the average salary by 2 decimals, order by departmentId
    @Query("SELECT d.departmentId, d.departmentName, ROUND(AVG(e.salary), 2) as avgSalary FROM EmployeesEntity e JOIN e.department d GROUP BY d.departmentId, d.departmentName ORDER BY d.departmentId")
    List<Object[]> findAvgSalaryByDepartment();

    // get job_id where job_title CONTAINS "Manager", in EMPLOYEES find job_id matches job_id of those with Manager,
    // concat first and last name, get department_id, get count of all employees under that department_id  as Total_Employees
    @Query("SELECT CONCAT(e.firstName, ' ', e.lastName) as managerName, e.departmentId, (SELECT COUNT(*) FROM EmployeesEntity WHERE departmentId = e.departmentId) as totalEmployees FROM EmployeesEntity e JOIN JobsEntity j ON e.jobId = j.jobId WHERE j.jobTitle LIKE '%Manager%'")
    List<Object[]> findManagerAndTotalEmployees();

}
