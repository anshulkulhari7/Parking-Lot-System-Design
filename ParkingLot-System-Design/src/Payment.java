import java.util.Date;

public abstract class Payment {
    private Date creationOnDate;
    private double amount;
    private PaymentStatus status;

    public boolean initiateTransaction(){
        if(status.equals(PaymentStatus.COMPLETED))return true;
        else return false;
    }
}
