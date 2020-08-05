package cases.salary.realize.one;

/**
 * @author swsm
 * @date 2020/6/6
 */
public class Employee {
    private String empId;
    private String name;
    private String address;
    
    public Employee(String empId, String name, String address) {
        this.empId = empId;
        this.name = name;
        this.address = address;
    }
    
    private PaymentClassification paymentClassification;
    private PaymentSchedule paymentSchedule;
    private PaymentMethod paymentMethod;


    public void setPaymentClassification(PaymentClassification paymentClassification) {
        this.paymentClassification = paymentClassification;
    }

    public void setPaymentSchedule(PaymentSchedule paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
