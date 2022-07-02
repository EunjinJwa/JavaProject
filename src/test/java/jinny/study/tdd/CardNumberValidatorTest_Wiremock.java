package jinny.study.tdd;

import com.github.tomakehurst.wiremock.WireMockServer;
import jinny.study.tdd.domain.CardNumberValidator;
import jinny.study.tdd.domain.CardValidity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;


public class CardNumberValidatorTest_Wiremock {

    private WireMockServer wireMockServer;

    @BeforeEach
    void setUp() {
        wireMockServer = new WireMockServer(8081);
    }

    @AfterEach
    void tearDown() {
        wireMockServer.stop();
    }

    @Test
    void valid() {
        // wireMock 생성
        stubFor(post("/card")
                .withRequestBody(equalTo("12341234"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/plain")
                        .withBody("ok")));

        // 실행
        CardNumberValidator cardNumberValidator = new CardNumberValidator();
        cardNumberValidator.setServer("http://localhost:8081");
        CardValidity validity = cardNumberValidator.validate("12341234");
        Assertions.assertThat(validity).isEqualTo(CardValidity.VALID);
    }




}
