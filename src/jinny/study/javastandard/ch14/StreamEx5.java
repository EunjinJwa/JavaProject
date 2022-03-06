package jinny.study.javastandard.ch14;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream reduce() 예시
 */
public class StreamEx5 {
    public static void main(String[] args) {
        String[] strArr = {
                "Inheritance", "Java", "Lambda", "Stream",
                "Optional", "IntStream", "count", "sum"
        };

        Stream.of(strArr).forEach(System.out::println);

        boolean noEmptyStr = Stream.of(strArr)
                .noneMatch(s -> s.length() == 0);
        Optional<String> sWord = Stream.of(strArr)
                .filter(s -> s.charAt(0) == 's')
                .findFirst();

        System.out.println("noEmptyStr = " + noEmptyStr);
        System.out.println("sWord = " + sWord.get());

        // Stream<String[]> 을 IntStream으로 변환
        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

        int count = intStream1.reduce(0, (a,b) -> a + 1);
        int sum = intStream2.reduce(0, (a,b) -> a + b);

        int max1 = intStream4.reduce(0, Integer::max);
        int max2 = intStream3.reduce(Integer::max).getAsInt();      //min, max는 초기값이 필요없으므로 이렇게 바로 Function을 전달하여 사용 가능

        System.out.println("count = " + count);
        System.out.println("sum = " + sum);
        System.out.println("max1 = " + max1);
        System.out.println("max2 = " + max2);

    }
}
