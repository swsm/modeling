package jksj.wangzeng.modeling.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author swsm
 * @date 2020/12/19
 */
public class Composite {


    public abstract class HumanResource {
        protected long id;
        protected double salary;

        public HumanResource(long id) {
            this.id = id;
        }

        public long getId() {
            return id;
        }

        public abstract double calculateSalary();
    }

    public class Employee extends HumanResource {
        public Employee(long id, double salary) {
            super(id);
            this.salary = salary;
        }

        @Override
        public double calculateSalary() {
            return salary;
        }
    }

    public class Department extends HumanResource {
        private List<HumanResource> subNodes = new ArrayList<>();

        public Department(long id) {
            super(id);
        }

        @Override
        public double calculateSalary() {
            double totalSalary = 0;
            for (HumanResource hr : subNodes) {
                totalSalary += hr.calculateSalary();
            }
            this.salary = totalSalary;
            return totalSalary;
        }

        public void addSubNode(HumanResource hr) {
            subNodes.add(hr);
        }
    }
    
    class DepartmentRepo {
        List<Long> getSubDepartmentIds(long deparemntId) {
            return Collections.emptyList();
        }
        
        
        
        
    }
    
    class EmployeeRepo {

        List<Long> getDepartmentEmployeeIds(long deparemntId) {
            return Collections.emptyList();
        }
        
        Double getEmployeeSalary(long employeeId) {
            return null;
        }
        
    }

    // 构建组织架构的代码
    class Demo {
        private static final long ORGANIZATION_ROOT_ID = 1001;
        private DepartmentRepo departmentRepo; // 依赖注入
        private EmployeeRepo employeeRepo; // 依赖注入

        public void buildOrganization() {
            Department rootDepartment = new Department(ORGANIZATION_ROOT_ID);
            buildOrganization(rootDepartment);
        }

        private void buildOrganization(Department department) {
            List<Long> subDepartmentIds = departmentRepo.getSubDepartmentIds(department.getId());
            for (Long subDepartmentId : subDepartmentIds) {
                Department subDepartment = new Department(subDepartmentId);
                department.addSubNode(subDepartment);
                buildOrganization(subDepartment);
            }
            List<Long> employeeIds = employeeRepo.getDepartmentEmployeeIds(department.getId());
            for (Long employeeId : employeeIds) {
                double salary = employeeRepo.getEmployeeSalary(employeeId);
                department.addSubNode(new Employee(employeeId, salary));
            }
        }
    }
    
}
