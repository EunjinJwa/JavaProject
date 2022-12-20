package jinny.study.pattern.templatecallback;

import java.io.IOException;
import java.util.function.BiFunction;

public class TemplateClient {

    // 익명 내부함수를 사용하여 콜백 작성
    public int calcSum(String filePath) throws IOException {
        LineCallback<Integer> callback = new LineCallback<Integer>() {
            @Override
            public Integer doSometingWithLine(String line, Integer value) {
                return Integer.parseInt(line) + value;
            }
        };

        return LineReadTemplate.lineReadDoTemplate(filePath, callback, 0);
    }

    // functional interface 를 사용하여 콜백 함수 작성
    public int calcSumWithFuntionalInterface(String filePath) throws IOException {
        BiFunction<String, Integer, Integer> fn = (line, value) -> Integer.valueOf(line) + value;
        return LineReadTemplate.lineReadDoTemplate(filePath, fn, 0);
    }

}
