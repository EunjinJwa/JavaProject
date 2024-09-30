package jinny.study.encoding;

import org.junit.jupiter.api.Test;

class EncryptUtilsTest {

    @Test
    public void testBase64Encode() {
        String str = "test:str";
        String encodedStr = EncryptUtils.base64Encode(str);

        System.out.println(encodedStr);
    }

}