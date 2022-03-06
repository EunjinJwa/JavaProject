package jinny.study.javastandard.ch14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest1 {

    public static void main(String[] args) {

        // Stream 생성 방법

        // 직접 요소를 지정하여 생성
        Stream<String> strStream = Stream.of("AAA", "BBB", "CCC");
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);

        // Collection
        // Stream<T> Collection.stream()
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream1 = list1.stream();

        // 배열
        Stream stream2 = Stream.of("AAA", "BBB", "CCC");
        IntStream stream3 = IntStream.of(1, 2, 3, 4, 4);
        Stream<String> stream4 = Arrays.stream(new String[]{"aaa", "bbb", "ccc"});






        List<String[]> list = Arrays.asList(
                new String[]{"aaa", "bbb", "ccc"},
                new String[]{"ddd", "eee", "fff"}
        );

        Stream<String[]> strArrStream = list.stream();

        // map 변환
        Stream<Stream<String>> streamStream = strArrStream.map(s -> Stream.of(s));
        streamStream.forEach(s -> {
            s.forEach(s2 -> System.out.println(s2));
        });

        // flatMap
        strArrStream = list.stream();
        Stream<String> flatStream = strArrStream.flatMap(Arrays::stream);
        flatStream.forEach(System.out::println);



    }
}
