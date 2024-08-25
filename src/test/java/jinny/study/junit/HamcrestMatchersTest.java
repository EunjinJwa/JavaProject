package jinny.study.junit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * hamcrest-library 를 활용하여 풍성하고 간결하게 테스트 하기
 */
public class HamcrestMatchersTest {

    private static String FIRST_NAME = "John";
    private static String LAST_NAME = "Smith";
    private static Customer customer = new Customer(FIRST_NAME, LAST_NAME);

    /**
     * Matchers.allOf() : 모든 규칙 만족
     * Matchers.anyOf() : 하나라도 규칙을 만족
     */

    @Test
    @DisplayName("Hamcrest is, anyOf, allOf 매처를 사용한 테스트")
    public void testHamcrestIs() {
        int price1 = 1;
        int price2 = 1;
        int price3 = 2;

        assertThat(1, is(price1));
        // Use assertJ
        Assertions.assertThat(1).isEqualTo(price1);
        // Use JUnit
        org.junit.jupiter.api.Assertions.assertEquals(1, price1);

        assertThat(1, anyOf(is(price2), is(price3)));
        assertThat(1, allOf(is(price1), is(price2)));
    }

    @Test
    @DisplayName("nullValue 매처를 사용한 테스트")
    void testNull() {
        assertThat(null, nullValue());
    }

    @Test
    @DisplayName("notNullValue 매처를 사용한 테스트")
    void testNotNull() {
        assertThat(customer, notNullValue());
    }

    @Test
    @DisplayName("hasProperty 매처를 사용한 테스트")
    void checkCorrectCustomerProperties() {
        System.out.println(customer);
        assertThat(customer, hasProperty("firstName")); // property를 가지는지 체크
        assertThat(customer, hasProperty("firstName", is(FIRST_NAME)));  // property의 값이 동일한지 체크

        // 여러 규칙이 모두 충족하는지 체크 : allOf
        assertThat(customer, allOf(
                hasProperty("firstName", is(FIRST_NAME)),
                hasProperty("lastName", is(LAST_NAME))
        ));
    }
}
