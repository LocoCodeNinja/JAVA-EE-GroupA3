package Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@jakarta.persistence.Table(name = "departments", schema = "hr")
public class DepartmentsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "department_id", nullable = false)
    private int departmentId;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "department_name", nullable = false, length = 30)
    private String departmentName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Basic
    @Column(name = "location_id", nullable = true)
    private Integer locationId;

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    @OneToMany(mappedBy = "department")
    private List<EmployeesEntity> employees;

    public List<EmployeesEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeesEntity> employees) {
        this.employees = employees;
    }
}
