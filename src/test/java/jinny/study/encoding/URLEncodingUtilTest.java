package jinny.study.encoding;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;

class URLEncodingUtilTest {

    @Test
    public void testEncode() throws UnsupportedEncodingException {
        String url = "FlipNGo Sit & Go Satellite to #18: $215 Main Event [Day 1]";
        String encodedUrl = URLEncodingUtil.encode(url);

        System.out.println(encodedUrl);
    }

}