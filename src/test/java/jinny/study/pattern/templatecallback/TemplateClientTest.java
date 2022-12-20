package jinny.study.pattern.templatecallback;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TemplateClientTest {

    TemplateClient client;

    @BeforeEach
    public void setUp() {
        client = new TemplateClient();
    }

    @Test
    public void fileReadSumTest() {
        try {
            int result = client.calcSum("numbers.txt");
            Assertions.assertThat(result).isEqualTo(16);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void fileReadSumTest2() throws IOException {
        int result = client.calcSumWithFuntionalInterface("numbers.txt");
        Assertions.assertThat(result).isEqualTo(16);
    }


}