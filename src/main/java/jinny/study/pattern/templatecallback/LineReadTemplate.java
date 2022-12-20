package jinny.study.pattern.templatecallback;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.BiFunction;
import java.util.function.Function;

public class LineReadTemplate {

    public static <T> T lineReadDoTemplate(String filePath, LineCallback<T> callback, T initValue) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            T res = initValue;
            String line = null;
            while ((line = br.readLine()) != null) {
                res = callback.doSometingWithLine(line, res);
            }
            return res;
        } catch (IOException e) {
            throw e;
        }
    }

    public static <T> T lineReadDoTemplate(String filePath, BiFunction<String, T, T> fn, T initValue) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            T res = initValue;
            String line = null;
            while ((line = br.readLine()) != null) {
                res = fn.apply(line, res);
            }
            return res;
        } catch (IOException e) {
            throw e;
        }
    }

}
