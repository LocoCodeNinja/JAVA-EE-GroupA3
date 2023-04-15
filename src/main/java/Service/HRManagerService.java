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
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private LocationRepository locationRepository;

    public void runQueries() {
        // demonstrate usage of all Repository classes

        // 1. Find all Employees whose salary is in the range 9000, 17000
        List<EmployeesEntity> employeesBySalaryRange = employeeRepository.findEmployeesBySalaryRange();

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

    }
}

