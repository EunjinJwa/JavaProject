package jinny.study.encrypt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncryptUtilsTest {

    @Test
    public void testBase64Encode() {
        String str = "test:str";
        String encodedStr = EncryptUtils.base64Encode(str);

        System.out.println(encodedStr);
    }

}