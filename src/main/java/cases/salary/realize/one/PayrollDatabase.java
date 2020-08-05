package cases.salary.realize.one;

import java.util.Map;

/**
 * @author swsm
 * @date 2020/6/6
 */
public class PayrollDatabase {
    
    private static  Map<String , Employee> itsEmployee;
    
    public static Employee getEmployee(String empId) {
        return itsEmployee.get(empId);
    }
    
    public static void addEmployee(String empId, Employee e) {
        itsEmployee.put(empId, e);
    }
    
}
