package jinny.study.encoding;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class URLEncodingUtil {

    public static String encode(String url) throws UnsupportedEncodingException {
        return URLEncoder.encode(url, "UTF-8");
    }
}
