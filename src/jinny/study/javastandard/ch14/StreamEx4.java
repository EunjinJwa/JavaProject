package jinny.study.javastandard.ch14;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamEx4 {
    public static void main(String[] args) {

        Stream<String[]> strArrStream = Stream.of(
                new String[]{"abc", "def", "jkl"},
                new String[]{"ABC", "GHI", "JKL"}
        );

        Stream<String> strStream = strArrStream.flatMap(Arrays::stream);

        strStream.map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println("==============================");

        String[] lineArr = {
                "Believe or not It is true",
                "Do or do not There is no try"
        };
        Stream<String> lineStream = Arrays.stream(lineArr);

        lineStream.flatMap(l -> Stream.of(l.split(" ")))
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.println("==============================");

        Stream<String> stream1 = Stream.of("AAA", "ABC", "bBb", "Dd");
        Stream<String> stream2 = Stream.of("bbb", "aaa", "ccc", "ddd");

        Stream<Stream<String>> strStreamStream = Stream.of(stream1, stream2);
        Stream<String> strStream3 = strStreamStream.map(s -> s.toArray(String[]::new))
                .flatMap(Arrays::stream);
        strStream3.map(String::toLowerCase)
                .distinct()
                .forEach(System.out::println);






    }
}
