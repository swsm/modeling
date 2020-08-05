package cases.salary.realize.one;/**
 * @author swsm
 * @date 2020/6/6
 */

public abstract class AddEmployeeTransaction implements Transaction {
    
    private String empId;
    private String itsAddress;
    private String itsName;
    
    
    
    abstract PaymentSchedule getPaymentSchedule();
    abstract PaymentClassification getPaymentClassification();
    
    public void execute() {
        PaymentClassification paymentClassification = getPaymentClassification();
        PaymentSchedule paymentSchedule = getPaymentSchedule();
        PaymentMethod paymentMethod = new HoldMethod();
        Employee employee = new Employee(empId, itsAddress, itsName);
        employee.setPaymentClassification(paymentClassification);
        employee.setPaymentSchedule(paymentSchedule);
        employee.setPaymentMethod(paymentMethod);
        PayrollDatabase.addEmployee(empId, employee);
    }
    

}
