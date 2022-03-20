package jinny.study.javastandard.ch16;

import java.net.URL;
import java.net.URLConnection;

public class NetworkEx3 {

    /**
     * URLConnection 클래스
     * @param args
     */
    public static void main(String[] args) {

        URL url = null;
        String address = "https://codechobo.tistory.com/reaction?entryId=1";

        try {
            url = new URL(address);
            URLConnection conn = url.openConnection();

            System.out.println("conn.toString = " + conn);
            System.out.println("conn.getAllowUserInteraction() = " + conn.getAllowUserInteraction());
            System.out.println("conn.getConnectTimeout() = " + conn.getConnectTimeout());
            System.out.println("conn.getContent() = " + conn.getContent());
            System.out.println("conn.getContentEncoding() = " + conn.getContentEncoding());
            System.out.println("getContentLength() = " + conn.getContentLength());
            System.out.println("ContentType() = " + conn.getContentType());
            System.out.println("Date() = " + conn.getDate());
            System.out.println("HeaderFields() = " + conn.getHeaderFields());
            System.out.println("IfModifiedSince() = " + conn.getIfModifiedSince());
            System.out.println("LastModified() = " + conn.getLastModified());
            System.out.println("ReadTimeout() = " + conn.getReadTimeout());

        } catch (Exception e) {

        }

    }
}
