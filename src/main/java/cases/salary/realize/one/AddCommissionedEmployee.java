package cases.salary.realize.one;

import java.math.BigDecimal;

/**
 * @author swsm
 * @date 2020/6/6
 */
public class AddCommissionedEmployee extends AddEmployeeTransaction {
    
    private BigDecimal salary;
    private Double commissionRate;
    
    
    @Override
    public void execute() {
        
    }

    public PaymentSchedule getPaymentSchedule() {
        return new BlweeklySchedule();
    }

    public PaymentClassification getPaymentClassification() {
        return new CommissionedClassification();
    }
}
