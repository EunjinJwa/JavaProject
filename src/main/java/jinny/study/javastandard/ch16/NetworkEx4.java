package jinny.study.javastandard.ch16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class NetworkEx4 {
    public static void main(String[] args) {
        URL url = null;
        BufferedReader input = null;
        String address = "http://www.codechobo.com";
        String line = "";

        try {
            url = new URL(address);
            InputStreamReader is = new InputStreamReader(url.openStream());
            input = new BufferedReader(is);

            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            input.close();

        } catch (Exception e) {
        }

    }
}
