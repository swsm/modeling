package cases.salary.realize.one;

/**
 * @author swsm
 * @date 2020/6/6
 */
public class AddHourlyEmployee extends AddEmployeeTransaction {
    
    private String hourlyRate;

    
    @Override
    public void execute() {
        
    }

    public PaymentSchedule getPaymentSchedule() {
        return new WeeklySchedule();
    }

    public PaymentClassification getPaymentClassification() {
        return new HourlyClassification();
    }
    
}
