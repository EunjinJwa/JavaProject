package jinny.study.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(CustomerExtension.class)
public class CustomerExtensionTester {

    @Test
    void myCustomerRuleTest() {
        System.out.println("Call of a test method 1");
    }

    @Test
    void myCustomerRuleTest2() {
        System.out.println("Call of a test method 2");
    }

}
