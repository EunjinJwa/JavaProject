package jinny.study.junit.stub;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

public class StubHttpURLConnection extends HttpURLConnection {
    private boolean isInput = true;

    public StubHttpURLConnection(URL url) {
        super(url);
    }

    public InputStream getInputStream() throws IOException {
        if (!isInput) {
            throw new ProtocolException("Cannot read from URLConnection");
        }
        String resultString = "It works";

        return new ByteArrayInputStream(resultString.getBytes());
    }


    @Override
    public void connect() throws IOException {
    }

    @Override
    public void disconnect() {
    }

    @Override
    public boolean usingProxy() {
        return false;
    }
}
