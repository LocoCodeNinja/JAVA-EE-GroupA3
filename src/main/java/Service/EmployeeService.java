package Service;

import Repository.DepartmentRepository;
import Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("HRService")
public class EmployeeService {
    @Autowired
    private EmployeeRepository emprepository;
    @Autowired
    private DepartmentRepository deptrepository;
    public void test() {
// demonstrate usage of all Repository classes
    }
}

