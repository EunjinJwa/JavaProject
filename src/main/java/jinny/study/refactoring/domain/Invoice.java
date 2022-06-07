package jinny.study.refactoring.domain;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
    public String customer;
    public List<InvoicePerformance> performances;

    public void addPerformance(InvoicePerformance invoicePerformance) {
        if (performances == null) {
            performances = new ArrayList<>();
        }
        performances.add(invoicePerformance);
    }
}
