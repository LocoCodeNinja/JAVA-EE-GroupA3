package Service;

import Model.DepartmentsEntity;
import Model.EmployeesEntity;
import Repository.CountryRepository;
import Repository.DepartmentRepository;
import Repository.EmployeeRepository;
import Repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("HRManagerService")
public class HRManagerService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    private CountryRepository countryRepository;

    private LocationRepository locationRepository;

    public void runQueries() {
        // demonstrate usage of all Repository classes

        // 1. Find all Employees whose salary is in the range 9000, 17000
        List<EmployeesEntity> employeesBySalaryRange = employeeRepository.findEmployeesBySalaryRange();
        // Process the results or print them
        // Display the list of EmployeesEntity objects
        employeesBySalaryRange.forEach(employee -> {
            System.out.println("Employee ID: " + employee.getEmployeeId());
            System.out.println("First Name: " + employee.getFirstName());
            System.out.println("Last Name: " + employee.getLastName());
            System.out.println("Email: " + employee.getEmail());
            System.out.println("Phone Number: " + employee.getPhoneNumber());
            System.out.println("Hire Date: " + employee.getHireDate());
            System.out.println("Job ID: " + employee.getJobId());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println("Commission Pct: " + employee.getCommissionPct());
            System.out.println("Manager ID: " + employee.getManagerId());
            System.out.println("Department ID: " + employee.getDepartmentId());
            System.out.println("--------------------------------------");
        });
        // 2. Find all Employees whose first name ends with Letter a
        List<EmployeesEntity> employeesWithFirstNameEndingA = employeeRepository.findEmployeesByFirstNameEndsWithA();
        // Process the results or print them

        // 3. Find all Employees working in Accounting Department
        List<EmployeesEntity> employeesInAccounting = employeeRepository.findEmployeesInAccountingDepartment();
        // Process the results or print them

        // 4. Find all Employees working under Manager ID 108
        List<EmployeesEntity> employeesUnderManager108 = employeeRepository.findEmployeesByManagerId();
        // Process the results or print them

        // 5. Find all Departments with Location ID 1700
        List<DepartmentsEntity> departmentsInLocation1700 = departmentRepository.findDepartmentsByLocationId();
        // Process the results or print them

        // 6. Count the number of cities each country has. Return country ID and number of cities.
        List<Object[]> countryCityCounts = countryRepository.findCountryAndCityCount();
        // Process the results or print them

        // 7. Display the department name, city, and state province for each department.
        List<Object[]> departmentInfo = departmentRepository.findDepartmentInfo();
        // Process the results or print them

        // 8. Display the last name, job, department number and department name for all employees who work in 'Toronto' city.
        List<Object[]> employeesInToronto = employeeRepository.findEmployeesInToronto();
        // Process the results or print them

        // 9. Display the average of sum of the salaries and group the result with the department id. Order the result with department id.
        List<Object[]> avgSalaryByDepartment = employeeRepository.findAvgSalaryByDepartment();
        // Process the results or print them

        // 10. Select the Manager name, department id of manager, the count of employees working under that manager as Total_Employees.
        List<Object[]> managerAndTotalEmployees = employeeRepository.findManagerAndTotalEmployees();
        // Process the results or print them
    }
}

