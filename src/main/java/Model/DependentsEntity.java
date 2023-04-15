package Model;

import jakarta.persistence.Entity;

@Entity
@jakarta.persistence.Table(name = "dependents", schema = "hr")
public class DependentsEntity {
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @jakarta.persistence.Column(name = "dependent_id", nullable = false)
    private int dependentId;

    public int getDependentId() {
        return dependentId;
    }

    public void setDependentId(int dependentId) {
        this.dependentId = dependentId;
    }

    @jakarta.persistence.Basic
    @jakarta.persistence.Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @jakarta.persistence.Basic
    @jakarta.persistence.Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @jakarta.persistence.Basic
    @jakarta.persistence.Column(name = "relationship", nullable = false, length = 25)
    private String relationship;

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    @jakarta.persistence.Basic
    @jakarta.persistence.Column(name = "employee_id", nullable = false)
    private int employeeId;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
