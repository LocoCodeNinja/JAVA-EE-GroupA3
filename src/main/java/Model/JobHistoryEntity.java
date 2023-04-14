package Model;

import jakarta.persistence.Entity;

import java.sql.Date;

@Entity
@jakarta.persistence.Table(name = "job_history", schema = "hr", catalog = "")
@jakarta.persistence.IdClass(Model.JobHistoryEntityPK.class)
public class JobHistoryEntity {
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @jakarta.persistence.Column(name = "Employee_Id", nullable = false)
    private int employeeId;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @jakarta.persistence.Column(name = "Start_Date", nullable = false)
    private Date startDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @jakarta.persistence.Basic
    @jakarta.persistence.Column(name = "End_Date", nullable = true)
    private Date endDate;

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @jakarta.persistence.Basic
    @jakarta.persistence.Column(name = "Job_Id", nullable = true)
    private Integer jobId;

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    @jakarta.persistence.Basic
    @jakarta.persistence.Column(name = "Department_Id", nullable = true)
    private Integer departmentId;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
