package jinny.study.tdd;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class PayData {

    private LocalDate billingDate;
    private int payAmount;

}
