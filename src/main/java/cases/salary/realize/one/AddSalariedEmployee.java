package cases.salary.realize.one;

import java.math.BigDecimal;

/**
 * @author swsm
 * @date 2020/6/6
 */
public class AddSalariedEmployee extends AddEmployeeTransaction {
    
    private BigDecimal salary;
    
    
    
    @Override
    public void execute() {
        
    }
    
    public PaymentSchedule getPaymentSchedule() {
        return new MonthlySchedule();
    }
    
    public PaymentClassification getPaymentClassification() {
        return new SalariedClassification();
    }
}
