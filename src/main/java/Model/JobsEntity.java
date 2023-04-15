package Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "jobs", schema = "hr", catalog = "")
public class JobsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "job_id", nullable = false)
    private int jobId;
    @Basic
    @Column(name = "job_title", nullable = false, length = 35)
    private String jobTitle;
    @Basic
    @Column(name = "min_salary", nullable = true, precision = 2)
    private BigDecimal minSalary;
    @Basic
    @Column(name = "max_salary", nullable = true, precision = 2)
    private BigDecimal maxSalary;

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public BigDecimal getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(BigDecimal minSalary) {
        this.minSalary = minSalary;
    }

    public BigDecimal getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(BigDecimal maxSalary) {
        this.maxSalary = maxSalary;
    }
}
