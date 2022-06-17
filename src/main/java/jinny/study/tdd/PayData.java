package jinny.study.tdd;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class PayData {

    private LocalDate firstBillingDate;
    private LocalDate billingDate;
    private int payAmount;

}
