package Service;

import Model.DepartmentsEntity;
import Model.EmployeesEntity;
import Repository.CountryRepository;
import Repository.DepartmentRepository;
import Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("HRManagerService")
public class HRManagerService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private CountryRepository countryRepository;


    public void runQueries() {
        // demonstrate usage of all Repository classes

        // 1. Find all Employees whose salary is in the range 9000, 17000
        List<EmployeesEntity> employeesBySalaryRange = employeeRepository.findEmployeesBySalaryRange();
        System.out.println("\n1. Find all Employees whose salary is in the range 9000, 17000\n");
        // display the list of EmployeesEntity objects
        printEmployeeInfo(employeesBySalaryRange);

        // 2. Find all Employees whose first name ends with Letter a
        List<EmployeesEntity> employeesWithFirstNameEndingA = employeeRepository.findEmployeesByFirstNameEndsWithA();
        System.out.println("\n2. Find all Employees whose first name ends with Letter 'a'\n");
        // display the list of EmployeesEntity objects
        printEmployeeInfo(employeesWithFirstNameEndingA);

        // 3. Find all Employees working in Accounting Department
        List<EmployeesEntity> employeesInAccounting = employeeRepository.findEmployeesInAccountingDepartment();
        System.out.println("\n3. Find all Employees working in Accounting Department\n");
        // display the list of EmployeesEntity objects
        printEmployeeInfo(employeesInAccounting);

        // 4. Find all Employees working under Manager ID 108
        List<EmployeesEntity> employeesUnderManager108 = employeeRepository.findEmployeesByManagerId();
        System.out.println("\n4. Find all Employees working under Manager ID 108\n");
        // display the list of EmployeesEntity objects
        printEmployeeInfo(employeesUnderManager108);

        // 5. Find all Departments with Location ID 1700
        List<DepartmentsEntity> departmentsInLocation1700 = departmentRepository.findDepartmentsByLocationId();
        System.out.println("\n5. Find all Departments with Location ID 1700\n");
        // display the DepartmentsEntity objects
        departmentsInLocation1700.forEach(department -> {
            System.out.println("Department ID: " + department.getDepartmentId());
            System.out.println("Department Name: " + department.getDepartmentName());
            System.out.println("--------------------------------------");
        });

        // 6. Count the number of cities each country has. Return country ID and number of cities
        List<Object[]> countryCityCounts = countryRepository.findCountryAndCityCount();
        System.out.println("\n6. Count the number of cities each country has. Return country ID and number of cities\n");
        // display the CountryId with number of cities
        for (Object[] result : countryCityCounts) {
            System.out.println("Country ID: " + result[0]);
            System.out.println("Number of Cities: " + result[1]);
            System.out.println("------------------------");
        }

        // 7. Display the department name, city, and state province for each department
        List<Object[]> departmentInfo = departmentRepository.findDepartmentLocationInfo();
        System.out.println("\n7. Display the department name, city, and state province for each department\n");
        // display data from DepartmentsEntity and LocationsEntity
        departmentInfo.forEach(info -> {
            String departmentName = (String) info[0];
            String city = (String) info[1];
            String stateProvince = (String) info[2];
            System.out.println("Department Name: " + departmentName);
            System.out.println("City: " + city);
            System.out.println("State/Province: " + stateProvince);
            System.out.println("--------------------------------------");
        });

        // 8. Display the last name, job, department number and department name for all employees who work in 'Toronto' city
        List<Object[]> employeesInToronto = employeeRepository.findEmployeesInToronto();
        System.out.println("\n8. Display the last name, job, department number and department name for all employees who work in 'Toronto' city\n");
        // display data from EmployeeEntity, JobsEntity, and DepartmentsEntity
        employeesInToronto.forEach(result -> {
            System.out.println("Last Name: " + result[0]);
            System.out.println("Job: " + result[1]);
            System.out.println("Department Number: " + result[2]);
            System.out.println("Department Name: " + result[3]);
            System.out.println("--------------------------------------");
        });

        // 9. Display the average of sum of the salaries and group the result with the department id. Order the result with department id
        List<Object[]> avgSalaryByDepartment = employeeRepository.findAvgSalaryByDepartment();
        System.out.println("\n9. Display the average of sum of the salaries and group the result with the department id. Order the result with department id\n");
        // display sums from using EmployeeEntity and DepartmentsEntity, also formats decimals
        System.out.printf("%-15s %-25s %15s\n", "Department ID", "Department Name", "Average Salary");
        System.out.println("---------------------------------------------------------");
        for (Object[] result : avgSalaryByDepartment) {
            String formattedSalary = String.format("$%.2f", (Double) result[2]);
            if (formattedSalary.endsWith(".0")) {
                formattedSalary = formattedSalary.substring(0, formattedSalary.length() - 3);
            }
            System.out.printf("%-15s %-25s %15s\n", result[0], result[1], formattedSalary);
        }
        System.out.println("---------------------------------------------------------");


        // 10. Select the Manager name, department id of manager, the count of employees working under that manager as Total_Employees
        List<Object[]> managerAndTotalEmployees = employeeRepository.findManagerAndTotalEmployees();
        System.out.println("\n10. Select the Manager name, department id of manager, the count of employees working under that manager as Total_Employees\n");
        managerAndTotalEmployees.forEach(result -> {
            String managerName = (String) result[0];
            int departmentId = (int) result[1];
            // deduct by 1 to account for the manager
            long totalEmployees = (long) result[2] - 1;

            System.out.println("Manager Name: " + managerName);
            System.out.println("Department ID: " + departmentId);
            System.out.println("Total Employees: " + totalEmployees);
            System.out.println("--------------------------------------");
        });
    }

    public static void printEmployeeInfo(List<EmployeesEntity> employees) {
        employees.forEach(employee -> {
            System.out.println("Employee ID: " + employee.getEmployeeId());
            System.out.println("Full Name: " + employee.getFirstName() + " " + employee.getLastName());
            // System.out.println("First Name: " + employee.getFirstName());
            // System.out.println("Last Name: " + employee.getLastName());
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

